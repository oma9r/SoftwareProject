Feature: Client Interaction


  Background:
    Given an instructor named "Malik"
    And Malik logged into the system
    And group of clients named "groupA"
    And groupA are enrolled clients

  Scenario: Communicate with enrolled clients
    #Given Dr.Malik logged into the system
    When Malik wants to communicate groupA
    Then Malik can messaging groupA or discussion forums with them


  Scenario: Providing Feedback
    When Malik has access to the progress data of groupA
    Then Malik can provide feedback or progress reports to groupA

