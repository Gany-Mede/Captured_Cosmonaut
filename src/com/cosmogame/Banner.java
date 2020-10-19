
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Banner {

    public static void displayBanner() throws IOException {
        Path path = Paths.get("./src/com/cosmogame/cosmomoscow.txt");
        Path path1 = Paths.get("./src/com/cosmogame/cosmo.txt");
        Path path2 = Paths.get("./src/com/cosmogame/spaceship.txt");

        Files.lines(path).forEach(System.out::println);
        //System.out.println();
        Files.lines(path1).forEach(System.out::println);

        //print Intro dialogue from file.  hard coded for Sprint 1
        System.out.println("\nYou are Cosmonaut Vlad, engineer on the exploration-class starship, Vostok-32.\n" +
                "While charting a new system, your ship is attacked and all but destroyed by\n" +
                "an unknown foe. Your only chance of escape is a shuttle in the hanger at the\n" +
                "stern of the Vostok. Normally a simple enough task, but the last remaining\n" +
                "console on the bridge indicates there is one other lifeform still alive on\n" +
                "the ship.....and it is not human...\n");

        Files.lines(path2).forEach(System.out::println);

    }

}