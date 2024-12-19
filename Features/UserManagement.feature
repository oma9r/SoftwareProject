Feature: User Management


  Scenario: Add a User with Valid Details
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    When the admin executes the addUser with valid details
    Then the system creates the new user account successfully
    And displays the message: "User added successfully"


  Scenario: Duplicate Accounts
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    When the admin selects addUser
    And provides an email already in use
    Then the system displays an error message: "Email already exists"
    And the account is not created

  Scenario: Fail to Add a User with Missing Required Details
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    When the admin navigates to the User Management section
    And selects Add User
    And provides incomplete details for the new user
    Then the system displays an error message: "Required fields are missing"
    And the user account is not created


  Scenario: delete an exist user
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    When the admin goes to User Management section
    And select delete user
    And provides a valid user email
    Then the system execute the delete user
    And displays a massage : "User deleted successfully"

  Scenario: delete a not exist user
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    When the admin goes to User Manager section
    And select delete user
    And provides an email
    And the system doesnt find it
    Then it display an error massage : "User not found"

  Scenario: try to delete an admin
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    When the admin goes to User Manager section
    And select delete user
    And provides an email
    And the system finds it belong to an admin
    Then it display an error massage : "Admin cant be deleted"




  Scenario: Update user information
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    And the user exist
    When the admin selects the updateUserDetails
    Then The system updates the user details
    And displays the massage "user details updated successfully"

  Scenario: Update a User’s role Successfully
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    And the user exists with a valid email
    When the admin select the updateUserRole command with the user email and role Instructor
    Then the system updates the user’s role
    And displays the message: "User role updated successfully"

  Scenario: Restore a Deactivated User
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    And the user exists with a status
    When the admin executes the reactivateUser command with the email
    Then the system restores the user account
    And displays the message: "User account reactivated"



  Scenario: Deactivate a User Successfully
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    And the user exists with a status
    When the admin executes the deactivateUser command with the email
    Then the system marks the user account as inactive
    And displays the message: "User account deactivated"


  Scenario: Prevent Deactivation of Admin Accounts
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    And the target account belongs to an admin
    When the admin executes the deactivateUser command with the admins email
    Then the system displays the error message: "Admin accounts cannot be deactivated"


  Scenario: View Most Engaged Users
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    When the admin executes the getEngagementStats command
    Then the system displays a list of the most engaged users

  Scenario: Identify Users with No Engagement
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    When the admin executes the filterUsersByEngagement command with the parameter No activity in the last 30 days
    Then the system displays a list of inactive users

  Scenario: Download Engagement Report
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    When the admin executes the downloadEngagementReport command
    Then the system generates and saves a report file
    And displays the message: "Engagement report downloaded successfully"




  Scenario: Search for Users by name
    Given the owner has logged into the system with email "mashaqi@gmail.com" and password "pass"
    And the following users exist in the system:
      | name           | age|gender|address|email   |pass|
      | John Doe       | 23| male  | uhjkn |   jk   |1654|
      | Jane Smith     | 50| male  | jnkl  | cygvhuj|7554|
      |Johnny Appleseed| 33| male  | lnk   | cgvhjbk|5745|
      | Joan Harris    | 25| male  | nkl   |tyugi   |5754|
    When the admin executes the searchUser command with the parameter "Jo"
    Then the system displays the following matching users
      | name           | age|gender|address|status|email|pass|
      | John Doe       | 23| male  | uhjkn |Active|jk   |1654|
      |Johnny Appleseed| 33| male  | lnk   |DeActive|cgvhjbk|5745|
      | Joan Harris    | 25| male  | nkl   |Active|tyugi|5754|

    And the system displays message: "3 users found matching 'Jo'"


