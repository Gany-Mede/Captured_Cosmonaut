package com.cosmogame;

import java.io.IOException;

public class CosmonautGame {

    public void setGame() throws IOException {
        //instantiate new player
        //Player player1 = new Player();
        //instantiate the game map (spaceship)
        SpaceShip spaceShip = new SpaceShip();
        //set up a new game
        //calling on a new player, game map, item manager
        intro();

    }
    public void intro() throws IOException {
        //print instructions
        // go, get, use, shoot, hack, etc
        startGame();
    }

    public void startGame() throws IOException {
        //print start dialogue from file, hard coded for Sprint 1
        System.out.println();
        System.out.println("Oof.... you groggily wake up and survey your surroundings. You're on the bridge;\n" +
                "sparking cables dangling from overhead monitors, malfunctioning feeds with\n" +
                "nonsense scrolling text. Your head is screaming. You raise your hand to it\n" +
                "and are met with a burst of pain from the touch. \\\"I\\'ve got to get out of\n" +
                "here.\\\" You step up to the only working console. \\\"Shuttle\\'s still intact.\n" +
                "That\\'s my way out.\\\" You notice something peculiar blinking in the hanger\n" +
                "diagram: You are not alone...");
        //start player on bridge

    }


}