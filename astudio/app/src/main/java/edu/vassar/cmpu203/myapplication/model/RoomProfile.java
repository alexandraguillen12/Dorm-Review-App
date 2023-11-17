package edu.vassar.cmpu203.myapplication.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class RoomProfile {

    Room room;
    List<Review> reviewList = new ArrayList<Review>();
    List<Room> favList = new ArrayList<Room>();
    public RoomProfile(Room room){
        this.room = room;
    }

    public void addReview(Review review){
        reviewList.add(review);
    }

    public void addFavorite () {
        favList.add(this.room);
    }

    @Override
    @NonNull
    public String toString (){
        String str = "";
        for(Review r: reviewList){
            str += r.toString();
        }
        return str;
    }
}
