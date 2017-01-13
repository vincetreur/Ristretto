package com.appsingularity.ristretto.lint.checks.detectors.util;

public final class MethodDefinitions {

    private static final String ESPRESSO_PACKAGE = "android.support.test.espresso";
    private static final String RISTRETTO_PACKAGE = "com.appsingularity.ristretto";
    private static final String HAMCREST_PACKAGE = "org.hamcrest";
    private static final ClassDefinition VIEW_MATCHERS = new ClassDefinition("ViewMatchers",
            ESPRESSO_PACKAGE + ".matcher");


    public static final MethodDefinition ALL_OF = new MethodDefinition("allOf",
            new ClassDefinition("AllOf", HAMCREST_PACKAGE + ".core"),
            new ClassDefinition("CoreMatchers", HAMCREST_PACKAGE),
            new ClassDefinition("Matchers", HAMCREST_PACKAGE));
    public static final MethodDefinition ON_VIEW = new MethodDefinition("onView",
            new ClassDefinition("Espresso", ESPRESSO_PACKAGE));
    public static final MethodDefinition WITH_ID = new MethodDefinition("withId", VIEW_MATCHERS);
    public static final MethodDefinition WITH_TEXT = new MethodDefinition("withText", VIEW_MATCHERS);
    public static final MethodDefinition IS_DISPLAYED = new MethodDefinition("isDisplayed", VIEW_MATCHERS);
    public static final MethodDefinition RISTRETTO_WITH_VIEW = new MethodDefinition("withView",
            new ClassDefinition("Ristretto", RISTRETTO_PACKAGE));
    public static final MethodDefinition RISTRETTO_WITH = new MethodDefinition("with",
            new ClassDefinition("RistrettoViewMatchers", RISTRETTO_PACKAGE));

    private MethodDefinitions() {
        // This class should not be instantiated.
    }

}
