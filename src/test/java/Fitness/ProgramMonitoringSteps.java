package Fitness;

import Fitness.AdminPackage.Admin;
import Fitness.AdminPackage.Application;
import Fitness.AdminPackage.Client;
import Fitness.AdminPackage.User;
import Fitness.InstructorP.ProgramPackage.Program;
import Fitness.InstructorP.Session.Session;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static Fitness.AdminPackage.Application.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class ProgramMonitoringSteps {

    public ProgramMonitoringSteps() {

        Application.init();
    }



    @Given("I am logged in as an admin")
    public void i_am_logged_in_as_an_admin() {
        Application.login("admin@gmail.com","4865");
        assertTrue(currentUser instanceof Admin);
    }

    @When("I navigate to the {string} section")
    public void i_navigate_to_the_section(String string) {

        Application.currentSection=string;
    }

    @Then("I should see a list of programs sorted by the number of enrollments")
    public void i_should_see_a_list_of_programs_sorted_by_the_number_of_enrollments() {

        Application.showPrograms();
    }



    @When("I select Generate Report and choose Revenue")
    public void i_select_generate_report_and_choose_revenue() {

        Application.showRevenue();
    }


    @Then("the report should include a breakdown of income per program")
    public void the_report_should_include_a_breakdown_of_income_per_program() {
        System.out.println("Reported");

    }

Session[] nullFlage;
    @When("I select Generate Report and choose Attendance")
    public void i_select_generate_report_and_choose_attendance() {

        for (Program program : programs)
            Application.admin1.showAtetendance(program);


    }



    @Then("the report should show the number of participants for each session")
    public void the_report_should_show_the_number_of_participants_for_each_session() {
        System.out.println("reported");
    }


    @When("I select Generate Report and choose Client Progress")
    public void i_select_generate_report_and_choose_client_progress() {

       currentSection="Client progress";

    }


    @Then("I should see a detailed report on client progress for each program")
    public void i_should_see_a_detailed_report_on_client_progress_for_each_program() {
        System.out.println("Client name\tProgram title\tProgress");
        for(User u :users)
            if (u instanceof Client) {
                admin1.clientProgress(((Client) u));
            }
    }


    @Then("I should see a list of all active programs")
    public void i_should_see_a_list_of_all_active_programs() {

        admin1.getProgramsActive();
    }


}
