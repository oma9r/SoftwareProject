package Fitness;
import Fitness.AdminPackage.Instructor;
import Fitness.AdminPackage.Status;
import Fitness.InstructorP.ProgramPackage.ProgramStatus;
import Fitness.InstructorP.ProgramPackage.tutorialTypeProgram;
import Fitness.InstructorP.Session.Session;
import Fitness.InstructorP.ProgramPackage.Program;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ProgramManagementStep
{
    Instructor instructor1,instructor2;
    Program program1,program2,program3,upProgram,notUpProgram,deleteProgram,notDeleteProgram;
    Session session1,session2,session3,session4;
    ArrayList<Session> sessionsList;
    List<Instructor> instructorsList;
    ArrayList<Program> programsList;

    public ProgramManagementStep()
    {
        instructor1 = new Instructor("Ali",26,"male","Nablus","ali@gmail.com","123ali", Status.Active);
        instructor2 = new Instructor("Sami",27,"male","Ramallah","sami@gmail.com","123sami",Status.Active);
        instructorsList = new ArrayList<Instructor>();
        instructorsList.add(instructor1);
        instructorsList.add(instructor2);
        program1 = new Program("Alpha","120","hard","more power", "Document","65$", ProgramStatus.Active,instructor1);
        instructor1.addPrograms(program1);
        program2 = new Program("Beta","90","very hard","more body", "Video","70$",ProgramStatus.Active,instructor2);
        instructor2.addPrograms(program2);
        sessionsList = new ArrayList<>();
        session1 = new Session("12","triceps and biceps","12/2/2025","Sunday","6:00pm", "offline");
        session2 = new Session("13","Chest","Tuesday","12/1/2025","6:00pm", "online");
        sessionsList.add(session1);
        sessionsList.add(session2);
        program1.setSessions(sessionsList);
        programsList = new ArrayList<Program>();
        programsList.add(program1);
        programsList.add(program2);

    }






    @Given("an instructor with name {string}")
    public void an_instructor_with_name(String instructorName)
    {
        System.out.println("Welcome" + instructorName);


        //throw new io.cucumber.java.PendingException();
    }
    @Given("he logged into the system with email {string} and password {string}")
    public void he_logged_into_the_system_with_email_and_password(String email, String password) {

        boolean isLoggedIn = false;

        for(Instructor instructor : instructorsList)
        {
            if(instructor.getEmail().equals(email) && instructor.getPass().equals(password))
            {
                isLoggedIn = true;
                break;
            }
        }

        assertFalse("Failed!",isLoggedIn);

      //  throw new io.cucumber.java.PendingException();
    }
    @Given("Program title {string} with duration {string} and level {string}, the goal {string}")
    public void program_title_with_duration_and_level_the_goal(String programTitle, String programDuration, String programLevel, String programGoal) {
        // Write code here that turns the phrase above into concrete actions

        program3 = new Program(programTitle,programDuration,programLevel,programGoal);
        programsList.add(program3);






        //throw new io.cucumber.java.PendingException();
    }
    @Given("vide url {string}, images {string} and a {string} document")
    public void vide_url_images_and_a_document(String video , String image, String document)
    {
        tutorialTypeProgram tutorialTypeProgram = new tutorialTypeProgram(video,image,document);
       program3.setProgramTutorialType(tutorialTypeProgram);



       // throw new io.cucumber.java.PendingException();
    }
    @Given("with price {string}")
    public void with_price(String priceProgram) {

        program3.setProgramPrice(priceProgram);


        //throw new io.cucumber.java.PendingException();
    }
    @When("Malik choose to create a new Program with details")
    public void malik_choose_to_create_a_new_program_with_details()
    {
        // Write code here that turns the phrase above into concrete actions
        Program program4 = new Program("ssn121","130","easy1","more focus");
        programsList.add(program4);



        //throw new io.cucumber.java.PendingException();
    }
    @Then("display a message that the program created successfully")
    public void display_a_message_that_the_program_created_successfully()
    {
        System.out.println("Program created successfully");


        //throw new io.cucumber.java.PendingException();
    }

    @Given("Malik in program management page")
    public void malik_in_program_management_page()
    {
        System.out.println("You are in the program management page");


        //throw new io.cucumber.java.PendingException();
    }
    @When("Malik wants to create a new fitness program")
    public void malik_wants_to_create_a_new_fitness_program()
    {

        Program program5 = new Program("pro3","70","medium","more12");
        programsList.add(program5);

        //throw new io.cucumber.java.PendingException();
    }
    @When("with missing data details")
    public void with_missing_data_details() {

       boolean test = true;
       Program incompleteProgram = new Program();

       if(incompleteProgram.getProgramTitle().isEmpty() || incompleteProgram.getProgramDuration().isEmpty() || incompleteProgram.getProgramLevel().isEmpty() || incompleteProgram.getProgramGoals().isEmpty())
       {
           test = false;
       }

       assertFalse(test);

        //throw new io.cucumber.java.PendingException();
    }
    @Then("the system will display an error Message {string}")
    public void the_system_will_display_an_error_message(String message) {
        System.out.println("Error Message: there's a missing data");
        //throw new io.cucumber.java.PendingException();
    }
    @Then("the program will not be created")
    public void the_program_will_not_be_created()
    {
        System.out.println("Program will not be created");
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }


//××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××
    @Given("already program exist with following details:")
    public void already_program_exist_with_following_details(io.cucumber.datatable.DataTable dataTable)
    {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        //throw new io.cucumber.java.PendingException();
    }
//××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××


    @When("Malik select the program to update by enter the name of the program {string}")
    public void malik_select_the_program_to_update_by_enter_the_name_of_the_program(String programUpdateName)
    {
        boolean flag = false;
        upProgram = new Program();

        for(Program program : programsList)
        {
            if(program.getProgramTitle().equals(programUpdateName))
            {
                flag = true;
                program.setProgramTitle(programUpdateName);
                upProgram = program;

            }
        }

        assertTrue(flag);

        //throw new io.cucumber.java.PendingException();
    }
    @Then("it will update the program details based on the enter data")
    public void it_will_update_the_program_details_based_on_the_enter_data()
    {
        System.out.println("Enter the updated data");





        //throw new io.cucumber.java.PendingException();
    }
    @Then("the system should show a that the program updated")
    public void the_system_should_show_a_that_the_program_updated()
    {
        boolean flag = true;
        if(upProgram.getProgramTitle().isEmpty()) {
            flag = false;
        }

        assertTrue("The program updated",flag);


        //throw new io.cucumber.java.PendingException();
    }


    @Given("Malik enter a title program {string}")
    public void malik_enter_a_title_program(String string)
    {
        notUpProgram = new Program();

        //throw new io.cucumber.java.PendingException();
    }
    @When("the program title hasn't exist")
    public void the_program_title_has_not_exist()
    {
        boolean flag = true;

        if(notUpProgram.getProgramTitle().isEmpty())
        {
            flag = false;
        }

        assertFalse(flag);

       // throw new io.cucumber.java.PendingException();
    }
    @Then("the system will not update the program details")
    public void the_system_will_not_update_the_program_details()
    {
        System.out.println("there's no data to update");
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("the system will display a message {string}")
    public void will_the_system_display_a_message(String string)
    {
        System.out.println("Error Message");
        //throw new io.cucumber.java.PendingException();
    }


    // delete ------------------------------------------------------------------------------------------------------------------------



    @Given("already program exist with following details to delete it:")
    public void already_program_exist_with_following_details_to_delete_it(io.cucumber.datatable.DataTable dataTable)
    {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        //throw new io.cucumber.java.PendingException();
    }

    @And("Malik enter the program title called {string}")
    public void malik_enter_the_program_title_called(String programName)
    {

        if (programsList == null || programsList.isEmpty())
        {
            throw new IllegalStateException("The programsList is not initialized or is empty.");
        }

        deleteProgram = null;
        Iterator<Program> iterator = programsList.iterator();

        while (iterator.hasNext()) {
            Program program = iterator.next();
            if (program.getProgramTitle().equals(programName)) {
                deleteProgram = program;
                iterator.remove(); // Safely remove the program using the iterator.
                break; // Exit the loop after finding the matching program.
            }
        }

        if (deleteProgram == null) {
            System.out.println("No program found with the title: " + programName);
        } else {
            System.out.println("Program removed: " + deleteProgram.getProgramTitle());
        }



        //throw new io.cucumber.java.PendingException();
    }

    @When("Malik choose to delete the program")
    public void malikChooseToDeleteTheProgram()
    {
        programsList.add(deleteProgram);

    }
    @Then("the system will delete the program with its details")
    public void the_system_will_delete_the_program_with_its_details()
    {
        programsList.add(deleteProgram);
        boolean flag = true;
        if(programsList.remove(deleteProgram))
        {
            flag = false;
        }

        assertFalse(flag);

        //throw new io.cucumber.java.PendingException();
    }
    @Then("the system will display message that the program deleted {string}")
    public void the_system_will_display_a_message(String string)                                    //////////////////////////////////////////////////////////
    {

        System.out.println("The program has been deleted");
        //throw new io.cucumber.java.PendingException();
    }



    @Given("Malik enter a title program {string} to delete it")
    public void malik_enter_a_title_program_to_delete_it(String string)
    {
        notDeleteProgram = new Program();
        notDeleteProgram.setProgramTitle(string);


       // throw new io.cucumber.java.PendingException();
    }
    @When("the program title doesn't exist")
    public void the_program_title_does_not_exist()
    {
       boolean flag = true;
       for(Program program : programsList)
       {
           if(notDeleteProgram.getProgramTitle().equals(program.getProgramTitle()))
           {
               flag = false;
               break;
           }
       }
       assertTrue(flag);
       // throw new io.cucumber.java.PendingException();
    }
    @Then("the system will not delete anything")
    public void the_system_will_not_delete_anything()
    {

        System.out.println("there's no program to delete");

        //throw new io.cucumber.java.PendingException();
    }
    @Then("the system will display Message that the program deleted {string}")
    public void the_system_will_display_message_that_the_program_deleted(String string)
    {
        System.out.println("Failed to delete the program");
       // throw new io.cucumber.java.PendingException();
    }



    //set schedules
    ////////////////////
    /////////




    @Given("Malik enter the date {string} and day {string} with {string} session")
    public void malik_enter_the_date_and_day_with_session(String sessionDate, String sessionDay, String sessionType)
    {
        session3 = new Session(sessionDate,sessionDay,sessionType);


        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @When("Malik choose to set session")
    public void malik_choose_to_set_session()
    {
        program3 = new Program();
       program3.addSession(session3);
      //  throw new io.cucumber.java.PendingException();
    }

    @Then("the system will create the session")
    public void the_system_will_create_the_session()
    {
        boolean flag = false;
        if(program3.getSessions().contains(session3))
        {
            flag = true;
        }
        assertTrue(flag);

       // throw new io.cucumber.java.PendingException();
    }

    @Then("the system will notified the group")
    public void the_system_will_notified_the_group()
    {
        System.out.println("notified the group");


       // throw new io.cucumber.java.PendingException();
    }





    @Given("that Malik enter a date {string}")
    public void that_malik_enter_a_date(String sessionDate)
    {
        session4 = new Session(sessionDate);



        //throw new io.cucumber.java.PendingException();
    }


    @Then("the system will not create the session")
    public void the_system_will_not_create_the_session()
    {
        boolean flag = true;
        String sessionName = session4.getSessionName();
        flag = session4.isSessionDateValid(sessionName);
        assertFalse(flag);
       // throw new io.cucumber.java.PendingException();
    }

    @Then("the system will display an Invalid date message {string}")
    public void the_system_will_display_an_invalid_date_message(String string)
    {
        System.out.println("Invalid date!");
      //  throw new io.cucumber.java.PendingException();
    }


    @Given("Malik enter a wrong day or wrong input")
    public void malik_enter_a_wrong_day_or_wrong_input()
    {
        boolean flag = true;
        session4 = new Session("13","ses3","12/2/2025","Friday","6:00pm","offline");
        if(session4.getSessionDate().equals("Friday") || session4.getSessionDate().equals("Tuesday"))
        {
            flag = false;

        }

        assertTrue(flag);
        //throw new io.cucumber.java.PendingException();
    }

    @Then("the system will display a invalid input message {string}")
    public void the_system_will_display_a_invalid_input_message(String string)
    {
        System.out.println("Invalid input!");
        //throw new io.cucumber.java.PendingException();
    }

    @Given("Malik provides a incomplete data about the session")
    public void malik_provides_a_incomplete_data_about_the_session()
    {
        session4 = new Session("12/3/2025","Wed","online");

       // throw new io.cucumber.java.PendingException();
    }

    @When("Malik choose to set the session")
    public void malik_choose_to_set_the_session()
    {
        boolean flag = true;
        if(session4.getSessionName()==null)
        {
            flag = false;

        }
        assertTrue(flag);
       // throw new io.cucumber.java.PendingException();
    }


    @Then("the system will display a Missing fields message {string}")
    public void the_system_will_display_a_missing_fields_message(String string)
    {
        System.out.println("Missing fields");
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    public boolean addProgram(Program program)
    {
        if(!this.programsList.contains(program))
        {
            this.programsList.add(program);
            return true;
        }
        return false;
    }

    public boolean removeProgram(Program program)
    {
        if(this.programsList.contains(program))
        {
            this.programsList.remove(program);
            return true;
        }
        return false;
    }





}
