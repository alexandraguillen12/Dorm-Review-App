package edu.vassar.cmpu203.myapplication.view;

import edu.vassar.cmpu203.myapplication.model.House;
import edu.vassar.cmpu203.myapplication.model.RoomType;

public interface IWriteReviewView {
    /**
     * Interface that classes interested in being notified of events happening
     * to the view should implement.
     */
    interface Listener {

        /**
         * Called when the user is done writing a headline and review.
         */
        void onAddedReview(String headline, String reviewStr, IWriteReviewView view);

        /**
         * Called when the user is ready to add the review.
         */
        void onReviewDone();

        /**
         * Called when the user wants to go back to the room profile without adding a review.
         */
        void onGoBack();
    }
}
