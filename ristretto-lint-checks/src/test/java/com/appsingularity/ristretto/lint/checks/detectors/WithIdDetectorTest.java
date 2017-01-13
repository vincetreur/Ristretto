package com.appsingularity.ristretto.lint.checks.detectors;

import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Issue;
import com.appsingularity.ristretto.lint.checks.BaseLintDetectorTest;

import java.util.Collections;
import java.util.List;

public class WithIdDetectorTest extends BaseLintDetectorTest {

    @Override
    protected Detector getDetector() {
        return new WithIdDetector();
    }

    @Override
    protected List<Issue> getIssues() {
        return Collections.singletonList(WithIdDetector.ISSUE);
    }


    public void testWithId() throws Exception {
        String output = lintFiles("withid/WithId.java");
        assertTrue(output.contains(WithIdDetector.ISSUE.getId()));
        assertTrue(output.contains("Information"));
        assertTrue(output.contains("Consider using with(R.id.some_id)"));
        assertTrue(output.contains(THREE_WARNINGS));
        assertFalse(output.contains(NO_WARNINGS));
    }

    public void testWithIdNoImport() throws Exception {
        String output = lintFiles("withid/WithIdNoImport.java");
        assertTrue(output.contains(WithIdDetector.ISSUE.getId()));
        assertTrue(output.contains("Information"));
        assertTrue(output.contains("Consider using with(R.id.some_id)"));
        assertTrue(output.contains(THREE_WARNINGS));
        assertFalse(output.contains(NO_WARNINGS));
    }

    public void testSuppressLint() throws Exception {
        String output = lintFiles("withid/SuppressLint.java");
        assertFalse(output.contains(WithIdDetector.ISSUE.getId()));
        assertFalse(output.contains("Information"));
        assertFalse(output.contains("Consider using with(R.id.some_id)"));
        assertFalse(output.contains(THREE_WARNINGS));
        assertTrue(output.contains(NO_WARNINGS));
    }

}
