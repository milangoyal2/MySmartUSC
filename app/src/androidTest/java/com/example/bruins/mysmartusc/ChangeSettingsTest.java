package com.example.bruins.mysmartusc;

import android.app.Activity;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;
import java.util.Iterator;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;

@LargeTest
@RunWith(AndroidJUnit4.class)

public class ChangeSettingsTest {
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
    public ActivityTestRule<ChangeSettingsActivity> mActivityTestRule = new ActivityTestRule<>(ChangeSettingsActivity.class);

    @Test
    public void testChangeFavFlagButton(){
        onView(withId(R.id.changeFavFlagButton)).check(matches((isDisplayed())));
        onView(withId(R.id.changeFavFlagButton)).perform(click());
        Assert.assertEquals(getActivityInstance().getClass(), ChangeFavFlagSettingsActivity.class);
    }

    @Test
    public void testchangeImpSubwordsButton(){
        onView(withId(R.id.changeImpSubwordsButton)).check(matches((isDisplayed())));
        onView(withId(R.id.changeImpSubwordsButton)).perform(click());
        Assert.assertEquals(getActivityInstance().getClass(), ChangeImpSubwordsActivity.class);
    }

    @Test
    public void testchangeImpEmailsButton(){
        onView(withId(R.id.changeImpEmailsButton)).check(matches((isDisplayed())));
        onView(withId(R.id.changeImpEmailsButton)).perform(click());
        Assert.assertEquals(getActivityInstance().getClass(), ChangeImpEmailsSettingsActivity.class);
    }

    @Test
    public void testchangeImpKeywordsButton(){
        onView(withId(R.id.changeImpKeywordsButton)).check(matches((isDisplayed())));
        onView(withId(R.id.changeImpKeywordsButton)).perform(click());
        Assert.assertEquals(getActivityInstance().getClass(), ChangeImpKeywordsSettingsActivity.class);
    }






}
