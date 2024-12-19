Feature: Client Interaction



  Background:
    Given an instructor with name "Malik"
    And he logged into the system with email "malik@gmail.com" and password "pass"
    And client named "Ahmad"  has enrolled in a Malik's program
    And client named "Sami"  has enrolled in a Malik's program
    And client named "Emad"  has enrolled in a Malik's program



 #first part

    Scenario: Malik sends a message to a client
      When Malik sends a message "Great job for today!" to Ahmad
      Then Ahmad should receive in their inbox
      And a notification must be sent to Ahmad's account

    Scenario: Ahmad sends a message to Malik
        Given Ahmad logged to the system
        When Ahmad send a message to Malik "Hey instructor Malik, when should start training"?
        Then Malik should receive the message in his inbox
        And the system should send a notification to Malik about the message

    Scenario: Ahmad post a question in the discussion form
        Given Ahmad logged to the system
        When Ahmad post a question "What is the best food for more power?" in the discussion form
         #first
        Then the question message should display in the discussion form to the other clients and to the instructor Malik
        And Malik should receive a notification about the new post
        ##hereeeeee

    Scenario: Malik answer the clients questions on the discussion form
          Given Ahmad logged to the system
          When Ahmad post a question "What is the best food for more power?" in the discussion form
          Then Malik post the answer on the question
          And the answer should appear under the question in the discussion form
          And Ahmad should receive a notification that there's a new answer to his question

      Scenario: Malik post a question
        Given clients logged to the system
        When Malik post an ad "new post"
        Then the question message should display in the discussion form to the other clients and to the instructor Malik
        And the system should sent a notification to all clients in the discussion form

    Scenario: Other clients answer Ahmad's question
            Given Sami has logged to the system
            And Emad has logged to the system
            And Ahmad post a question "What is the best food for more power?" in the discussion form
            When Sami answer Ahmad "Well, you have to practice more"
            And Emad answer Ahmad "Well, as Sami said and you need to be patient!"
            Then both answers should appear in the discussion form
            And the owner question and every client has answered Ahmad should receive a message about the new answers

    Scenario: there's a previous answer for a new question
              Given Ahmad post a question "What is the best food for more power?" in the discussion form
              And Malik has already answered this question before
              When Malik marks the question as answered before
              Then the old answer should appear under the question
              # with specifc date and time for each answer like facebook!!
              And the system should sent notification to all participants in the Ahmad's question

#second part------------------------


    Scenario: Malik provides feedback or reports
      Given Malik creates a feedback or reports for Ahmad
      When Malik sent the results to Ahmad
      And Malik can write a comment about Ahmad's results
      Then the reports should be available in the client's progress section
      And the system should display Malik's comment about Ahmad report
      And the system should send a notification to Ahmad that receive a report or feedback from Malik



      Scenario: Ahmad receive a report from Malik
        Given Ahmad logged to the system
        And receive a report from Malik
        When Ahmad send a reply
        Then the reply should appear to Malik in client's progress reports page
        And the system should send a notification to Malik about Ahmad's reply










