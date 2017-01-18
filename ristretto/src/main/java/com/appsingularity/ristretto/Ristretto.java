/*
 * Copyright (c) 2011-2016 App Singularity
 */

package com.appsingularity.ristretto;

import android.support.test.espresso.ViewInteraction;
import android.view.View;

import org.hamcrest.Matcher;
import org.hamcrest.core.SubstringMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.appsingularity.ristretto.RistrettoViewMatchers.with;
import static org.hamcrest.Matchers.allOf;

/**
 * A shorthand class for Espresso.
 * It contains shorthand methods for {@code onView(withId(int))}, {@code onView(allOf(withId(int), isDisplayed)))}
 * and alike.
 */
@SuppressWarnings({"WeakerAccess", "UnusedDeclaration"})
public final class Ristretto {

    private Ristretto() {
        // This class should not be instantiated
    }

    /**
     * This replaces {@code onView(withId(viewId))} and {@code onView(withText(stringId))}.
     * @see RistrettoViewMatchers#with(int)
     */
    public static ViewInteraction withView(final int resourceId) {
        // This is a placeholder to resolve the resourceId into a type.
        return onView(with(resourceId));
    }

    /**
     * This replaces {@code onView(withText(String))}.
     * @see RistrettoViewMatchers#with(String)
     */
    public static ViewInteraction withView(final String text) {
        return onView(withText(text));
    }

    /**
     * This replaces {@code onView(Matcher<View>)}.
     * @see RistrettoViewMatchers#with(Matcher)
     */
    public static ViewInteraction withView(final Matcher<View> matcher) {
        return onView(matcher);
    }

    /**
     * This replaces {@code onView(SubstringMatcher)}.
     * @see RistrettoViewMatchers#with(String)
     */
    public static ViewInteraction withView(final SubstringMatcher matcher) {
        return onView(withText(matcher));
    }

    /**
     * This replaces onView(allOf(withId(viewId), isDisplayed())) and onView(allOf(withText(stringId), isDisplayed())).
     * @see RistrettoViewMatchers#with(int)
     */
    public static ViewInteraction withDisplayedView(final int resourceId) {
        // This is a placeholder to resolve the resourceId into a type.
        return withDisplayedView(with(resourceId));
    }

    /**
     * This replaces onView(allOf(withText(String), isDisplayed())).
     * @see RistrettoViewMatchers#with(String)
     */
    public static ViewInteraction withDisplayedView(final String text) {
        return withDisplayedView(with(text));
    }

    /**
     * This replaces onView(allOf(Matcher<View>, isDisplayed())).
     * @see Ristretto#withView(Matcher)
     */
    public static ViewInteraction withDisplayedView(final Matcher<View> matcher) {
        return onView(allOf(matcher, isDisplayed()));
    }

    /**
     * This replaces onView(allOf(SubstringMatcher, isDisplayed())).
     * @see Ristretto#withView(SubstringMatcher)
     */
    public static ViewInteraction withDisplayedView(final SubstringMatcher matcher) {
        return onView(allOf(withText(matcher), isDisplayed()));
    }

}
