package com.cosmogame;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

public class TextParser {
    static String bridgeDescription ="";
    static String gymDescription ="";
    static String kitchenDescription="";
    static Map<String, String> bridgeExits = new HashMap<>();
    static Map<String, String> gymExits = new HashMap<>();
    static Map<String, String> kitchenExits = new HashMap<>();
    static List<String> bridgeItems = new ArrayList<>();
    static List<String> gymItems = new ArrayList<>();
    static List<String> kitchenItems = new ArrayList<>();

    public void parser() {

        try {
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
            NodeList rooms = document.getElementsByTagName("room");

            for (int i = 0; i<rooms.getLength(); i++){
                Node node = rooms.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    //print the current room
                    if (element.getAttribute("id").equals("bridge")){
                        bridgeDescription = element.getElementsByTagName("description").item(0).getTextContent();
                        bridgeExits.put("west",element.getElementsByTagName("west").item(0).getTextContent());
                        bridgeExits.put("south",element.getElementsByTagName("south").item(0).getTextContent());
                        bridgeItems = Arrays.asList(element.getElementsByTagName("items").item(0).getTextContent().split(" "));
                    }
                    else if (element.getAttribute("id").equals("gym")){
                        gymDescription =  element.getElementsByTagName("description").item(0).getTextContent();
                        gymExits.put("east",element.getElementsByTagName("east").item(0).getTextContent());
                        gymItems =Arrays.asList(element.getElementsByTagName("items").item(0).getTextContent().split(" "));

                    }
                    else if (element.getAttribute("id").equals("kitchen")){
                        kitchenDescription =  element.getElementsByTagName("description").item(0).getTextContent();
                        kitchenExits.put("north",element.getElementsByTagName("north").item(0).getTextContent());
                        kitchenItems = Arrays.asList(element.getElementsByTagName("items").item(0).getTextContent().split(" "));
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
