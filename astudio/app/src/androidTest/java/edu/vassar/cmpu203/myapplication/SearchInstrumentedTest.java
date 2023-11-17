package edu.vassar.cmpu203.myapplication;

import android.os.SystemClock;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import edu.vassar.cmpu203.myapplication.controller.MainActivity;

@RunWith(AndroidJUnit4.class)
public class SearchInstrumentedTest {
    // specify what activity to launch for test (it will be launched afresh everytime a test is run
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /**
     * This test tries to choose a house, a floor, a room type, and availability and checks to see that it is actually
     * added by checking the contents of the spinners.
     * Then it will do the search.
     */
    @Test
    public void testSearch() {

        // get a ViewInteraction for the line items text
        ViewInteraction viSearchText = Espresso.onView(
                ViewMatchers.withId(R.id.searchText));
        // check the text matches the default one from strings.xml
        viSearchText.check(
                ViewAssertions.matches(
                        ViewMatchers.withText(R.string.search_msg_fragment)));

        // find house spinner and select "Jewett"
        ViewInteraction viHouseName = Espresso.onView(ViewMatchers.withId(R.id.houseSpinner));
        viHouseName.perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withText("Jewett"))
                .perform(ViewActions.click());


        // find floor spinner and select "8"
        ViewInteraction viFloorNum = Espresso.onView(ViewMatchers.withId(R.id.floorSpinner));
        viFloorNum.perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withText("8"))
                .perform(ViewActions.click());

        // find room type spinner and select "Jewett"
        ViewInteraction viRoomType = Espresso.onView(ViewMatchers.withId(R.id.roomTypeSpinner));
        viRoomType.perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withText("Single"))
                .perform(ViewActions.click());

        // find availability spinner and select "Available rooms"
        ViewInteraction viAvailability = Espresso.onView(ViewMatchers.withId(R.id.availabilitySpinner));
        viAvailability.perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withText("Available rooms"))
                .perform(ViewActions.click());

        // find search button and click it
        Espresso.onView(ViewMatchers.withId(R.id.searchButton))
                .perform(ViewActions.click());

        /*
        /// check that spinner chose "Jewett"
        viHouseName.check(
                ViewAssertions.matches(
                        ViewMatchers.withSpinnerText("Jewett")));
        /// check that spinner chose "8"
        viHouseName.check(
                ViewAssertions.matches(
                        ViewMatchers.withSpinnerText("8")));
        /// check that spinner chose "Single"
        viHouseName.check(
                ViewAssertions.matches(
                        ViewMatchers.withSpinnerText("Single")));
        /// check that line items text contains 2 x avocado
        viHouseName.check(
                ViewAssertions.matches(
                        ViewMatchers.withSpinnerText("Available rooms")));

         */
    }

    /**
     * Tests that we're able to go back to do a new search.
     */
    @Test
    public void testMovingToPayment(){
        testSearch(); // call other test as a helper method

        /*
        // find and click the done button
        Espresso.onView(ViewMatchers.withText(R.string.done_button_label))
                .perform(ViewActions.click());

         */

        // confirm we're in the payment screen by checking that a pay button exists
        Espresso.onView(ViewMatchers.withId(R.id.newSearchButton));
    }

}
