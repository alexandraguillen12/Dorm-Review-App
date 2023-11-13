package edu.vassar.cmpu203.myapplication.model;

import java.util.HashSet;
import java.util.Set;

public class AvailabilityFilter {
    boolean availability;


    public AvailabilityFilter(RoomType type){
        this.availability = availability;
    }
    /*
    public void add
    */

    public Set<Room> filter(Set<Room> roomList){
        Set<Room> filteredList = new HashSet<Room>();
        for (Room r : roomList) {
            if (this.availability == r.getAvailability()) {
                filteredList.add(r);
            }
        }
        return filteredList;
    }
}