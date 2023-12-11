package edu.vassar.cmpu203.myapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.vassar.cmpu203.myapplication.R;
import edu.vassar.cmpu203.myapplication.databinding.CarouselItemBinding;
import edu.vassar.cmpu203.myapplication.databinding.ReviewViewBinding;
import edu.vassar.cmpu203.myapplication.model.Review;
import edu.vassar.cmpu203.myapplication.model.Room;

/**
 * This class extends from Recycler.View.Adapter and serves as adapter for the Recycler view
 * that displays a carousel of photo.
 */
public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.RViewHolder> {
    private Context context;
    ArrayList<Review> reviewArrayList;
    ReviewViewBinding binding;

    /**
     * Constructs a new PhotoPagerAdapter that provide context array of image resources IDs.
     * @param context Which the adapter being exist.
     * @param reviewArrayList The array of image which the adapter being used.
     */
    public ReviewAdapter(Context context, ArrayList<Review> reviewArrayList) {
        this.context = context;
        this.reviewArrayList = reviewArrayList;
    }

    @NonNull
    @Override
    public RViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.binding = ReviewViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RViewHolder(this.binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolder holder, int position) {
        holder.fixedRatingView.setRating(reviewArrayList.get(position).getRatingNum());
        holder.headlineView.setText(reviewArrayList.get(position).getHeadline());
        holder.reviewView.setText(reviewArrayList.get(position).getReviewStr());
    }

    /**
     * Returns the amount of the item in the data set held by the adapter set
     * @return the amount of the item in the adapter set.
     */
    @Override
    public int getItemCount() {
        return reviewArrayList.size();
    }

    class RViewHolder extends RecyclerView.ViewHolder {
        TextView headlineView, reviewView;
        RatingBar fixedRatingView;

        RViewHolder(@NonNull View itemView) {
            super(itemView);

            fixedRatingView = ReviewAdapter.this.binding.fixedRatingBar;
            headlineView = ReviewAdapter.this.binding.headlineText;
            reviewView = ReviewAdapter.this.binding.reviewText;
        }

    }
}
