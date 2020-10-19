package com.cosmogame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class BetterSpaceship {
    //All the rooms are in spaceship array list now
    static ArrayList<ArrayList> spaceship = BetterParser.rooms;
    boolean matchPlayed = false;

    String currentRoom;
    //All the attributes of the current room go here
    HashMap<String, String> currentRoomInfo = new HashMap<>();
    //All the items in the room
    List<String> roomItems = new LinkedList<>();
    //User's inventory
    List<String> inventory = new ArrayList<>();
    String input;
    //List of picked up items
    List<String> pickedUp = new ArrayList<>();
    //List of items used
    List<String> usedItems = new ArrayList<>();

    public void start() throws IOException, InterruptedException {
        System.out.println("Welcome to the game\n");
        System.out.println("You can type 'get (item) to add an item to your inventory'");
        System.out.println("or you can type 'go (direction)' to go to another room");
        System.out.println("Or type 'quit' to quit the game.\n");
        //Start at the bridge
        currentRoom = "bridge";
        initializeCurrentRoom(currentRoom);
        askAction();
    }
    public void askAction() throws IOException, InterruptedException {
        do{
            System.out.println();
            printInventory();
            printRoomInfo();
            evaluateChallenge();
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            evaluateInput(input);
        }
        while(!input.equals("quit"));
    }
//This is where challenges are going to be  called.
    public void evaluateChallenge() throws IOException, InterruptedException {
        String challenge = currentRoomInfo.get("challenge");

        switch(challenge){
            case "alien":
                boolean gamePlayed = false;
                if(!gamePlayed){
                    Conflict c1 = new Conflict(); //Can pass in enemy and player name / stats and if player has a weapon
                    c1.ConflictPrompt();
                }
                go("east");
                break;
            case "match":
                while(!matchPlayed) {
                    matchPlayed = true;
                    GUIButtonGame guiGame = new GUIButtonGame();
                    guiGame.start();
                    go("south");
                }
                break;
            case "hacking":
                if(usedItems.contains("key")){
                    Computer.hackPrint();
                    usedItems.remove("key");
                    askAction();
                }
                else{
                    System.out.println("You do not have the right permissions to use the computer! ");
                }

        }
    }
    public void evaluateInput(String input) throws IOException, InterruptedException {
        String[] inputArray = input.split(" ");
        if(inputArray[0].equals("quit")){
            System.exit(0);
        }
        if (inputArray.length !=2) {
            System.out.println("Wrong command");
        } else {
            if (inputArray[0].equals("go")) {
                go(inputArray[1]);
            } else if (inputArray[0].equals("get")) {
                get(inputArray[1]);
            }
            else if(inputArray[0].equals("use")){
                use(inputArray[1]);
            }
            else {
                System.out.println("You typed in the wrong command");
            }
        }
    }
    public void go(String direction) throws IOException, InterruptedException {
        if(!currentRoomInfo.containsKey(direction)){
            System.out.println("Wrong direction");
        }
        else {
            String result = currentRoomInfo.get(direction);
            if (result.equals("none")) {
                System.out.println("Cannot go that way!");
                askAction();
            } else {
                initializeCurrentRoom(result);
            }
        }
    }
    public void get(String item){
        if(roomItems.contains(item)){
            inventory.add(item);
            pickedUp.add(item);
            roomItems.remove(item);
        }
        else{
            System.out.println("Cannot add what doesn't exist!");
        }
    }
    public void use(String item){
        if(!inventory.contains(item)){
            System.out.println("You do not have this item in your inventory!");
        }
        else{
            if(inventory.contains(item) && currentRoomInfo.get("usable").equals("none")){
                System.out.println("You cannot use " + item + " in this room");
        }
            else if(inventory.contains(item) && currentRoomInfo.get("usable").equals(item)){
                System.out.println("Good job, you used " + item);
                usedItems.add(item);
                inventory.remove(item);
            }
        }
    }
    public void initializeCurrentRoom(String room){
      for (int i =  0; i<spaceship.size(); i++){
          for(int j =0 ; j<spaceship.get(i).size(); j++){
              HashMap<String, String> newMap;
              newMap = (HashMap<String, String>) spaceship.get(i).get(j);
              if(newMap.get("name").equals(room)){
                  roomItems.clear();
                  currentRoomInfo.putAll(newMap);
                  List <String> temp = Arrays.asList(currentRoomInfo.get("items").split(" "));
                  roomItems.addAll(temp);
                  for(String x : pickedUp){
                          roomItems.removeAll(Collections.singleton(x));
                  }
              }
          }
      }
      printRoomInfo();
    }
    public void printInventory(){
        System.out.println("Current items in your inventory: " + inventory +"\n");
    }
    public void printRoomInfo(){
        System.out.println("You are located in the " + currentRoomInfo.get("name"));
        System.out.println(currentRoomInfo.get("description"));
        printItems(roomItems);
    }
    public void printItems(List<String> items){
        System.out.println("----------------------------------------");
        if(items.size()==0){
            System.out.println("There are no items left to pick up in this room");
        }
        else {
            System.out.println("You see the following items: ");
            for (var item : items) {
                System.out.print(item + " ");
            }
        }
        System.out.println("\n----------------------------------------");
    }
}

