package edu.vassar.cmpu203.myapplication.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String house;
    private int floor;
    private String roomType;
    private boolean availability;
    private int roomNum;
    private static final String ROOM_NUM = "roomNum";
    private ArrayList<Review> reviews = new ArrayList<>();

    public Room(String house, int floor, String roomType, boolean availability, int roomNum){
        this.house = house;
        this.floor = floor;
        this.roomType = roomType;
        this.availability = availability;
        this.roomNum = roomNum;
    };
    public String getHouse(){
        return this.house;
    };

    public int getFloor(){
        return this.floor;
    };

    public String getRoomType(){
        return this.roomType;
    };

    public boolean getAvailability(){
        return this.availability;
    };

    public int getRoomNum() { return roomNum; }

    public ArrayList<Review> getReviews() {return this.reviews;}

    public void addReviews(Review review){
        this.reviews.add(review);
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    @NonNull
    public String toString(){
        String str = "";
        String houseStr = this.house;
        houseStr = houseStr.charAt(0) + houseStr.substring(1).toLowerCase() + " House";
        str += houseStr + " | Floor " + this.floor + " | ";
        String rtStr = this.roomType;
        rtStr = rtStr.charAt(0) + rtStr.substring(1).toLowerCase();
        str += rtStr + " | ";
        if (this.availability) {str += "Available";}
        else {str += "Not available";}
        return str;
    };

}
