package edu.vassar.cmpu203.myapplication.model;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

/**
 * The RoomTypeFilter class implements the Filter interface and is used to tp filter a list of rooms based on their room type
 */

public class RoomTypeFilter implements Filter{
    String type;

    /**
     * The room type to be used for filtering
     * @param type
     */

    public RoomTypeFilter(String type){
        this.type = type;
    }

    /**
     * Filters the givin list of rooms based on the specified room type.
     * @param roomList
     * @return A Arraylist containing only the rooms that match the specified room type.
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
