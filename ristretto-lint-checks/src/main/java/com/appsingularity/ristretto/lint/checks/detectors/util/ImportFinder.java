package com.appsingularity.ristretto.lint.checks.detectors.util;


import com.android.tools.lint.detector.api.JavaContext;

import lombok.ast.ForwardingAstVisitor;
import lombok.ast.ImportDeclaration;
import lombok.ast.Node;


public class ImportFinder extends ForwardingAstVisitor {
    private boolean importFound = false;
    private MethodCall methodCall;

    ImportFinder(MethodCall aMethodCall) {
        methodCall = aMethodCall;
    }

    public static boolean findImport(JavaContext context, MethodCall aMehtodCall) {
        ImportFinder finder = new ImportFinder(aMehtodCall);
        Node surroundingClass = context.getCompilationUnit();
        surroundingClass.accept(finder);
        return finder.isImportFound();
    }

    @Override
    public boolean visitImportDeclaration(ImportDeclaration node) {
        if (methodCall.importMatches(node)) {
            importFound = true;
        }
        return true;
    }

    boolean isImportFound() {
        return importFound;
    }

}
