Feature: User Management
Background:


  Scenario: Add a User with Valid Details
    Given the owner has logged into the system with email "exam@exam.com" and password "pass"
    When the admin executes the addUser with valid details
    Then the system creates the new user account successfully
    And displays the message: "User added successfully"
    

  Scenario: Duplicate Accounts
    Given the owner is logged into the system with email "exam@exam.com" and password "pass"
    When the admin selects addUser
    And provides an email already in use
    Then the system displays an error message: "Email already exists"
    And the account is not created

  Scenario: Fail to Add a User with Missing Required Details
    Given the admin is in the system with email "exam@exam1.com" and password "pass"
    When the admin navigates to the User Management section
    And selects Add User
    And provides incomplete details for the new user
    Then the system displays an error message: "Required fields are missing"
    And the user account is not created

  Scenario: Fail to Add a User with not Matching Required Details
    Given the admin is logged the system with email "exam@exam3.com" and password "pass"
    When the admin navigates to the User Management section
    And selects Add User
    And provides incomplete details for the new user
    Then the system displays an error message: Required fields are missing
    And the user account is not created



  Scenario: delete an exist user
      Given admin entered the system with email "exam@exam.gmail" and password "pass"
      When the admin goes to User Management section
      And select delete user
      And provides a valid user id
      Then the system execute the delete user
      And displays a massage : "User deleted successfully"

  Scenario: delete a not exist user
        Given owner entered the system with email "admin@gmail.com" and password "pass"
        When the admin goes to User Manager section
        And select delete user
        And provides an id
        And the system doesnt find it
        Then it display an error massage : "User not found"

  Scenario: try to delete an admin
    Given owner entered system via email "admin@gmail.com" and password "pass"
    When the admin goes to User Manager section
    And select delete user
    And provides an id
    And the system finds it belong to an admin
    Then it display an error massage : "Admin cant be deleted"




  Scenario: Update user information
    Given  admin have logged into the system with email "exam@exam.com" and password "pass"
    And the user exist
    When the admin executes the updateUserDetails
    Then The system updates the user details
    And displays the massage "user details updated successfully"

  Scenario: Update a User’s Role Successfully
    Given   logged into the system with email "exam@exam.com" and password "pass"
    And the user exists with a valid ID
    When the admin executes the updateUserRole command with the user ID and role "Instructor"
    Then the system updates the user’s role
    And displays the message: "User role updated successfully"

  Scenario: Restore a Deactivated User
    Given the admin is logged to the system with email "exam@exam.com" and password "pass"
    And the user exists with a status of "Deactivated"
    When the admin executes the reactivateUser command with the user ID
    Then the system restores the user account
    And displays the message: "User account reactivated"




  Scenario: Deactivate a User Successfully
    Given the admin logged into the system with email "exam@exam.com" and password "pass"
    And the user exists with a status of "Active"
    When the admin executes the deactivateUser command with the user ID
    Then the system marks the user account as inactive
    And displays the message: "User account deactivated"

  Scenario: Deactivate a User already deactivated
    Given the admin is logged into system with email "exam@exam.com" and password "pass"
    And the user exists with a status of "deactivated"
    When the admin executes the deactivateUser with the user ID
    Then The system displays the message: " User already deactivated"

  Scenario: Prevent Deactivation of Admin Accounts
    Given the admin is logged into the system email "exam@exam.com" and password "pass"
    And the target account belongs to an admin
    When the admin executes the deactivateUser command with the admins user ID
    Then the system displays the error message: "Admin accounts cannot be deactivated"




  Scenario: Approve Instructor Registration
    Given the admin is logged in the system with email "exam@exam.com" and password "pass"
    And the admin is logged into the system 
    When the admin executes the approveRegistration command with the instructor’s ID
    Then the system activates the instructor account
    And displays the message: "Instructor registration approved"

  Scenario: Reject Instructor Registration with a Reason
    Given the admin is logg into the system with email "exam123@exam.com" and password "pass"
    And the admin is logged into the system 
    When the admin executes the rejectRegistration command with the instructor’s ID and a reason
    Then the system marks the registration as rejected
    And displays the message: "Instructor registration rejected: Missing required certifications"



  Scenario: View Most Engaged Users
    Given the admin has logged into the system with email "exam@exam.com" and password "pass"
    When the admin executes the getEngagementStats command
    Then the system displays a list of the most engaged users

  Scenario: Identify Users with No Engagement
    Given the admin is log into the system with email "exam@exam.com" and password "pass"
    When the admin executes the filterUsersByEngagement command with the parameter No activity in the last 30 days
    Then the system displays a list of inactive users

  Scenario: Download Engagement Report
    Given the admin has logg into the system with email "exam@exam.com" and password "pass"
    When the admin executes the downloadEngagementReport command
    Then the system generates and saves a report file
    And displays the message: "Engagement report downloaded successfully"




  Scenario: Search for Users by Partial Name
    Given the admin is in the system via email "exam@exam.com" and password "pass"
    And the following users exist in the system:
      | User ID | Name           | Role      | Status  |
      | 1       | John Doe       | Client    | Active  |
      | 2       | Jane Smith     | Instructor| Active  |
      | 3       | Johnny Appleseed | Client | Inactive |
      | 4       | Joan Harris    | Client    | Active  |
    When the admin executes the searchUser command with the parameter "Jo"
    Then the system displays the following matching users:
      | User ID | Name           | Role      | Status  |
      | 1       | John Doe       | Client    | Active  |
      | 3       | Johnny Appleseed | Client | Inactive |
      | 4       | Joan Harris    | Client    | Active  |
    And the system displays message: "3 users found matching 'Jo'"



  Scenario Outline: Search for Users by role
    Given  admin has log into the system via email "exam@exam.com" and password "pass"
    And the following users exist in the system:
      | User ID | Name             | Role      | Status  |
      | 1       | John Doe         | Client    | Active  |
      | 2       | Jane Smith       | Instructor| Active  |
      | 3       | Johnny Appleseed | Client    | Inactive|
      | 4       | Joan Harris      | Client    | Active  |

    When the admin executes the searchUser command with the parameter Role
    Then the system displays <User ID> <Name> <Role> <Status>

    And the system displays message: "3 users found with Role 'Client'"
    Examples:
      | User ID | Name             | Role      | Status  |
      | 1       | John Doe         | Client    | Active  |
      | 3       | Johnny Appleseed | Client    | Inactive|
      | 4       | Joan Harris      | Client    | Active  |


  Scenario Outline: Search for Users by Status
    Given  admin has log into the system with email "exam@exam.com" and password "pass"
    And the following users exist in the system:
      | User ID | Name             | Role      | Status  |
      | 1       | John Doe         | Client    | Active  |
      | 2       | Jane Smith       | Instructor| Active  |
      | 3       | Johnny Appleseed | Client    | Inactive|
      | 4       | Joan Harris      | Client    | Active  |

    When the admin executes the searchUser command with the parameter Status>
    Then the system displays <User ID> <Name> <Role> <Status>

    And the system displays message: "3 users found with status 'Active'"
    Examples:
      | User ID | Name             | Role      | Status  |
      | 1       | John Doe         | Client    | Active  |
      | 2       | Jane Smith       | Instructor| Active  |
      | 4       | Joan Harris      | Client    | Active  |
