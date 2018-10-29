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

public class ChangeImpEmailsSettingsTest {
    @Rule
    public ActivityTestRule<ChangeImpEmailsSettingsActivity> mActivityTestRule = new ActivityTestRule<>(ChangeImpEmailsSettingsActivity.class);

    @Test
    public void testDisplayText1(){
        ViewInteraction displayText1 = onView(withId(R.id.textView10));
        displayText1.check(matches(withText("Below are your current selected unimportant email addresses")));

        ViewInteraction displayText2 = onView(withId(R.id.textView15));
        displayText2.check(matches(withText("Change the current important emails below, seperated by commas")));

    }
    @Test
    public void testButtons(){
        onView(withId(R.id.impEmailsSetButton)).check(matches((isDisplayed())));
        onView(withId(R.id.impEmailsSetButton)).perform(click());

        onView(withId(R.id.impEmailHomeButton)).check(matches((isDisplayed())));
        onView(withId(R.id.impEmailHomeButton)).perform(click());
    }
}
