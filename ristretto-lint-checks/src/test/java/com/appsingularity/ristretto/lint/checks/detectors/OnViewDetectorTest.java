package com.appsingularity.ristretto.lint.checks.detectors;

import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Issue;
import com.appsingularity.ristretto.lint.checks.BaseLintDetectorTest;

import java.util.Collections;
import java.util.List;

public class OnViewDetectorTest extends BaseLintDetectorTest {
    public static final String SIX_WARNINGS = NUMBERED_WARNINGS.format(new Object[] {6});

    @Override
    protected Detector getDetector() {
        return new OnViewDetector();
    }

    @Override
    protected List<Issue> getIssues() {
        return Collections.singletonList(OnViewDetector.ISSUE);
    }

    public void testOnViewWithId() throws Exception {
        String output = lintFiles("onview/OnViewWithId.java");
        assertTrue(output.contains(OnViewDetector.ISSUE.getId()));
        assertTrue(output.contains("Information"));
        assertTrue(output.contains("Consider using withView(R.id.some_id)"));
        assertTrue(output.contains("Consider using withView(R.string.some_text)"));
        assertTrue(output.contains("Consider using withView(\"some text\")"));
        assertTrue(output.contains(SIX_WARNINGS));
        assertFalse(output.contains(NO_WARNINGS));
    }

    public void testOnViewWithIdNoImport() throws Exception {
        String output = lintFiles("onview/OnViewWithIdNoImport.java");
        assertTrue(output.contains(OnViewDetector.ISSUE.getId()));
        assertTrue(output.contains("Information"));
        assertTrue(output.contains("Consider using withView(R.id.some_id)"));
        assertTrue(output.contains("Consider using withView(R.string.some_text)"));
        assertTrue(output.contains("Consider using withView(\"some text\")"));
        assertTrue(output.contains(SIX_WARNINGS));
        assertFalse(output.contains(NO_WARNINGS));
    }


    public void testSuppressLint() throws Exception {
        String output = lintFiles("onview/SuppressLint.java");
        assertFalse(output.contains(OnViewDetector.ISSUE.getId()));
        assertFalse(output.contains("Information"));
        assertFalse(output.contains("Consider using with(R.id.some_id)"));
        assertFalse(output.contains(SIX_WARNINGS));
        assertTrue(output.contains(NO_WARNINGS));
    }

    public void testOnViewWithIdOtherPackage() throws Exception {
        String output = lintFiles("onview/OnViewWithIdOtherPackage.java");
        assertFalse(output.contains(OnViewDetector.ISSUE.getId()));
        assertFalse(output.contains("Information"));
        assertFalse(output.contains("Consider using with(R.id.some_id)"));
        assertFalse(output.contains(SIX_WARNINGS));
        assertTrue(output.contains(NO_WARNINGS));
    }


}
