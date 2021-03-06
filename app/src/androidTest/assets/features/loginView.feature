Feature: This test suite is all about login view and its controls

  Scenario: I can see all controls for login view
    Given: I open application
    When: I can see LoginActivity
    Then: I can see login button
    And: I can see register user button
    And: I can see register company button
    And: I can see login field
    And: I can see password field

    Scenario: I can see progress view after pressing login button
      Given I open application
      When: I can see LoginActivity
      And: I press login button
      Then: I can see progress bar on login button

