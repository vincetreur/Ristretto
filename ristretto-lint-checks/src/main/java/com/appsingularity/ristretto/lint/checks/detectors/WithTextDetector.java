package com.appsingularity.ristretto.lint.checks.detectors;


import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;
import com.appsingularity.ristretto.lint.checks.detectors.util.MethodDefinition;
import com.appsingularity.ristretto.lint.checks.detectors.util.MethodDefinitions;

import java.util.Collections;
import java.util.List;

import lombok.ast.AstVisitor;
import lombok.ast.MethodInvocation;

import static com.appsingularity.ristretto.lint.checks.detectors.util.DetectorUtils.argumentsAsString;
import static com.appsingularity.ristretto.lint.checks.detectors.util.DetectorUtils.isNode;

public class WithTextDetector extends Detector implements Detector.JavaScanner {
    private static final MethodDefinition METHOD_CALL = MethodDefinitions.WITH_TEXT;
    private static final String MESSAGE_FORMAT = "Consider using `with({0})`";
    public static final Issue ISSUE = Issue.create(
            IssuesIds.WITH_ISSUE_ID,
            "You are using withText()",
            "You are using `ViewMatchers.withText()` but you could be using `RistrettoViewMatchers.with()` or `Ristretto.withView()`",
            Category.USABILITY, 6, Severity.INFORMATIONAL,
            new Implementation(WithTextDetector.class, Scope.JAVA_FILE_SCOPE));

    // region JavaScanner
    @Override
    public List<String> getApplicableMethodNames() {
        return Collections.singletonList(METHOD_CALL.methodName);
    }

    @Override
    public void visitMethod(JavaContext context, AstVisitor visitor, MethodInvocation node) {
        if (isNode(context, node, METHOD_CALL)) {
            String message = argumentsAsString(node, MESSAGE_FORMAT);
            context.report(ISSUE, node, context.getLocation(node), message);
        }
    }
    // endregion

}
