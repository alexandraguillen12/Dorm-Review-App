package edu.vassar.cmpu203.myapplication.persistence;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import edu.vassar.cmpu203.myapplication.model.Review;
import edu.vassar.cmpu203.myapplication.model.Room;

/**
 * Interface that specifies a contract that all persistence solutions must fulfill.
 */
public interface IPersistenceFacade {

    /**
     * Interface that classes interested in being notified of data-generating events
     * from the persistence layer should implement.
     */
    interface Listener {
        void onReviewsReceived(@NonNull ArrayList<Review> reviews);
    }

    /**
     * Saves the review passed in as input to the underlying persistence solution.
     * @param review the review to be saved
     */
    void saveReview(@NonNull Review review, Room room);

    /**
     * Issues a review list retrieval operation.
     * @param listener the observer to be notified of query result.
     */
    void retrieveReviews(@NonNull Listener listener, Room room);
}
