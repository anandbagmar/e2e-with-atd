package com.vodqa.e2e.screen.android;

import com.vodqa.e2e.screen.ActionsScreen;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsScreenAndroid extends ActionsScreen {
    @Override
    public ActionsScreen dragAndDrop () {
        waitForElement("dragAndDrop").click();
        return this;
    }

    @Override
    public boolean didDragAndDropWork () {
        try{
            new WebDriverWait(driver, 30)
                    .until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("dragMe")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
