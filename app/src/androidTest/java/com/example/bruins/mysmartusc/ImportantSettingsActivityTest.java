package com.example.bruins.mysmartusc;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ImportantSettingsActivityTest {
    @Rule
    public ActivityTestRule<ImportantSettingsActivity> activityActivityTestRule = new ActivityTestRule<ImportantSettingsActivity>(ImportantSettingsActivity.class);

    @Test
    public void TestSenders() {
        onView(withId(R.id.editText)).check(matches((isDisplayed())));
        onView(withId(R.id.editText)).perform(typeText("Hello")).check(matches(withText("Hello")));

    }

    @Test
    public void TestContentKeywords() {
        onView(withId(R.id.editText2)).check(matches((isDisplayed())));
        onView(withId(R.id.editText)).perform(typeText("Hello")).check(matches(withText("Hello")));
    }

    @Test
    public void TestSubjectKeywords() {
        onView(withId(R.id.editText3)).check(matches((isDisplayed())));
        onView(withId(R.id.editText)).perform(typeText("Hello")).check(matches(withText("Hello")));
    }

    @Test
    public void TestFavoriteKeywords() {
        onView(withId(R.id.editText4)).check(matches((isDisplayed())));
        onView(withId(R.id.editText)).perform(typeText("Hello")).check(matches(withText("Hello")));
    }

    @Test
    public void TestButton() {
        onView(withId(R.id.button)).check(matches((isDisplayed())));
    }
}
