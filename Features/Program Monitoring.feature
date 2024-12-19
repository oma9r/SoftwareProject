Feature: Program Monitoring

  Scenario: View statistics on the most popular programs by enrollment
    Given I am logged in as an admin
    When I navigate to the "Program Monitoring" section
    Then I should see a list of programs sorted by the number of enrollments

  Scenario: Generate a report on revenue
    Given I am logged in as an admin
    When I navigate to the "Program Monitoring" section
    And I select Generate Report and choose Revenue
    Then the report should include a breakdown of income per program

  Scenario: Generate a report on attendance
    Given I am logged in as an admin
    When I navigate to the "Program Monitoring" section
    And I select Generate Report and choose Attendance
    Then I should see a detailed report on the attendance for each program
    And the report should show the number of participants for each session

  Scenario: Generate a report on client progress
    Given I am logged in as an admin
    When I navigate to the "Program Monitoring" section
    And I select Generate Report and choose Client Progress
    Then I should see a detailed report on client progress for each program
    And the report should include completion rates, client feedback, and milestones

  Scenario: Track active programs
    Given I am logged in as an admin
    When I navigate to the "Program Monitoring" section
    Then I should see a list of all active programs
    And I should be able to filter the list by categories such as difficulty or focus area

  Scenario: Track completed programs
    Given I am logged in as an admin
    When I navigate to the "Program Monitoring" section
    And I filter the programs to show completed ones
    Then I should see a list of all completed programs
    And I should be able to view details about the completion status of each program
