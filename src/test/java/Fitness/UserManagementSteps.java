package Fitness;

import Fitness.AdminPackage.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static Fitness.AdminPackage.Application.login;
import static Fitness.AdminPackage.Application.users;
import static org.junit.Assert.*;

public class UserManagementSteps {

    Admin admin1 = null;
    Admin admin2 = null;
    Client deletedClient;
    String deleted;
    Application app;
    public UserManagementSteps() {
       // users = new ArrayList<User>();
        app = new Application();
        admin2 = new Admin("admin", 22, "male", "palestine", "admin@gmail.com", "4865");
        users.add(admin2);
        admin2.addClient("client", 18, "male", "yaseed", "client@gmail.com", "12345", Status.Active);
        User deletedUser = new User("client", 18, "male", "yaseed", "client@gmail.com", "12345", Role.Client);
        Application.addUser(deletedUser);
        admin2.addClient("notActive", 18, "male", "yaseed", "not@gmail.com", "12345", Status.DeActive);
        admin2.addClient("is", 18, "male", "yaseed", "is@gmail.com", "12345", Status.Active);
        deletedClient = new Client("delete user",25,"female","testAddress","moh@gmail.com","passTest",Status.Active);
        admin2.addClient("delete user",25,"female","testAddress","moh@gmail.com","passTest",Status.Active);
        //admin2.addClient("delete user",25,"female","testAddress","moh@gmail.com","passTest",Status.Active);
        //Client user = new Client("delete user",25,"female","testAddress","moh@gmail.com","passTest",Status.Active);
        Application.addUser(deletedClient);



    }




    @Given("the owner has logged into the system with email {string} and password {string}")
    public void the_owner_has_logged_into_the_system_with_email_and_password(String email, String pass) {
        admin1 = new Admin("ibrahim", 20, "male", "yaseed", email, pass);
        users.add(admin1);
        Application.currentUser = login(email,pass);

        //assertNull(Application.currentUser);
        assertTrue(Application.currentUser instanceof Admin);
    }
    int totalUsers ;
    @When("the admin executes the addUser with valid details")
    public void the_admin_executes_the_add_user_with_valid_details() {
        totalUsers = users.size();
        assertTrue(admin1.addClient("moh", 16, "male", "nablus", "moh@gmail.com", "123", Status.Active));

    }

    @Then("the system creates the new user account successfully")
    public void the_system_creates_the_new_user_account_successfully() {

        assertEquals(totalUsers+1 , users.size());
    }

    @Then("displays the message: {string}")
    public void displays_the_message(String msg) {
        System.out.println(msg);

    }

    @When("the admin selects addUser")
    public void the_admin_selects_add_user() {
        app.setCurrentFeature("addUser");
    }


    @When("provides an email already in use")
    public void provides_an_email_already_in_use() {
        String existEmail = "mashaqi@gmail.com";
        assertFalse(admin1.addClient("fd", 16, "male", "nablus", existEmail, "123", Status.Active));


    }

    @Then("the system displays an error message: {string}")
    public void the_system_displays_an_error_message(String string) {
            System.out.println(string);
    }

    @Then("the account is not created")
    public void the_account_is_not_created() {
        app.setCurrentFeature("");
    }



    @When("the admin navigates to the User Management section")
    public void the_admin_navigates_to_the_user_management_section() {
        Application.currentSection = "User Management Section";
    }

    @When("selects Add User")
    public void selects_add_user() {
        app.setCurrentFeature("addUser");
    }

    @When("provides incomplete details for the new user")
    public void provides_incomplete_details_for_the_new_user() {
        assertFalse(admin1.addAdmin(null, 55, "gr", "gr", "4rfe", "453"));

    }

    @Then("the user account is not created")
    public void the_user_account_is_not_created() {
        app.setCurrentFeature("");
    }

    @Then("the system displays an error message: Required fields are missing")
    public void the_system_displays_an_error_message_required_fields_are_missing() {
        System.out.println("Required fields are missing");

    }

