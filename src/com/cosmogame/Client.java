package com.cosmogame;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {

        Banner.displayBanner();
        TextParser parser = new TextParser();
        parser.parser();
        SpaceShip spaceShip =new SpaceShip();
        spaceShip.buildSpaceship();
        spaceShip.start();

    }
}
