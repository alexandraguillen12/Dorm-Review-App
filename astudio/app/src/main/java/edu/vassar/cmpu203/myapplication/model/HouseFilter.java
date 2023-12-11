package edu.vassar.cmpu203.myapplication.model;

import java.util.*;

/**
 * The HouseFilter implements the filter interface and represents a filter for filtering a list
 * house based on house name.
 */
public class HouseFilter implements Filter {

    String name;

    /**
     * Constructs a new HouseFilter with the specified house name.
     * @param name the house name to be used for filtering.
     */
    public HouseFilter(String name){
        this.name = name;
    }

    /**
     * Filters the given room list based on the house name.
     * @param roomList the list of the rooms to be filtered.
     * @return list containing only the specified house name.
     */
    public ArrayList<Room> filter(ArrayList<Room> roomList){
        ArrayList<Room> filteredList = new ArrayList<Room>();
        for (Room r : roomList) {
            if (this.name.equals(r.getHouse())) {
                filteredList.add(r);
            }
        }
        return filteredList;
    }
}
