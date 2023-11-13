package edu.vassar.cmpu203.myapplication.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class RoomLibrary {
    public ArrayList<Room> rooms;


    public int size = 1;

    public RoomLibrary(){
        this.rooms = new ArrayList<>();
    }

    Room[] roomList = new Room[] {
            new Room(House.JEWETT,3, RoomType.SINGLE, true)};


    public void addRoom(House name, int floor, RoomType rt, boolean availability){
        Room r = new Room(name, floor, rt, availability);
        this.rooms.add(r);
        this.size ++;
    }

    public ArrayList<Room> getRoomLibrary(){
        this.rooms = (ArrayList<Room>) Arrays.asList(roomList);
        return this.rooms; }


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