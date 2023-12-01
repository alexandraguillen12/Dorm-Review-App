package edu.vassar.cmpu203.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.myapplication.databinding.FragmentSearchBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment implements ISearchView{

    private FragmentSearchBinding binding;
    Listener listener; // observer to be notified of events of interest
    String name;
    int floor;
    String rt;
    boolean avail;

    /**
     * Called to check if the view hierachy associated with the fragment.
     * @param listener The fragment searched for the UI or null.
     */
    public SearchFragment(@NonNull Listener listener){
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentSearchBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    /**
     * Constructs the new class and view the hierarchy has been completely created.
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.binding.searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                name = SearchFragment.this.binding.houseSpinner.getSelectedItem().toString();
                String floorStr = SearchFragment.this.binding.floorSpinner.getSelectedItem().toString();
                if (floorStr.equals("All Floors")) {floor = 0;}
                else {floor = Integer.parseInt(floorStr);}
                rt = SearchFragment.this.binding.roomTypeSpinner.getSelectedItem().toString();
                String availStr = SearchFragment.this.binding.availabilitySpinner.getSelectedItem().toString();
                avail = availStr.equals("Available rooms");

                SearchFragment.this.listener.onAddedFilters(name, floor, rt, avail, SearchFragment.this);
                SearchFragment.this.listener.onSearchDone(SearchFragment.this);
            }
        });
    }
}