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
            logger.log("le joueur a raté");
            System.out.println("Raté! Essaie encore.");
        } else {
            logger.log("le joueur a gagné");
            System.out.println("Bravo! Tu as trouvé l'age du capitaine.");
        }
    }
}
