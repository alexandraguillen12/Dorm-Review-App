package edu.vassar.cmpu203.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.myapplication.R;
import edu.vassar.cmpu203.myapplication.databinding.FragmentRoomProfileBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoomProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoomProfileFragment extends Fragment implements IRoomProfileView {
    private FragmentRoomProfileBinding binding; // reference to graphical widgets from xml layout
    Listener listener;


    public RoomProfileFragment(@NonNull Listener listener) {
        this.listener = listener;
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentRoomProfileBinding.inflate(inflater);
        return this.binding.getRoot();
    }

}