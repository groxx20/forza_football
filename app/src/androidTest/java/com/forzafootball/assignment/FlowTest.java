package com.forzafootball.assignment;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import com.forzafootball.assignment.ui.splash.SplashActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by pavel on 8/2/18.
 */

@RunWith(AndroidJUnit4.class)
public class FlowTest {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityRule =
            new ActivityTestRule<SplashActivity>(SplashActivity.class) {
            };

    @Test
    public void ensureFunction() {

        // For press Back Button
        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        pauseTestFor(2500);

        // Check if rv is displayed"
        onView(withId(R.id.rvTeams))
                .check(matches(isDisplayed()));
        pauseTestFor(500);

        // click tests for future show of details
        onView(withId(R.id.rvTeams))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));

        onView(withId(R.id.rvTeams))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));

        onView(withId(R.id.rvTeams))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2,click()));



        // Scroll Tests of RecyclerView, so short list on that case
        onView(withId(R.id.rvTeams))
                .perform(RecyclerViewActions.scrollToPosition(1));
        pauseTestFor(500);
        onView(withId(R.id.rvTeams))
                .perform(RecyclerViewActions.scrollToPosition(2));
        pauseTestFor(500);
        onView(withId(R.id.rvTeams))
                .perform(RecyclerViewActions.scrollToPosition(3));
        pauseTestFor(500);
    }


    private void pauseTestFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
