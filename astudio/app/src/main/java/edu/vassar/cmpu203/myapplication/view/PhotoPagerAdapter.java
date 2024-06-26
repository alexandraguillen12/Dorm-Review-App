package edu.vassar.cmpu203.myapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.vassar.cmpu203.myapplication.R;
import edu.vassar.cmpu203.myapplication.databinding.CarouselItemBinding;
import edu.vassar.cmpu203.myapplication.databinding.FragmentRoomProfileBinding;
import edu.vassar.cmpu203.myapplication.databinding.ReviewViewBinding;

/**
 * This class extends from Recycler.View.Adapter and serves as an adapter.view for the Recycler.View
 * and displays a carousel of photos.
 */
public class PhotoPagerAdapter extends RecyclerView.Adapter<PhotoPagerAdapter.PhotoViewHolder> {

    private Context context;
    private int[] imageResourceIds;
    private CarouselItemBinding binding;

    /**
     * A new Adapter with the provided context and array of image resource IDs.
     * @param context in which the adapter being used.
     * @param imageResourceIds The array of image which is resources IDs to displays to the carousel.
     */
    public PhotoPagerAdapter(Context context, int[] imageResourceIds) {
        this.context = context;
        this.imageResourceIds = imageResourceIds;
    }

    /**
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.binding = CarouselItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhotoViewHolder(this.binding.getRoot());
    }

    /**
     * Called when the class needs a new PhotoViewHolder of the given type to represent an item.
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.bind(position);
    }

    /**
     * Returns the total amount of items in the data set held by the adapter.
     * @return The total number of item.
     */
    @Override
    public int getItemCount() {
        return imageResourceIds.length;
    }

    /**
     * It represents a single item view in the carousel.
     */
    class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        /**
         * a new PhotoViewHolder with the provided item holder.
         * @param itemView It represents a single item in the RecyclerView.
         */
        PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = PhotoPagerAdapter.this.binding.imageView;
        }

        void bind(int position) {
            // Set image resource based on position
            imageView.setImageResource(imageResourceIds[position]);
        }
    }
}