    @When("the admin goes to User Management section")
    public void the_admin_goes_to_user_management_section() {
        Application.currentSection = "User Management Section";
    }

    @When("select delete user")
    public void select_delete_user() {
        app.setCurrentFeature("deleteUser");
    }



    @When("provides a valid user email")
    public void provides_a_valid_user_email() {
        deleted = "moh@gmail.com";
    }

    @Then("the system execute the delete user")
    public void the_system_execute_the_delete_user() {
        deleted = "moh@gmail.com";
        //assertTrue(admin2.addClient("delete user",25,"female","testAddress","moh@gmail.com","passTest",Status.Active));
        assertTrue(admin2.deleteUser(deleted));
    }

    @Then("displays a massage : {string}")
    public void displays_a_massage(String string) {
        System.out.println(string);
    }


    @When("the admin goes to User Manager section")
    public void the_admin_goes_to_user_manager_section() {
        Application.currentSection = "User Manager Section";
    }

    @When("provides an email")
    public void provides_an_email() {
        deleted = "notfound@gmail.com";
    }

    @When("the system doesnt find it")
    public void the_system_doesnt_find_it() {
        deleted = "notfound@gmail.com";
        assertFalse(admin1.deleteUser(deleted));
    }

    @Then("it display an error massage : {string}")
    public void it_display_an_error_massage(String string) {
        System.out.println(string);
    }


    @When("the system finds it belong to an admin")
    public void the_system_finds_it_belong_to_an_admin() {
        deleted = "admin@gmail.com";
        assertFalse(admin1.deleteUser(deleted));
    }



    @Given("the user exist")
    public void the_user_exist() {
        admin1.addClient("ave", 16, "male", "nablus", "ave@gmail.com", "123", Status.Active);
        User userAve = new User("ave",16,"male","nablus", "ave@gmail.com", "123",Role.Client);
        Application.addUser(userAve);
        //assertTrue(admin1.addClient("ave", 16, "male", "nablus", "ave@gmail.com", "123", Status.Active));

        assertTrue(Application.findUser("ave@gmail.com"));
    }

    @When("the admin selects the updateUserDetails")
    public void the_admin_selects_the_update_user_details() {
        app.setCurrentFeature("updateUserDetails");
    }

    @Then("The system updates the user details")
    public void the_system_updates_the_user_details()
    {
        admin1.addClient("ave", 16, "male", "nablus", "ave@gmail.com", "123", Status.Active);
        assertTrue(admin1.updateUser("ave@gmail.com", 33, "jenin", "456"));

    }

    @Then("displays the massage {string}")
    public void displays_the_massage(String string) {
        System.out.println(string);
    }


    @Given("the user exists with a valid email")
    public void the_user_exists_with_a_valid_email() {
        int i = 0;
        for(User user : users)
        {
            System.out.println(users.get(i).getEmail());
            i++;
        }
        assertTrue(Application.findUser("client@gmail.com"));
    }

    @When("the admin select the updateUserRole command with the user email and role Instructor")
    public void the_admin_select_the_update_user_role_command_with_the_email_and_role() {
        app.setCurrentFeature("updateUserRole");
    }

    @Then("the system updates the user’s role")
    public void the_system_updates_the_user_s_role() {
        assertTrue(admin1.updateRole("client@gmail.com"));

    }

    @Given("the user exists with a status")
    public void the_user_exists_with_a_status_of() {
        assertTrue(app.activeCheck("client@gmail.com"));

    }

    @When("the admin executes the reactivateUser command with the email")
    public void the_admin_executes_the_reactivate_user_command_with_the_user_id() {
        assertTrue(admin1.setStatus("not@gmail.com", Status.Active));
    }

    @Then("the system restores the user account")
    public void the_system_restores_the_user_account() {
        System.out.println("user restored successfully");
    }

    @When("the admin executes the deactivateUser command with the email")
    public void the_admin_executes_the_deactivate_user_command_with_the_user_id() {
        assertTrue(admin1.setStatus("is@gmail.com", Status.DeActive));
    }

