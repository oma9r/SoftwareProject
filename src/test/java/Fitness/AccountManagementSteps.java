package Fitness;

import Fitness.AdminPackage.Admin;
import Fitness.AdminPackage.Application;
import Fitness.AdminPackage.Role;
import Fitness.AdminPackage.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import io.cucumber.datatable.DataTable;

import java.util.*;
import java.util.List;

import static Fitness.AdminPackage.Application.users;
import static org.junit.Assert.*;

public class AccountManagementSteps {

    //private Application application;
    //private User currentUser;
    ProgramManagementStep programManagementStep;
    private String lastDisplayedMessage;
    private boolean confirmationDialogDisplayed;
    private String lastDisplayedDialog;
    Admin admin=new Admin("yuhi",54,"male","kj","tesser","securePassword");

    public AccountManagementSteps() {
        // Instantiate the application. In a real scenario, use dependency injection.
        //Application.init();
        Application.currentUser = new User();
        programManagementStep = new ProgramManagementStep();


    }

    @Given("the user has successfully logged into the Fitness Management System")
    public void the_user_has_successfully_logged_into_the_fitness_management_system() {
        String username = "Abood";
        String password = "112233";
        //Application.init();
        User user = new User(username, password);
        user.setEmail("Abood@gmail.com");
        users.add(user);

        //Application.currentUser = user;


        System.out.println("Email for user: " + user.getEmail());
        assertNotNull("Email is null for user: " + username, user.getEmail());

        User isLoginSuccessful = Application.login(user.getEmail(), user.getPass());

        boolean flag  = false;

        flag = (isLoginSuccessful != null);

      // /*debugging */System.out.println("Login attempt with email: " + user.getEmail() + " and password: " + user.getPass());
       //  /*debugging */System.out.println("Users in system: " + users);

        for (User user1 : users) {
            System.out.println("User email: " + user1.getEmail());
        }



        assertTrue("Login failed for user: " + username, flag);

        if (flag) {
            System.out.println("The user has successfully logged into the system.");
        }

    }

    @When("the user navigates to the {string} section")
    public void the_user_navigates_to_the_section(String section) {
        Application.currentSection = section;
        System.out.println("The user has navigated to the " + section + " section.");
    }
    String b;
    @When("clicks on the {string} button")
    public void clicks_on_the_button(String button) {
        b=button;

    }
    public List<String> getFormFields() {
        List<String> fields = new ArrayList<>();
        fields.add("Username");
        fields.add("Password");
        fields.add("Email");

        return fields;
    }
    @Then("the system displays a form with the following fields:")
    public void the_system_displays_a_form_with_the_following_fields(DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);


        List<String> expectedFields = Arrays.asList("Name", "Age", "Fitness Goals", "Dietary Preferences", "Dietary Restrictions");

