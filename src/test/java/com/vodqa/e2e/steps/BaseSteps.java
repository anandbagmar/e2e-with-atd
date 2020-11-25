package com.vodqa.e2e.steps;

import com.context.SessionContext;
import com.context.TestExecutionContext;

public class BaseSteps {
    private String testName;
    private TestExecutionContext testExecutionContext;

    protected String getTestName() {
        if (null == testName){
            testName = testContext().getTestName();
        }
        return testName;
    }

    protected TestExecutionContext testContext() {
        if (null == testExecutionContext) {
            testExecutionContext = SessionContext.getTestExecutionContext(Thread.currentThread().getId());
        }
        return testExecutionContext;
    }

}
