package use_cases;

import Fitness.Admin;

import Fitness.Application;
import Fitness.Program;
import Fitness.UserStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static Fitness.Application.*;
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


    @When("I select Generate Report and choose Attendance")
    public void i_select_generate_report_and_choose_attendance() {
        // Write code here that turns the phrase above into concrete actions
        
    }

    @Then("I should see a detailed report on the attendance for each program")
    public void i_should_see_a_detailed_report_on_the_attendance_for_each_program() {
        // Write code here that turns the phrase above into concrete actions
        
    }

    @Then("the report should show the number of participants for each session")
    public void the_report_should_show_the_number_of_participants_for_each_session() {
        Application.participants();
        
    }

    @When("I select Generate Report and choose Client Progress")
    public void i_select_generate_report_and_choose_client_progress() {
        // Write code here that turns the phrase above into concrete actions
        
    }


    @Then("I should see a detailed report on client progress for each program")
    public void i_should_see_a_detailed_report_on_client_progress_for_each_program() {
        // Write code here that turns the phrase above into concrete actions
        
    }

    @Then("the report should include completion rates, client feedback, and milestones")
    public void the_report_should_include_completion_rates_client_feedback_and_milestones() {
        // Write code here that turns the phrase above into concrete actions
        
    }

    @Then("I should see a list of all active programs")
    public void i_should_see_a_list_of_all_active_programs() {
        // Write code here that turns the phrase above into concrete actions
        
    }

    @Then("I should be able to filter the list by categories such as difficulty or focus area")
    public void i_should_be_able_to_filter_the_list_by_categories_such_as_difficulty_or_focus_area() {
        // Write code here that turns the phrase above into concrete actions
        
    }

    @When("I filter the programs to show completed ones")
    public void i_filter_the_programs_to_show_completed_ones() {
        // Write code here that turns the phrase above into concrete actions
        
    }

    @Then("I should see a list of all completed programs")
    public void i_should_see_a_list_of_all_completed_programs() {
        // Write code here that turns the phrase above into concrete actions
        
    }

    @Then("I should be able to view details about the completion status of each program")
    public void i_should_be_able_to_view_details_about_the_completion_status_of_each_program() {
        // Write code here that turns the phrase above into concrete actions
        
    }
}
