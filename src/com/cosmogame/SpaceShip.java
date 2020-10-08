package com.cosmogame;
import java.util.*;

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

    String currentRoom;
    //empty inventory
    List<String> inventory = new ArrayList<>();


    public void start() {
        //Start at the bridge
        currentRoom = "bridge";
        System.out.println("Welcome to the game ");
        printInventory();
        System.out.println("Your are now in this room: " + currentRoom);
        printItems(bridgeItems);
        prompt();
        evaluateInput();
        whereAmI();
        prompt();

    }
    public void evaluateInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        if (inputArray.length < 2) {
            System.out.println("Wrong command");
        } else {
            if (inputArray[0].equals("go")) {
                go(inputArray[1]);
            } else if (inputArray[0].equals("get")) {
                get(inputArray[1]);
            } else {
                System.out.println("You typed in the wrong command");
            }
        }
        System.out.println("the current room now is: " + currentRoom);
    }

    public void whereAmI(){
        switch(currentRoom){
            case "bridge":
                System.out.println(bridgeDescription);
                printItems(bridgeItems);
                break;
            case "gym":
                System.out.println(gymDescription);
                printItems(gymItems);
                break;
            case "kitchen":
                System.out.println(kitchenDescription);
                printItems(kitchenItems);
                break;
        }
    }
    public void printInventory(){
        System.out.println("You current inventory: " + inventory);
    }
    public void prompt(){
        System.out.println("You can type 'get (item) to add an item to your inventory'");
        System.out.println("or you can type 'go (direction)' to go to another room");
    }
        public void go(String direction){
            switch (currentRoom){
                case "bridge":
                    currentRoom = bridgeExits.get(direction);
                    break;
                case "gym":
                    currentRoom = gymExits.get(direction);
                    break;
                case "kitchen":
                    currentRoom = kitchenExits.get(direction);
                    break;
            }
        }
        public void get(String item){
        inventory.add(item);

            switch (currentRoom){
                case "bridge":
                    bridgeItems.remove(item);
                    break;
                case "gym":
                    gymItems.remove(item);
                    break;
                case "kitchen":
                    kitchenItems.remove(item);
                    break;
        }
            printInventory();
    }
    public void printItems(List<String> items){
        System.out.println("You see the following items: ");
        for (var item : items){
            System.out.print(item + " ");
        }
        System.out.println();
    }


    public void buildSpaceship(){
        bridgeExits.putAll(TextParser.bridgeExits);
        gymExits.putAll(TextParser.gymExits);
        kitchenExits.putAll(TextParser.kitchenExits);
        bridgeItems.addAll(TextParser.bridgeItems);
        gymItems.addAll(TextParser.gymItems);
        kitchenItems.addAll((TextParser.kitchenItems));
    }
//    public void testOutput(){
//        System.out.println("Test Bridge");
//        System.out.println("Bridge description: " + bridgeDescription);
//        System.out.println("Bridge Exits: " + bridgeExits);
//        System.out.println("Bridge Items: " + bridgeItems);
//
//        System.out.println("Test Kitchen");
//        System.out.println("Kitchen description: " + kitchenDescription);
//        System.out.println("Kitchen Exits: " + kitchenExits);
//        System.out.println("Kitchen Items: " + kitchenItems);
//
//        System.out.println("Test Gym");
//        System.out.println("Gym description: " + gymDescription);
//        System.out.println("Gym Exits: " + gymExits);
//        System.out.println("Gym Items: " + gymItems);
//    }
}