package Fitness;

import Fitness.ClientPackage.ProgressTrackingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class ProgressTracking {

    private ProgressTrackingPage progressTrackingPage;




    @Given("the user is on the progress tracking page")
    public void the_user_is_on_the_progress_tracking_page() {
        // Write code to navigate to the progress tracking page
        progressTrackingPage = new ProgressTrackingPage();

        progressTrackingPage.navigateToProgressTrackingPage();
    }

    @When("the user enters their current weight")
    public void the_user_enters_their_current_weight() {
        // Write code to simulate the user entering their weight
        progressTrackingPage.enterCurrentWeight(70);
    }

    @Then("the system should save the weight data")
    public void the_system_should_save_the_weight_data() {
        // Write code to validate that the weight data has been saved
        assertTrue(progressTrackingPage.isWeightSaved());

    }

    @Then("the user should see their current weight displayed")
    public void the_user_should_see_their_current_weight_displayed() {
        // Write code to validate that the weight is displayed correctly
        assertTrue(progressTrackingPage.isWeightDisplayed());

    }

    @When("the user enters their current BMI")
    public void the_user_enters_their_current_bmi() {
        // Write code to simulate the user entering their BMI
        progressTrackingPage.enterCurrentBMI(22.5);

    }

    @Then("the system should save the BMI data")
    public void the_system_should_save_the_bmi_data() {
        // Write code to validate that the BMI data has been saved
        assertTrue(progressTrackingPage.isBMISaved());

    }

    @Then("the user should see their current BMI displayed")
    public void the_user_should_see_their_current_bmi_displayed() {
        // Write code to validate that the BMI is displayed correctly
        assertTrue(progressTrackingPage.isBMIDisplayed());

    }


    @When("the user logs attendance for a program session")
    public void the_user_logs_attendance_for_a_program_session() {
        // Write code to simulate the user logging attendance for a session
        progressTrackingPage.logAttendance();

    }

    @Then("the system should save the attendance data")
    public void the_system_should_save_the_attendance_data() {
        // Write code to validate that the attendance data has been saved
        assertTrue(progressTrackingPage.isAttendanceSaved());

    }

    @Then("the user should see their attendance history displayed")
    public void the_user_should_see_their_attendance_history_displayed() {
        // Write code to validate that the attendance history is displayed correctly
        assertTrue(progressTrackingPage.isAttendanceHistoryDisplayed());

    }
    @Given("the user has completed a program")
    public void the_user_has_completed_a_program() {
        // Write code to simulate the user completing a program
        if (progressTrackingPage == null) {
            progressTrackingPage = new ProgressTrackingPage();
        }
        progressTrackingPage.completeProgram();

    }

    @When("the user views their achievements page")
    public void the_user_views_their_achievements_page() {
        // Write code to simulate the user viewing their achievements page
        progressTrackingPage.viewAchievementsPage();

    }

    @Then("the user should see a badge for completing the program")
    public void the_user_should_see_a_badge_for_completing_the_program() {
        // Write code to validate that the user sees the completion badge
        assertTrue(progressTrackingPage.isBadgeVisible());

    }
    @Given("the user has tracked their milestones over time")
    public void the_user_has_tracked_their_milestones_over_time() {
        // Write code to simulate the user having tracked their milestones over time
        if (progressTrackingPage == null) {
            progressTrackingPage = new ProgressTrackingPage();
        }


        progressTrackingPage.trackMilestones();
    }

    @When("the user views their progress chart")
    public void the_user_views_their_progress_chart() {
        // Write code to simulate the user viewing their progress chart
        progressTrackingPage.viewProgressChart();

    }

    @Then("the user should see a visual representation of their progress over time")
    public void the_user_should_see_a_visual_representation_of_their_progress_over_time() {
        // Write code to validate that the progress chart is displayed correctly
        assertTrue(progressTrackingPage.isProgressChartDisplayed());

    }

}
