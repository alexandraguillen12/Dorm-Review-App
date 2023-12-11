package edu.vassar.cmpu203.myapplication.model;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * This class implements the Filter interface and represents a filter for filtering a list of rooms based on
 * the given floor number.
 */
public class FloorFilter implements Filter {
    int floor;

    /**
     * Constructs a new FloorFilter with the specified floor number.
     * @param floor the floor number to be used for filtering.
     */
    public FloorFilter(int floor){
        this.floor = floor;
    }

    /**
     * Filters the given room list based on the floor number.
     * @param roomList the list of the rooms to be filtered.
     * @return list containing only the specified floor number.
     */
    public ArrayList<Room> filter(ArrayList<Room> roomList){
        ArrayList<Room> filteredList = new ArrayList<Room>();
        for (Room r : roomList) {
            if (this.floor == r.getFloor()) {
                filteredList.add(r);
            }
        }
        return filteredList;
    }
}
