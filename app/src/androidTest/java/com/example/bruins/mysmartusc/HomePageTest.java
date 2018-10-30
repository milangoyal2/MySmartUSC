package com.example.bruins.mysmartusc;

import android.app.Activity;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.test.espresso.Root;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.view.WindowManager;

import org.hamcrest.Description;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.matchers.TypeSafeMatcher;
import org.junit.runner.RunWith;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class HomePageTest {
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
    public ActivityTestRule<LoginActivity> activityActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private void setUp() {
        onView(withId(R.id.editText)).perform(typeText("mysmartusctest@gmail.com"));
        onView(withId(R.id.editText2)).perform(typeText("mysmartusctest5*"), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.button)).perform(click());
    }

    @Test
    public void StartListeningButtonTest() {
        setUp();
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.button2)).perform(click());
    }

    @Test
    public void StopListeningButtonTest() {
        setUp();
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.button3)).perform(click());
    }

    @Test
    public void GetStatusButtonTest() {
        setUp();
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.button4)).perform(click());
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.button4)).perform(click());
    }

    @Test
    public void ChangeSettingsButtonTest() {
        setUp();
        onView(withId(R.id.button5)).perform(click());
        Assert.assertEquals(getActivityInstance().getClass(), ChangeSettingsActivity.class);
    }
}
