@smoke
Feature: Sample Feature

    This feature file just sleeps for a 4 seconds (one second each scenario)
    It is not meant to do anything, but sleep
    So we can prove that it runs in parallel

    @android @visual
    Scenario: Example 1 that sleep 1 seconds
        Given I login
        When I drag & drop
        Then drag and drop should have worked