package com.cosmogame;
//import org.json.simple.JSONObject;

public class Navigator {


    private static String currentRoom;

    private static String currentSouth;
    private static String currentSouthWest;
    private static String currentSouthEast;
    private static String currentNorth;
    private static String currentNorthEast;
    private static String currentNorthWest;
    private static String currentEast;
    private static String currentWest;

    //TODO
    // Get Current Room and view valid directional inputs. if invalid input is provided reject input otherwise update current room


    //Getters & Assessors
    public static String getCurrentRoom() {
        return currentRoom;
    }

    public static void setCurrentRoom(String currentRoom) {
        Navigator.currentRoom = currentRoom;
    }

    //Locate Method to show current room and additionally adjacent rooms

    public String locateMe() {
        return currentRoom;
    }


    //Test Client Start
    public static void main(String[] args) {

        if (Navigator.currentRoom == null) {
            Navigator.setCurrentRoom("Bridge"); //Navigator.currentRoom Default to Bridge
            Navigator.currentNorthWest = "Captains Quarters";
            Navigator.currentSouthWest = "Conference Room";
            currentWest = "CargoHold";
        }

        Navigator nav1 = new Navigator();
        nav1.locateMe();
        System.out.printf("You are currently located in the %s %n", nav1.getCurrentRoom());
        //System.out.println("%s is to the North West and %s is to the South West while %s is to the West", Navigator.currentSouthWest(), Navigator);
    }
}