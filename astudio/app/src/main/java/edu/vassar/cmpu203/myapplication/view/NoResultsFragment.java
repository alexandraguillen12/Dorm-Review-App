package edu.vassar.cmpu203.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import edu.vassar.cmpu203.myapplication.R;
import edu.vassar.cmpu203.myapplication.databinding.FragmentNoResultsBinding;
import edu.vassar.cmpu203.myapplication.databinding.FragmentSearchBinding;
import edu.vassar.cmpu203.myapplication.model.House;
import edu.vassar.cmpu203.myapplication.model.RoomType;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoResultsFragment} factory method to
 * create an instance of this fragment.
 */
public class NoResultsFragment extends Fragment implements INoResultsView{
    private FragmentNoResultsBinding binding; // reference to graphical widgets from xml layout
    Listener listener; // observer to be notified of events of interest

    public NoResultsFragment(@NonNull INoResultsView.Listener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentNoResultsBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.binding.backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                NoResultsFragment.this.listener.onNewSearch();
            }
        });
    }
}