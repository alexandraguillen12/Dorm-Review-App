package edu.vassar.cmpu203.myapplication.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import edu.vassar.cmpu203.myapplication.R;

import edu.vassar.cmpu203.myapplication.model.Review;
import edu.vassar.cmpu203.myapplication.model.Room;
import edu.vassar.cmpu203.myapplication.model.House;
import edu.vassar.cmpu203.myapplication.model.RoomType;
import edu.vassar.cmpu203.myapplication.model.Search;
import edu.vassar.cmpu203.myapplication.view.INoResultsView;
import edu.vassar.cmpu203.myapplication.view.IRoomProfileView;
import edu.vassar.cmpu203.myapplication.view.IRoomSelectionView;
import edu.vassar.cmpu203.myapplication.view.ISearchView;
import edu.vassar.cmpu203.myapplication.view.IMainView;
import edu.vassar.cmpu203.myapplication.view.IWriteReviewView;
import edu.vassar.cmpu203.myapplication.view.MainView;
import edu.vassar.cmpu203.myapplication.view.NoResultsFragment;
import edu.vassar.cmpu203.myapplication.view.RoomProfileFragment;
import edu.vassar.cmpu203.myapplication.view.RoomSelectionFragment;
import edu.vassar.cmpu203.myapplication.view.SearchFragment;
import edu.vassar.cmpu203.myapplication.view.WriteReviewFragment;


public class MainActivity extends AppCompatActivity implements ISearchView.Listener,
        IRoomSelectionView.Listener, IRoomProfileView.Listener, INoResultsView.Listener, IWriteReviewView.Listener {

    Search curSearch = new Search();
    Room curRoom;
    IMainView mainView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create main view object
        this.mainView = new MainView(this);
        SearchFragment searchFragment = new SearchFragment(this);
        this.mainView.displayFragment(searchFragment, false, "search rooms");


        setContentView(R.layout.activity_main);
    }

    @Override
    public void onAddedFilters(House name, int floor, RoomType rt, boolean availability, ISearchView view) {
        this.curSearch.addFilters(name, floor, rt, availability);
    }

    /**
     * Called when the user is done adding filters.
     */
    @Override
    public void onSearchDone() {
        List<Room> curResults = this.curSearch.getResults();
        Fragment rsfrag = new RoomSelectionFragment(curResults, this);
        Fragment nrfrag = new NoResultsFragment(this);
        if (curResults.isEmpty()) {this.mainView.displayFragment(nrfrag, false, "no results");}
        else {this.mainView.displayFragment(rsfrag, false, "room selection");}
    }

    @Override
    public void onSelectionDone(int position) {
        this.curRoom = curSearch.getResults().get(position);
        this.mainView.displayFragment(new RoomProfileFragment(this, position, curRoom), false, "view room");
    }


    @Override
    public void onNewSearch() {
        this.curSearch = new Search();
        this.mainView.displayFragment(new SearchFragment(this), true, "search");
    }

    @Override
    public void onNewSelection(){
        List<Room> curResults = this.curSearch.getResults();
        Fragment rsfrag = new RoomSelectionFragment(curResults, this);
        this.mainView.displayFragment(rsfrag, false, "room selection");
    }

    @Override
    public void onWriteReview(){
        Fragment wrfrag = new WriteReviewFragment(this);
        this.mainView.displayFragment(wrfrag, false, "write review");
    }

    @Override
    public void onAddedReview(String headline, String reviewStr, IWriteReviewView view){
        this.curRoom.addReviews(new Review(headline, reviewStr));
        Fragment rpfrag = new RoomProfileFragment(this,curSearch.getResults().indexOf(curRoom),curRoom);
        this.mainView.displayFragment(rpfrag, false, "room profile");
    }

    @Override
    public void onReviewDone(){
        Fragment rpfrag = new RoomProfileFragment(this,curSearch.getResults().indexOf(curRoom),curRoom);
        this.mainView.displayFragment(rpfrag, false, "room profile");
    }

    @Override
    public void onGoBack(){
        Fragment rpfrag = new RoomProfileFragment(this,curSearch.getResults().indexOf(curRoom),curRoom);
        this.mainView.displayFragment(rpfrag, false, "room profile");
    }

}