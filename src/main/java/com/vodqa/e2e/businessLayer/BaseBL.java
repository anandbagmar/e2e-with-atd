package com.vodqa.e2e.businessLayer;

import com.context.TestExecutionContext;
import com.vodqa.e2e.context.Session;

public class BaseBL {
    private String testName;
    private TestExecutionContext testExecutionContext;

    protected String getTestName() {
        if (null == testName) {
            testName = testContext().getTestName();
        }
        return testName;
    }

    protected TestExecutionContext testContext() {
        if (null == testExecutionContext) {
            testExecutionContext = Session.getTestExecutionContext(Thread.currentThread().getId());
        }
        return testExecutionContext;
    }
}
