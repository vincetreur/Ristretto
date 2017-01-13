package com.appsingularity.ristretto.lint.checks.detectors.util;

public final class MethodCalls {

    public static final String DOT = ".";

    private static final String VIEW_MATCHERS = "ViewMatchers";


    public static final MethodCall ALL_OF = new MethodCall("allOf", "AllOf", "CoreMatchers", "Matchers");
    public static final MethodCall ON_VIEW = new MethodCall("onView", "Espresso");
    public static final MethodCall WITH_ID = new MethodCall("withId", VIEW_MATCHERS);
    public static final MethodCall WITH_TEXT = new MethodCall("withText", VIEW_MATCHERS);
    public static final MethodCall IS_DISPLAYED = new MethodCall("isDisplayed", VIEW_MATCHERS);
    public static final MethodCall RISTRETTO_WITH_VIEW = new MethodCall("withView", "Ristretto");
    public static final MethodCall RISTRETTO_WITH = new MethodCall("with", "RistrettoViewMatchers");

    private MethodCalls() {
        // This class should not be instantiated.
    }

}
