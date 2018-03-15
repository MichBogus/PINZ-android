Feature: Testing menu view and its component

  Background:
    Given: I open application
    And: I put valid login
    And: I put valid password
    And: I press login button

    Scenario: As a user I want to see whole menu filled with proper controls
      When: I can see menu view
      Then: I can see my items button
      And: I can see scan button
      And: I can see logout button

