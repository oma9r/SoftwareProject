Feature: Program Management
  Create, update, or delete fitness programs with the following details:


  Background:
    Given an instructor with name "Malik"
    And he logged into the system with email "malik@gmail.com" and password "pass"



    #create scenarios

    Scenario: create a fitness program
      Given Program title "Alpha" with duration "90 days" and level "3", the goal "more power"
      And vide url "url1", images "image.png" and a "roadmap" document
      And with price "65$"
      When Malik choose to create a new Program with deatils
      Then display a message that the program created successfully

    Scenario: failed create a program
      Given Malik in program managment page
      When Malik wants to create a new fitness program
      And with missing data details
      Then the system will display an error message "Required fields are missing"
      And the program will not be created

      #update scenarios

      Scenario: update the program
        Given already program exist with following details:

              |Program Title|duration|level|goal        |video|images     |documents|price|
              |Alpha        | 90     | 3   | more power | url1| image.png | roadmap | 65$ |
        When Malik select the program to update by enter the name of the program "Alpha"
        Then it will update the program details based on the enterd data
        And the system should show a that the program updated

        Scenario: failed to update
          Given already program exist with following details:
            |Program Title|duration|level|goal        |video|images     |documents|price|
            |Alpha        | 90     | 3   | more power | url1| image.png | roadmap | 65$ |
          And Malik enter a title program "Gama"
           When the program tilte hasn't exist
          Then the system will not update the program detalis
          And will the system display a message "There's no Program with this title"

          #delete scenarios

        Scenario: delete a program
          Given already program exist with following details:

            |Program Title|duration|level|goal        |video|images     |documents|price|
            |Alpha        | 90     | 3   | more power | url1| image.png | roadmap | 65$ |
          When Malik enter the program title called "Alpha"
          Then the system will delete the program with its details
          And the system will dispaly a message "The Deletion of the program done!"

          Scenario: failed to delete a program
            Given already program exist with following details:
              |Program Title|duration|level|goal        |video|images     |documents|price|
              |Alpha        | 90     | 3   | more power | url1| image.png | roadmap | 65$ |
            And Malik enter a title program "Gama" to delete it
            When the program title doesn't exist
            Then the system will not delete anything
            And the system will display a message "There's no exist Program with this title"

          #Set schedules

          Scenario: set schedules
            Given Malik enter the date "1/1/2025" and day "Wed" with "online" session
            Then the system will create the session
            And the system will notificate the group 










