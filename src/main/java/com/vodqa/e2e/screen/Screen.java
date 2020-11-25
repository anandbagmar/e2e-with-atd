package com.vodqa.e2e.screen;

import com.applitools.eyes.appium.Eyes;
import com.context.TestExecutionContext;
import com.vodqa.e2e.context.Session;
import com.vodqa.e2e.entities.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screen {
    protected static final Platform platform = Session.platform;
    protected final AppiumDriver driver;
    private String testName;
    private TestExecutionContext testExecutionContext;

    protected Screen () {
        testExecutionContext = Session.getTestExecutionContext(Thread.currentThread().getId());
        driver = testExecutionContext.getDriver();
    }

    protected String getTestName() {
        if (null == testName) {
            testName = testContext().getTestName();
        }
        return testName;
    }

    protected TestExecutionContext testContext() {
        if (null == testExecutionContext) {
            testExecutionContext = Session.getTestExecutionContext(Thread.currentThread().getId());
        }
        return testExecutionContext;
    }

    protected Eyes eyes() {
        return (Eyes) testContext().getTestState("eyes");
    }

    protected WebElement waitForVisibilityOf(By elementId) {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(elementId));
    }

    public WebElement waitForElement(String locator) {
        return new WebDriverWait(driver,15).until(ExpectedConditions
                .elementToBeClickable(MobileBy.AccessibilityId(locator)));
    }

}
