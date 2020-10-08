package com.cosmogame;

public class Client {
    public static void main(String[] args) {
        TextParser parser = new TextParser();
        parser.parser();
        SpaceShip spaceShip =new SpaceShip();
        spaceShip.buildSpaceship();
        spaceShip.start();

    }
}
