package edu.vassar.cmpu203.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.vassar.cmpu203.myapplication.model.Room;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.vassar.cmpu203.myapplication.R;
import edu.vassar.cmpu203.myapplication.databinding.FragmentRoomSelectionBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoomSelectionFragment} factory method to
 * create an instance of this fragment.
 */
public class RoomSelectionFragment extends Fragment implements IRoomSelectionView {

    private FragmentRoomSelectionBinding binding; // reference to graphical widgets from xml layout
    private final Listener listener; // observer to be notified of events of interest
    private final List<Room> curResults; // total amount to charge for sale



    public RoomSelectionFragment(List<Room> curResults, @NonNull Listener listener) {
        this.curResults = curResults;
        this.listener = listener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = FragmentRoomSelectionBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        this.binding.recyclerView.setAdapter(new MyAdapter(getContext().getApplicationContext(), curResults));

        /*this.binding.recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomSelectionFragment.this.listener.onSelectionDone();
            }
        });

         */

        this.binding.newSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomSelectionFragment.this.listener.onNewSearch();
            }
        });
    }

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_room_selection);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getContext().getApplicationContext(),curResults));
    }

     */


}