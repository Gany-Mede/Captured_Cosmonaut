package com.cosmogame;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Computer {
    private static int attempts = 0;
    //Computer security = new Computer();


    public static void hackPrint() throws IOException, InterruptedException {
        //fake code that is printed to screen for "hack"
            System.out.println("Security System Override in Progress...");
            Thread.sleep(500);
            System.out.println();

            File update = new File ("/Users/nmicjime/Desktop/Captured_Cosmonaut/src/com/cosmogame/System Update.txt");
            Scanner scan = new Scanner(update);
            while (scan.hasNextLine()) {
                String line1 = scan.nextLine();
                System.out.println(line1);
                Thread.sleep(400);
            }
            System.out.println();

            File f = new File("/Users/nmicjime/Desktop/Captured_Cosmonaut/src/com/cosmogame/Door Hack.txt");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                Thread.sleep(225);
            }
            //Path hack = Paths.get("/Users/nmicjime/Desktop/Captured_Cosmonaut/src/com/cosmogame/Door Hack.txt");
            //Files.lines(hack).forEach(System.out::println);
            System.out.println();
            passcode();
        }


    public static void passcode() throws InterruptedException {
        //3 attempts to get right key word.
        while (attempts < 3) {

            //user input for keyword
            Scanner user_input = new Scanner(System.in);
            System.out.println("To Override Security System, Enter Today's Key Word: ");

            //make lowercase
            String userInput = user_input.nextLine().trim().toLowerCase();

            //if incorrect, get warning message
            if (!userInput.equals("sputnik")) {
                attempts++;
                System.out.println("WARNING! You have " + (3 - attempts) + " attempt(s) before Emergency Destruct Procedures are activated!");
            }
            if (userInput.equals("sputnik")) {
                System.out.println("Manual Override Successful!  Unlocking Doors.");
                //unlock door to room
                break;
            }
        }
        if (attempts == 3) {
            emergencyDestruct();
        }

    }
    public static void emergencyDestruct() throws InterruptedException {
        System.out.println("Emergency Destruct Procedures activated. The Shuttle will self destruct in 5 seconds.");
        System.out.println("5");
        Thread.sleep(1000);
        System.out.println("4");
        Thread.sleep(1000);
        System.out.println("3");
        Thread.sleep(1000);
        System.out.println("2");
        Thread.sleep(1000);
        System.out.println("1");
        Thread.sleep(1000);
        System.out.println("Game Over, Good Bye!");
        System.exit(0);
    }





//end of class bracket
}
