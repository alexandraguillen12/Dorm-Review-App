package edu.vassar.cmpu203.myapplication.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a room.
 */
public class Room {
    private String house;
    private int floor;
    private String roomType;
    private boolean availability;
    private int roomNum;
    private static final String ROOM_NUM = "roomNum";
    private ArrayList<Review> reviews = new ArrayList<>();

    /**
     * Constructor, initializes fields to values provided.
     *
     * @param house the house name the room is located in
     * @param floor the floor the room is on
     * @param roomType the type of room
     * @param availability the availability status of the room
     * @param roomNum the room number
     */
    public Room(String house, int floor, String roomType, boolean availability, int roomNum){
        this.house = house;
        this.floor = floor;
        this.roomType = roomType;
        this.availability = availability;
        this.roomNum = roomNum;
    };

    /**
     * Returns the room's house.
     * @return the room's house.
     */
    public String getHouse(){
        return this.house;
    };

    /**
     * Returns the room's floor.
     * @return the room's floor.
     */
    public int getFloor(){
        return this.floor;
    };

    /**
     * Returns the room's type.
     * @return the room's type.
     */
    public String getRoomType(){
        return this.roomType;
    };

    /**
     * Returns the room's availability.
     * @return the room's availability.
     */
    public boolean getAvailability(){
        return this.availability;
    };

    /**
     * Returns the room's number.
     * @return the room's number.
     */
    public int getRoomNum() { return roomNum; }

    /**
     * Returns the room's reviews.
     * @return the room's reviews.
     */
    public ArrayList<Review> getReviews() {return this.reviews;}

    /**
     * Adds the given review to the review list of the room.
     * @param review the review written for the room
     */
    public void addReviews(Review review){
        this.reviews.add(review);
    }

    /**
     * Sets the given review list as the review list of the room.
     * @param reviews the list of reviews given
     */
    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    /**
     * Returns a textual representation of the room.
     * @return the room's textual representation
     */
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
