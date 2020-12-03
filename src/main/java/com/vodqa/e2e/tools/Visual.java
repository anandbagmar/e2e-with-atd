package com.vodqa.e2e.tools;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.appium.AppiumCheckSettings;
import com.applitools.eyes.appium.Eyes;
import com.applitools.eyes.appium.Target;
import org.openqa.selenium.WebElement;

public class Visual {
    private final String visualTestNotEnabledMessage = "Visual Test not enabled";
    private final Eyes eyes;

    public Visual (Eyes eyes) {
        this.eyes = eyes;
    }

    public Visual () {
        this.eyes = null;
    }

    public Visual checkWindow (String tag) {
        if (null != eyes) {
            eyes.check(tag, Target.window());
        } else {
            // TODO - take screenshot
            System.out.println(visualTestNotEnabledMessage + " - " + tag);
        }
        return this;
    }

    public Visual checkWindow (String tag, MatchLevel level) {
        if (null != eyes) {
            eyes.check(tag, Target.window().matchLevel(level));
        } else {
            // TODO - take screenshot
            System.out.println(visualTestNotEnabledMessage + " - " + tag);
        }
        return this;
    }

    public Visual checkElement (String tag, WebElement element) {
        if (null != eyes) {
            eyes.check(tag, Target.region(element));
        } else {
            // TODO - take screenshot
            System.out.println(visualTestNotEnabledMessage + " - " + tag);
        }
        return this;
    }

    public Visual checkElement (String tag, WebElement element, MatchLevel level) {
        if (null != eyes) {
            eyes.check(tag, Target.region(element).matchLevel(level));
        } else {
            // TODO - take screenshot
            System.out.println(visualTestNotEnabledMessage + " - " + tag);
        }
        return this;
    }

    public Visual checkElement (String tag, AppiumCheckSettings targetRegion, MatchLevel level) {
        if (null != eyes) {
            eyes.check(tag, targetRegion.matchLevel(level));
        } else {
            // TODO - take screenshot
            System.out.println(visualTestNotEnabledMessage + " - " + tag);
        }
        return this;
    }

    public Visual ignore (String tag, AppiumCheckSettings targetRegion, WebElement element) {
        if (null != eyes) {
            eyes.check(tag, targetRegion.ignore(element));
        } else {
            // TODO - take screenshot
            System.out.println(visualTestNotEnabledMessage + " - " + tag);
        }
        return this;
    }

    public boolean handleTestResults () {
        if (null == eyes) {
            System.out.println("Eyes is null");
            return true;
        } else {
            TestResults visualResults = eyes.close(false);
            return handleTestResults(visualResults);
        }
    }

    private boolean handleTestResults (TestResults result) {
        System.out.println("\t\t" + result);
        System.out.printf("\t\tName = '%s', \nDevice = %s,OS = %s, viewport = %dx%d, matched = %d, mismatched = %d, missing = %d, aborted = %s%n",
                result.getName(),
                result.getHostApp(),
                result.getHostOS(),
                result.getHostDisplaySize().getWidth(),
                result.getHostDisplaySize().getHeight(),
                result.getMatches(),
                result.getMismatches(),
                result.getMissing(),
                (result.isAborted() ? "aborted" : "no"),
                result.getAccessibilityStatus(),
                result.getDuration());
        System.out.println("Visual Testing results available here: " + result.getUrl());
        boolean hasMismatches = result.getMismatches() != 0 || result.isAborted();
        System.out.println("Visual testing differences found? - " + hasMismatches);
        return hasMismatches;
    }

}
