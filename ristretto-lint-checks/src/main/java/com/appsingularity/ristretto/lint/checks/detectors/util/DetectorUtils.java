package com.appsingularity.ristretto.lint.checks.detectors.util;


import com.android.annotations.Nullable;
import com.android.tools.lint.detector.api.JavaContext;

import java.text.MessageFormat;

import lombok.ast.Expression;
import lombok.ast.MethodInvocation;
import lombok.ast.Select;
import lombok.ast.StrictListAccessor;
import lombok.ast.VariableReference;


public final class DetectorUtils {

    private DetectorUtils() {
        // This class should not be instantiated.
    }

    public static MethodInvocation getFirstArgument(MethodInvocation node) {
        StrictListAccessor<Expression, MethodInvocation> args = node.astArguments();
        if (args != null && args.size() >= 1) {
            Expression expression = args.first();
            // Skip anything that is not a method call, such as operands
            if (expression instanceof MethodInvocation) {
                return (MethodInvocation) expression;
            }
        }
        return null;
    }


    /**
     * Does the given {@code argument} match the given {@code methodDefinition}?
     * This method will first check the operand if it's there or imports if it's not there.
     * @param context   The context
     * @param argument  The argument we are trying to match
     * @param methodDefinition  The method we are matching against
     * @return {@code true} if it matches, false otherwise
     */
    public static boolean isNode(JavaContext context, MethodInvocation argument, MethodDefinition methodDefinition) {
        if (methodDefinition == null || argument == null
                || !methodDefinition.methodName.equals(argument.getDescription())) {
            return false;
        }
        Expression operand = argument.astOperand();
        if (operand != null) {
            return methodDefinition.classMatches(operand.toString());
        }
        // method found in the code with no operand, see if there is an import for it.
        return ImportFinder.hasImport(context, methodDefinition);
    }

    public static String argumentsAsString(MethodInvocation node, String messageFormat) {
        StringBuilder buffer = new StringBuilder();
        StrictListAccessor<Expression, MethodInvocation> expressions = node.astArguments();
        for (Expression expression : expressions) {
            if (expression instanceof VariableReference) {
                buffer.append(expression);
                buffer.append(ClassDefinition.DOT);
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

    public static boolean isWithNode(JavaContext context, @Nullable MethodInvocation node) {
        return node != null && (isNode(context, node, MethodDefinitions.WITH_ID)
                || isNode(context, node, MethodDefinitions.WITH_TEXT)
                || isNode(context, node, MethodDefinitions.RISTRETTO_WITH));
    }

}
