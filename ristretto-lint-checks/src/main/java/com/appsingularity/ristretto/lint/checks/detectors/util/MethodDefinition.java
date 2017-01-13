package com.appsingularity.ristretto.lint.checks.detectors.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.ast.ImportDeclaration;


public class MethodDefinition {
    private static final String STAR = "*";
    public final String methodName;
    private final List<ClassDefinition> classes;

    public MethodDefinition(String aMethodName, ClassDefinition aClassName, ClassDefinition... moreClassNames) {
        methodName = aMethodName;
        List<ClassDefinition> classesList = new ArrayList<ClassDefinition>();
        classesList.add(aClassName);
        classesList.addAll(Arrays.asList(moreClassNames));
        classes = classesList;
    }

    public boolean classMatches(String name) {
        for (ClassDefinition classDefinition : classes) {
            if (classDefinition.matches(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean importMatches(ImportDeclaration node) {
        String fqName = node.asFullyQualifiedName();
        for (ClassDefinition classDefinition : classes) {
            String name =classDefinition.asText() + ClassDefinition.DOT;
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
