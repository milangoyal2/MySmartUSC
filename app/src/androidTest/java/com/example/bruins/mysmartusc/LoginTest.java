package com.example.bruins.mysmartusc;

import android.app.Activity;
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
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)

public class LoginTest {

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

    @Test
    public void UsernameFieldTest() {
        onView(withId(R.id.editText)).check(matches((isDisplayed())));
        onView(withId(R.id.editText)).perform(typeText("Hello")).check(matches(withText("Hello")));
    }

    @Test
    public void PasswordFieldTest() {
        onView(withId(R.id.editText2)).check(matches((isDisplayed())));
        onView(withId(R.id.editText2)).perform(typeText("Hello")).check(matches(withText("Hello")));
    }

    @Test
    public void LoginButtonTest() {
        onView(withId(R.id.button)).check(matches((isDisplayed())));
    }

    @Test
    public void InvalidLoginTest() {
        onView(withId(R.id.editText)).perform(typeText("invalid@gmail.com"));
        onView(withId(R.id.editText2)).perform(typeText("mysmartusctest5*"), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        Assert.assertEquals(getActivityInstance().getClass(), LoginActivity.class);
    }

    @Test
    public void ValidLoginTest() {
        onView(withId(R.id.editText)).perform(typeText("mysmartusctest@gmail.com"));
        onView(withId(R.id.editText2)).perform(typeText("mysmartusctest5*"), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        Assert.assertEquals(getActivityInstance().getClass(), ImportantSettingsActivity.class);
    }
}


