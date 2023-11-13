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
            new Room(House.MAIN,3, RoomType.SINGLE, true),
            new Room(House.STRONG,4, RoomType.SINGLE, true),
            new Room(House.RAYMOND,2, RoomType.SINGLE, true),
            new Room(House.DAVISON,5, RoomType.DOUBLE, true),
            new Room(House.LATHROP,3, RoomType.DOUBLE, true),
            new Room(House.JEWETT,7, RoomType.TRIPLE, true),
            new Room(House.JOSSELYN,1, RoomType.SUITE, true),
            new Room(House.CUSHING,2, RoomType.TWO_ROOM_DOUBLE, true),
            new Room(House.NOYES,3, RoomType.TWO_ROOM_TRIPLE, true),
            new Room(House.JEWETT,9, RoomType.QUAD, true),
            new Room(House.JEWETT,8, RoomType.SINGLE, true),
            new Room(House.JEWETT,6, RoomType.SINGLE, true)};


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