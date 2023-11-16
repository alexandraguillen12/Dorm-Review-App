package edu.vassar.cmpu203.myapplication.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import edu.vassar.cmpu203.myapplication.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView roomIdView,houseView,floorView,rtView,availView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        //imageView = itemView.findViewById(R.id.imageview);
        roomIdView = itemView.findViewById(R.id.room_id);
        houseView = itemView.findViewById(R.id.houseName);
        floorView = itemView.findViewById(R.id.floorNum);
        rtView = itemView.findViewById(R.id.roomType);
        availView = itemView.findViewById(R.id.availability);

    }
}
