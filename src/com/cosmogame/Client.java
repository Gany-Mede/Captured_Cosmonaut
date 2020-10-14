package com.cosmogame;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Banner.displayBanner();
        BetterParser parser = new BetterParser();
        parser.betterParser();
        BetterSpaceship ship = new BetterSpaceship();
        ship.start();
    }
}
