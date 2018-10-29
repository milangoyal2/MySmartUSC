package com.example.bruins.mysmartusc;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class ChangeFavFlagSettingsTest {
    @Rule
    public ActivityTestRule<ChangeFavFlagSettingsActivity> mActivityTestRule = new ActivityTestRule<>(ChangeFavFlagSettingsActivity.class);

    @Test
    public void testDisplayText1(){
        ViewInteraction displayText1 = onView(withId(R.id.textView10));
        displayText1.check(matches(withText("Below are your current selected important favorited or flagged subject/content keywords.")));

        ViewInteraction displayText2 = onView(withId(R.id.textView13));
        displayText2.check(matches(withText("Change the current important subject/content keywords for fav/flagged emails below, separated by commas")));

    }
    @Test
    public void testButtons(){
        onView(withId(R.id.changeFavFlagSetButton)).check(matches((isDisplayed())));
        onView(withId(R.id.changeFavFlagSetButton)).perform(click());

        onView(withId(R.id.favFlagHomeButton)).check(matches((isDisplayed())));
        onView(withId(R.id.favFlagHomeButton)).perform(click());
    }
}
