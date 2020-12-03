package com.vodqa.e2e.screen;

import com.vodqa.e2e.screen.android.ActionsScreenAndroid;
import com.vodqa.e2e.tools.Driver;
import com.vodqa.e2e.tools.Visual;
import org.apache.commons.lang3.NotImplementedException;

import static com.vodqa.e2e.context.Session.*;

public abstract class ActionsScreen {
    public static ActionsScreen get () {
        Driver driver = fetchDriver(Thread.currentThread().getId());
        Visual visually = fetchEyes(Thread.currentThread().getId());

        ActionsScreen actionsScreen = null;
        switch (platform) {
            case android:
                actionsScreen = new ActionsScreenAndroid(driver, visually);
                break;
            default:
                throw new NotImplementedException("Unexpected value: " + platform);
        }
        return actionsScreen;
    }

    public abstract ActionsScreen dragAndDrop ();

    public abstract boolean didDragAndDropWork ();
}
