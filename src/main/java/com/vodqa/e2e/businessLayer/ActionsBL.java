package com.vodqa.e2e.businessLayer;

import com.vodqa.e2e.screen.ActionsScreen;

public class ActionsBL {
    public ActionsBL dragAndDrop () {
        ActionsScreen.get().dragAndDrop();
        return this;
    }

    public ActionsBL verifyDragAndDropWorked () {
        ActionsScreen.get().didDragAndDropWork();
        return this;
    }
}
