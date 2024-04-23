package com.example.bmicalculator;

import android.content.Intent;
import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class BMITestCase {
    @Before
    public void launchActivity() {
        ActivityScenario.launch(BMIActivity.class);
    }

    @Test
    public void testBMIResultCalculation() {
        Espresso.onView(withId(R.id.height)).perform(ViewActions.typeText("170"));
        Espresso.onView(withId(R.id.weight)).perform(ViewActions.typeText("70"));

        Espresso.onView(withId(R.id.calculate)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.result)).check(matches(isDisplayed()));

        Espresso.onView(withId(R.id.result)).check(matches(withText("Your BMI is 24.22")));
    }

    @Test
    public void testEmptyInput() {
        Espresso.onView(withId(R.id.calculate)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.result)).check(matches(withText("Please enter your height and weight")));
    }
}

