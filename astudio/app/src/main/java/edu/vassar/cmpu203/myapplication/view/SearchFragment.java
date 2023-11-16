package edu.vassar.cmpu203.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    House name;
    int floor;
    RoomType rt;
    boolean avail;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*this.binding.houseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 String houseStr = getSelectedItem().toString();
                 name = House.valueOf(houseStr);
             }

             @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        this.binding.floorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String floorStr = floorSpinner.getSelectedItem().toString();
                floor = Integer.parseInt(floorStr);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        this.binding.roomTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String rtStr = rtSpinner.getSelectedItem().toString();
                rt = RoomType.valueOf(rtStr);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        this.binding.availabilitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String availStr = availSpinner.getSelectedItem().toString();
                avail = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

         */



        this.binding.searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //next fragment?
                String houseStr = SearchFragment.this.binding.houseSpinner.getSelectedItem().toString();
                houseStr = houseStr.toUpperCase();
                if (houseStr.equals("ALL HOUSES")) {name = House.ALL_HOUSES;}
                else {name = House.valueOf(houseStr);}
                String floorStr = SearchFragment.this.binding.floorSpinner.getSelectedItem().toString();
                if (floorStr.equals("All Floors")) {floor = 0;}
                else {floor = Integer.parseInt(floorStr);}
                String rtStr = SearchFragment.this.binding.roomTypeSpinner.getSelectedItem().toString();
                rtStr = rtStr.toUpperCase();
                if (rtStr.equals("ALL ROOM TYPES")) {rt = RoomType.ALL_ROOM_TYPES;}
                else {rt = RoomType.valueOf(rtStr);}
                String availStr = SearchFragment.this.binding.availabilitySpinner.getSelectedItem().toString();
                avail = availStr.equals("Available rooms");

                SearchFragment.this.listener.onAddedFilters(name, floor, rt, avail, SearchFragment.this);
                SearchFragment.this.listener.onSearchDone();
            }
        });
    }
}