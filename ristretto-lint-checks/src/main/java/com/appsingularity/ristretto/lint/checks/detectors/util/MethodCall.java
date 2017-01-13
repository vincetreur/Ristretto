package com.appsingularity.ristretto.lint.checks.detectors.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.ast.ImportDeclaration;


public class MethodCall {
    private static final String DOT = ".";
    private static final String STAR = "*";
    public final String methodName;
    public final List<String> classNames;

    public MethodCall(String aMethodName, String aClassName, String... moreClassNames) {
        methodName = aMethodName;
        classNames = new ArrayList<String>();
        classNames.add(aClassName);
        classNames.addAll(Arrays.asList(moreClassNames));
    }

    public boolean classMatches(String name) {
        for (String className : classNames) {
            if (name.equals(className) || name.endsWith(DOT + className)) {
                return true;
            }
        }
        return false;
    }

    public boolean importMatches(ImportDeclaration node) {
        String fqName = node.asFullyQualifiedName();
        for (String className : classNames) {
            String name = DOT + className + DOT;
            if (node.astStarImport()) {
                name += STAR;
            } else {
                name += methodName;
            }
            if (fqName.endsWith(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "[MethodCall " + methodName + "]";
    }

}
