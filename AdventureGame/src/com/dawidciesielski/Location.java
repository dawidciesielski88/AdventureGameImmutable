package com.dawidciesielski;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int LOCATION_ID;
    private final String DESCRIPTION;
    private final Map<String,Integer> EXITS;

    public Location(int LOCATION_ID, String DESCRIPTION, Map<String, Integer> exits) {
        this.LOCATION_ID = LOCATION_ID;
        this.DESCRIPTION = DESCRIPTION;
        if (exits != null) {
            this.EXITS = new HashMap<>(exits);
        } else {
            this.EXITS = new HashMap<>();
        }
        this.EXITS.put("Q",0);

    }


//    public void addExit (String direction, int location) {
//        EXITS.put(direction,location);
//    }

    public int getLOCATION_ID() {
        return LOCATION_ID;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public Map<String, Integer> getEXITS() {
        return new HashMap<>(EXITS);
    }
}
