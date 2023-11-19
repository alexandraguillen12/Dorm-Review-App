package edu.vassar.cmpu203.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import edu.vassar.cmpu203.myapplication.R;
import edu.vassar.cmpu203.myapplication.databinding.FragmentRoomProfileBinding;
import edu.vassar.cmpu203.myapplication.model.Review;
import edu.vassar.cmpu203.myapplication.model.Room;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoomProfileFragment} factory method to
 * create an instance of this fragment.
 */
public class RoomProfileFragment extends Fragment implements IRoomProfileView {
    private FragmentRoomProfileBinding binding; // reference to graphical widgets from xml layout
    Listener listener;                          // observer to be notified of events of interest
    int position;
    Room room;

    //private ViewPager2 viewPager2;
    private PhotoPagerAdapter pagerAdapter;


    public RoomProfileFragment(@NonNull Listener listener, int position, Room room) {
        this.listener = listener;
        this.position = position;
        this.room = room;
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

        int[] imageResourceIds = {
                R.drawable.dorm1,
                R.drawable.dorm2
        };

        pagerAdapter = new PhotoPagerAdapter(requireContext(), imageResourceIds);
        this.binding.viewPager2.setAdapter(pagerAdapter);

        this.binding.btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentImage = (RoomProfileFragment.this.binding.viewPager2.getCurrentItem());
                    if (currentImage > 0) {
                        RoomProfileFragment.this.binding.viewPager2.setCurrentItem(currentImage - 1);
                    }
                }
        });
        this.binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentImage = (RoomProfileFragment.this.binding.viewPager2.getCurrentItem());
                if (currentImage < pagerAdapter.getItemCount() - 1) {
                    RoomProfileFragment.this.binding.viewPager2.setCurrentItem(currentImage + 1);
                }
            }
        });

        this.binding.description.setText(this.room.toString());

        this.binding.recyclerView2.setLayoutManager(new LinearLayoutManager(this.getContext()));
        ReviewAdapter adapter = new ReviewAdapter(getContext().getApplicationContext(), room.getReviews());
        this.binding.recyclerView2.setAdapter(adapter);

        this.binding.back2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomProfileFragment.this.listener.onNewSelection();
            }
        });

        this.binding.writeReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomProfileFragment.this.listener.onWriteReview();
            }
        });
    }

}