package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long nextGuess = player.askNextGuess();
        logger.log("Le joueur a choisit " + nextGuess);

        if (nextGuess == numberToGuess) {
            logger.log("Le joueur a trouvé le bon nombre.");
            return true;
        } else if (nextGuess > numberToGuess) {
            System.out.println("Raté! Le nombre est plus petit que " + nextGuess);
        } else {
            System.out.println("Raté! Le nombre est plus grand que " + nextGuess);
        }

        logger.log("Le joueur s'est trompé.");
        return false;
    }

    public void loopUntilPlayerSucceed() {
        while (!nextRound()) {
            logger.log("nouvelle tentative");
        }
    }
}
