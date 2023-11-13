package edu.vassar.cmpu203.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import edu.vassar.cmpu203.myapplication.R;
import edu.vassar.cmpu203.myapplication.databinding.FragmentSearchBinding;
import edu.vassar.cmpu203.myapplication.model.House;
import edu.vassar.cmpu203.myapplication.model.RoomType;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment implements ISearchView{

    private FragmentSearchBinding binding;
    Listener listener; // observer to be notified of events of interest

    public SearchFragment(@NonNull Listener listener){
        this.listener = listener;
    }

    /*
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentSearchBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.binding.searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //next fragment?
                Spinner houseSpinner = v.findViewById(R.id.houseSpinner);
                String houseStr = houseSpinner.getSelectedItem().toString();

                Spinner floorSpinner = v.findViewById(R.id.floorSpinner);
                String floorStr = floorSpinner.getSelectedItem().toString();

                Spinner rtSpinner = v.findViewById(R.id.roomTypeSpinner);
                String rtStr = rtSpinner.getSelectedItem().toString();

                Spinner availSpinner = v.findViewById(R.id.availabilitySpinner);
                String availStr = availSpinner.getSelectedItem().toString();

                House name = House.valueOf(houseStr);
                int floor = Integer.parseInt(floorStr);
                RoomType rt = RoomType.valueOf(rtStr);
                boolean avail = true;

                SearchFragment.this.listener.onAddedFilters(name, floor, rt, avail, SearchFragment.this);
                SearchFragment.this.listener.onSearchDone();
            }
        });
    }
}