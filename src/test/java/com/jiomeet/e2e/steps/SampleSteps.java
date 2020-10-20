package com.jiomeet.e2e.steps;

import com.jiomeet.e2e.UserBaseTest;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleSteps extends UserBaseTest {

  public SampleSteps() {
    super();
  }

  @Given("^I have the this useless scenario$")
  public void uselessScenario() {
    System.out.println("Passed");
    System.out.println(
        "*****DriverSession***" + Thread.currentThread().getName() + getDriver().toString());
  }

  @When("^I click on (\\d+) number")
  public void I_sleep_for_seconds(int arg1) throws InterruptedException {
    System.out.println("sleep for " + arg1 + " sec");
    Thread.sleep(arg1 * 1000);
    //    getDriver().findElementByXPath(".//*[@text=" + arg1 + "]").click();
    System.out.println("Passed");
  }

  @Then("^It should finnish$")
  public void It_should_finnish() {
    System.out.println("Passed");
  }

  @Given("I login")
  public void iLogin() {
    login("login").click();
  }

  @When("I drag & drop")
  public void iDragDrop() {
    waitForElement("dragAndDrop").click();
  }

  @Then("drag and drop should have worked")
  public void dragAndDropShouldHaveWorked() {
    new WebDriverWait(driver, 30)
        .until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("dragMe")));
  }
}