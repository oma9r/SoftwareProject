Feature: Progress Tracking


  # Scenario 1: Track personal fitness milestones
  Scenario: User tracks weight progress
    Given the user is on the progress tracking page
    When the user enters their current weight
    Then the system should save the weight data
    And the user should see their current weight displayed

  Scenario: User tracks BMI progress
    Given the user is on the progress tracking page
    When the user enters their current BMI
    Then the system should save the BMI data
    And the user should see their current BMI displayed

  Scenario: User tracks attendance
    Given the user is on the progress tracking page
    When the user logs attendance for a program session
    Then the system should save the attendance data
    And the user should see their attendance history displayed

  # Scenario 2: View achievements or badges
  Scenario: User views program completion badge
    Given the user has completed a program
    When the user views their achievements page
    Then the user should see a badge for completing the program

  Scenario: User views progress over time
    Given the user has tracked their milestones over time
    When the user views their progress chart
    Then the user should see a visual representation of their progress over time