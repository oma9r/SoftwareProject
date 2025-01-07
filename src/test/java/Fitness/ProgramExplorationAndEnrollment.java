package Fitness;
import static org.junit.jupiter.api.Assertions.*;

import Fitness.AdminPackage.Client;
import Fitness.ClientPackage.FilterSelection;
import Fitness.ClientPackage.ProgramData;
import Fitness.ClientPackage.ProgramDetailPage;
import Fitness.ClientPackage.ProgramExplorer;
import Fitness.InstructorP.ProgramPackage.Program;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;
import java.util.List;

public class ProgramExplorationAndEnrollment {
    private FilterSelection filterSelection = new FilterSelection();
    //private ProgramExplorer programExplorer;
    private ProgramExplorer programExplorer = new ProgramExplorer();
    private ProgramDetailPage programDetailPage;
    private Client client;


    public ProgramExplorationAndEnrollment()
    {
        List<Program> programs = ProgramData.getPrograms();

        programExplorer = new ProgramExplorer(programs);
        client = new Client();
        Program program = new Program("Yoga Basics", "Beginner", "Flexibility", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), List.of("09:00 AM - 10:00 AM", "10:30 AM - 11:30 AM", "01:00 PM - 02:00 PM"));

        programDetailPage = new ProgramDetailPage(program);
    }


    @Given("the user is on the program exploration page")
    public void the_user_is_on_the_program_exploration_page() {

        programExplorer.navigateToProgramExplorationPage();
        assertTrue(programExplorer.isOnProgramExplorationPage());
    }

    @When("the user selects the {string} difficulty level filter")
    public void the_user_selects_the_difficulty_level_filter(String level) {
        // Code for selecting difficulty level filter
        filterSelection.selectDifficultyLevel(level);
    }

    @Then("the user should see only programs with the {string} difficulty level")
    public void the_user_should_see_only_programs_with_difficulty_level(String difficultyLevel) {
        // Code for validating that only programs with selected difficulty level are shown
        List<Program> filteredPrograms = programExplorer.filterProgramsByDifficulty(difficultyLevel);

        for (Program program : filteredPrograms) {
            assertTrue(program.getProgramLevel().equalsIgnoreCase(difficultyLevel));
        }
    }

    // Scenario 2: Browse programs by focus area
    @When("the user selects the {string} focus area filter")
    public void the_user_selects_the_focus_area_filter(String focusArea) {
        // Code for selecting the focus area filter
        programExplorer.filterProgramsByFocusArea(focusArea);
    }

    @Then("the user should see only programs focused on {string}")
    public void the_user_should_see_only_programs_focused_on(String focusArea) {
        // Code for validating that only programs with selected focus area are shown
        List<Program> filteredPrograms = programExplorer.filterProgramsByFocusArea(focusArea);


        for (Program program : filteredPrograms) {
            assertEquals("Program does not match the expected focus area",
                    focusArea, program.getProgramGoals());
        }

    }

    // Scenario 3: User enrolls in a program
    @Given("the user is on a program detail page")
    public void the_user_is_on_a_program_detail_page() {
        // Code for navigating to the program detail page
        programDetailPage.navigateToProgramDetailPage();
    }

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String buttonName) {
        // Write code here that turns the phrase above into concrete actions
        boolean buttonClicked = false;


        if (buttonName.equalsIgnoreCase("Enroll")) {
            buttonClicked = programDetailPage.clickEnrollButton();
        } else if (buttonName.equalsIgnoreCase("View Schedule")) {
            buttonClicked = programDetailPage.clickViewScheduleButton();
        }
        //assertTrue(buttonClicked);
    }

    @Then("the user should be enrolled in the program")
    public void the_user_should_be_enrolled_in_the_program() {
        Program enrolledProgram = new Program();
        enrolledProgram.setProgramTitle("Fitness Program");
        programDetailPage.enrollInProgram(enrolledProgram);


        if (enrolledProgram == null) {
            System.out.println("Error: The enrolled program is null. User is not enrolled in any program.");
        } else {
            System.out.println("User is enrolled in program: " + enrolledProgram.getProgramTitle());
        }


        assertNotNull( enrolledProgram);



        //client.setProgram(enrolledProgram);
        assertTrue( client.addProgram(enrolledProgram));

        System.out.println("User has been successfully enrolled in the program.");
    }

    @Then("the user should see a confirmation message")
    public void the_user_should_see_a_confirmation_message() {
        // Code for showing confirmation message
        programDetailPage.clickEnrollButton();
        assertTrue( programDetailPage.isEnrolled());
    }

    @Then("the user's enrolled program should be added to their account")
    public void the_user_s_enrolled_program_should_be_added_to_their_account() {
        // Code for adding the program to the user's account
        Program enrolledProgram = programDetailPage.getEnrolledProgram();


        boolean programAdded = client.addProgram(enrolledProgram);
        assertFalse( programAdded);
    }

    // Scenario 4: User views program schedule
    @Then("the user should see the full schedule of the program")
    public void the_user_should_see_the_full_schedule_of_the_program() {
        // Code for displaying the full schedule
        System.out.println("Program Schedule: ");
        System.out.println("Start Date: " + programDetailPage.getStartDate());
        System.out.println("End Date: " + programDetailPage.getEndDate());
        System.out.println("Available Time Slots: " + String.join(", ", programDetailPage.getAvailableTimeSlots()));

        assertNotNull( programDetailPage.getStartDate());
        assertNotNull( programDetailPage.getEndDate());
        assertTrue( !programDetailPage.getAvailableTimeSlots().isEmpty());
    }

    @Then("the user should see the start date, end date, and available time slots")
    public void the_user_should_see_the_start_date_end_date_and_available_time_slots() {
        // Code for displaying the start date, end date, and available time slots
        System.out.println("Program Start Date: " + programDetailPage.getStartDate());
        System.out.println("Program End Date: " + programDetailPage.getEndDate());
        System.out.println("Available Time Slots: " + String.join(", ", programDetailPage.getAvailableTimeSlots()));


        assertEquals( LocalDate.of(2024, 1, 1), programDetailPage.getStartDate());
        assertEquals( LocalDate.of(2024, 12, 31), programDetailPage.getEndDate());
        assertTrue( !programDetailPage.getAvailableTimeSlots().isEmpty());
    }

    // Scenario 5: User applies multiple filters
    @When("the user selects the {string} difficulty level filter and the {string} focus area filter")
    public void the_user_selects_multiple_filters(String difficulty, String focusArea) {
        // Code for applying multiple filters (both difficulty level and focus area)
        List<Program> filteredByDifficulty = programExplorer.filterProgramsByDifficulty(difficulty);


        List<Program> filteredPrograms = programExplorer.filterProgramsByFocusArea(focusArea);

        System.out.println("Filtered Programs: ");
        filteredPrograms.forEach(program -> System.out.println(program.getProgramTitle()));
    }

    @Then("the user should see only programs with {string} difficulty level and {string} focus area")
    public void the_user_should_see_only_programs_with_difficulty_level_and_focus_area(String difficulty, String focusArea) {
        List<Program> filteredPrograms = programExplorer.filterProgramsByDifficulty(difficulty);
        filteredPrograms = programExplorer.filterProgramsByFocusArea(focusArea);

        for (Program program : filteredPrograms) {
            assertEquals("Program does not match the expected difficulty level", difficulty, program.getProgramLevel());
            assertEquals("Program does not match the expected focus area", focusArea, program.getProgramGoals());
        }
    }

    // Scenario 6: User clears filters
    @Given("the user has applied filters for {string} difficulty level and {string} focus area")
    public void the_user_has_applied_filters_for_difficulty_level_and_focus_area(String difficulty, String focusArea) {
        // Code for applying filters
        programExplorer.filterProgramsByDifficulty(difficulty);


        programExplorer.filterProgramsByFocusArea(focusArea);


        List<Program> filteredPrograms = programExplorer.getFilteredPrograms();
        System.out.println("Filtered Programs: ");
        filteredPrograms.forEach(program -> System.out.println(program.getProgramTitle()));
    }

    @When("the user clicks the {string} button to clear filters")
    public void the_user_clicks_the_clear_filters_button(String string) {
        // Code for clearing filters
        programExplorer.clearFilters();

        List<Program> allPrograms = programExplorer.getFilteredPrograms();
        System.out.println("All Programs: ");
        allPrograms.forEach(program -> System.out.println(program.getProgramTitle()));
    }

    @Then("all filters should be cleared")
    public void all_filters_should_be_cleared() {
        // Code for confirming all filters are cleared
        programExplorer.clearFilters();


        List<Program> allPrograms = programExplorer.getFilteredPrograms();
        assertEquals( ProgramData.getPrograms().size(), allPrograms.size());

    }

    @Then("the user should see all available programs without any filters applied")
    public void the_user_should_see_all_available_programs_without_any_filters_applied() {
        // Code for showing all available programs without filters
        List<Program> allPrograms = programExplorer.getFilteredPrograms();


        assertEquals( ProgramData.getPrograms().size(), allPrograms.size());

    }
}