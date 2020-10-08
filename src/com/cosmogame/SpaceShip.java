package com.cosmogame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SpaceShip{
    String bridgeDescription = TextParser.bridgeDescription;
    String gymDescription = TextParser.bridgeDescription;
    String kitchenDescription= TextParser.kitchenDescription;
    Map<String, String> bridgeExits = new HashMap<>();
    Map<String, String> gymExits = new HashMap<>();
    Map<String, String> kitchenExits = new HashMap<>();
    List<String> bridgeItems = new ArrayList<>();
    List<String> gymItems = new ArrayList<>();
    List<String> kitchenItems = new ArrayList<>();

    public void buildSpaceship(){
       bridgeExits.putAll(TextParser.bridgeExits);
       gymExits.putAll(TextParser.gymExits);
       kitchenExits.putAll(TextParser.kitchenExits);
       bridgeItems.addAll(TextParser.bridgeItems);
       gymItems.addAll(TextParser.gymItems);
       kitchenItems.addAll((TextParser.kitchenItems));
    }
    public void testOutput(){
        System.out.println("Test Bridge");
        System.out.println("Bridge description: " + bridgeDescription);
        System.out.println("Bridge Exits: " + bridgeExits);
        System.out.println("Bridge Items: " + bridgeItems);

        System.out.println("Test Kitchen");
        System.out.println("Kitchen description: " + kitchenDescription);
        System.out.println("Kitchen Exits: " + kitchenExits);
        System.out.println("Kitchen Items: " + kitchenItems);

        System.out.println("Test Gym");
        System.out.println("Gym description: " + gymDescription);
        System.out.println("Gym Exits: " + gymExits);
        System.out.println("Gym Items: " + gymItems);
    }
}
