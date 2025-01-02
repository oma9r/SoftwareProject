package Fitness;

import Fitness.AdminPackage.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Fitness.AdminPackage.Application.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ContentManagementSteps {
    Admin admin;
    Instructor instructor;
    public ContentManagementSteps()
    {
        Application.init();
        admin = new Admin("Ibrahim",22,"male","fscd","admin1@gmail.com","123");
        users.add(admin);
        instructor=new Instructor("mohammad",33,"male","hdbgfvd","instructor@gmail.com","4865", Status.Active);
        admin.addInstructor(instructor);


    }
    @Given("an admin is logged in")
    public void an_admin_is_logged_in() {
        currentUser = Application.login("admin1@gmail.com","123");
        assertTrue(currentUser!=null);
        //assertTrue(currentUser instanceof Admin);

    }


    @When("an instructor submits a wellness article")
    public void an_instructor_submits_a_wellness_article() {

        instructor.addWallness(new Article(instructor.getName(),"article"));

    }
int currentSize;
    @Then("the admin reviews the article")
    public void the_admin_reviews_the_article() {
         currentSize=wallness.size();
        admin.review();

    }


    @Then("the article is published")
    public void the_article_is_published() {
        //assertTrue(wallness.size()>currentSize);
    }

    @When("an instructor submits a wellness tip")
    public void an_instructor_submits_a_wellness_tip() {
        instructor.addWallness(new Article(instructor.getName(),"Rejected article"));

    }

    @Then("the admin reviews the tip")
    public void the_admin_reviews_the_tip() {
        currentSize=wallness.size();
        admin.review();
    }

    @Then("the admin rejects the tip")
    public void the_admin_rejects_the_tip() {

    }

    @Then("the tip is not published")
    public void the_tip_is_not_published() {
        assertEquals(currentSize,wallness.size());
    }

    Client client;
    @When("a client submits feedback")
    public void a_user_submits_feedback() {
        client=new Client();
        client.submitFeedBack("feed");
    }

    @Then("the admin reviews the feedback")
    public void the_admin_reviews_the_feedback() {
        admin.review();

    }




}
