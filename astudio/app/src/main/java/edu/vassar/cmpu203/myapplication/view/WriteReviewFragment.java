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

    public WriteReviewFragment(@NonNull Listener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentWriteReviewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

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
                WriteReviewFragment.this.listener.onAddedReview(headlineStr, writtenReviewStr, WriteReviewFragment.this);
                WriteReviewFragment.this.listener.onReviewDone();
            }
        });
    }


}