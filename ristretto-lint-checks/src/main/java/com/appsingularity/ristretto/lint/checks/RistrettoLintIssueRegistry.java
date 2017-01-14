package com.appsingularity.ristretto.lint.checks;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;
import com.appsingularity.ristretto.lint.checks.detectors.AllOfIsDisplayedDetector;
import com.appsingularity.ristretto.lint.checks.detectors.OnViewDetector;
import com.appsingularity.ristretto.lint.checks.detectors.WithIdDetector;
import com.appsingularity.ristretto.lint.checks.detectors.WithTextDetector;
import com.appsingularity.ristretto.lint.checks.detectors.WithViewDetector;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
public class RistrettoLintIssueRegistry extends IssueRegistry {

    @Override
    public List<Issue> getIssues() {
        return Arrays.asList(
                WithIdDetector.ISSUE,
                WithTextDetector.ISSUE,
                OnViewDetector.ISSUE,
                WithViewDetector.ISSUE,
                AllOfIsDisplayedDetector.ISSUE
        );
    }

}
