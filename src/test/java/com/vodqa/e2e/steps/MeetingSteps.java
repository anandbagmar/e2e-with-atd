package com.vodqa.e2e.steps;

import com.context.SessionContext;
import com.context.TestExecutionContext;
import com.vodqa.e2e.entities.User;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class MeetingSteps {
    private final TestExecutionContext context;

    public MeetingSteps () {
        context = SessionContext.getTestExecutionContext(Thread.currentThread().getId());
    }

    @When("I signup for a new account")
    public void iSignupForANewAccount () {
    }

    @Then("I can login using my account")
    public void iCanLoginUsingMyAccount () {
    }

    @And("I can start a new meeting")
    public void iCanStartANewMeeting () {
    }

    @Given("I provide valid details")
    public void iProvideValidDetails (List<User> signUpDetails) {

        signUpDetails.stream().forEach(user -> {
            context.addTestState("emailOrMobile", user.emailOrMobile());
        });
    }

    @DataTableType
    public User user (Map<String, String> userDetails) {
        return new User(
                userDetails.get("emailOrMobile"),
                userDetails.get("firstName"),
                userDetails.get("lastName"));
    }
}
