package edu.vassar.cmpu203.myapplication.model;

import java.util.ArrayList;

public class Room {
    private House House;
    private int Floor;
    private RoomType RoomType;
    private boolean Availability;
    private ArrayList<Review> reviews = new ArrayList<>();

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

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void addReviews(Review review){
        this.reviews.add(review);
    }

    public String toString(){
        String str = String.format("%s, %d, %s, ", this.House, this.Floor, this.RoomType);
        if (this.Availability) {str += "available";}
        else {str += "not available";}
        return str;
    };

}
