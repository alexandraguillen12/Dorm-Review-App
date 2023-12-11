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
 * A simple {@link Fragment} subclass. It represents a fragment that displays a list of
 * rooms based on the search.
 * Use the {@link RoomSelectionFragment} factory method to
 * create an instance of this fragment.
 */
public class RoomSelectionFragment extends Fragment implements IRoomSelectionView {

    private FragmentRoomSelectionBinding binding; // reference to graphical widgets from xml layout
    private final Listener listener; // observer to be notified of events of interest
    private final List<Room> curResults; // results of the search

    /**
     * Creates a new RoomSelectionFragment with the provide current search results
     * and listener.
     * @param curResults The list of rooms represents teh current rooms.
     * @param listener To be notified of events about the selection.
     */
    public RoomSelectionFragment(List<Room> curResults, @NonNull Listener listener) {
        this.curResults = curResults;
        this.listener = listener;
    }

    /**
     * onCreateView() overrides method of the same name from superclass. It's purpose is to
     * inflate the xml layout associated with the fragment.
     * @param inflater object to use to inflate the xml layout (create actual graphical widgets out of the xml declarations)
     * @param container where the graphical widgets will be placed
     * @param savedInstanceState any saved state information to be restored (null if none exists)
     * @return the root of the layout that has just been inflated
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = FragmentRoomSelectionBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    /**
     * Called immediately OnCreateView() to check if the view hierarchy has been completely created
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // displays results from search. If results list is empty, shows "No results"
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

            // register adapter click listener
            adapter.setOnItemClickListener(position -> {
                RoomSelectionFragment.this.listener.onSelectionDone(position);
            });
        }


        // register new search button click listener
        this.binding.newSearchButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when associated button is clicked.
             * @param view The view that was clicked.
             */
            @Override
            public void onClick(View view) {
                RoomSelectionFragment.this.listener.onNewSearch();
            }
        });
    }

}