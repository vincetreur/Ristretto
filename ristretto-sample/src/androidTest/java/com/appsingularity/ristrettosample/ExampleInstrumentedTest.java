package com.appsingularity.ristrettosample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.appsingularity.ristretto.Ristretto.withDisplayedView;
import static com.appsingularity.ristretto.Ristretto.withView;
import static com.appsingularity.ristretto.RistrettoViewMatchers.with;
import static org.hamcrest.core.Is.is;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public final ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void withViewId_control() {
        onView(withId(R.id.label)).check(matches(isDisplayed()));
    }

    @Test
    public void with_viewId() {
        onView(with(R.id.label)).check(matches(isDisplayed()));
    }

    @Test
    public void withText_id_control() {
        onView(withText(R.string.label)).check(matches(isDisplayed()));
    }

    @Test
    public void withText_text_control() {
        onView(withText(activityRule.getActivity().getString(R.string.label))).check(matches(isDisplayed()));
    }

    @Test
    public void with_textId() {
        onView(with(R.string.label)).check(matches(isDisplayed()));
    }

    @Test
    public void with_text() {
        onView(with(activityRule.getActivity().getString(R.string.label))).check(matches(isDisplayed()));
    }

    @Test
    public void with_matcher() {
        onView(with(is(activityRule.getActivity().getString(R.string.label)))).check(matches(isDisplayed()));
    }

    @Test
    public void withView_viewId() {
        withView(R.id.label).check(matches(isDisplayed()));
    }

    @Test
    public void withView_textId() {
        withView(R.string.label).check(matches(isDisplayed()));
    }

    @Test
    public void withView_text() {
        withView(activityRule.getActivity().getString(R.string.label)).check(matches(isDisplayed()));
    }

    @Test
    public void withDisplayedView_viewId() {
        withDisplayedView(R.id.label).check(matches(isDisplayed()));
    }

    @Test
    public void withDisplayedView_textId() {
        withDisplayedView(R.string.label).check(matches(isDisplayed()));
    }

    @Test
    public void withDisplayedView_text() {
        withDisplayedView(activityRule.getActivity().getString(R.string.label)).check(matches(isDisplayed()));
    }

    @Test
    public void wWithDisplayedView_matcher() {
        withDisplayedView(with(R.id.label)).check(matches(isDisplayed()));
    }

}
