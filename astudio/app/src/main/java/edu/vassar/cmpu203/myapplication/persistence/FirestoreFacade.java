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


public class FirestoreFacade implements IPersistenceFacade{

    private static final String REVIEWS_COLLECTION = "reviews";
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    /**
     * Saves the review passed in as input to the underlying persistence solution.
     * @param review the review to be saved
     */
    @Override
    public void saveReview(@NonNull Review review) {
        CollectionReference cref = this.db.collection(REVIEWS_COLLECTION);
        cref.add(review.toMap());
    }

    @Override
    public void retrieveReviews(@NonNull Listener listener) {
        ArrayList<Review> reviews = new ArrayList<Review>();

        Task<QuerySnapshot> task = this.db.collection(REVIEWS_COLLECTION).get();

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
