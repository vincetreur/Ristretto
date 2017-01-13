package com.appsingularity.ristretto.lint.checks.detectors;

import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Issue;
import com.appsingularity.ristretto.lint.checks.BaseLintDetectorTest;

import java.util.Collections;
import java.util.List;

public class WithViewDetectorTest extends BaseLintDetectorTest {
    public static final String SIX_WARNINGS = NUMBERED_WARNINGS.format(new Object[] {6});

    @Override
    protected Detector getDetector() {
        return new WithViewDetector();
    }

    @Override
    protected List<Issue> getIssues() {
        return Collections.singletonList(WithViewDetector.ISSUE);
    }

    public void testWithViewWithId() throws Exception {
        String output = lintFiles("withview/WithViewWithId.java");
        assertTrue(output.contains(WithViewDetector.ISSUE.getId()));
        assertTrue(output.contains("Information"));
        assertTrue(output.contains("Consider using withView(R.id.some_id)"));
        assertTrue(output.contains("Consider using withView(R.string.some_text)"));
        assertTrue(output.contains("Consider using withView(\"some text\")"));
        assertTrue(output.contains(SIX_WARNINGS));
        assertFalse(output.contains(NO_WARNINGS));
    }


    public void testWithViewWithIdNoImport() throws Exception {
        String output = lintFiles("withview/WithViewWithIdNoImport.java");
        assertTrue(output.contains(WithViewDetector.ISSUE.getId()));
        assertTrue(output.contains("Information"));
        assertTrue(output.contains("Consider using withView(R.id.some_id)"));
        assertTrue(output.contains("Consider using withView(R.string.some_text)"));
        assertTrue(output.contains("Consider using withView(\"some text\")"));
        assertTrue(output.contains(SIX_WARNINGS));
        assertFalse(output.contains(NO_WARNINGS));
    }

    public void testSuppressLint() throws Exception {
        String output = lintFiles("withview/SuppressLint.java");
        assertFalse(output.contains(WithViewDetector.ISSUE.getId()));
        assertFalse(output.contains("Information"));
        assertFalse(output.contains("Consider using with(R.id.some_id)"));
        assertFalse(output.contains(SIX_WARNINGS));
        assertTrue(output.contains(NO_WARNINGS));
    }

    public void testWithViewWithIdOtherPackage() throws Exception {
        String output = lintFiles("withview/WithViewWithIdOtherPackage.java");
        assertFalse(output.contains(WithViewDetector.ISSUE.getId()));
        assertFalse(output.contains("Information"));
        assertFalse(output.contains("Consider using with(R.id.some_id)"));
        assertFalse(output.contains(SIX_WARNINGS));
        assertTrue(output.contains(NO_WARNINGS));
    }

}
