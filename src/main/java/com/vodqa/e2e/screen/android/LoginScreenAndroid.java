package com.vodqa.e2e.screen.android;

import com.vodqa.e2e.screen.ActionsScreen;
import com.vodqa.e2e.screen.LoginScreen;
import com.vodqa.e2e.tools.Driver;
import com.vodqa.e2e.tools.Visual;

public class LoginScreenAndroid extends LoginScreen {
    private final String loginLocator = "login";
    private final Driver driver;
    private final Visual visually;

    public LoginScreenAndroid (Driver driver, Visual visually) {
        this.driver = driver;
        this.visually = visually;
    }

    @Override
    public ActionsScreen login () {
        driver.waitForElementToBeClickable(loginLocator).click();
        return ActionsScreen.get();
    }

}
