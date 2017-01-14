package com.appsingularity.ristretto.lint.checks;


import com.android.tools.lint.checks.infrastructure.LintDetectorTest;
import com.android.utils.SdkUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.text.MessageFormat;

public abstract class BaseLintDetectorTest extends LintDetectorTest {
    private static final String PATH_TEST_RESOURCES = "/src/test/resources/";
    public static final String NO_WARNINGS = "No warnings.";
    public static final String THREE_WARNINGS = "0 errors, 3 warnings";
    public static final MessageFormat NUMBERED_WARNINGS = new MessageFormat("0 errors, {0} warnings");


    @Override
    protected InputStream getTestResource(String relativePath, boolean expectExists) {
        String path = (PATH_TEST_RESOURCES + relativePath).replace('/', File.separatorChar);
        File file = new File(getTestDataRootDir(), path);
        if (file.exists()) {
            try {
                return new BufferedInputStream(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                if (expectExists) {
                    fail("Could not find file " + relativePath);
                }
            }
        }
        return null;
    }

    private File getTestDataRootDir() {
        CodeSource source = getClass().getProtectionDomain().getCodeSource();
        if (source != null) {
            URL location = source.getLocation();
            try {
                File classesDir = SdkUtils.urlToFile(location);
                return classesDir.getParentFile().getAbsoluteFile().getParentFile().getParentFile();
            } catch (MalformedURLException e) {
                fail(e.getLocalizedMessage());
            }
        }
        return null;
    }

}
