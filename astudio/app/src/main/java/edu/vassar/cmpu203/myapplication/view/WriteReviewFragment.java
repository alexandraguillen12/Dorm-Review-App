package edu.vassar.cmpu203.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.myapplication.databinding.FragmentRoomProfileBinding;
import edu.vassar.cmpu203.myapplication.databinding.FragmentWriteReviewBinding;
import edu.vassar.cmpu203.myapplication.view.IWriteReviewView;
import edu.vassar.cmpu203.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WriteReviewFragment} factory method to
 * create an instance of this fragment.
 */
public class WriteReviewFragment extends Fragment implements IWriteReviewView {

    private FragmentWriteReviewBinding binding; // reference to graphical widgets from xml layout
    Listener listener;                          // observer to be notified of events of interest

    /**
     * A new WriteReviewFragment with the listener.
     * @param listener Be notified of the events related to the view.
     */
    public WriteReviewFragment(@NonNull Listener listener) {
        this.listener = listener;
    }
    /**
     * Called to view the new hierarchy associate with the fragments.
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return THe view for the fragment UI and null.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentWriteReviewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    /**
     * Called immediately after OnCreateView() has returned and check if the view hierarchy
     * has been completely created.
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.binding.back3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // notify listener (controller)
                WriteReviewFragment.this.listener.onGoBack();
            }
        });

        this.binding.addReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // retrieves rating
                final Float ratingNum = WriteReviewFragment.this.binding.simpleRatingBar.getRating();

                // retrieves headline
                final Editable headlineEditable = WriteReviewFragment.this.binding.headlineInput.getText();
                final String headlineStr = headlineEditable.toString();

                // retrieve written review
                final Editable writtenReviewEditable = WriteReviewFragment.this.binding.writtenReviewInput.getText();
                final String writtenReviewStr = writtenReviewEditable.toString();

                // confirm we have both headline and written review
                if (headlineStr.length() == 0 || writtenReviewStr.length() == 0){
                    String errMsgStr = view.getContext().getString(R.string.missing_item_fields_error);
                    Snackbar.make(view, errMsgStr, Snackbar.LENGTH_LONG).show();
                    return;
                }

                // notify listener (controller)
                WriteReviewFragment.this.listener.onAddedReview(ratingNum, headlineStr, writtenReviewStr, WriteReviewFragment.this);
                WriteReviewFragment.this.listener.onReviewDone();
            }
        });
    }


}