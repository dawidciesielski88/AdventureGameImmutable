package com.dawidciesielski;

import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> location = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        
        Map<String, Integer> tempExit = new HashMap<>();
        tempExit.put("W",2);
        location.put(0, new Location(0, "You are waking up in a strange dark place. There are door and you can see light in key hole",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        location.put(1, new Location(1, "You are inside the tunnel",tempExit));
        
        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        location.put(2, new Location(2, "You are inside the mine",tempExit));
        
        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        location.put(3, new Location(3, "You are inside the cave",tempExit));
        
        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        location.put(4, new Location(4, "You are inside the lair with some kind of monster watching in the dark",tempExit));
        
        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        location.put(5, new Location(5, "You are on the fresh air inside a forest",tempExit));
        
        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");

        int loc = 1;
        while (true) {
            System.out.println(location.get(loc).getDESCRIPTION());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = location.get(loc).getEXITS();
            System.out.println("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.println(exit + " , ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String [] words = direction.split(" ");
                for (String word: words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }
            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go into that direction");
            }

        }
    }
}
