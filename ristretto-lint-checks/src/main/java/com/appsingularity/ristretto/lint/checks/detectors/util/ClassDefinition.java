package com.appsingularity.ristretto.lint.checks.detectors.util;


class ClassDefinition {
    public static final String DOT = ".";
    private final String name;
    private final String packageName;

    public ClassDefinition(String aName, String aPackageName) {
        name = aName;
        packageName = aPackageName;
    }

    public String asText() {
        return packageName + DOT + name;
    }

    public boolean matches(String other) {
         return other.equals(name) || other.endsWith(asText());
    }
}
