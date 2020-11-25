package com.vodqa.e2e;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

public class RunCukes extends AbstractTestNGCucumberTests {
  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    System.out.printf("ThreadID: %d: in overridden scenarios%n", Thread.currentThread().getId());
    Object[][] scenarios = super.scenarios();
    System.out.println(scenarios);
    return scenarios;
  }
}
