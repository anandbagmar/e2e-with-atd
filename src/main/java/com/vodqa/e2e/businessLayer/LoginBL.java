package com.vodqa.e2e.businessLayer;

import com.vodqa.e2e.screen.LoginScreen;

public class LoginBL {
    public ActionsBL login () {
        LoginScreen.get().login();
        return new ActionsBL();
    }
}