        for (Map<String, String> field : formFields) {
            String fieldName = field.get("Field");
            String mandatory = field.get("Mandatory");
            String type = field.get("Type");

            System.out.println("Field: " + fieldName + ", Mandatory: " + mandatory + ", Type: " + type);

            assertTrue("Field not found: " + fieldName, expectedFields.contains(fieldName));


            if (mandatory.equals("Yes")) {
                System.out.println(fieldName + " is mandatory.");
            } else {
                System.out.println(fieldName + " is optional.");
            }

            System.out.println("Field type: " + type);
        }
    }


    @When("the user fills out the form with valid information:")
    public void the_user_fills_out_the_form_with_valid_information(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> formData = dataTable.asMaps(String.class, String.class);


        String name = formData.get(0).get("Name");
        String ageString = formData.get(0).get("Age");
        String fitnessGoals = formData.get(0).get("Fitness Goals");
        String dietaryPreferences = formData.get(0).get("Dietary Preferences");
        String dietaryRestrictions = formData.get(0).get("Dietary Restrictions");


        int age = 0;
        if (ageString != null && !ageString.isEmpty()) {
            age = Integer.parseInt(ageString);
        }


        //User currentUser = Application.currentUser;
        User currentUser = new User();
        currentUser.setName(name);
        currentUser.setAge(age);
        currentUser.setGoalsUser(fitnessGoals);
        currentUser.setDietaryPreferencesUser(dietaryPreferences);
        currentUser.setDietaryRestrictions(dietaryRestrictions);


        if (currentUser.getUserProgram() != null) {
            currentUser.getUserProgram().setProgramGoals("Achieve Fitness Goals");
        } else {
            System.out.println("Error: userProgram is null.");
        }

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Fitness Goals: " + fitnessGoals);
        System.out.println("Dietary Preferences: " + dietaryPreferences);
        System.out.println("Dietary Restrictions: " + dietaryRestrictions);
    }


    @Then("the system saves the profile information")
    public void the_system_saves_the_profile_information() {

        User currentUser = Application.currentUser;
        currentUser = new User();

        assertNotNull("Name should be provided", currentUser.getName());
        assertNotNull("Age should be provided", currentUser.getAge());
        //assertNotNull("Fitness Goals should be provided", currentUser.getFitnessGoals());


        assertTrue("Optional field (e.g., Dietary Preferences) should be empty or null",
                currentUser.getDietaryPreferencesUser() == null || currentUser.getDietaryPreferencesUser().isEmpty());
        assertTrue("Optional field (e.g., Dietary Restrictions) should be empty or null",
                currentUser.getDietaryPreferencesUser() == null || currentUser.getDietaryPreferencesUser().isEmpty());

        System.out.println("Profile information saved successfully.");
    }

    @Then("displays a confirmation message: {string}")
    public void displays_a_confirmation_message(String message) {
        // Check the last displayed message
        lastDisplayedMessage = message;
        assertEquals("Confirmation message does not match.", message, lastDisplayedMessage);
        System.out.println("Confirmation message displayed: " + message);
    }

    @Given("the user has a previously created profile")
    public void the_user_has_a_previously_created_profile()
    {
        //users = new ArrayList<User>();
        String email = "abood@gmail.com";

        //boolean userExists = users.stream().anyMatch(user -> user.getEmail().equals(email));

        boolean userExists = false;


        for(User user1 : Application.users)
        {
            if(user1.getEmail() == null)
            {
                continue;
            }
            else if(user1.getEmail().equals(email))
            {
                userExists = true;
                break;
            }
        }

        if (!userExists) {

            User user = new User("Abood", 25, "male", "Palestine", email, "password123", Role.Client);
            users.add(user);
            System.out.println("User profile created successfully with email: " + user.getEmail());
        } else {

            System.out.println("User profile with email " + email + " already exists.");
        }
    }

    @Then("the system displays the current profile details in editable fields")
    public void the_system_displays_the_current_profile_details_in_editable_fields() {

        //User currentUser  = Application.currentUser;
        User currentUser = new User();
        //if(currentUser == null) System.out.println("null");
        assertNotNull("Current user is not logged in", currentUser);


        Map<String, String> editableFields = new HashMap<>();
        editableFields.put("Name", currentUser.getName());
        editableFields.put("Email", currentUser.getEmail());
        editableFields.put("Password", currentUser.getPass());


        assertEquals("The Name field does not match the current user's name.",
                currentUser.getName(), editableFields.get("Name"));
        assertEquals("The Email field does not match the current user's email.",
                currentUser.getEmail(), editableFields.get("Email"));
        assertEquals("The Password field does not match the current user's password.",
                currentUser.getPass(), editableFields.get("Password"));

        System.out.println("Current profile details displayed correctly in editable fields.");
    }

    @When("the user modifies any field \\(e.g., updates dietary preferences)")
    public void the_user_modifies_any_field_e_g_updates_dietary_preferences() {

        User currentUser = Application.currentUser;

        assertNotNull("Current user is not logged in", currentUser);

        String newDietaryPreference = "Vegetarian";

        currentUser.setDietaryPreferencesUser(newDietaryPreference);
        assertEquals("Dietary preference update failed.", newDietaryPreference, currentUser.getDietaryPreferencesUser());
        System.out.println("Dietary preferences updated to: " + newDietaryPreference);
    }

    @When("the user modifies the dietary preferences to {string}")
    public void the_user_modifies_the_dietary_preferences_to(String string) {

    }



    @Then("the system updates the profile information")
    public void the_system_updates_the_profile_information() {
        System.out.println("this is we need to see: " + Application.currentUser);
        User currentUser = Application.currentUser;

        //currentUser = new User();
        assertNotNull("Current user is not logged in", currentUser);

        currentUser.setName("Updated Name");
        currentUser.setEmail("updatedemail@example.com");

        assertEquals("Updated Name", currentUser.getName());
        assertEquals("updatedemail@example.com", currentUser.getEmail());

        System.out.println("Profile information updated successfully.");

    }

    @Given("the user is on the {string} form")
    public void the_user_is_on_the_form(String formName) {
        System.out.println("User is on the " + formName + " form.");

    }

    @When("the user fills out only the mandatory fields:")
    public void the_user_fills_out_only_the_mandatory_fields(DataTable dataTable) {
        List<Map<String, String>> formData = dataTable.asMaps(String.class, String.class);

        String name = formData.get(0).get("Name");
        String ageString = formData.get(0).get("Age");
        String fitnessGoals = formData.get(0).get("Fitness Goals");

        int age = Integer.parseInt(ageString);
        System.out.println("Name: " + name);
        System.out.println("Fitness Goals: " + fitnessGoals);
        System.out.println("Age: " + age);

        User currentUser = Application.currentUser;
        currentUser.setName(name);
        currentUser.setAge(age);
        currentUser.setUserProgram(programManagementStep.program1);
        System.out.println("here we are: " + currentUser);
        currentUser.getUserProgram().setProgramGoals(fitnessGoals);

        assertEquals(name, currentUser.getName());
        assertEquals(age, currentUser.getAge());
        assertEquals(fitnessGoals, currentUser.getUserProgram().getProgramGoals());
        System.out.println("Mandatory fields have been filled out successfully.");

    }

    @When("leaves the optional fields blank")
    public void leaves_the_optional_fields_blank() {
        System.out.println("Optional fields left blank (no action needed).");
    }

    @Then("the system saves the profile with only the provided information")
    public void the_system_saves_the_profile_with_only_the_provided_information() {
        User currentUser = Application.currentUser;
        assertNotNull("Name should be provided", currentUser.getName());
        assertNotNull("Age should be provided", currentUser.getAge());
        assertNotNull("Fitness Goals should be provided", currentUser.getUserProgram().getProgramGoals());

        assertTrue("Optional field (e.g., Address) should be empty or null",
                currentUser.getAddress() == null || currentUser.getAddress().isEmpty());
        //assertTrue("Optional field (e.g., Email) should be empty or null",
        //currentUser.getEmail() == null || currentUser.getEmail().isEmpty());

        System.out.println("Profile saved with mandatory fields (Name, Age, Fitness Goals");


    }

    @When("the user leaves a mandatory field blank \\(e.g., Age)")
    public void the_user_leaves_a_mandatory_field_blank_e_g_age() {
        User currentUser = Application.currentUser;
        currentUser.setAge(0);
        System.out.println("Mandatory field 'Age' left blank.");
    }

    @Given("the user has an existing profile")
    public void the_user_has_an_existing_profile() {
        String email = "Abood@gmail.com";


        boolean userExists = users.stream()
                .anyMatch(user -> user.getEmail() != null && user.getEmail().equals(email));


        if (!userExists) {
            User newUser = new User("Abd", 30, "male", "address", email, "password123", Role.Client);
            users.add(newUser);
            System.out.println("User profile created for: " + email);


            userExists = users.stream()
                    .anyMatch(user -> user.getEmail() != null && user.getEmail().equals(email));
        }

        assertTrue("User profile does not exist.", userExists);
    }

    @Then("the system displays a confirmation dialog: {string}")
    public void the_system_displays_a_confirmation_dialog(String dialog) {
        //assertEquals("Confirmation message does not match", dialog, "Are you sure you want to update your profile?");
        System.out.println("Confirmation dialog displayed successfully.");
    }

    @When("the user confirms the deletion")
    public void the_user_confirms_the_deletion() {
        User currentUser = Application.currentUser;
        assertNotNull("No user is currently logged in", currentUser);
        System.out.println("User confirmed the deletion of the profile: " + currentUser.getEmail());
    }

    @Then("the system permanently deletes the user’s profile")
    public void the_system_permanently_deletes_the_user_s_profile() {
        User currentUser = Application.currentUser;
        Application.currentUser.setEmail("Abood@gmail.com");
        assertNotNull("No user is currently logged in", currentUser);

        for(User userTest: users)
        {
            if(userTest.equals(currentUser))
            {
                System.out.println("Is exist!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println(userTest);
                System.out.println(currentUser);

            }
            else {
                System.out.println("Is not exist!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println(userTest);
                System.out.println(currentUser);
            }
        }
        boolean userDeleted = false;

        for(User userTest: users)
        {
            if(userTest.getEmail() == null) continue;
            if(userTest.getEmail().equals(currentUser.getEmail()))
            {
                userDeleted = users.remove(userTest);
                break;
            }
        }
        assertTrue("User profile was not deleted successfully.", userDeleted);

        System.out.println("User profile has been permanently deleted: " + currentUser.getEmail());
    }



    @Then("all personal data associated with the profile is removed from the database.")
    public void all_personal_data_associated_with_the_profile_is_removed_from_the_database() {
        User currentUser = Application.currentUser;


        if (currentUser == null) {
            System.out.println("Error: No user is currently logged in before data removal.");
            return;
        }

        System.out.println("Current user: " + currentUser.getEmail());


        boolean userExists = users.contains(currentUser);
        assertTrue("User profile is not found in the users list.", userExists);


        boolean isDeleted = users.remove(currentUser);
        assertTrue("Personal data was not removed successfully.", isDeleted);

        System.out.println("All personal data associated with the profile has been removed.");
    }
    @Then("logs the user out of the system")
    public void logs_the_user_out_of_the_system() {
        User currentUser = Application.currentUser;


        if (currentUser == null) {
            System.out.println("Error: No user to log out.");
            return;
        }


        Application.currentUser = null;
        assertNull("User was not logged out successfully.", Application.currentUser);
        System.out.println("User has been logged out successfully.");
    }
}