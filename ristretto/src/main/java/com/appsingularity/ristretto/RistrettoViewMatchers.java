package com.appsingularity.ristretto;


import android.content.res.Resources;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;

/**
 * A collection of shorthand ViewMatchers.
 */
@SuppressWarnings("WeakerAccess")
public final class RistrettoViewMatchers {

    private RistrettoViewMatchers() {
        // This class should not be instantiated
    }

    /**
     * Shorthand for {@code withText(Text)).
     */
    @SuppressWarnings("UnusedDeclaration")
    public static Matcher<View> with(String text) {
        return with(is(text));
    }

    /**
     * Shorthand for {@code withText(Matcher<String>)}.
     */
    @SuppressWarnings("UnusedDeclaration")
    public static Matcher<View> with(final Matcher<String> stringMatcher) {
        return withText(stringMatcher);
    }

    /**
     * Shorthand for {@code withId(viewId)} and {@code withText(stringId)}.
     * This matcher will figure out if you are passing a string resource or an id resource.
     * Other resource types are not supported.
     */
    @SuppressWarnings("UnusedDeclaration")
    public static Matcher<View> with(final int resourceId) {
        // This is a placeholder to resolve the resourceId into a type.
        return new WithMatcher(resourceId);
    }

    private static class WithMatcher extends TypeSafeMatcher<View> {
        private Resources resources = null;
        private Matcher<View> matcher;
        private final int resourceId;

        WithMatcher(int id) {
            resourceId = id;
        }

        @Override
        public void describeTo(Description description) {
            String idDescription = Integer.toString(resourceId);
            if (resources != null) {
                try {
                    idDescription = resources.getResourceName(resourceId);
                } catch (Resources.NotFoundException e) {
                    // No big deal, will just use the int value.
                    idDescription = String.format("%s (resource name not found)", resourceId);
                }
            }
            description.appendText("with resource id: " + idDescription);
        }

        @Override
        public boolean matchesSafely(View view) {
            if (resources == null) {
                resources = view.getResources();
                String typeName = resources.getResourceTypeName(resourceId);
                if ("string".matches(typeName)) {
                    matcher = withText(resourceId);
                } else if ("id".equals(typeName)) {
                    matcher = withId(resourceId);
                } else {
                    throw new Resources.NotFoundException("Type not supported, only id & string are supported!");
                }
            }
            return matcher.matches(view);
        }
    }

}
