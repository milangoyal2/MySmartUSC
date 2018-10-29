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

public class ChangeImpSubwordsTest {

    @Rule
    public ActivityTestRule<ChangeImpSubwordsActivity> mActivityTestRule = new ActivityTestRule<>(ChangeImpSubwordsActivity.class);

    @Test
    public void testDisplayText1(){
        ViewInteraction displayText1 = onView(withId(R.id.textView19));
        displayText1.check(matches(withText("Below are your current selected important subject line keywords")));

        ViewInteraction displayText2 = onView(withId(R.id.textView21));
        displayText2.check(matches(withText("Change the current subject line keywords below, separated by commas")));

    }
    @Test
    public void testButtons(){
        onView(withId(R.id.changeImpSubwordsSetButton)).check(matches((isDisplayed())));
        onView(withId(R.id.changeImpSubwordsSetButton)).perform(click());

        onView(withId(R.id.impSubwordsHomeButton)).check(matches((isDisplayed())));
        onView(withId(R.id.impSubwordsHomeButton)).perform(click());
    }
}
