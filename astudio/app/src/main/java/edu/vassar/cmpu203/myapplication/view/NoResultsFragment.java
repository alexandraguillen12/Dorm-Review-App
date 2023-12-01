package edu.vassar.cmpu203.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import edu.vassar.cmpu203.myapplication.databinding.FragmentNoResultsBinding;

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

    /**
     * Called a new view hierarchy associate with the view fragment.
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentNoResultsBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    /**
     * Called immediately OnCreateView()
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
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