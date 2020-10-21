@smoke
Feature: Signup for JioMeet account

  Scenario Outline: New user signs up for new JioMeet account
    Given I provide valid details
#      | emailOrMobile       | firstName | lastName |
#      | <communicationType> | John      | Doe      |
    When I signup for a new JioMeet account
    Then I can login using my account
    And I can start a new meeting
    Examples:
      | communicationType | firstName | lastName |
      | email             | John      | Doe      |
      | 1234              | John      | Doe      |