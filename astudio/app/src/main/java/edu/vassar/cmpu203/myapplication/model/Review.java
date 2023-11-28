package edu.vassar.cmpu203.myapplication.model;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Review {

    private static final String HEADLINE = "headline";
    private static final String REVIEWSTR = "reviewstr";
    String headline;
    String reviewStr;
    public Review(String headline, String reviewStr){
        this.headline = headline;
        this.reviewStr = reviewStr;
    }

    public String getHeadline() {
        return headline;
    }

    public String getReviewStr() {
        return reviewStr;
    }

    /**
     * Converts the Review the method is called on into a String to Object Map.
     *
     * @return A map with the review's contents
     */
    @NonNull
    public Map<String, Object> toMap(){
        Map<String, Object> map = new HashMap<>();
        map.put(HEADLINE, this.headline);
        map.put(REVIEWSTR, this.reviewStr);

        return map;
    }

    /**
     * Creates and returns a review from a previously created String to Object Map.
     *
     * @param map the Map to convert to a Review
     * @return the Review representation of the input map
     */
    @NonNull
    public static Review fromMap(@NonNull Map<String,Object> map){
        String headline = (String) map.get(HEADLINE);
        String reviewStr = (String) map.get(REVIEWSTR);

        return new Review(headline, reviewStr);
    }

}
