package edu.vassar.cmpu203.myapplication.model;

import java.util.HashSet;
import java.util.Set;

public class RoomTypeFilter implements Filter{
    RoomType type;


    public RoomTypeFilter(RoomType type){
        this.type = type;
    }
    /*
    public void add
    */

    public Set<Room> filter(Set<Room> roomList){
        Set<Room> filteredList = new HashSet<Room>();
        for (Room r : roomList) {
            if (this.type == r.getRoomType()) {
                filteredList.add(r);
            }
        }
        return filteredList;
    }
}
