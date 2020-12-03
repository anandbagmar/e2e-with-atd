package com.vodqa.e2e;

import com.applitools.eyes.appium.Eyes;
import com.context.SessionContext;
import com.context.TestExecutionContext;
import com.vodqa.e2e.context.Session;
import com.vodqa.e2e.tools.Driver;
import com.vodqa.e2e.tools.Visual;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

public class RunCukes extends AbstractTestNGCucumberTests {
    private final TestExecutionContext context;

    public RunCukes () {
        context = SessionContext.getTestExecutionContext(Thread.currentThread().getId());
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios () {
        System.out.printf("ThreadID: %d: in overridden scenarios%n", Thread.currentThread().getId());
        Object[][] scenarios = super.scenarios();
        System.out.println(scenarios);
        return scenarios;
    }

    @Before
    public void beforeScenario (Scenario scenario) {
        System.out.printf("ThreadId: '%d': In RunCukes - Before: '%s'%n", Thread.currentThread().getId(), scenario.getName());
        System.out.printf("Running test: '%s' on '%s'%n", context.getTestName(), Session.platform);
        Driver driver = new Driver(context.getDriver());
        context.addTestState("driver", driver);
        Visual visually = new Visual();
        context.addTestState("eyes", visually);
    }

    @Before("@visual")
    public void beforeVisualScenario (Scenario scenario) {
        if (Session.isVisualTestingEnabled) {
            System.out.printf("ThreadId: '%d': In RunCukes - Before Visual: '%s'%n", Thread.currentThread().getId(), scenario.getName());
            Eyes eyes = new Eyes();
            eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));
            eyes.setBatch(Session.batchName);
            eyes.open(context.getDriver(), "VodQA-" + Session.platform, scenario.getName());
            Visual visually = new Visual(eyes);
            context.addTestState("eyes", visually);
        } else {
            System.out.println("ThreadId: " + Thread.currentThread().getId() + ": In RunCukes - Skip Before Visual: " + scenario.getName());
        }
    }

    @After
    public void afterScenario (Scenario scenario) {
        System.out.printf("ThreadId: '%d': In RunCukes - After: '%s'%n", Thread.currentThread().getId(), scenario.getName());
    }

    @After("@visual")
    public void afterVisualScenario (Scenario scenario) {
        if (Session.isVisualTestingEnabled) {
            System.out.printf("ThreadId: '%d': In RunCukes - After Visual: '%s'%n", Thread.currentThread().getId(), scenario.getName());
            Visual eyes = (Visual) context.getTestState("eyes");
            boolean visualTestingStatus = eyes.handleTestResults();
        } else {
            System.out.println("ThreadId: " + Thread.currentThread().getId() + ": In RunCukes - Skip After Visual: " + scenario.getName());
        }
    }

}
