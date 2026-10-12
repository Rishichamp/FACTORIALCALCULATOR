package com.example.factorialcalculator;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Drives the real screen on a device or emulator. */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);

    private void compute(String number) {
        onView(withId(R.id.editTextNumber)).perform(typeText(number), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
    }

    @Test
    public void emptyFieldShowsAVisibleError() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView2)).check(matches(allOf(isDisplayed(),
                withText("Number field can't be empty"))));
    }

    @Test
    public void factorialOfThirteenIsExact() {
        compute("13");
        onView(withId(R.id.textView2)).check(matches(withText("Factorial=6227020800")));
    }

    @Test
    public void hugeInputShowsAnErrorInsteadOfFreezing() {
        compute("999999999");
        onView(withId(R.id.textView2)).check(matches(withText("Error! Factorial works for 0 to 100")));
    }
}
