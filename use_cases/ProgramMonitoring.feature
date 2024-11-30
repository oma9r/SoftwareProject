Feature: Program Monitoring

  Scenario: View Statistics on Most Popular Programs
    Given the admin is logged into the system
    When the admin navigates to the Program Monitoring section
    Then the admin can view statistics on the most popular programs by enrollment

  Scenario: Generate Reports on Revenue, Attendance, and Client Progress
    Given the admin is logged into the system
    When the admin selects Generate Report in the Program Monitoring section
    And the admin chooses a report type (Revenue, Attendance, or Client Progress)
    Then the system generates the requested report

  Scenario: Track Active and Completed Programs
    Given the admin is logged into the system
    When the admin navigates to the Program Tracking section
    Then the admin can view a list of active and completed programs
