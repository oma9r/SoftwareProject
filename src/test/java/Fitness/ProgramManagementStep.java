package Fitness;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramManagementStep {

    @Given("an instructor with name {string}")
    public void an_instructor_with_name(String string) {
        // Write code here that turns the phrase above into concrete actions



        System.out.println("Welcome" + string);
       // throw new io.cucumber.java.PendingException();
    }
    @Given("he logged into the system with email {string} and password {string}")
    public void he_logged_into_the_system_with_email_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Welcome to login");

      //  throw new io.cucumber.java.PendingException();
    }
    @Given("Program title {string} with duration {string} and level {string}, the goal {string}")
    public void program_title_with_duration_and_level_the_goal(String string, String string2, String string3, String string4) {
        // Write code here that turns the phrase above into concrete actions

        System.out.println("Welcome to: "+string);

        //throw new io.cucumber.java.PendingException();
    }
    @Given("vide url {string}, images {string} and a {string} document")
    public void vide_url_images_and_a_document(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
    @Given("with price {string}")
    public void with_price(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Malik choose to create a new Program with deatils")
    public void malik_choose_to_create_a_new_program_with_deatils() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("display a message that the program created successfully")
    public void display_a_message_that_the_program_created_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Malik in program managment page")
    public void malik_in_program_managment_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Malik wants to create a new fitness program")
    public void malik_wants_to_create_a_new_fitness_program() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("with missing data details")
    public void with_missing_data_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the system will display an error message {string}")
    public void the_system_will_display_an_error_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the program will not be created")
    public void the_program_will_not_be_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("already program exist with following details:")
    public void already_program_exist_with_following_details(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
    @When("Malik select the program to update by enter the name of the program {string}")
    public void malik_select_the_program_to_update_by_enter_the_name_of_the_program(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("it will update the program details based on the enterd data")
    public void it_will_update_the_program_details_based_on_the_enterd_data() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the system should show a that the program updated")
    public void the_system_should_show_a_that_the_program_updated() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Given("Malik enter a title program {string}")
    public void malik_enter_a_title_program(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the program tilte hasn't exist")
    public void the_program_tilte_hasn_t_exist() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the system will not update the program detalis")
    public void the_system_will_not_update_the_program_detalis() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("will the system display a message {string}")
    public void will_the_system_display_a_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @When("Malik enter the program title called {string}")
    public void malik_enter_the_program_title_called(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the system will delete the program with its details")
    public void the_system_will_delete_the_program_with_its_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the system will dispaly a message {string}")
    public void the_system_will_dispaly_a_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Given("Malik enter a title program {string} to delete it")
    public void malik_enter_a_title_program_to_delete_it(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the program title doesn't exist")
    public void the_program_title_doesn_t_exist() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the system will not delete anything")
    public void the_system_will_not_delete_anything() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the system will display a message {string}")
    public void the_system_will_display_a_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Malik enter the date {string} and day {string} with {string} Session")
    public void malik_enter_the_date_and_day_with_session(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Malik choose to set Session")
    public void malik_choose_to_set_session() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the system will create the Session")
    public void the_system_will_create_the_session() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the system will notificate the group")
    public void the_system_will_notificate_the_group() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("that Malik enter a date {string}")
    public void that_malik_enter_a_date(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the system will not create the seesion")
    public void the_system_will_not_create_the_seesion() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Malik enter a wrong day or wrong input")
    public void malik_enter_a_wrong_day_or_wrong_input() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Malik provides a incomplete data about the seesion")
    public void malik_provides_a_incomplete_data_about_the_seesion() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Malik choose to set the Session")
    public void malik_choose_to_set_the_session() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }













}
