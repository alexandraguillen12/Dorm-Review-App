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
 * A simple {@link Fragment} subclass. It represents a fragment that displays detailed information
 * about a specific room or image.
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

    /**
     * Construct a new RoomProfileFragment that provides listener, position and room details.
     * @param listener It notified the events happing in the fragment.
     * @param position THe position of hte room within the overall room list
     * @param room Containing details about the room.
     */
    public RoomProfileFragment(@NonNull Listener listener, int position, Room room) {
        this.listener = listener;
        this.position = position;
        this.room = room;
    }

    /**
     * Called to view hierarchy associate with the fragment.
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return The view for the fragment UI or nulll.
     */

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentRoomProfileBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    /**
     * It called immediately after the OnViewCreated build to check if the view hierarchy has been
     * completely created.
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
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