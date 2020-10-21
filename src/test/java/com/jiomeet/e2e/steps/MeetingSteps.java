package com.jiomeet.e2e.steps;

import com.context.TestExecutionContext;
import com.jiomeet.e2e.core.entities.User;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class MeetingSteps extends BaseSteps {
    @When("I signup for a new JioMeet account")
    public void iSignupForANewJioMeetAccount() {}

    @Then("I can login using my account")
    public void iCanLoginUsingMyAccount() {}

    @And("I can start a new meeting")
    public void iCanStartANewMeeting() {}

    @Given("I provide valid details")
    public void iProvideValidDetails(List<User> signUpDetails) {

        signUpDetails.stream().forEach(user -> {
            testContext().addTestState("emailOrMobile", user.emailOrMobile());
        });
    }

    @DataTableType
    public User user(Map<String, String> userDetails) {
        return new User(
                userDetails.get("emailOrMobile"),
                userDetails.get("firstName"),
                userDetails.get("lastName"));
    }
}
