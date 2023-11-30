package edu.vassar.cmpu203.myapplication.model;

import androidx.annotation.NonNull;

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
            new Room("Main",3, "Single", true, 327),
            new Room("Strong",4, "Single", true, 403),
            new Room("Raymond",2, "Single", true, 223),
            new Room("Davison",5, "Double", true, 557),
            new Room("Lathrop",3, "Double", true, 305),
            new Room("Jewett",7, "Triple", true, 711),
            new Room("Josselyn",1, "Suite", true, 113),
            new Room("Cushing",2, "Two Room Double", true, 217),
            new Room("Noyes",3, "Two Room Triple", true, 345),
            new Room("Jewett",9, "Quad", true, 936),
            new Room("Jewett",8, "Single", true, 823),
            new Room("Jewett",6, "Single", true, 603),
            new Room("Jewett",8, "Single", true, 815),
            new Room("Jewett",8, "Single", true, 800),
            new Room("Jewett",8, "Single", true, 810),
            new Room("Jewett",8, "Single", true, 841),
            new Room("Jewett",8, "Single", true, 836),
            new Room("Jewett",8, "Single", true, 821),
            new Room("Jewett",8, "Single", true, 816)};


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

    @Override
    @NonNull
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