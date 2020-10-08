package com.cosmogame;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.*;

public class TextParser {

    public void parser() {
        try {
            //Get Document Builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Build the document from xml file
            Document document = builder.parse(new File("./src/spaceship.xml"));
            //Normalize
            document.getDocumentElement().normalize();
            //Get the root of the document and print it
            Element root = document.getDocumentElement();
            System.out.println(root.getNodeName());

            //Get all the rooms in the document
            NodeList rooms = document.getElementsByTagName("room");

            for (int i = 0; i<rooms.getLength(); i++){
                Node node = rooms.item(i);
                System.out.println("--   --   --  ");

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    //print the current room
                    System.out.println("You are currently in: "+element.getAttribute("id"));
                    System.out.println(element.getElementsByTagName("description").item(0).getTextContent());
                    System.out.println("You can see: " + element.getElementsByTagName("items").item(0).getTextContent());


                }

            }









        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


}
