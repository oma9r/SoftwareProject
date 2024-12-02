Feature: Program Management
  Create, update, or delete fitness programs with the following details:


  Background:
    Given an instructor named "Malik"
    And he logged into the system



  Scenario: create a fitness program
    When Malik add a new fitness program with title, duration, difficulty level, and goals
    And add videos,images, or documents
    And add the price
    Then the operation done successfully



  Scenario: update a fitness program
    Given Malik has an existing program
    When Malik update the details
    Then the changes are saved successfully

  Scenario: delete a fitness program
    Given Malik has an existing program
    When Malik delete the program
    Then the program should removed from the system






    