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
     * This replaces onView(withId(viewId)) and onView(withText(stringId))
     * @see {@link android.support.test.espresso.Espresso#onView(org.hamcrest.Matcher)}
     */
    @SuppressWarnings("UnusedDeclaration")
    public static ViewInteraction withView(final int resourceId) {
        // This is a placeholder to resolve the resourceId into a type.
        return onView(with(resourceId));
    }

    @SuppressWarnings("UnusedDeclaration")
    public static ViewInteraction withView(final String text) {
        return withView(withText(text));
    }


    @SuppressWarnings("UnusedDeclaration")
    public static ViewInteraction withView(final Matcher matcher) {
        if (matcher instanceof SubstringMatcher) {
            return onView(withText(matcher));
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
