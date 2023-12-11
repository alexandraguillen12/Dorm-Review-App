package edu.vassar.cmpu203.myapplication.persistence;

import com.google.firebase.firestore.FirebaseFirestore;
import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import edu.vassar.cmpu203.myapplication.model.Review;
import edu.vassar.cmpu203.myapplication.model.Room;

/**
 * The FireStoreFacade class implements the IPersistanceFacade interface and provides methods for
 * interacting with FireStore as th underlying persistance solution.
 */
public class FirestoreFacade implements IPersistenceFacade{

    /**
     * The name of the FireStore collection used for storing reviews.
     */
    private static final String REVIEWS_COLLECTION = "reviews";
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    /**
     * Saves the review passed in as input to the underlying persistence solution.
     * @param review the review to be saved
     */
    @Override
    public void saveReview(@NonNull Review review, Room room) {
        CollectionReference cref = this.db.collection(REVIEWS_COLLECTION);
        Map<String, Object> reviewOfRoom = review.toMap();
        reviewOfRoom.put("roomNum", room.getRoomNum());
        cref.add(reviewOfRoom);
    }

    /**
     * Retrieves reviews associated itwh a specific room from the Firestore database notifies the listener.
     * @param listener the observer to be notified of query result.
     * @param room The room that the reviews should be retrieved.
     */

    @Override
    public void retrieveReviews(@NonNull Listener listener, Room room) {
        ArrayList<Review> reviews = new ArrayList<Review>();

        Task<QuerySnapshot> task = this.db.collection(REVIEWS_COLLECTION).whereEqualTo("roomNum", room.getRoomNum()).get();

        task.addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot qsnap) {
                for (DocumentSnapshot dsnap : qsnap){
                    Map<String, Object> mapData = dsnap.getData();
                    Review review = Review.fromMap(mapData);
                    reviews.add(review);
                }
                listener.onReviewsReceived(reviews);
            }
        });
    }

}
