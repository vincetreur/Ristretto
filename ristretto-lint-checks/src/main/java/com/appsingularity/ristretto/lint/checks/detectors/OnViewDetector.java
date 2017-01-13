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
import static com.appsingularity.ristretto.lint.checks.detectors.util.DetectorUtils.getFirstArgument;
import static com.appsingularity.ristretto.lint.checks.detectors.util.DetectorUtils.isNode;
import static com.appsingularity.ristretto.lint.checks.detectors.util.DetectorUtils.isWithNode;

public class OnViewDetector extends Detector implements Detector.JavaScanner {
    private static final String MESSAGE_FORMAT = "Consider using `withView({0})`";
    private static final MethodDefinition METHOD_CALL = MethodDefinitions.ON_VIEW;
    public static final Issue ISSUE = Issue.create(
            "RistrettoOnView",
            "Statement can be simplified",
            "You could be using `Ristretto.withView()` which is shorter and easier to read.",
            Category.USABILITY, 6, Severity.INFORMATIONAL,
            new Implementation(OnViewDetector.class, Scope.JAVA_FILE_SCOPE));

    // region JavaScanner
    @Override
    public List<String> getApplicableMethodNames() {
        return Collections.singletonList(METHOD_CALL.methodName);
    }

    @Override
    public void visitMethod(JavaContext context, AstVisitor visitor, MethodInvocation node) {
        if (isNode(context, node, METHOD_CALL)) {
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
