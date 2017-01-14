package com.appsingularity.ristretto.lint.checks.detectors;

import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Issue;
import com.appsingularity.ristretto.lint.checks.BaseLintDetectorTest;

import java.util.Collections;
import java.util.List;


public class WithTextDetectorTest extends BaseLintDetectorTest {
    private static final String SIX_WARNINGS = NUMBERED_WARNINGS.format(new Object[] {6});

    @Override
    protected Detector getDetector() {
        return new WithTextDetector();
    }

    @Override
    protected List<Issue> getIssues() {
        return Collections.singletonList(WithTextDetector.ISSUE);
    }



    public void testWithId() throws Exception {
        String output = lintFiles("withtext/WithText.java");
        assertTrue(output.contains(WithTextDetector.ISSUE.getId()));
        assertTrue(output.contains("Information"));
        assertTrue(output.contains("Consider using with(R.string.some_text)"));
        assertTrue(output.contains(SIX_WARNINGS));
        assertFalse(output.contains(NO_WARNINGS));
    }

    public void testWithIdNoImport() throws Exception {
        String output = lintFiles("withtext/WithTextNoImport.java");
        assertTrue(output.contains(WithTextDetector.ISSUE.getId()));
        assertTrue(output.contains("Information"));
        assertTrue(output.contains("Consider using with(R.string.some_text)"));
        assertTrue(output.contains(SIX_WARNINGS));
        assertFalse(output.contains(NO_WARNINGS));
    }

    public void testSuppressLint() throws Exception {
        String output = lintFiles("withtext/SuppressLint.java");
        assertFalse(output.contains(WithTextDetector.ISSUE.getId()));
        assertFalse(output.contains("Information"));
        assertFalse(output.contains("Consider using with(R.id.some_id)"));
        assertFalse(output.contains(SIX_WARNINGS));
        assertTrue(output.contains(NO_WARNINGS));
    }

    public void testWithIdOtherPackage() throws Exception {
        String output = lintFiles("withtext/WithTextOtherPackage.java");
        assertFalse(output.contains(WithTextDetector.ISSUE.getId()));
        assertFalse(output.contains("Information"));
        assertFalse(output.contains("Consider using with(R.id.some_id)"));
        assertFalse(output.contains(SIX_WARNINGS));
        assertTrue(output.contains(NO_WARNINGS));
    }

}
