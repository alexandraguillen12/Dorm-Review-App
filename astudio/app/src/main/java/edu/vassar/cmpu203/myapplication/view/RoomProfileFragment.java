package edu.vassar.cmpu203.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.myapplication.R;
import edu.vassar.cmpu203.myapplication.databinding.FragmentRoomProfileBinding;
import edu.vassar.cmpu203.myapplication.model.Room;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoomProfileFragment} factory method to
 * create an instance of this fragment.
 */
public class RoomProfileFragment extends Fragment implements IRoomProfileView {
    private FragmentRoomProfileBinding binding; // reference to graphical widgets from xml layout
    Listener listener;
    int position;


    public RoomProfileFragment(@NonNull Listener listener, int position) {
        this.listener = listener;
        this.position = position;
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentRoomProfileBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String str = "Room " + (position + 1);
        this.binding.roomIdText.setText(str);

        this.binding.back2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomProfileFragment.this.listener.onNewSelection();
            }
        });
    }

}