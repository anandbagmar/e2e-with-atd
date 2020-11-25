package com.vodqa.e2e.screen;

import com.vodqa.e2e.screen.android.LoginScreenAndroid;
import org.apache.commons.lang3.NotImplementedException;

public abstract class LoginScreen extends Screen {
    public static LoginScreen get () {
        LoginScreen loginScreen = null;
        switch (platform) {
            case android:
                loginScreen = new LoginScreenAndroid();
                break;
            default:
                throw new NotImplementedException("Unexpected value: " + platform);
        }
        return loginScreen;
    }

    public abstract ActionsScreen login ();
}
