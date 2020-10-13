package com.cosmogame;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        CosmonautGame game = new CosmonautGame();
        Banner.displayBanner();
        game.setGame();
        Computer.hackPrint();



    }


}
