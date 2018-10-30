package com.example.bruins.mysmartusc;

import android.app.Activity;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringContains.containsString;


public class ChangeImpEmailsSettingsTest {

    private Activity getActivityInstance(){
        final Activity[] currentActivity = {null};

        getInstrumentation().runOnMainSync(new Runnable(){
            public void run(){
                Collection<Activity> resumedActivity = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                Iterator<Activity> it = resumedActivity.iterator();
                currentActivity[0] = it.next();
            }
        });

        return currentActivity[0];
    }

    @Rule
    public ActivityTestRule<ChangeImpEmailsSettingsActivity> mActivityTestRule = new ActivityTestRule<>(ChangeImpEmailsSettingsActivity.class);

    @Test
    public void testDisplayText(){
        ViewInteraction displayText1 = onView(withId(R.id.textView10));
        displayText1.check(matches(withText("Below are your current selected unimportant email addresses")));

        ViewInteraction displayText2 = onView(withId(R.id.textView15));
        displayText2.check(matches(withText("Change the current important emails below, seperated by commas")));

    }
    @Test
    public void testChangeButton(){
        onView(withId(R.id.impEmailsSetButton)).check(matches((isDisplayed())));
        onView(withId(R.id.changeImpEmailsInput)).perform(typeText("test1, test2"));
        onView(withId(R.id.impEmailsSetButton)).perform(click());
        onView(withId(R.id.impEmailsSetButton)).perform(click());
        Assert.assertEquals(getActivityInstance().getClass(), ChangeImpEmailsSettingsActivity.class);

        onView(withId(R.id.textView14)).check(matches(withText(containsString("test1"))));
    }

    @Test
    public void testHomeButton(){
        onView(withId(R.id.impEmailHomeButton)).check(matches((isDisplayed())));
        onView(withId(R.id.impEmailHomeButton)).perform(click());
        Assert.assertEquals(getActivityInstance().getClass(), HomePageActivity.class);
    }
}
