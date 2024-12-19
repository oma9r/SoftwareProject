Feature: Program Exploration and Enrollment

  # Scenario 1: Browse programs by difficulty level
  Scenario: User browses programs by difficulty level
    Given the user is on the program exploration page
    When the user selects the "Beginner" difficulty level filter
    Then the user should see only programs with the "Beginner" difficulty level
    When the user selects the "Intermediate" difficulty level filter
    Then the user should see only programs with the "Intermediate" difficulty level
    When the user selects the "Advanced" difficulty level filter
    Then the user should see only programs with the "Advanced" difficulty level

  # Scenario 2: Browse programs by focus area
  Scenario: User browses programs by focus area
    Given the user is on the program exploration page
    When the user selects the "Weight Loss" focus area filter
    Then the user should see only programs focused on "Weight Loss"
    When the user selects the "Muscle Building" focus area filter
    Then the user should see only programs focused on "Muscle Building"
    When the user selects the "Flexibility" focus area filter
    Then the user should see only programs focused on "Flexibility"

  # Scenario 3: User enrolls in a program
  Scenario: User enrolls in a program
    Given the user is on a program detail page
    When the user clicks the "Enroll" button
    Then the user should be enrolled in the program
    And the user should see a confirmation message
    And the user's enrolled program should be added to their account

  # Scenario 4: User views program schedule
  Scenario: User views program schedule
    Given the user is on a program detail page
    When the user clicks the "View Schedule" button
    Then the user should see the full schedule of the program
    And the user should see the start date, end date, and available time slots

  # Scenario 5: User applies multiple filters
  Scenario: User applies multiple filters to browse programs
    Given the user is on the program exploration page
    When the user selects the "Intermediate" difficulty level filter
    And the user selects the "Muscle Building" focus area filter
    Then the user should see only programs with "Intermediate" difficulty level and "Muscle Building" focus area

  # Scenario 6: User clears filters
  Scenario: User clears applied filters
    Given the user has applied filters for "Beginner" difficulty level and "Weight Loss" focus area
    When the user clicks the "Clear Filters" button
    Then all filters should be cleared
    And the user should see all available programs without any filters applied