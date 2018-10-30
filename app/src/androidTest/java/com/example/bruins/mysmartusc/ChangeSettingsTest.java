package com.example.bruins.mysmartusc;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;

@LargeTest
@RunWith(AndroidJUnit4.class)

public class ChangeSettingsTest {
    @Rule
    public ActivityTestRule<ChangeSettingsActivity> mActivityTestRule = new ActivityTestRule<>(ChangeSettingsActivity.class);

    @Test
    public void testChangeFavFlagButton(){
        onView(withId(R.id.changeFavFlagButton)).check(matches((isDisplayed())));
        onView(withId(R.id.changeFavFlagButton)).perform(click());
    }

    @Test
    public void testchangeImpSubwordsButton(){
        onView(withId(R.id.changeImpSubwordsButton)).check(matches((isDisplayed())));
        onView(withId(R.id.changeImpSubwordsButton)).perform(click());
    }

    @Test
    public void testchangeImpEmailsButton(){
        onView(withId(R.id.changeImpEmailsButton)).check(matches((isDisplayed())));
        onView(withId(R.id.changeImpEmailsButton)).perform(click());

    }

    @Test
    public void testchangeImpKeywordsButton(){
        onView(withId(R.id.changeImpKeywordsButton)).check(matches((isDisplayed())));
        onView(withId(R.id.changeImpKeywordsButton)).perform(click());
    }






}
