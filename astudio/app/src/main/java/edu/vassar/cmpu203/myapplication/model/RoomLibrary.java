package edu.vassar.cmpu203.myapplication.model;

import java.util.ArrayList;
import java.util.Set;

/**
 * The RoomLibrary class represents a library of rooms within a context, allowing the management and
 * retrieval of room information. It contains a collection of rooms, a default size, method for
 * adding the rooms, and receiving the room library and representing a short representation of the rooms.
 */
public class RoomLibrary {
    public ArrayList<Room> rooms;


    public int size = 12;
    public RoomLibrary(){
        this.rooms = new ArrayList<>();
    }

    /**
     * Adds new room to the library with the specified parameters and the specified size.
     */

    Room[] roomArray = new Room[] {
            new Room(House.MAIN,3, RoomType.SINGLE, true, 327),
            new Room(House.STRONG,4, RoomType.SINGLE, true, 403),
            new Room(House.RAYMOND,2, RoomType.SINGLE, true, 223),
            new Room(House.DAVISON,5, RoomType.DOUBLE, true, 557),
            new Room(House.LATHROP,3, RoomType.DOUBLE, true, 305),
            new Room(House.JEWETT,7, RoomType.TRIPLE, true, 711),
            new Room(House.JOSSELYN,1, RoomType.SUITE, true, 113),
            new Room(House.CUSHING,2, RoomType.TWO_ROOM_DOUBLE, true, 217),
            new Room(House.NOYES,3, RoomType.TWO_ROOM_TRIPLE, true, 345),
            new Room(House.JEWETT,9, RoomType.QUAD, true, 936),
            new Room(House.JEWETT,8, RoomType.SINGLE, true, 823),
            new Room(House.JEWETT,6, RoomType.SINGLE, true, 603),
            new Room(House.JEWETT,8, RoomType.SINGLE, true, 815),
            new Room(House.JEWETT,8, RoomType.SINGLE, true, 800),
            new Room(House.JEWETT,8, RoomType.SINGLE, true, 810),
            new Room(House.JEWETT,8, RoomType.SINGLE, true, 841),
            new Room(House.JEWETT,8, RoomType.SINGLE, true, 836),
            new Room(House.JEWETT,8, RoomType.SINGLE, true, 821),
            new Room(House.JEWETT,8, RoomType.SINGLE, true, 816)};


    /*public void addRoom(House name, int floor, RoomType rt, boolean availability){
        Room r = new Room(name, floor, rt, availability, );
        this.rooms.add(r);
        this.size ++;
    }

     */

    public ArrayList<Room> getRoomLibrary(){
        //this.rooms = (ArrayList<Room>) Arrays.asList(roomList);

        this.rooms = new ArrayList<>();
        for (Room r : roomArray)
            this.rooms.add(r);

        return this.rooms;
    }

    /**
     * Generates a string representation of the room in the library, including their context
     * and their detail
     * @return A formatting string representing the rooms in the library.
     */

    public String toString(){
        int i = 1;
        String rl = "";
        for (Room r : this.rooms){
            rl += i + ": " + r + "\n";
            i ++;
        }
        return rl;
    }


}