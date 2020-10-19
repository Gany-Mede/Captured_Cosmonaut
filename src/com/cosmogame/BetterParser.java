package com.cosmogame;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

public class BetterParser {
    static ArrayList<ArrayList> rooms = new ArrayList<>();
    public void betterParser(){

        ArrayList<HashMap> room = new ArrayList<>();
        HashMap<String, String> insideRoom = new HashMap<>();

        try{
            //Get Document Builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Build the document from xml file
            Document document = builder.parse(new File("./src/com/cosmogame/spaceship.xml"));
            //Normalize
            document.getDocumentElement().normalize();
            //Get the root of the document and print it
            Element root = document.getDocumentElement();
            //Get all the rooms in the document
            NodeList allRooms = document.getElementsByTagName("room");

            for (int i = 0; i<allRooms.getLength(); i++){
                Node node = allRooms.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    insideRoom.put("name", element.getElementsByTagName("name").item(0).getTextContent());
                    insideRoom.put("description", element.getElementsByTagName("description").item(0).getTextContent());
                    insideRoom.put("items", element.getElementsByTagName("items").item(0).getTextContent());
                    insideRoom.put("north", element.getElementsByTagName("north").item(0).getTextContent());
                    insideRoom.put("east", element.getElementsByTagName("east").item(0).getTextContent());
                    insideRoom.put("west", element.getElementsByTagName("west").item(0).getTextContent());
                    insideRoom.put("south", element.getElementsByTagName("south").item(0).getTextContent());
                    insideRoom.put("usable", element.getElementsByTagName("usable").item(0).getTextContent());
                    insideRoom.put("challenge", element.getElementsByTagName("challenge").item(0).getTextContent());
                    //add all room attributes inside the room array list
                    room.add(insideRoom);
                    //add that room with attributes inside the rooms array
                    rooms.add(room);
                    //create new data structures for a new room
                    insideRoom = new HashMap<>();
                    room = new ArrayList<>();

                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
