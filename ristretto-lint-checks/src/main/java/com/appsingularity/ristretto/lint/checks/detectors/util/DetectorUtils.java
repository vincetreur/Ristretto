package com.appsingularity.ristretto.lint.checks.detectors.util;


import com.android.tools.lint.detector.api.JavaContext;

import java.text.MessageFormat;

import lombok.ast.Expression;
import lombok.ast.MethodInvocation;
import lombok.ast.Select;
import lombok.ast.StrictListAccessor;
import lombok.ast.VariableReference;

import static com.appsingularity.ristretto.lint.checks.detectors.util.MethodCalls.DOT;


public final class DetectorUtils {

    private DetectorUtils() {
        // This class should not be instantiated.
    }

    public static boolean isOperand(JavaContext context, MethodInvocation node, MethodCall methodCall) {
        Expression operand = node.astOperand();
        if (operand == null) {
            // method found in the code with no operand, see if there is an import for it.
            if (!ImportFinder.findImport(context, methodCall)) {
                return false;
            }
        } else {
            String operandText = operand.toString();
            if (!methodCall.classMatches(operandText)) {
                return false;
            }
        }
        return true;
    }

    public static MethodInvocation getFirstArgument(MethodInvocation node) {
        StrictListAccessor<Expression, MethodInvocation> args = node.astArguments();
        if (args.size() == 1) {
            Expression expression = args.first();
            if (expression instanceof MethodInvocation) {
                return (MethodInvocation) expression;
            }
        }
        return null;
    }


    public static boolean isNode(JavaContext context, MethodInvocation argument, MethodCall methodCall) {
        if (!methodCall.methodName.equals(argument.getDescription())) {
            return false;
        }
        boolean keepLooking = true;
        if (argument.astOperand() == null) {
            // method found in the code with no operand, see if there is an import for it.
            if (!ImportFinder.findImport(context, methodCall)) {
                return false;
            }
            keepLooking = false;
        }
        if (keepLooking) {
            String operand = argument.astOperand().toString();
            if (!methodCall.classMatches(operand)) {
                return false;
            }
        }
        return true;
    }

    public static String argumentsAsString(MethodInvocation node, String messageFormat) {
        StringBuilder buffer = new StringBuilder();
        StrictListAccessor<Expression, MethodInvocation> expressions = node.astArguments();
        for (Expression expression : expressions) {
            if (expression instanceof VariableReference) {
                buffer.append(expression);
                buffer.append(DOT);
            } else if (expression instanceof Select) {
                if (buffer.length() != 0) {
                    buffer.append("(");
                    buffer.append(expression);
                    buffer.append(")");
                } else {
                    buffer.append(expression);
                }
            } else {
                buffer.append(expression);
            }
        }
        return MessageFormat.format(messageFormat, buffer.toString());
    }

    public static boolean isWithNode(JavaContext context, MethodInvocation node) {
        return isNode(context, node, MethodCalls.WITH_ID) || isNode(context, node, MethodCalls.WITH_TEXT)
                || isNode(context, node, MethodCalls.RISTRETTO_WITH);
    }


}
