package com.appsingularity.ristretto.lint.checks.detectors;


import com.android.annotations.Nullable;
import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;
import com.appsingularity.ristretto.lint.checks.detectors.util.MethodDefinitions;

import java.util.Collections;
import java.util.List;

import lombok.ast.AstVisitor;
import lombok.ast.Expression;
import lombok.ast.MethodInvocation;
import lombok.ast.Node;
import lombok.ast.StrictListAccessor;

import static com.appsingularity.ristretto.lint.checks.detectors.util.DetectorUtils.argumentsAsString;
import static com.appsingularity.ristretto.lint.checks.detectors.util.DetectorUtils.isNode;
import static com.appsingularity.ristretto.lint.checks.detectors.util.DetectorUtils.isWithNode;


public class AllOfIsDisplayedDetector extends Detector implements Detector.JavaScanner {
    private static final String MESSAGE_FORMAT = "Consider using `withDisplayedView({0})`";
    public static final Issue ISSUE = Issue.create(
            IssuesIds.WITH_DISPLAYED_VIEW_ISSUE_ID,
            "Statement can be simplified",
            "You could be using `Ristretto.withDisplayedView()` which is shorter and easier to read.",
            Category.USABILITY, 6, Severity.INFORMATIONAL,
            new Implementation(AllOfIsDisplayedDetector.class, Scope.JAVA_FILE_SCOPE));

    // region JavaScanner
    @Override
    public List<String> getApplicableMethodNames() {
        return Collections.singletonList(MethodDefinitions.ALL_OF.methodName);
    }

    @Override
    public void visitMethod(JavaContext context, AstVisitor visitor, MethodInvocation node) {
        if (!isNode(context, node, MethodDefinitions.ALL_OF)) {
            return;
        }
        // is parent onView or withView?
        Node parentNode = node.getParent();
        if (isInvalidParent(context, parentNode)) {
            return;
        }

        MethodInvocation matcher = extractMatcher(context, node);
        // has withXXX()
        if (!isWithNode(context, matcher)) {
            return;
        }
        String message = argumentsAsString(matcher, MESSAGE_FORMAT);
        context.report(ISSUE, node, context.getLocation(parentNode), message);
    }
    // endregion

    /**
     * Extract non-isDisplayed part or null
     */
    @Nullable
    private MethodInvocation extractMatcher(JavaContext context, MethodInvocation node) {
        // Only 2 items in allOf()?
        StrictListAccessor<Expression, MethodInvocation> args = node.astArguments();
        if (args == null || args.size() != 2) {
            return null;
        }
        // has isDisplayed()
        boolean foundIsDisplayed = false;
        MethodInvocation other = null;
        for (Expression next : args) {
            if (next instanceof MethodInvocation) {
                MethodInvocation invocation = (MethodInvocation) next;
                if (isNode(context, invocation, MethodDefinitions.IS_DISPLAYED)) {
                    foundIsDisplayed = true;
                } else {
                    other = invocation;
                }
            }
        }
        if (!foundIsDisplayed || other == null) {
            return null;
        }
        return other;
    }

    private boolean isInvalidParent(JavaContext context, Node parentNode) {
        if (!(parentNode instanceof MethodInvocation)) {
            return true;
        }
        MethodInvocation parent = (MethodInvocation) parentNode;
        return !isNode(context, parent, MethodDefinitions.RISTRETTO_WITH_VIEW)
                && !isNode(context, parent, MethodDefinitions.ON_VIEW);
    }

}
