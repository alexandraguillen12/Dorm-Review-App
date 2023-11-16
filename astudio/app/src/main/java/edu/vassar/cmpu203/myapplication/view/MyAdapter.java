package edu.vassar.cmpu203.myapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.vassar.cmpu203.myapplication.R;
import edu.vassar.cmpu203.myapplication.model.Room;
import edu.vassar.cmpu203.myapplication.view.MyViewHolder;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<Room> rooms;

    public MyAdapter(Context context, List<Room> rooms) {
        this.context = context;
        this.rooms = rooms;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String roomIdStr = "Room " + (position + 1);
        holder.roomIdView.setText(roomIdStr);
        String houseStrDisplay = rooms.get(position).getHouse().toString();
        houseStrDisplay = houseStrDisplay.substring(0,1) + houseStrDisplay.substring(1).toLowerCase() + " House";
        holder.houseView.setText(houseStrDisplay);
        String floorStrDisplay = "Floor " + rooms.get(position).getFloor();
        holder.floorView.setText(floorStrDisplay);
        String rtStrDisplay = rooms.get(position).getRoomType().toString();
        rtStrDisplay = rtStrDisplay.substring(0,1) + rtStrDisplay.substring(1).toLowerCase();
        holder.rtView.setText(rtStrDisplay);
        if (rooms.get(position).getAvailability()) { holder.availView.setText("Available");}
        else { holder.availView.setText("Not Available");}
        //holder.imageView.setImageResource(rooms.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

}
