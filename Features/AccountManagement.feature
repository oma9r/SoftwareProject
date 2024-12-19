Feature: Account Management - Profile Creation and Customization


  Scenario: User creates their profile
    Given the user has successfully logged into the Fitness Management System
    When the user navigates to the "Profile" section
    And clicks on the "Create Profile" button
    Then the system displays a form with the following fields:
      | Field                  | Mandatory | Type       |
      | Name                   | Yes       | Text       |
      | Age                    | Yes       | Number     |
      | Fitness Goals          | Yes       | Text       |
      | Dietary Preferences    | No        | Dropdown   |
      | Dietary Restrictions   | No        | Text       |
    When the user fills out the form with valid information:
      | Name           | John Doe     |
      | Age            | 30           |
      | Fitness Goals  | Lose Weight  |
      | Dietary Preferences | Vegan    |
      | Dietary Restrictions | None     |
    And clicks on the "Save" button
    Then the system saves the profile information
    And displays a confirmation message: "Profile created successfully."


  Scenario: User customizes their profile
    Given the user has a previously created profile
    When the user navigates to the "Profile" section
    And clicks on the "Edit Profile" button
    Then the system displays the current profile details in editable fields
    When the user modifies the dietary preferences to "Gluten-Free"
    And clicks on the "Save" button
    Then the system updates the profile information
    And displays a confirmation message: "Profile updated successfully."


  Scenario: User updates their profile
    Given the user has a previously created profile
    When the user navigates to the "Profile" section
    And clicks on the "Edit Profile" button
    Then the system displays the current profile details in editable fields
    When the user modifies any field (e.g., updates dietary preferences)
    And clicks on the "Save" button
    Then the system updates the profile information
    And displays a confirmation message: "Profile updated successfully."

  Scenario: User skips optional fields during profile creation
    Given the user is on the "Create Profile" form
    When the user fills out only the mandatory fields:
      | Name        | Age | Fitness Goals       |
      | John Doe    | 25  | Lose Weight         |
    And leaves the optional fields blank
    And clicks on the "Save" button
    Then the system saves the profile with only the provided information
    And displays a confirmation message: "Profile created successfully."

  Scenario: User receives error for missing mandatory fields
    Given the user is on the "Create Profile" form
    When the user leaves a mandatory field blank (e.g., Age)
    And clicks on the "Save" button
    Then the system displays an error message: "Please fill in all mandatory fields."


  Scenario: User deletes their profile
    Given the user has successfully logged into the Fitness Management System
    And the user has an existing profile
    When the user navigates to the "Profile" section
    And clicks on the "Delete Profile" button
    Then the system displays a confirmation dialog: "Are you sure you want to delete your profile? This action cannot be undone."
    When the user confirms the deletion
    Then the system permanently deletes the user’s profile
    And logs the user out of the system
    And displays a confirmation message: "Your profile has been deleted successfully."
    And all personal data associated with the profile is removed from the database.
