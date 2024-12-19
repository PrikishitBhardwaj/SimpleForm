Feature: Simple Form Submission

  Scenario: Submit the form with valid data
    Given I open the Simple Form application
    When I fill in the form with the following details:
      | field       | value          |
      | firstName   | John           |
      | lastName    | Doe            |
      | email       | john.doe@example.com |
      | contact     | 1234567890     |
    And I click the submit button
    Then I should see the confirmation message
