package com.cosmogame;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {
        CosmonautGame game = new CosmonautGame();
        Banner.displayBanner();
        game.setGame();



    }
}
