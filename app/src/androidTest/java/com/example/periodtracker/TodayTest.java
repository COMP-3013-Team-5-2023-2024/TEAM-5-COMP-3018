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

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

@RunWith(AndroidJUnit4ClassRunner.class)
public class TodayTest {

    @Test
    public void today_in_view(){
        try {
            ActivityScenario.launch(Today.class);
        } catch (Exception e) {
            fail();
        }
        onView(withId(R.id.dateOval)).check(matches(isDisplayed()));
    }


    @Test
    public void activity_displayed_correctly(){
        try {
            ActivityScenario.launch(Today.class);
        } catch (Exception e) {
            fail();
        }
        Calendar currentDate = Calendar.getInstance();
        Locale locale = Locale.getDefault();
        onView(withId(R.id.day)).check(matches(withText(String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH)))));
        onView(withId(R.id.month)).check(matches(withText(currentDate.getDisplayName(Calendar.MONTH, Calendar.SHORT, locale))));

        // TODO (matthew fletcher) need to find out how to check the min / max prediction
    }


    @Test
    public void date_select(){
        try {
            ActivityScenario.launch(Today.class);
        } catch (Exception e) {
            fail();
        }


        // TODO (matthew fletcher) need to find out how the onClick works
    }

}