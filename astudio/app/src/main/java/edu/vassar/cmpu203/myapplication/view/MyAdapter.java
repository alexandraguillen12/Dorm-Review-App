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

/**
 * The MyAdapter class extends RecyclerView.Adaptr and severs like adapter for pou;ating a
 * RecyclerReview with a list of rooms.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<Room> rooms;
    private onItemClickListener onItemClickListener;

    /**
     * Constucts with a new MyAdapter with specified context and list of rooms.
     * @param context The context that the adapter being used
     * @param rooms The rooms to be displays
     */
    public MyAdapter(Context context, List<Room> rooms) {
        this.context = context;
        this.rooms = rooms;
    }

    /**
     * For handling the items
     */
    public interface onItemClickListener {
        void onItemClick(int position);
    }

    /**
     * For handling item click events.
     * @param listener The listener to be set.
     */
    public void setOnItemClickListener(onItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    /**
     * Called when the RecylceViews needs of a new MyViewHolder of the givin type to represent an item.
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new MyViewHolder that holds with a specified layout resources.
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    /**
     * Called RecycleView to display the data at specified position.
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String roomIdStr = "Room " + rooms.get(position).getRoomNum();
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

        holder.itemView.setOnClickListener(view -> {
            if (onItemClickListener !=null) {
                onItemClickListener.onItemClick(position);
            }
        });
    }



    @Override
    public int getItemCount() {
        return rooms.size();
    }

}
