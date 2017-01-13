package com.appsingularity.ristretto.lint.checks.detectors;

import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Issue;
import com.appsingularity.ristretto.lint.checks.BaseLintDetectorTest;

import java.util.Collections;
import java.util.List;

public class AllOfIsDisplayedDetectorTest extends BaseLintDetectorTest {
    public static final String SIXTEEN_WARNINGS = NUMBERED_WARNINGS.format(new Object[] {16});
    public static final String FORTY_EIGHT_WARNINGS = NUMBERED_WARNINGS.format(new Object[] {48});

    @Override
    protected Detector getDetector() {
        return new AllOfIsDisplayedDetector();
    }

    @Override
    protected List<Issue> getIssues() {
        return Collections.singletonList(AllOfIsDisplayedDetector.ISSUE);
    }


    public void testOnViewAllOfAllOfWithIsDisplayed() throws Exception {
        String output = lintFiles("allof_isdisplayed/OnViewAllOfAllOfWithIsDisplayed.java");
        assertTrue(output.contains(AllOfIsDisplayedDetector.ISSUE.getId()));
        assertTrue(output.contains("Information"));
        assertTrue(output.contains("Consider using withDisplayedView(R.id.some_id)"));
        assertTrue(output.contains(SIXTEEN_WARNINGS));
        assertFalse(output.contains(NO_WARNINGS));
    }

    public void testOnViewCoreMatchersAllOfWithIsDisplayed() throws Exception {
        String output = lintFiles("allof_isdisplayed/OnViewCoreMatchersAllOfWithIsDisplayed.java");
        assertTrue(output.contains(AllOfIsDisplayedDetector.ISSUE.getId()));
        assertTrue(output.contains("Information"));
        assertTrue(output.contains("Consider using withDisplayedView(R.id.some_id)"));
        assertTrue(output.contains(SIXTEEN_WARNINGS));
        assertFalse(output.contains(NO_WARNINGS));
    }

    public void testOnViewMatchersAllOfWithIsDisplayed() throws Exception {
        String output = lintFiles("allof_isdisplayed/OnViewMatchersAllOfWithIsDisplayed.java");
        assertTrue(output.contains(AllOfIsDisplayedDetector.ISSUE.getId()));
        assertTrue(output.contains("Information"));
        assertTrue(output.contains("Consider using withDisplayedView(R.id.some_id)"));
        assertTrue(output.contains(SIXTEEN_WARNINGS));
        assertFalse(output.contains(NO_WARNINGS));
    }

    public void testOnViewAllOfWithIsDisplayedNoImport() throws Exception {
        String output = lintFiles("allof_isdisplayed/OnViewAllOfWithIsDisplayedNoImport.java");
        assertTrue(output.contains(AllOfIsDisplayedDetector.ISSUE.getId()));
        assertTrue(output.contains("Information"));
        assertTrue(output.contains("Consider using withDisplayedView(R.id.some_id)"));
        assertTrue(output.contains(FORTY_EIGHT_WARNINGS));
        assertFalse(output.contains(NO_WARNINGS));
    }

    public void testAllOfAllOfWithIsDisplayedNoParent() throws Exception {
        String output = lintFiles("allof_isdisplayed/AllOfAllOfWithIsDisplayedNoParent.java");
        assertFalse(output.contains(AllOfIsDisplayedDetector.ISSUE.getId()));
        assertFalse(output.contains("Information"));
        assertFalse(output.contains("Consider using withDisplayedView(R.id.some_id)"));
        assertTrue(output.contains(NO_WARNINGS));
    }

    public void testSuppressLint() throws Exception {
        String output = lintFiles("allof_isdisplayed/SuppressLint.java");
        assertFalse(output.contains(AllOfIsDisplayedDetector.ISSUE.getId()));
        assertFalse(output.contains("Information"));
        assertFalse(output.contains("Consider using with(R.id.some_id)"));
        assertFalse(output.contains(SIXTEEN_WARNINGS));
        assertTrue(output.contains(NO_WARNINGS));
    }

}
