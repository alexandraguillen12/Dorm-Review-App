package edu.vassar.cmpu203.myapplication.model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private House House;
    private int Floor;
    private RoomType RoomType;
    private boolean Availability;
    private int roomNum;
    private ArrayList<Review> reviews = new ArrayList<>();

    public Room(House house, int floor, RoomType roomType, boolean availability, int roomNum){
        this.House = house;
        this.Floor = floor;
        this.RoomType = roomType;
        this.Availability = availability;
        this.roomNum = roomNum;
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

    public int getRoomNum() { return roomNum; }

    public ArrayList<Review> getReviews() {return this.reviews;}

    public void addReviews(Review review){
        this.reviews.add(review);
    }

    public String toString(){
        String str = "";
        String houseStr = this.House.toString();
        houseStr = houseStr.substring(0,1) + houseStr.substring(1).toLowerCase() + " House";
        str += houseStr + ", Floor " + this.Floor + ", ";
        String rtStr = this.RoomType.toString();
        rtStr = rtStr.substring(0,1) + rtStr.substring(1).toLowerCase();
        str += rtStr + ", ";
        if (this.Availability) {str += "available";}
        else {str += "not available";}
        return str;
    };

}
