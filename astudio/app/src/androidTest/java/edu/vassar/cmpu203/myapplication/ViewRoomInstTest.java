package edu.vassar.cmpu203.myapplication;

import android.app.Activity;
import android.os.SystemClock;
import android.view.InputDevice;
import android.view.View;
import android.widget.RatingBar;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.MotionEvents;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.vassar.cmpu203.myapplication.controller.MainActivity;

@RunWith(AndroidJUnit4.class)
public class ViewRoomInstTest {
    // specify what activity to launch for test (it will be launched afresh everytime a test is run
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /**
     * This test tries to select a room and checks
     * if it is in the right room.
     */
    @Test
    public void testSelection() {

        // find search button and click it
        Espresso.onView(ViewMatchers.withId(R.id.searchButton))
                .perform(ViewActions.click());
        // get a ViewInteraction for the text "Room 305"
        ViewInteraction viRoomId = Espresso.onView(
                ViewMatchers.withText("Room 305"));
        // click "Room 305"
        viRoomId.perform(ViewActions.click());
        // check the room id text matches "Room 305"
        Espresso.onView(ViewMatchers.withId(R.id.roomIdText))
                .check(ViewAssertions.matches(
                        ViewMatchers.withText("Room 305")));

    }

    /**
     * This test tries to return to the room selection screen
     * and checks if it is there, then makes a different selection.
     */
    @Test
    public void testNewSelection() {
        testSelection(); // call other test as a helper method

        // get a ViewInteraction for the back button
        ViewInteraction viBack = Espresso.onView(ViewMatchers.withId(R.id.back2Button));
        // click "Back"
        viBack.perform(ViewActions.click());
        // get a ViewInteraction for the text "Room 305"
        ViewInteraction viRoomId = Espresso.onView(
                ViewMatchers.withText("Room 557"));
        // click "Room 305"
        viRoomId.perform(ViewActions.click());
        // check the room id text matches "Room 305"
        Espresso.onView(ViewMatchers.withId(R.id.roomIdText))
                .check(ViewAssertions.matches(
                        ViewMatchers.withText("Room 557")));

    }


    /**
     * This test tries to write a review and add it and then checks
     * if the review was added on the room profile screen.
     */
    @Test
    public void testWriteReview() {
        testSelection(); // call other test as a helper method

        // find "write a review" button and click it
        Espresso.onView(ViewMatchers.withId(R.id.writeReviewButton))
                .perform(ViewActions.click());

        // find rating bar and select 5 stars
        ViewInteraction viRating = Espresso.onView(ViewMatchers.withId(R.id.simpleRatingBar));
        viRating.perform(ViewActions.swipeRight());

        // find headline text field and type in "The best!"
        ViewInteraction viHeadline = Espresso.onView(ViewMatchers.withId(R.id.headlineInput));
        viHeadline.perform(ViewActions.typeText("The best!"));

        Espresso.closeSoftKeyboard();

        // find written review text field and type in "I love this room!!!"
        Espresso.onView(ViewMatchers.withId(R.id.writtenReviewInput))
                .perform(ViewActions.typeText("I love this room!!!"));

        Espresso.closeSoftKeyboard();

        // find add review button and click it
        Espresso.onView(ViewMatchers.withId(R.id.addReviewButton))
                .perform(ViewActions.click());

        // get a ViewInteraction for headline text on the room profile screen
        ViewInteraction viH = Espresso.onView(ViewMatchers.withId(R.id.headlineText));
        // check if it matches the headline "The best!"
        viH.check(ViewAssertions.matches(ViewMatchers.withText("The best!")));

        // get a ViewInteraction for the written review text on the room profile screen
        ViewInteraction viWR = Espresso.onView(ViewMatchers.withId(R.id.reviewText));
        // check if it matches the written review "I love this room!!!"
        viWR.check(ViewAssertions.matches(ViewMatchers.withText("I love this room!!!")));
    }

    /**
     * This test checks if a review was saved.
     */
    @Test
    public void testSaveReview(){
        testNewSelection(); // call other test as a helper method

        // find "write a review" button and click it
        Espresso.onView(ViewMatchers.withId(R.id.writeReviewButton))
                .perform(ViewActions.click());

        // find rating bar and select 5 stars
        ViewInteraction viRating = Espresso.onView(ViewMatchers.withId(R.id.simpleRatingBar));
        viRating.perform(ViewActions.swipeRight());

        // find headline text field and type in "The best!"
        ViewInteraction viHeadline = Espresso.onView(ViewMatchers.withId(R.id.headlineInput));
        viHeadline.perform(ViewActions.typeText("The best!"));

        Espresso.closeSoftKeyboard();

        // find written review text field and type in "I love this room!!!"
        Espresso.onView(ViewMatchers.withId(R.id.writtenReviewInput))
                .perform(ViewActions.typeText("I love this room!!!"));

        Espresso.closeSoftKeyboard();

        // find add review button and click it
        Espresso.onView(ViewMatchers.withId(R.id.addReviewButton))
                .perform(ViewActions.click());

        // find back button and click it
        Espresso.onView(ViewMatchers.withId(R.id.back2Button))
                .perform(ViewActions.click());

        // find new search button and click it
        Espresso.onView(ViewMatchers.withId(R.id.newSearchButton))
                .perform(ViewActions.click());

        // find search button and click it
        Espresso.onView(ViewMatchers.withId(R.id.searchButton))
                .perform(ViewActions.click());

        // get a ViewInteraction for the text "Room 557"
        ViewInteraction viRoomId = Espresso.onView(
                ViewMatchers.withText("Room 557"));
        // click "Room 557"
        viRoomId.perform(ViewActions.click());
        // check the room id text matches "Room 557"
        Espresso.onView(ViewMatchers.withId(R.id.roomIdText))
                .check(ViewAssertions.matches(
                        ViewMatchers.withText("Room 557")));

        // get a ViewInteraction for headline text on the room profile screen
        ViewInteraction viH = Espresso.onView(ViewMatchers.withId(R.id.headlineText));
        // check if it matches the headline "The best!"
        viH.check(ViewAssertions.matches(ViewMatchers.withText("The best!")));

        // get a ViewInteraction for the written review text on the room profile screen
        ViewInteraction viWR = Espresso.onView(ViewMatchers.withId(R.id.reviewText));
        // check if it matches the written review "I love this room!!!"
        viWR.check(ViewAssertions.matches(ViewMatchers.withText("I love this room!!!")));
    }
}
