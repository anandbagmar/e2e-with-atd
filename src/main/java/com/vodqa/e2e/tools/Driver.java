package com.vodqa.e2e.tools;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Driver {
    private final AppiumDriver driver;

    public Driver (AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForVisibilityOf (By elementId) {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(elementId));
    }

    public WebElement waitForElementToBeClickable (String locator) {
        return new WebDriverWait(driver, 15).until(ExpectedConditions
                .elementToBeClickable(MobileBy.AccessibilityId(locator)));
    }

    public void waitForAlert () {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.alertIsPresent());
    }

    public WebElement findElement (By elementId) {
        return driver.findElement(elementId);
    }

    public List findElements (By element) {
        return this.driver.findElements(element);
    }

    public WebElement findElementById (String locator) {
        return driver.findElementById(locator);
    }

    public WebElement findElementByAccessibilityId (String locator) {
        return driver.findElementByAccessibilityId(locator);
    }

    public WebElement findElementByXPath (String locator) {
        return driver.findElementByXPath(locator);
    }
}