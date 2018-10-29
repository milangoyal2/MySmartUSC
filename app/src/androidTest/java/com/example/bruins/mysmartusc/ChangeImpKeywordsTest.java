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

public class ChangeImpKeywordsTest {
    @Rule
    public ActivityTestRule<ChangeImpKeywordsSettingsActivity> mActivityTestRule = new ActivityTestRule<>(ChangeImpKeywordsSettingsActivity.class);

    @Test
    public void testDisplayText1(){
        ViewInteraction displayText1 = onView(withId(R.id.textView18));
        displayText1.check(matches(withText("Below are your current selected keywords")));

        ViewInteraction displayText2 = onView(withId(R.id.textView17));
        displayText2.check(matches(withText("Change the current important keywords below, seperated by commas")));

    }
    @Test
    public void testButtons(){
        onView(withId(R.id.impKeywordsSetButton)).check(matches((isDisplayed())));
        onView(withId(R.id.impKeywordsSetButton)).perform(click());

        onView(withId(R.id.impKeywordsHomeButton)).check(matches((isDisplayed())));
        onView(withId(R.id.impKeywordsHomeButton)).perform(click());
    }
}

