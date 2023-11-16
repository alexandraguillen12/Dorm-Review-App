package edu.vassar.cmpu203.myapplication.view;

public interface IRoomSelectionView {

    interface Listener{

        void onSelectionDone(int position);

        void onNewSearch();
    }

}
