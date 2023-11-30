package edu.vassar.cmpu203.myapplication.model;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeFilter implements Filter{
    String type;


    public RoomTypeFilter(String type){
        this.type = type;
    }
    /*
    public void add
    */

    public ArrayList<Room> filter(ArrayList<Room> roomList){
        ArrayList<Room> filteredList = new ArrayList<Room>();
        for (Room r : roomList) {
            if (this.type.equals(r.getRoomType())) {
                filteredList.add(r);
            }
        }
        return filteredList;
    }
}
