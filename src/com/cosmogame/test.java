package com.cosmogame;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

    public void listMap(){
        ArrayList<ArrayList> rooms = new ArrayList<>();
        ArrayList<HashMap> room = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();


        map.put("name", "bridge");
        map.put("west", "kitchen");
        room.add(map);
        rooms.add(room);
        //System.out.println(rooms);

        map = new HashMap<>();
        room = new ArrayList<>();


        map.put("name", "kitchen");
        map.put("east", "none");
        room.add(map);
        rooms.add(room);

        //System.out.println(rooms);


//        for(int i = 0; i<rooms.size(); i++){
//            for(int x =0; x<rooms.get(0))
//
//        }
//
        for (var x : rooms){
            for(var a : x){
                HashMap<String, String> newMap;
                newMap = (HashMap<String, String> ) a;
                if(newMap.containsValue("bridge")){
                    System.out.println(a);
                }

            }
        }




    }
}
