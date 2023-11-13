package edu.vassar.cmpu203.myapplication.model;

import java.util.ArrayList;
import java.util.Set;

public class RoomLibrary {
    public ArrayList<Room> rooms;


    public int size = 0;

    public RoomLibrary(){
        this.rooms = new ArrayList<>();
    }

    public void addRoom(House name, int floor, RoomType rt, boolean availability){
        Room r = new Room(name, floor, rt, availability);
        this.rooms.add(r);
        this.size ++;
    }


    public String toString(){
        int i = 1;
        String rl = "";
        for (Room r : this.rooms){
            rl += i + ": " + r + "\n";
            i ++;
        }
        return rl;
    }

    /*
    public Set<Room> Search(Set<Room> roomList, Set<Filter> filters){
        for (Filter f : filters) roomList = f.filter(roomList);
        return roomList;
    }
     */

}