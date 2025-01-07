package Fitness;

import Fitness.AdminPackage.Client;
import Fitness.AdminPackage.Instructor;
import Fitness.AdminPackage.Role;
import Fitness.InstructorP.Communicate.*;
import Fitness.InstructorP.DiscussionFromP.Comment;
import Fitness.InstructorP.DiscussionFromP.DiscussionForm;
import Fitness.InstructorP.DiscussionFromP.Post;
import Fitness.InstructorP.DiscussionFromP.PostType;
import Fitness.InstructorP.ProgramPackage.Program;
import Fitness.InstructorP.Reports.Report;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientInteractionStep
{

    ProgramManagementStep programManagementStep1;
    Program program1;
    Instructor instructor1;
    Client client1,client2,client3,client4;
    DiscussionForm discussionForm1,discussionForm2,discussionFormReport;
    MessagingSystem messagingSystem1;
    Message messageInstructor,messageClient;
    NotificationSystem notificationSystem1,notificationSystem2,notificationSystem3;
    Notification notification1,notification2,notification3,notification4,notification5,notification6,notification7,notification8,notification9,notification10;
    Notification[] notificationArray;
    Post post1,post2,post3,post4,post5,reportPost;
    Comment comment1,comment2,comment3,comment4;
    Comment [] commentArray;
    Report report1;



    public ClientInteractionStep()
    {
        programManagementStep1 = new ProgramManagementStep();
        program1 = programManagementStep1.program1;
        instructor1 = programManagementStep1.instructor1;


        programManagementStep1.addProgram(program1);
        program1.setInstructorProgram(instructor1);

        instructor1.addPrograms(program1);


        discussionForm1 = new DiscussionForm();
        discussionForm1.setProgram(program1);
        program1.addDiscussionForm(discussionForm1);
        instructor1.addDiscussionForm(discussionForm1);

        discussionForm1.setInstructor(instructor1);
        client1 = new Client();
        client1.setEmail("ahmad@gmail.com");
        client1.setPass("ahmad123");
        client1.setName("Ahmad");

        post1 = new Post();


        messagingSystem1 = new MessagingSystem(instructor1,client1);
        notificationSystem1 = new NotificationSystem();
        notification1 = new Notification();

        notificationSystem1.addNotification(notification1);

        notificationSystem2 = new NotificationSystem();

        notification2 = new Notification();

        comment1 = new Comment();

        notification3 = new Notification();
        notification4 = new Notification();

        client2 = new Client();
        client2.setEmail("client2@gmail.com");
        client2.setPass("client2123");
        program1.addClient(client2);
        client3 = new Client();
        client3.setEmail("client3@gmail.com");
        client3.setPass("client3123");
        program1.addClient(client3);
        client4 = new Client();
        client4.setEmail("client4@gmail.com");
        client4.setPass("client4123");
        program1.addClient(client4);

        notification5 = new Notification();

        discussionForm2 = new DiscussionForm();
        post2 = new Post();
        discussionForm2.setProgram(program1);


        comment2 = new Comment();

        comment3 = new Comment();
        notification6 = new Notification();
        notification7 = new Notification();


        post3 = new Post();
        post3.setContent("how to work?");

        post4 = new Post();

        post5 = new Post();

        comment4 = new Comment();

        report1 = new Report();
        notificationArray = new Notification[10];



        commentArray = new Comment[10];
        commentArray[0] = new Comment();

        discussionFormReport = new DiscussionForm();
        reportPost = new Post();
        notificationSystem3 = new NotificationSystem();

        notification8 = new Notification();
        notification9 = new Notification();
        notification10 = new Notification();








    }

    @Given("client named {string}  has enrolled in a Malik's program")
    public void client_named_has_enrolled_in_a_malik_s_program(String clientName)
    {
        //client1.setName(clientName);


        program1.addClient(client1);

        discussionForm1.addClient(client1);


         boolean flag = false;
         if(program1.getClientsList().contains(client1))
         {
             flag = true;

         }

         assertTrue(flag);

        //throw new io.cucumber.java.PendingException();
    }
    @When("Malik sends a message {string} to Ahmad")
    public void malik_sends_a_message_to_ahmad(String message)
    {

        messageInstructor = new Message(instructor1,message, Role.Instructor,MessageType.sent);
        messagingSystem1.addMessage(messageInstructor);
        instructor1.addMessage(messageInstructor);
        messagingSystem1.addInstructorMessage(messageInstructor);



        boolean flag = false;
        if(instructor1.getMessageList().contains(messageInstructor))
        {
            if(messagingSystem1.getMessagesList().contains(messageInstructor))
            {
                if(messagingSystem1.getInstructorMessageList().contains(messageInstructor))
                {
                    flag = true;

                }
            }

        }

        assertTrue(flag);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("Ahmad should receive in their inbox")
    public void ahmad_should_receive_in_their_inbox()
    {
        client1.addMessage(messageInstructor);
        Message messageInstructorReceived = messageInstructor;
        messageInstructorReceived.setMessageType(MessageType.received);
        messagingSystem1.addClientMessage(messageInstructorReceived);


        boolean flag = false;
        if(client1.getMessageList().contains(messageInstructor))
        {
            if(messagingSystem1.getMessagesList().contains(messageInstructor))
            {
                if(messagingSystem1.getClientMessageList().contains(messageInstructor))
                {
                    flag = true;

                }
            }
        }

        assertTrue(flag);


        //throw new io.cucumber.java.PendingException();
    }
    @Then("a notification must be sent to Ahmad's account")
    public void a_notification_must_be_sent_to_ahmad_s_account()
    {
        client1.addNotification(notification1);

        //boolean flag = false;

        //boolean flag1 = false;
        //boolean flag2 = false;
        boolean flag3 = false;

        if(client1.getNotificationList().contains(notification1))
        {
            //flag1 = true;
            //assertTrue(flag1);
            if(notificationSystem1.getNotificationsList().contains(notification1))
            {
                //flag2 = true;
                //assertTrue(flag2);
                if(notificationSystem1.getClientNotificationList().contains(notification1))
                {


                    //flag = true;
                    notification1.setNotificationType(NotificationType.Message);
                    notification1.setNotificationAuthor(instructor1);
                    notificationSystem1.addClientNotification(notification1);
                    notification1.setNotificationContent(messageInstructor.getMessageAuthor().getName() + "has sent a message for you!");
                    flag3 = true;
                    assertTrue(flag3);
                }
            }
        }

       // assertTrue(flag);

        //throw new io.cucumber.java.PendingException();
    }

    @Given("Ahmad logged to the system")
    public void ahmad_logged_to_the_system()
    {
        program1.addClient(client1);
        boolean flag = false;
        if(program1.getClientsList().contains(client1))
        {
            flag = true;

        }

        assertTrue(flag);




        //throw new io.cucumber.java.PendingException();
    }
    @When("Ahmad send a message to Malik {string}?")
    public void ahmad_send_a_message_to_malik_hey_instructor_malik_when_should_start_training(String message)
    {
        messageClient = new Message(client1,message,Role.Client,MessageType.sent);
        messagingSystem1.addMessage(messageClient);
        client1.addMessage(messageClient);
        messagingSystem1.addClientMessage(messageClient);


        boolean flag = false;
        if(client1.getMessageList().contains(messageClient))
        {
            if(messagingSystem1.getMessagesList().contains(messageClient))
            {
                if(messagingSystem1.getClientMessageList().contains(messageClient))
                {
                    flag = true;
                }
            }

        }

        assertTrue(flag);


        //throw new io.cucumber.java.PendingException();
    }
    @Then("Malik should receive the message in his inbox")
    public void malik_should_receive_the_message_in_his_inbox()
    {
        instructor1.addMessage(messageClient);
        Message messageClientReceived = messageClient;
        messageClientReceived.setMessageType(MessageType.received);
        messagingSystem1.addInstructorMessage(messageClientReceived);

        //notification1.setNotificationTitle(messageClientReceived.getMessageAuthor().getName() + " has sent a message to you!");

        boolean flag = false;
        if(client1.getMessageList().contains(messageClient))
        {
            if(messagingSystem1.getMessagesList().contains(messageClient))
            {
                if(messagingSystem1.getInstructorMessageList().contains(messageClient))
                {
                    flag = true;
                }
            }
        }

        assertTrue(flag);



        //throw new io.cucumber.java.PendingException();
    }
    @Then("the system should send a notification to Malik about the message")
    public void the_system_should_send_a_notification_to_malik_about_the_message()
    {
        instructor1.addNotification(notification1);

        boolean flag = false;

        if(instructor1.getNotificationList().contains(notification1))
        {
            if(notificationSystem1.getNotificationsList().contains(notification1))
            {
                if(notificationSystem1.getInstructorNotificationList().contains(notification1))
                {

                    notification2.setNotificationType(NotificationType.Message);
                    notification2.setNotificationAuthor(instructor1);
                    notificationSystem1.addInstructorNotification(notification2);
                    notification1.setNotificationContent(messageInstructor.getMessageAuthor().getName() + "has sent a message for you!");
                    flag = true;
                    assertTrue(flag);

                }
            }
        }





        //throw new io.cucumber.java.PendingException();
    }

    @When("Ahmad post a question {string} in the discussion form")
    public void ahmad_post_a_question_in_the_discussion_form(String contentPost)   //first
    {
        post1 = new Post(client1,client1.getName() + " post a new question, check now!",contentPost,"12/1/2025"); //public
        discussionForm1.addClient(client1);
        discussionForm1.addPost(post1);
        boolean flag = false;
        if(discussionForm1.getClientsList().contains(client1))
        {
            if(discussionForm1.getPostList().contains(post1))
            {

                flag = true;
            }


        }

        assertTrue(flag);


        //throw new io.cucumber.java.PendingException();
    }
    @Then("the question message should display in the discussion form to the other clients and to the instructor Malik")
    public void the_question_message_should_display_in_the_discussion_form_to_the_other_clients_and_to_the_instructor_malik()
    {

        notification2.setNotificationContent(post1.getTitle());
        notification2.setNotificationType(NotificationType.Post);
        //System.out.println("Title post: " + post1.getTitle());
        System.out.println("post:\n" + post1.getContent());
        System.out.println(post1.getAuthor().getName() + " posted a post");



        //throw new io.cucumber.java.PendingException();
    }
    @Then("Malik should receive a notification about the new post")
    public void malik_should_receive_a_notification_about_the_new_post()
    {
        boolean flag = false;

        notification2.setNotificationAuthor(client1);
        notification2.setNotificationType(NotificationType.Post);
        instructor1.addNotification(notification2);
        notificationSystem2.addNotification(notification2);
        notificationSystem2.setInstructor(instructor1);
        notificationSystem2.addInstructorNotification(notification2);


        if(instructor1.getNotificationList().contains(notification2))
        {
            if(notificationSystem2.getNotificationsList().contains(notification2))
            {
                if(notificationSystem2.getInstructorNotificationList().contains(notification2));
                {
                    flag = true;
                }
            }

        }

        assertTrue(flag);

        if(flag)
        {
            System.out.println("There's a new post " + notification2.getNotificationTitle() + "From " + notification2.getNotificationAuthor());

        }


        //throw new io.cucumber.java.PendingException();
    }

    //hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee


    @When("Malik post the answer on the question")
    public void malik_post_the_answer_on_the_question()
    {

        discussionForm1.addClient(client1);
        discussionForm1.addPost(post1);
        comment1 = new Comment(instructor1,"we will talk about it in the offline session","6:35PM",post1);
        post1.addComment(comment1);
        notification3.setNotificationTitle(instructor1.getName() + " answers your question");



        boolean flagFirstComment = false;

        if(discussionForm1.getClientsList().contains(client1))
        {
            if(discussionForm1.getPostList().contains(post1))
            {
                if(post1.getComment().contains(comment1))
                {
                    flagFirstComment = true;
                }
            }
        }

        assertTrue(flagFirstComment,"invalid to add your comment in: " + post1.getAuthor().getName() + "'s post") ;

        if(flagFirstComment)
        {
            System.out.println(comment1.getAuthor().getName() + " posted a comment");

        }



        //throw new io.cucumber.java.PendingException();
    }
    @Then("the answer should appear under the question in the discussion form")
    public void the_answer_should_appear_under_the_question_in_the_discussion_form()
    {
        System.out.println(comment1.getAuthor().getName() + " posted a post: ");
        System.out.println(post1.getContent());
        System.out.println("=============================================");
        System.out.println(comment1.getAuthor().getName() + " posted a comment: ");
        System.out.println(comment1.getContent());
        System.out.println("=============================================");



       // throw new io.cucumber.java.PendingException();
    }
    @Then("Ahmad should receive a notification that there's a new answer to his question")
    public void ahmad_should_receive_a_notification_that_there_s_a_new_answer_to_his_question()
    {
        boolean flag = false;
        notification3.setNotificationAuthor(instructor1);
        notification3.setNotificationType(NotificationType.Comment);
        client1.addNotification(notification3);
        notificationSystem2.addNotification(notification3);
        notificationSystem2.setInstructor(instructor1);
        notificationSystem2.addClientNotification(notification3);

        if(client1.getNotificationList().contains(notification3))
        {
            if(notificationSystem2.getNotificationsList().contains(notification3))
            {
                if(notificationSystem2.getInstructorNotificationList().contains(notification3))
                {
                    flag = true;
                    assertTrue(flag,"error in notification system");

                }
            }
        }







       // throw new io.cucumber.java.PendingException();
    }

    @Given("clients logged to the system")
    public void clientsLoggedToTheSystem()
    {
        boolean flag = false;
        for(Client client: program1.getClientsList() )
        {
            if(discussionForm2.addClient( client))
            {
                flag = true;
            }
            assertTrue(flag,"There's a problem in sign in, try again please");

        }


    }

    @When("Malik post an ad {string}")
    public void malikPostAnAd(String contentPost)
    {
        post2 = new Post(instructor1,instructor1.getName() + " has a new post, check it now!",contentPost,"10/1/2025");
        discussionForm2.setInstructor(instructor1);
        discussionForm2.addPost(post2);
        boolean flag = false;

        if(discussionForm2.getInstructor().equals(instructor1))
        {
            if(discussionForm2.getPostList().contains(post2))
            {
                flag = true;
            }
        }

        assertTrue(flag,"failed to post");

    }

    @And("the system should sent a notification to all clients in the discussion form")
    public void theSystemShouldSentANotificationToAllClientsInTheDiscussionForm()
    {
        boolean flag = false;
        notification4.setNotificationAuthor(instructor1);
        notification4.setNotificationType(NotificationType.Post);
        for(Client client: program1.getClientsList() )
        {
            client.addNotification(notification4);

        }
        notificationSystem2.addNotification(notification4);
        notificationSystem2.setInstructor(instructor1);
        notificationSystem2.addClientNotification(notification4);

        for(Client client: program1.getClientsList() )
        {
            if(client.getNotificationList().contains(notification4))
            {
                if(notificationSystem2.getNotificationsList().contains(notification4))
                {
                    if(notificationSystem2.getInstructorNotificationList().contains(notification4))
                    {
                        flag = true;
                        assertTrue(flag,"There's a problem in notificationSystem, try again please");
                    }

                }
            }
        }




    }


    @Given("Sami has logged to the system")
    public void sami_has_logged_to_the_system()
    {
        String clientEmail = "client2@gmail.com";

        String clientPassword = "client2123";

        boolean loggedIn = false;
        for(Client client: program1.getClientsList() )
        {
            if(client.getEmail().equals(clientEmail) && client.getPass().equals(clientPassword))
            {
                loggedIn = true;

                client2 = client;
            }
        }
        assertTrue(loggedIn,"invalid input,check the enter data");

        if(loggedIn)
        {
            System.out.println(client2.getName() + " logged in!");
        }

        //throw new io.cucumber.java.PendingException();
    }

    @And("Emad has logged to the system")
    public void emad_has_logged_to_the_system()
    {
        String clientEmail = "client3@gmail.com";
        String clientPassword = "client3123";
        boolean loggedIn = false;
        for(Client client: program1.getClientsList() )
        {
            if(client.getEmail().equals(clientEmail) && client.getPass().equals(clientPassword))
            {
                loggedIn = true;

                client3 = client;
            }
        }
        assertTrue(loggedIn,"invalid input,check the enter data");

        if(loggedIn)
        {
            System.out.println(client3.getName() + " logged in!");
        }





        //throw new io.cucumber.java.PendingException();
    }

    @When("Sami answer Ahmad {string}")
    public void sami_answer_ahmad(String answer)
    {
         //"you can ask me later in the offline session"


        discussionForm2.setInstructor(instructor1);
        discussionForm2.addPost(post1);
        discussionForm2.addClient(client1);
        discussionForm2.addClient(client2);
        comment2 = new Comment(client2,answer,"6:45pm",post1);
        post1.addComment(comment2);
        notification5.setNotificationTitle(client2.getName() + " answer your question");

        System.out.println(comment2.getAuthor().getName() + " posted a comment");

        boolean flag = false;

        if(discussionForm2.getInstructor().equals(instructor1))
        {
            if(discussionForm2.getPostList().contains(post1))
            {
                if(discussionForm2.getClientsList().contains(client1))
                {
                    if(discussionForm2.getClientsList().contains(client2))
                    {
                        if(post1.getComment().contains(comment2))
                        {
                            flag = true;
                            notification6.setNotificationContent(client2.getName() + " answer your question");
                            notification6.setNotificationType(NotificationType.Comment);

                        }
                    }
                }
            }
        }

        assertTrue(flag,"invalid to add your comment in: " + post1.getAuthor().getName() + "'s post");

        if(flag)
        {
            System.out.println(comment1.getAuthor().getName() + " posted a comment");

        }
        //throw new io.cucumber.java.PendingException();
    }
    @When("Emad answer Ahmad {string}")
    public void emad_answer_ahmad(String answer)
    {
        //"you can ask me later in the offline session"//

        discussionForm2.setInstructor(instructor1);
        discussionForm2.addPost(post1);
        discussionForm2.addClient(client1);
        discussionForm2.addClient(client3);
        comment3 = new Comment(client3,answer,"6:45pm",post1);
        post1.addComment(comment3);
        notification5.setNotificationTitle(client3.getName() + " answer your question");

        System.out.println(comment3.getAuthor().getName() + " posted a comment");

        boolean flag = false;

        if(discussionForm2.getInstructor().equals(instructor1))
        {
            if(discussionForm2.getPostList().contains(post1))
            {
                if(discussionForm2.getClientsList().contains(client1))
                {
                    if(discussionForm2.getClientsList().contains(client3))
                    {
                        if(post1.getComment().contains(comment3))
                        {
                            flag = true;
                            notification7.setNotificationContent(client3.getName() + " answer your question");
                            notification7.setNotificationType(NotificationType.Comment);

                        }
                    }
                }
            }
        }

        assertTrue(flag,"invalid to add your comment in: " + post1.getAuthor().getName() + "'s post");

        if(flag)
        {
            System.out.println(comment3.getAuthor().getName() + " posted a comment");

        }


        //throw new io.cucumber.java.PendingException();
    }
    @Then("both answers should appear in the discussion form")
    public void both_answers_should_appear_in_the_discussion_form()
    {
        //ArrayList<Comment> commentArrayList = new ArrayList<Comment>();

        for(int i=0; i<post1.getComment().size(); i++)
        {
            if(post1.getComment().size() == 1) {
                System.out.println(post1.getComment().get(i).getAuthor().getName() + " posted a comment");
                System.out.println("post content: " + post1.getComment().get(i).getContent());
                break;
            }

            if(post1.getComment().size() == 2)
            {
                System.out.println(post1.getComment().get(i).getAuthor().getName() + " posted a comment");
                System.out.println("post content: " + post1.getComment().get(i).getContent());
                break;
            }
            

                if (post1.getComment().get(i).dateCompare(post1.getComment().get(i+1).getDate()))
                {
                    System.out.println(post1.getComment().get(i).getAuthor().getName() + " posted a comment");
                    System.out.println("post content: " + post1.getComment().get(i).getContent());

                }
                else
                {
                    System.out.println(post1.getComment().get(i+1).getAuthor().getName() + " posted a comment");
                    System.out.println("post content: " + post1.getComment().get(i+1).getContent());
                }





        }

        //throw new io.cucumber.java.PendingException();
    }
    @Then("the owner question and every client has answered Ahmad should receive a message about the new answers")
    public void the_owner_question_and_every_client_has_answered_ahmad_should_receive_a_message_about_the_new_answers()
    {
        boolean flag1 = false;
        boolean flag2 = false;
        notification6.setNotificationAuthor(client2);
        post1.getAuthor().addNotification(notification6);
        notificationSystem2.addNotification(notification6);
        notificationSystem2.addClientNotification(notification6);
        notificationSystem2.addClient(client2);

        if(notification6.getNotificationAuthor().equals(client2))
        {
            if(post1.getAuthor().getNotificationList().contains(notification6))
            {
                if(notificationSystem2.getNotificationsList().contains(notification6))
                {
                    if(notificationSystem2.getClientNotificationList().contains(notification6))
                    {
                        flag1 = true;
                    }
                }

            }


        }




        notification7.setNotificationAuthor(client3);
        post1.getAuthor().addNotification(notification7);
        notificationSystem2.addNotification(notification7);
        notificationSystem2.addClientNotification(notification7);
        notificationSystem2.addClient(client3);

        if(notification7.getNotificationAuthor().equals(client3))
        {
            if(post1.getAuthor().getNotificationList().contains(notification7))
            {
                if(notificationSystem2.getNotificationsList().contains(notification7))
                {
                    if(notificationSystem2.getClientNotificationList().contains(notification7))
                    {

                        flag2 = true;
                    }
                }

            }

        }

        assertTrue(flag1&&flag2,"wrong process in notification system");

        if(flag1&&flag2)
        {
            System.out.println("There's a new notification from " + notification6.getNotificationAuthor() + " and " + notification7.getNotificationAuthor());
        }

        //throw new io.cucumber.java.PendingException();
    }


    @Given("Malik has already answered this question before")
    public void malik_has_already_answered_this_question_before()
    {
        boolean flag = false;
        post3.setContent("how to?");
        discussionForm1.addPost(post3);
        post4 = new Post(client1,"how to","how to?","2025-1-11");
        discussionForm1.addPost(post4);

        for(Post post : discussionForm1.getPostList())
        {
            if(post.getContent().equals(post4.getContent()))
            {
                flag = true;
                post5 = post;
            }
        }

        assertTrue(flag,"it's a new post");




        //throw new io.cucumber.java.PendingException();
    }
    @When("Malik marks the question as answered before")
    public void malik_marks_the_question_as_answered_before()
    {
        boolean flag = false;

        for(Post post : discussionForm1.getPostList())
        {
            if(post.getContent().equals(post5.getContent()))
            {
                post.setPostType(PostType.answeredPost);
                comment4 = new Comment(instructor1,"This post has answered before","7:00pm",post);
                post.addComment(comment4);
                discussionForm1.addPost(post);
                flag = true;
                break;
            }
        }

        assertTrue(flag);




       // throw new io.cucumber.java.PendingException();
    }
    @Then("the old answer should appear under the question")
    public void the_old_answer_should_appear_under_the_question()
    {
        Post InnerPost = comment4.getPost();
        comment4.setPost(InnerPost);

        System.out.println("Post content: \n" + post1.getContent());
        System.out.println("Instructor comment: " + comment4.getContent());
        System.out.println("Post answered before: \n" + InnerPost.getContent());

        //throw new io.cucumber.java.PendingException();
    }
    @Then("the system should sent notification to all participants in the Ahmad's question")
    public void the_system_should_sent_notification_to_all_participants_in_the_ahmad_s_question()
    {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;

       if(!post4.getAuthor().equals(client1))
       {
           System.out.println("you need to add an author to the post");
           return;
       }




       post4.addParticipant(client1);
        notification10.setNotificationAuthor(instructor1);
        notification10.setNotificationTitle(instructor1.getName() + " answer " + post4.getAuthor().getName());
        notification10.setNotificationType(NotificationType.Comment);
        client1.addNotification(notification10);
        notificationSystem2.addNotification(notification10);
        notificationSystem2.addInstructorNotification(notification10);
        notificationSystem2.addClientNotification(notification10);

        if(notification10.getNotificationAuthor().equals(instructor1))
        {
            if(client1.getNotificationList().contains(notification10))
            {
                flag1 = true;
            }

        }


        post4.addParticipant(client2);


       notification8.setNotificationAuthor(instructor1);
       notification8.setNotificationTitle(instructor1.getName() + " answer " + post4.getAuthor().getName());
       notification8.setNotificationType(NotificationType.Comment);
       client2.addNotification(notification8);
       notificationSystem2.addNotification(notification8);
       notificationSystem2.addInstructorNotification(notification8);
       notificationSystem2.addClientNotification(notification8);

        if(notification8.getNotificationAuthor().equals(instructor1))
        {
            if(client2.getNotificationList().contains(notification8))
            {
                flag2 = true;
            }

        }

        post4.addParticipant(client3);

        notification9.setNotificationAuthor(instructor1);
        notification9.setNotificationTitle(instructor1.getName() + " answer " + post4.getAuthor().getName());
        notification9.setNotificationType(NotificationType.Comment);
        client3.addNotification(notification9);
        notificationSystem2.addNotification(notification9);
        notificationSystem2.addInstructorNotification(notification9);
        notificationSystem2.addClientNotification(notification9);

        if(notification9.getNotificationAuthor().equals(instructor1))
        {
            if(client1.getNotificationList().contains(notification9))
            {
                flag3 = true;
                assertTrue(flag1&&flag2&&flag3,"wrong process in notification system");
            }

        }



        //throw new io.cucumber.java.PendingException();
    }

    @Given("Malik creates a feedback or reports for Ahmad")
    public void malik_creates_a_feedback_or_reports_for_ahmad()
    {
        boolean flag = false;
        report1.setName("report1");
        report1.setID("12");
        report1.setInstructor(instructor1);
        program1.addReport(report1);

        if(program1.getReportList().contains(report1))
        {

            /// check the size of report list of program that has been changed -- abdallah thaer
            flag = true;
        }

        assertTrue(flag,"failed to create a report");







        //throw new io.cucumber.java.PendingException();
    }
    @When("Malik sent the results to Ahmad")
    public void malik_sent_the_results_to_ahmad()
    {
        boolean flag = false;

        notificationArray[0] = new Notification();

        notificationArray[0].setNotificationAuthor(instructor1);
        notificationArray[0].setNotificationType(NotificationType.Report);

        notificationSystem2.addNotification(notificationArray[0]);
        notificationSystem2.addInstructorNotification(notificationArray[0]);


        if(instructor1.getNotificationList().contains(notificationArray[0]))
        {
            flag = true;
            assertTrue(flag,"failed to create a send a report to: " + client1.getName());
        }



        //throw new io.cucumber.java.PendingException();
    }
    @When("Malik can write a comment about Ahmad's results")
    public void malik_can_write_a_comment_about_ahmad_s_results()
    {
        boolean flag = false;


        commentArray[0].setContent("good results: " + client1.getName());
        commentArray[0].setAuthor(instructor1);
        instructor1.addCommentReport(commentArray[0]);
        report1.addComment(commentArray[0]);
        discussionFormReport.addPost(reportPost);
        reportPost.addComment(commentArray[0]);

        notificationArray[1] = new Notification();
        notificationArray[1].setNotificationAuthor(instructor1);
        notificationArray[1].setNotificationType(NotificationType.Comment);
        for(Report report: client1.getReportList())
        {
            if(report.equals(report1))
            {
                notificationArray[1].setNotificationContent(instructor1.getName() + " comment in your report: " + report.getName());
                flag = true;
                assertTrue(flag,"failed to write a comment");
                break;

            }
        }






        //throw new io.cucumber.java.PendingException();
    }
    @Then("the reports should be available in the client's progress section")
    public void the_reports_should_be_available_in_the_client_progress_section()
    {
        boolean flag = false;
        if(client1.getReportList().contains(report1))
        {

            flag = true;
            assertTrue(flag,"No report!");

        }





        //throw new io.cucumber.java.PendingException();
    }
    @Then("the system should display Malik's comment about Ahmad report")
    public void the_system_should_display_malik_s_comment_about_ahmad_report()
    {

        System.out.println("Report Name: " + report1.getName());
        System.out.println("ID report: " + report1.getID());
        System.out.println("Instructor Name: " + instructor1.getName());
        System.out.println("Comment Content: " + commentArray[0].getContent());

        //throw new io.cucumber.java.PendingException();
    }
    @Then("the system should send a notification to Ahmad that receive a report or feedback from Malik")
    public void the_system_should_send_a_notification_to_ahmad_that_receive_a_report_or_feedback_from_malik()
    {
        boolean flag = false;
        client1.addNotification(notificationArray[0]);
        notificationSystem2.addClientNotification(notificationArray[0]);

        if(client1.getNotificationList().contains(notificationArray[0]))
        {
            flag = true;
        }

        assertTrue(flag,"Failed in notification system");


       // throw new io.cucumber.java.PendingException();
    }


    @Given("receive a report from Malik")
    public void receive_a_report_from_malik()
    {
        boolean flag = false;
        report1.setClient(client1);
        client1.addReport(report1);
        report1.setProgram(client1.getProgram());
        report1.setInstructor(instructor1);

        if(client1.getReportList().contains(report1))
        {
            flag = true;
        }

        assertTrue(flag,"Failed in receiving report process");

        if(flag)
        {
            report1.printReport();
        }


        //throw new io.cucumber.java.PendingException();
    }
    @When("Ahmad send a reply")
    public void ahmad_send_a_reply()
    {
        boolean flag = false;
        commentArray[1] = new Comment();
        commentArray[1].setReply(true);
        commentArray[1].setAuthor(client1);
        commentArray[1].setContent("Thanks for this report");

        notificationArray[2] = new Notification();
        notificationArray[2].setNotificationType(NotificationType.Reply);
        notificationArray[2].setNotificationContent("New report from " + instructor1.getName());

        client1.addReply(commentArray[1]);

        commentArray[0].addComment(commentArray[1]);

        if(client1.getReplyList().contains(commentArray[1]))
        {
            flag = true;
            assertTrue(flag,"Failed in reply process");
        }








        //throw new io.cucumber.java.PendingException();
    }
    @Then("the reply should appear to Malik in client's progress reports page")
    public void the_reply_should_appear_to_malik_in_client_s_progress_reports_page()
    {


        System.out.println("Report Name: " + report1.getName());
        System.out.println("Comment Content: " + commentArray[0].getContent());
        System.out.println("Reply content: " + commentArray[1].getContent());
        System.out.println("========================================================");

        //throw new io.cucumber.java.PendingException();
    }
    @Then("the system should send a notification to Malik about Ahmad's reply")
    public void the_system_should_send_a_notification_to_malik_about_ahmad_s_reply()
    {
        boolean flag = false;

        notificationSystem3.addNotification(notificationArray[2]);
        notificationSystem3.addClientNotification(notificationArray[2]);

        if(notificationSystem3.getNotificationsList().contains(notificationArray[2]))
        {
            flag = true;
        }

        assertTrue(flag,"Failed in notification system");



        //throw new io.cucumber.java.PendingException();
    }






}
