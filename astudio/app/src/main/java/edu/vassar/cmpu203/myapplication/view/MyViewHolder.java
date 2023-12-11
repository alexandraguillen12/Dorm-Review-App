package edu.vassar.cmpu203.myapplication.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import edu.vassar.cmpu203.myapplication.R;
import edu.vassar.cmpu203.myapplication.databinding.ItemViewBinding;

/**
 * This class extends from RecyclerView.ViewHolder and represents a single item in a RecycleView.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView roomIdView,houseView,floorView,rtView,availView;
    //private ItemViewBinding binding;

    /**
     * Constructs a new MyViewHolder with the provided item view.
     * @param binding This is representing a single item in RecyclerView.
     */
    public MyViewHolder(@NonNull ItemViewBinding binding) {
        super(binding.getRoot());

        roomIdView = binding.roomId;
        houseView = binding.houseName;
        floorView = binding.floorNum;
        rtView = binding.roomType;
        availView = binding.availability;

        /*
        roomIdView = itemView.findViewById(R.id.room_id);
        houseView = itemView.findViewById(R.id.houseName);
        floorView = itemView.findViewById(R.id.floorNum);
        rtView = itemView.findViewById(R.id.roomType);
        availView = itemView.findViewById(R.id.availability);
         */
    }
}
