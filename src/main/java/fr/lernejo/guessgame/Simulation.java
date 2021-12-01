package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        if (numberToGuess < 1 || numberToGuess > 10000) {
            throw new IllegalArgumentException("Le nombre donné doit être comprit entre 1 et 10 000.");
        }
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long nextGuess = player.askNextGuess();

        if (nextGuess == numberToGuess) {
            logger.log("Le joueur a trouvé le bon nombre.");
            return true;
        } else if (nextGuess > numberToGuess) {
            player.respond(false);
        } else {
            player.respond(true);
        }
        logger.log("Le joueur s'est trompé.");
        return false;
    }

    public void loopUntilPlayerSucceed(long maxRounds) {
        final long startTime = System.currentTimeMillis();
        boolean isWon = false;

        for (long i = 0; i < maxRounds; i++) {
            logger.log("nouvelle tentative");
            if (nextRound()) {
                // On affiche le nombre de coups seuleument si le joueur gagne
                logger.log("Partie terminée en " + i + " coups");
                isWon = true;
                break;
            }
        }
        final long endTime = System.currentTimeMillis();
        final long gameDuration = endTime - startTime;
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");

        if (isWon) {
            logger.log("Le joueur a gagné la partie.");
        } else {
            logger.log("Le joueur a perdu la partie.");
        }
        logger.log("Durée de la partie: " + dateFormat.format(new Date(gameDuration)));
    }
}
