package edu.vassar.cmpu203.myapplication.model;

public class Room {
    private House House;
    private int Floor;
    private RoomType RoomType;
    private boolean Availability;

    public Room(House house, int floor, RoomType roomType, boolean availability){
        this.House = house;
        this.Floor = floor;
        this.RoomType = roomType;
        this.Availability = availability;
    };
    public House getHouse(){
        return this.House;
    };

    public int getFloor(){
        return this.Floor;
    };

    public RoomType getRoomType(){
        return this.RoomType;
    };

    public boolean getAvailability(){
        return this.Availability;
    };

    public String toString(){
        return String.format("Room (%s, %d, %s, %s)", this.House, this.Floor, this.RoomType, this.Availability);
    };

}
