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
      When Malik choose to create a new Program with details
      Then display a message that the program created successfully

    Scenario: failed create a program
      Given Malik in program management page
      When Malik wants to create a new fitness program
      And with missing data details
      Then the system will display an error Message "Required fields are missing"
      When Malik choose to create a new Program with details
      Then display a message that the program created successfully

    Scenario: failed create a program
      Given Malik in program management page
      When Malik wants to create a new fitness program
      And with missing data details
      Then the system will display an error Message "Required fields are missing"
      And the program will not be created

      #update scenarios

      Scenario: update the program
        Given already program exist with following details:

              |Program Title|duration|level|goal        |video|images     |documents|price|
              |Alpha        | 90     | 3   | more power | url1| image.png | roadmap | 65$ |
        When Malik select the program to update by enter the name of the program "Alpha"

        Then it will update the program details based on the enter data

        And the system should show a that the program updated

        Scenario: failed to update
          Given already program exist with following details:
            |Program Title|duration|level|goal        |video|images     |documents|price|
            |Alpha        | 90     | 3   | more power | url1| image.png | roadmap | 65$ |
          And Malik enter a title program "Gama"

           When the program title hasn't exist
          Then the system will not update the program details
          And  the system will display a message "There's no Program with this title"

           When the program title hasn't exist
          Then the system will not update the program details
          And the system will display a message "There's no Program with this title"


          #delete scenarios

        Scenario: delete a program

          Given already program exist with following details to delete it:

            |Program Title|duration|level|goal        |video|images     |documents|price|
            |Alpha        | 90     | 3   | more power | url1| image.png | roadmap | 65$ |
          And Malik enter the program title called "Alpha"
          When Malik choose to delete the program
          Then the system will delete the program with its details
          And the system will display message that the program deleted "The Deletion of the program done!"

          Given already program exist with following details:

            |Program Title|duration|level|goal        |video|images     |documents|price|
            |Alpha        | 90     | 3   | more power | url1| image.png | roadmap | 65$ |
          And Malik enter the program title called "Alpha"
          Then the system will delete the program with its details
          And the system will display message that the program deleted "The Deletion of the program done!"


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
            When Malik choose to set session
            Then the system will create the session
            And the system will notified the group


            Scenario: invalid date
              Given that Malik enter a date "12/2/2023"
              When Malik choose to set session
              Then the system will not create the session
              And the system will display an Invalid date message "Invalid date"


              Scenario: invalid day or wrong string
                Given Malik enter a wrong day or wrong input
                When Malik choose to set session
                Then the system will not create the session
                And the system will display a invalid input message "Invalid input"

                Scenario: set schedules with missing data
                  Given Malik provides a incomplete data about the session
                  When Malik choose to set the session
                  Then the system will not create the session
                  And the system will display a Missing fields message "Missing fields required"












