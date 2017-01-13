package com.appsingularity.ristretto.lint.checks.detectors;


import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;
import com.appsingularity.ristretto.lint.checks.detectors.util.MethodCall;
import com.appsingularity.ristretto.lint.checks.detectors.util.MethodCalls;

import java.util.Collections;
import java.util.List;

import lombok.ast.AstVisitor;
import lombok.ast.MethodInvocation;

import static com.appsingularity.ristretto.lint.checks.detectors.util.DetectorUtils.argumentsAsString;
import static com.appsingularity.ristretto.lint.checks.detectors.util.DetectorUtils.getFirstArgument;
import static com.appsingularity.ristretto.lint.checks.detectors.util.DetectorUtils.isOperand;
import static com.appsingularity.ristretto.lint.checks.detectors.util.DetectorUtils.isWithNode;


public class WithViewDetector extends Detector implements Detector.JavaScanner {
    private static final String MESSAGE_FORMAT = "Consider using `withView({0})`";
    private static final MethodCall METHOD_CALL = MethodCalls.RISTRETTO_WITH_VIEW;
    public static final Issue ISSUE = Issue.create(
            "RistrettoWithView",
            "Statement can be simplified",
            "You could be using `Ristretto.withView()` which is shorter and easier to read.",
            Category.USABILITY, 6, Severity.INFORMATIONAL,
            new Implementation(WithViewDetector.class, Scope.JAVA_FILE_SCOPE));

    // region JavaScanner
    @Override
    public List<String> getApplicableMethodNames() {
        return Collections.singletonList(METHOD_CALL.methodName);
    }

    @Override
    public void visitMethod(JavaContext context, AstVisitor visitor, MethodInvocation node) {
        if (isOperand(context, node, METHOD_CALL)) {
            MethodInvocation first = getFirstArgument(node);
            if (first != null) {
                if (isWithNode(context, first)) {
                    String message = argumentsAsString(first, MESSAGE_FORMAT);
                    context.report(ISSUE, node, context.getLocation(node), message);
                }
            }
        }
    }
    // endregion

}
