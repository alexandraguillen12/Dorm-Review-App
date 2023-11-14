package edu.vassar.cmpu203.myapplication.model;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class AvailabilityFilter implements Filter {
    boolean availability;


    public AvailabilityFilter(boolean availability){
        this.availability = availability;
    }
    /*
    public void add
    */

    public ArrayList<Room> filter(ArrayList<Room> roomList){
        ArrayList<Room> filteredList = new ArrayList<Room>();
        for (Room r : roomList) {
            if (this.availability == r.getAvailability()) {
                filteredList.add(r);
            }
        }
        return filteredList;
    }
}
