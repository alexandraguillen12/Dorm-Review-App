package edu.vassar.cmpu203.myapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.vassar.cmpu203.myapplication.R;
import edu.vassar.cmpu203.myapplication.model.Review;
import edu.vassar.cmpu203.myapplication.model.Room;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.RViewHolder> {
    private Context context;
    ArrayList<Review> reviewArrayList;

    public ReviewAdapter(Context context, ArrayList<Review> reviewArrayList) {
        this.context = context;
        this.reviewArrayList = reviewArrayList;
    }

    @NonNull
    @Override
    public RViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_view, parent, false);
        return new RViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolder holder, int position) {
        holder.headlineView.setText(reviewArrayList.get(position).getHeadline());
        holder.reviewView.setText(reviewArrayList.get(position).getReviewStr());
    }

    @Override
    public int getItemCount() {
        return reviewArrayList.size();
    }

    static class RViewHolder extends RecyclerView.ViewHolder {
        TextView headlineView, reviewView;

        RViewHolder(@NonNull View itemView) {
            super(itemView);
            headlineView = itemView.findViewById(R.id.headlineText);
            reviewView = itemView.findViewById(R.id.reviewText);
        }

    }
}
