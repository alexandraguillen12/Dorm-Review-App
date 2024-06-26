package edu.vassar.cmpu203.myapplication.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import java.util.List;

import edu.vassar.cmpu203.myapplication.R;

import edu.vassar.cmpu203.myapplication.model.Review;
import edu.vassar.cmpu203.myapplication.model.Room;
import edu.vassar.cmpu203.myapplication.model.Search;
import edu.vassar.cmpu203.myapplication.persistence.FirestoreFacade;
import edu.vassar.cmpu203.myapplication.persistence.IPersistenceFacade;
import edu.vassar.cmpu203.myapplication.view.IRoomProfileView;
import edu.vassar.cmpu203.myapplication.view.IRoomSelectionView;
import edu.vassar.cmpu203.myapplication.view.ISearchView;
import edu.vassar.cmpu203.myapplication.view.IMainView;
import edu.vassar.cmpu203.myapplication.view.IWriteReviewView;
import edu.vassar.cmpu203.myapplication.view.MainView;
import edu.vassar.cmpu203.myapplication.view.RoomProfileFragment;
import edu.vassar.cmpu203.myapplication.view.RoomSelectionFragment;
import edu.vassar.cmpu203.myapplication.view.SearchFragment;
import edu.vassar.cmpu203.myapplication.view.WriteReviewFragment;

/**
 * The MainActivity class represents the main activity of the application. It extends AppCompatActivity
 * implements several listener interfaces for different views.The main functionality includes handling
 * searches, room selection, room profile, and handling cases where no results are found.
 */
public class MainActivity extends AppCompatActivity implements ISearchView.Listener,
        IRoomSelectionView.Listener, IRoomProfileView.Listener, IWriteReviewView.Listener {

    Fragment curFrag; // keeps track of the current fragment being displayed
    Search curSearch = new Search(); // keeps track of the current search being done
    Room curRoom; // keeps track of the current room being viewed
    IMainView mainView; // a reference to the UI object
    IPersistenceFacade persFacade;

    /**
     * Called when the activity first called. Responsible for initializing the main view,
     * and displaying the initial fragment for searching rooms.
     * @param savedInstanceState Bundle containing the activity's previously saved state.
     *                           or null if there's no saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize persistence facade
        this.persFacade = new FirestoreFacade();

        // create main view object
        this.mainView = new MainView(this);
        SearchFragment searchFragment = new SearchFragment(this);
        this.mainView.displayFragment(searchFragment, false, "search rooms");

        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user is done specifying a house, floor,
     * room type, and availability to search for.
     * @param name the house name
     * @param floor the floor of the house
     * @param rt the room type
     * @param availability the availability
     * @param view the view where the event originated
     */
    @Override
    public void onAddedFilters(String name, int floor, String rt, boolean availability, ISearchView view) {
        this.curSearch.addFilters(name, floor, rt, availability);
    }

    /**
     * Called when the user is done adding filters.
     */
    @Override
    public void onSearchDone(ISearchView view) {
        List<Room> curResults = this.curSearch.getResults();
        this.curFrag = new RoomSelectionFragment(curResults, this);
        this.mainView.displayFragment(this.curFrag, false, "room selection");
    }

    /**
     * Called when the user has completed the room selection for a specific position.
     * @param position The position of the selected room in the results list.
     */
    @Override
    public void onSelectionDone(int position) {
        this.curRoom = curSearch.getResults().get(position);
        this.curFrag = new RoomProfileFragment(this, curRoom);
        this.mainView.displayFragment(this.curFrag, false, "view room");
    }

    /**
     * Invoked when the user initialize a new search. Resets the current search and
     * displays the SearchFragment for the new search.
     */
    @Override
    public void onNewSearch() {
        this.curSearch = new Search();
        this.curFrag = new SearchFragment(this);
        this.mainView.displayFragment(curFrag, true, "search");
    }

    /**
     * Called when the user wants to make a new room selection.
     */
    @Override
    public void onNewSelection(){
        List<Room> curResults = this.curSearch.getResults();
        this.curFrag = new RoomSelectionFragment(curResults, this);
        this.mainView.displayFragment(this.curFrag, false, "room selection");
    }

    /**
     * Called when the user wants to write a review.
     */
    @Override
    public void onWriteReview(){
        this.curFrag = new WriteReviewFragment(this);
        this.mainView.displayFragment(this.curFrag, false, "write review");
    }

    /**
     * Called when user finishes writing their review and adds the review.
     * @param ratingNum the rating out of five stars
     * @param headline the headline of the review
     * @param reviewStr the written review
     * @param view the view where the event originated
     */
    @Override
    public void onAddedReview(Float ratingNum, String headline, String reviewStr, IWriteReviewView view){
        Review curReview = new Review(ratingNum, headline, reviewStr);
        this.curRoom.addReviews(curReview);
        //save review to underlying persistence storage
        this.persFacade.saveReview(curReview, curRoom);
    }

    /**
     * Called when the user is done writing their review.
     */
    @Override
    public void onReviewDone(){
        this.curFrag = new RoomProfileFragment(this,curRoom);
        this.mainView.displayFragment(this.curFrag, false, "room profile");
    }

    /**
     * Called if the user decides not to write a review and go back to the room profile.
     */
    @Override
    public void onGoBack(){
        this.curFrag = new RoomProfileFragment(this,curRoom);
        this.mainView.displayFragment(this.curFrag, false, "room profile");
    }

}