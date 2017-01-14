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

// TODO: Add withView(Matcher... matcher)
@SuppressWarnings("WeakerAccess")
public final class Ristretto {

    private Ristretto() {
        // This class should not be instantiated
    }

    /**
     * This replaces {@code onView(withId(viewId))} and {@code onView(withText(stringId))}
     * @see android.support.test.espresso.Espresso#onView(org.hamcrest.Matcher)
     */
    @SuppressWarnings("UnusedDeclaration")
    public static ViewInteraction withView(final int resourceId) {
        // This is a placeholder to resolve the resourceId into a type.
        return onView(with(resourceId));
    }

    /**
     * This replaces {@code onView(withText(String))}
     * @see android.support.test.espresso.Espresso#onView(org.hamcrest.Matcher)
     * @see android.support.test.espresso.matcher.ViewMatchers#withText(String)
     */
    @SuppressWarnings("UnusedDeclaration")
    public static ViewInteraction withView(final String text) {
        return onView(withText(text));
    }


    /**
     * This replaces {@code onView(Matcher<View>)} and {@code onView(Matcher<String>)}
     * @see android.support.test.espresso.Espresso#onView(org.hamcrest.Matcher)
     */
    @SuppressWarnings("UnusedDeclaration")
    public static ViewInteraction withView(final Matcher matcher) {
        if (matcher instanceof SubstringMatcher) {
            return onView(withText((Matcher<String>) matcher));
        }
        return onView((Matcher<View>) matcher);
    }

    /**
     * This replaces onView(allOf(withId(viewId), isDisplayed())) and onView(allOf(withText(stringId), isDisplayed()))
     */
    @SuppressWarnings("UnusedDeclaration")
    public static ViewInteraction withDisplayedView(final int resourceId) {
        // This is a placeholder to resolve the resourceId into a type.
        return withDisplayedView(with(resourceId));
    }

    @SuppressWarnings("UnusedDeclaration")
    public static ViewInteraction withDisplayedView(final String text) {
        return withDisplayedView(with(text));
    }

    @SuppressWarnings("UnusedDeclaration")
    public static ViewInteraction withDisplayedView(final Matcher matcher) {
        if (matcher instanceof SubstringMatcher) {
            return onView(allOf(withText(matcher), isDisplayed()));
        }
        return onView(allOf((Matcher<View>) matcher, isDisplayed()));
    }

}
