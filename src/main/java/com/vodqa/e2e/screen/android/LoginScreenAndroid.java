package com.vodqa.e2e.screen.android;

import com.vodqa.e2e.screen.ActionsScreen;
import com.vodqa.e2e.screen.LoginScreen;

public class LoginScreenAndroid extends LoginScreen {
    private final String loginLocator = "login";

    @Override
    public ActionsScreen login () {
        waitForElement(loginLocator).click();
        return ActionsScreen.get();
    }

}
