package com.appsingularity.ristretto.lint.checks.detectors.util;


import com.android.tools.lint.detector.api.JavaContext;

import lombok.ast.ForwardingAstVisitor;
import lombok.ast.ImportDeclaration;
import lombok.ast.Node;


class ImportFinder extends ForwardingAstVisitor {
    private boolean importFound = false;
    private final MethodDefinition methodDefinition;

    private ImportFinder(MethodDefinition aMethodDefinition) {
        methodDefinition = aMethodDefinition;
    }

    public static boolean findImport(JavaContext context, MethodDefinition aMehtodCall) {
        ImportFinder finder = new ImportFinder(aMehtodCall);
        Node surroundingClass = context.getCompilationUnit();
        surroundingClass.accept(finder);
        return finder.isImportFound();
    }

    @Override
    public boolean visitImportDeclaration(ImportDeclaration node) {
        if (methodDefinition.importMatches(node)) {
            importFound = true;
        }
        return true;
    }

    private boolean isImportFound() {
        return importFound;
    }

}
