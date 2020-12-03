package com.vodqa.e2e.screen;

import com.vodqa.e2e.screen.android.LoginScreenAndroid;
import com.vodqa.e2e.tools.Driver;
import com.vodqa.e2e.tools.Visual;
import org.apache.commons.lang3.NotImplementedException;

import static com.vodqa.e2e.context.Session.*;

public abstract class LoginScreen {
    public static LoginScreen get () {
        Driver driver = fetchDriver(Thread.currentThread().getId());
        Visual visually = fetchEyes(Thread.currentThread().getId());

        LoginScreen loginScreen = null;
        switch (platform) {
            case android:
                loginScreen = new LoginScreenAndroid(driver, visually);
                break;
            default:
                throw new NotImplementedException("Unexpected value: " + platform);
        }
        return loginScreen;
    }

    public abstract ActionsScreen login ();
}
