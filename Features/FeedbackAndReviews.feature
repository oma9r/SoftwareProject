Feature: Feedback and Reviews

   # Scenario 1: Rate a completed program
   Scenario: User rates a completed program
   Given the user has completed a program
   When the user clicks the "Rate Program" button
   And the user selects a rating between 1 and 5 stars
   Then the system should save the rating for the program
   And the user should see a confirmation message

  # Scenario 2: Review a completed program
   Scenario: User writes a review for a completed program
   Given the user has completed a program
   When the user writes a review in the text box
   And the user clicks the "Submit Review" button
   Then the review should be saved
   And the user should see a confirmation message

  # Scenario 3: Submit improvement suggestions
   Scenario: User submits a suggestion to the instructor
   Given the user has completed a program
   When the user clicks the "Submit Suggestion" button
   And the user enters a suggestion for improvement
   Then the suggestion should be sent to the instructor
   And the user should see a confirmation message