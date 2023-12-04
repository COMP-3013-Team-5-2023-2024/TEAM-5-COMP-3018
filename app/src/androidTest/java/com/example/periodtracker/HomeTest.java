package com.example.periodtracker;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RunWith(AndroidJUnit4ClassRunner.class)
public class HomeTest {

    @Test
    public void home_in_view(){
        try {
            ActivityScenario.launch(Home.class);
        } catch (Exception e) {
            fail();
        }
        onView(withId(R.id.button)).check(matches(isDisplayed()));
    }

    @Test
    public void health_button_pressed(){
        try {
            ActivityScenario.launch(Home.class);
        } catch (Exception e) {
            fail();
        }
        onView(withId(R.id.imageButton3)).perform(click());


        // TODO (matthew fletcher) when stuff has been added
    }
    @Test
    public void edit_button_pressed(){
        try {
            ActivityScenario.launch(Home.class);
        } catch (Exception e) {
            fail();
        }
        onView(withId(R.id.button4)).perform(click());

        onView(withId(R.id.dateOval)).check(matches(isDisplayed()));
    }

    @Test
    public void symptom_button_pressed(){
        try {
            ActivityScenario.launch(Home.class);
        } catch (Exception e) {
            fail();
        }
        onView(withId(R.id.imageButton4)).perform(click());

        onView(withId(R.id.dateText)).check(matches(isDisplayed()));
    }

    @Test
    public void page_displayed_correctly(){
        try {
            ActivityScenario.launch(Home.class);
        } catch (Exception e) {
            fail();
        }
        LocalDate today = LocalDate.now();
        onView(withId(R.id.button)).check(matches(withText(Integer.toString(today.getDayOfMonth()))));
        onView(withId(R.id.button2)).check(matches(withText(Integer.toString(today.minusDays(1).getDayOfMonth()))));
        onView(withId(R.id.button3)).check(matches(withText(Integer.toString(today.plusDays(1).getDayOfMonth()))));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH);
        onView(withId(R.id.textView)).check(matches(withText(today.format(formatter))));
    }


}