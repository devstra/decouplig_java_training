package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("-interactive")) {
            final Player player = new HumanPlayer();
            final Simulation simulation = new Simulation(player);

            final SecureRandom random = new SecureRandom();
            final long randomNumber = random.nextLong(1, 101);

            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        } else if (args.length == 2 && args[0].equals("-auto") && isNumeric(args[1])) {
            final Player player = new ComputerPlayer();
            final Simulation simulation = new Simulation(player);

            simulation.initialize(Long.parseLong(args[1]));
            simulation.loopUntilPlayerSucceed(1000);
        } else {
            System.out.println("Il faut spécifier le(s) argument(s) suivant:");
            System.out.println("-interactive : Version jouable");
            System.out.println("-auto <nb> : Version jouée par un robot");
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            long aLong = Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
