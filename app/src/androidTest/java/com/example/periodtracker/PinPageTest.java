package com.example.periodtracker;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.fail;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.group_5_project.R;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class PinPageTest {

    @Test
    public void activity_in_view() {

        try {
            ActivityScenario.launch(PinPage.class);
        } catch (Exception e) {
            fail();
        }
        onView(withId(R.id.pin_pad_01)).check(matches(isDisplayed()));
    }


    @Test
    public void check_with_with_invalid_pin() {
        // TODO add method to make the database interact correctly
        // pin code is currently 2345
        try {
            ActivityScenario.launch(PinPage.class);
        } catch (Exception e) {
            fail();
        }

        onView(withId(R.id.pin_pad_01)).perform(click());
        onView(withId(R.id.pin_pad_01)).perform(click());
        onView(withId(R.id.pin_pad_01)).perform(click());
        onView(withId(R.id.pin_pad_01)).perform(click());
        onView(withId(R.id.pin_pad_OK)).perform(click());

        // page should still be visible
        onView(withId(R.id.pin_pad_01));

        // TODO should also check if the background resource is correct
    }


    @Test
    public void check_with_valid_pin() {
        // TODO add method to make the database interact correctly
        // pin code is currently 2345
        try {
            ActivityScenario.launch(PinPage.class);
        } catch (Exception e) {
            fail();
        }

        onView(withId(R.id.pin_pad_02)).perform(click());
        onView(withId(R.id.pin_pad_03)).perform(click());
        onView(withId(R.id.pin_pad_04)).perform(click());
        onView(withId(R.id.pin_pad_05)).perform(click());
        onView(withId(R.id.pin_pad_OK)).perform(click());

        // page should still be visible
        // TODO add a check that it has moved onto the next page
    }

    @Test
    public void check_with_back_space() {
        // TODO add method to make the database interact correctly
        // pin code is currently 2345
        try {
            ActivityScenario.launch(PinPage.class);
        } catch (Exception e) {
            fail();
        }

        onView(withId(R.id.pin_pad_02)).perform(click());
        onView(withId(R.id.pin_pad_back_space)).perform(click());

        // TODO should check to see if no dots are available
        // could also add cases for back space if nothing was added
    }

    @Test
    public void check_dots_change() {
        // TODO add method to make the database interact correctly
        // pin code is currently 2345
        try {
            ActivityScenario.launch(PinPage.class);
        } catch (Exception e) {
            fail();
        }

        onView(withId(R.id.pin_pad_02)).perform(click());

        // TODO should check to see if the dots change
    }

    // TODO add cases for the save not just check

}