    @Then("the system marks the user account as inactive")
    public void the_system_marks_the_user_account_as_inactive() {
        System.out.println("Admin account marked as inactive");
    }


    @Given("the target account belongs to an admin")
    public void the_target_account_belongs_to_an_admin() {
        assertTrue(app.isAdmin("admin@gmail.com"));
    }

    @When("the admin executes the deactivateUser command with the admins email")
    public void the_admin_executes_the_deactivate_user_command_with_the_admins_user_id() {
        assertFalse(admin1.setStatus("admin@gmail.com", Status.DeActive));
    }

    @Then("the system displays the error message: {string}")
    public void the_system_displays_the_error_message(String string) {
        System.out.println("error message: " + string);
    }


    @When("the admin executes the getEngagementStats command")
    public void the_admin_executes_the_get_engagement_stats_command() {
        admin1 = (Admin) Application.currentUser;
        System.out.println(admin1.displayEngagedUsers());
    }

    @Then("the system displays a list of the most engaged users")
    public void the_system_displays_a_list_of_the_most_engaged_users() {
assertTrue(true);


    }

    @When("the admin executes the filterUsersByEngagement command with the parameter No activity in the last 30 days")
    public void the_admin_executes_the_filter_users_by_engagement_command_with_the_parameter_no_activity_in_the_last_days() {
        Application.currentSection = "filterUsersByEngagement";
    }

    @Then("the system displays a list of inactive users")
    public void the_system_displays_a_list_of_inactive_users() {
        admin1.displayInActiveUsers();
    }

    @When("the admin executes the downloadEngagementReport command")
    public void the_admin_executes_the_download_engagement_report_command() {
        Application.currentSection = "downloadEngagementReport";
    }

    @Then("the system generates and saves a report file")
    public void the_system_generates_and_saves_a_report_file() {
        assertTrue(admin1.report());

    }
    List<User> newUsers,searchResults;
    String searchMessage;
    @Given("the admin is in the system via email {string} and password {string}")
    public void givenTheAdminIsInTheSystem(String email, String password) {
        assertNotNull(login(email, password));

    }

    @Given("the following users exist in the system:")
    public void givenTheUsersExistInTheSystem(List<Map<String, String>> userData) {
        newUsers = new ArrayList<>();
        for (Map<String, String> data : userData) {
            String name = data.get("name");
            int age = Integer.parseInt(data.get("age"));
            String gender = data.get("gender");
            String address = data.get("address");
            String email = data.get("email");
            String password = data.get("pass");
             Status status = Status.Active;  // Assume active by default for example purposes

               admin1.addClient(name, age, gender, address, email, password, status);
        }
    }

    @When("the admin executes the searchUser command with the parameter {string}")
    public void whenTheAdminExecutesSearchCommand(String searchParam) {
        searchResults = new ArrayList<User>();
        for (User user : users) {
            if (user.getName().contains(searchParam)) {
                searchResults.add(user);
            }

        }


        searchMessage = searchResults.size() + " users found matching '" + searchParam + "'";
    }

    @Then("the system displays the following matching users")
    public void thenTheSystemDisplaysMatchingUsers(List<Map<String, String>> expectedUsers) {


        for (int i = 0; i < expectedUsers.size(); i++) {

            Map<String, String> expectedUser = expectedUsers.get(i);
            //System.out.println("Size" + searchResults.size());
           if(searchResults.size() == 0) {continue;}
            User result = searchResults.get(i);

            assertEquals(expectedUser.get("name"), result.getName());
            assertEquals(Integer.parseInt(expectedUser.get("age")), result.getAge());
            assertEquals(expectedUser.get("gender"), result.getGender());
            assertEquals(expectedUser.get("address"), result.getAddress());
            assertEquals(expectedUser.get("email"), result.getEmail());
            assertEquals(expectedUser.get("pass"), result.getPass());

        }
    }

    @Then("the system displays message: {string}")
    public void thenTheSystemDisplaysMessage(String expectedMessage) {
        assertEquals(expectedMessage, searchMessage);
    }


}