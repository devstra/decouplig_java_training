package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("robot");
    private boolean isFirstGuess = true;
    private boolean previousLowerOrGreater;
    private long min = 1;
    private long max = 100;

    @Override
    public long askNextGuess() {
        if (!isFirstGuess) {
            if (previousLowerOrGreater) {
                this.min = (this.min + this.max) / 2;
            } else {
                this.max = (this.min + this.max) / 2;
            }
        } else {
            this.isFirstGuess = false;
        }
        long guess = (this.min + this.max) / 2;
        logger.log("Le joueur a choisit " + guess);
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            this.logger.log("Raté! Le nombre cherché est plus grand");
        } else {
            this.logger.log("Raté! Le nombre cherché est plus petit");
        }
        previousLowerOrGreater = lowerOrGreater;
    }
}
