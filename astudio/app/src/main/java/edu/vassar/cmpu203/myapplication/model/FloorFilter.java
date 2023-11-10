package edu.vassar.cmpu203.myapplication.model;

import java.util.HashSet;
import java.util.Set;

public class FloorFilter implements Filter {
    int floor;


    public FloorFilter(int floor){
        this.floor = floor;
    }
    /*
    public void add
    */

    public Set<Room> filter(Set<Room> roomList){
        Set<Room> filteredList = new HashSet<Room>();
        for (Room r : roomList) {
            if (this.floor == r.getFloor()) {
                filteredList.add(r);
            }
        }
        return filteredList;
    }
}
