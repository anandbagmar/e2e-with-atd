package com.vodqa.e2e.screen;

import com.vodqa.e2e.screen.android.ActionsScreenAndroid;
import org.apache.commons.lang3.NotImplementedException;

public abstract class ActionsScreen extends Screen {
    public static ActionsScreen get () {
        ActionsScreen actionsScreen = null;
        switch (platform) {
            case android:
                actionsScreen = new ActionsScreenAndroid();
                break;
            default:
                throw new NotImplementedException("Unexpected value: " + platform);
        }
        return actionsScreen;
    }

    public abstract ActionsScreen dragAndDrop ();

    public abstract boolean didDragAndDropWork ();
}
