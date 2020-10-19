package com.cosmogame;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            Banner.displayBanner();
            BetterParser parser = new BetterParser();
            parser.betterParser();
            BetterSpaceship ship = new BetterSpaceship();
            ship.start();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
