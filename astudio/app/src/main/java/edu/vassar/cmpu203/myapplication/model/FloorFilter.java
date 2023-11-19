package edu.vassar.cmpu203.myapplication.model;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * This class implements the filter and represents a filter for filtering a list of rooms based on
 * the floor numbers.
 */
public class FloorFilter implements Filter {
    int floor;


    public FloorFilter(int floor){
        this.floor = floor;
    }
    /*
    public void add
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
