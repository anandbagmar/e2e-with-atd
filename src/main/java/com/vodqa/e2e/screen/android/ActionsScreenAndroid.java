package com.vodqa.e2e.screen.android;

import com.vodqa.e2e.screen.ActionsScreen;
import com.vodqa.e2e.tools.Driver;
import com.vodqa.e2e.tools.Visual;

public class ActionsScreenAndroid extends ActionsScreen {
    private final Driver driver;
    private final Visual visually;
    private final String dragMeLocator = "dragMe";
    private final String dragAndDropLocator = "dragAndDrop";

    public ActionsScreenAndroid (Driver driver, Visual visually) {
        this.driver = driver;
        this.visually = visually;
    }

    @Override
    public ActionsScreen dragAndDrop () {
        driver.waitForElementToBeClickable(dragAndDropLocator).click();
        return this;
    }

    @Override
    public boolean didDragAndDropWork () {
        try {
            driver.waitForElementToBeClickable(dragMeLocator).click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
