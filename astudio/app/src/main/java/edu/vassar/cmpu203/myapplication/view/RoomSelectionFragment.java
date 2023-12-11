package edu.vassar.cmpu203.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.vassar.cmpu203.myapplication.model.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.vassar.cmpu203.myapplication.R;
import edu.vassar.cmpu203.myapplication.databinding.FragmentRoomSelectionBinding;

/**
 * A simple {@link Fragment} subclass. It represents a list of frgment that represents a list of
 * room selection based on the search.
 * Use the {@link RoomSelectionFragment} factory method to
 * create an instance of this fragment.
 */
public class RoomSelectionFragment extends Fragment implements IRoomSelectionView {

    private FragmentRoomSelectionBinding binding; // reference to graphical widgets from xml layout
    private final Listener listener; // observer to be notified of events of interest
    private final List<Room> curResults; // results of the search

    /**
     * This class represents a new RoomselectionFragment with the provide current search results
     * and listener.
     * @param curResults The list of rooms represents teh current rooms.
     * @param listener To be notified of events about the selection.
     */

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

    /**
     * Called immediately OnCreatView() to check if the view hierarchy has been completely created
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (this.curResults.isEmpty()) {
            this.binding.scrollView.setVisibility(View.GONE);
            this.binding.noResults.setVisibility(View.VISIBLE);
        }
        else {
            this.binding.noResults.setVisibility(View.GONE);
            this.binding.scrollView.setVisibility(View.VISIBLE);

            this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
            MyAdapter adapter = new MyAdapter(getContext().getApplicationContext(), curResults);
            this.binding.recyclerView.setAdapter(adapter);

            adapter.setOnItemClickListener(position -> {
                RoomSelectionFragment.this.listener.onSelectionDone(position);
            });
        }


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