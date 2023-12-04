package edu.vassar.cmpu203.myapplication.model;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Review {

    private static final String RATING = "rating";
    private static final String HEADLINE = "headline";
    private static final String REVIEW_STR = "reviewStr";
    float ratingNum;
    String headline;
    String reviewStr;
    public Review(Float rating, String headline, String reviewStr){
        this.ratingNum = rating;
        this.headline = headline;
        this.reviewStr = reviewStr;
    }

    public float getRatingNum() { return ratingNum; }
    
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
        map.put(RATING, this.ratingNum);
        map.put(HEADLINE, this.headline);
        map.put(REVIEW_STR, this.reviewStr);

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
        float rating = Float.parseFloat(map.get(RATING).toString());
        String headline = (String) map.get(HEADLINE);
        String reviewStr = (String) map.get(REVIEW_STR);

        return new Review(rating, headline, reviewStr);
    }

}
