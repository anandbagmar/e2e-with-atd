package com.vodqa.e2e.steps;

import com.vodqa.e2e.businessLayer.ActionsBL;
import com.vodqa.e2e.businessLayer.BaseBL;
import com.vodqa.e2e.businessLayer.LoginBL;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleSteps extends BaseBL {

    public SampleSteps() {
        super();
    }

    @Given("I login")
    public void iLogin() {
        new LoginBL().login();
    }

    @When("I drag & drop")
    public void iDragDrop() {
        new ActionsBL().dragAndDrop();
    }

    @Then("drag and drop should have worked")
    public void dragAndDropShouldHaveWorked() {
        new ActionsBL().verifyDragAndDropWorked();
    }
}
