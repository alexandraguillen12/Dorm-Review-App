package edu.vassar.cmpu203.myapplication.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.myapplication.R;

import edu.vassar.cmpu203.myapplication.view.ISearchView;
import edu.vassar.cmpu203.myapplication.view.IMainView;
import edu.vassar.cmpu203.myapplication.view.MainView;
import edu.vassar.cmpu203.myapplication.view.SearchFragment;


public class MainActivity extends AppCompatActivity implements ISearchView.Listener {

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
}