package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        System.out.print("Entrez un nombre: ");
        return scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            this.logger.log("Raté! Le nombre cherché est plus grand");
        } else {
            this.logger.log("Raté! Le nombre cherché est plus petit");
        }
    }
}
