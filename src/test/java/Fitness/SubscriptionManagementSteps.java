package Fitness;

import Fitness.AdminPackage.Admin;
import Fitness.AdminPackage.Application;
import Fitness.AdminPackage.Client;
import Fitness.AdminPackage.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Fitness.AdminPackage.Application.users;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SubscriptionManagementSteps {
Client client;
Admin admin;

    public SubscriptionManagementSteps()
    {
        client=new Client();
        admin=new Admin();

        client.setEmail("instructorTest1@gmail.com");
        client.setPass("instructorTest1pass");

        users.add(client);

    }


    @Given("a client is logged in")
    public void a_client_is_logged_in() {

        Application.currentUser = Application.login(client.getEmail(),client.getPass());
        System.out.println(Application.currentUser);
        assertNotNull(Application.currentUser);
    }
    String plan;
    @When("the client selects the {string} plan")
    public void the_client_selects_the_plan(String string) {
        plan=string;
    }


    @Then("the client's subscription is activated")
    public void the_client_s_subscription_is_activated() {
        assertTrue(client.setPlan(plan));
    }

    @Then("the client can access premium features")
    public void the_client_can_access_premium_features() {
        assertTrue(client.isPremium());
    }

boolean flag;
    @When("the admin views the subscription plans")
    public void the_admin_views_the_subscription_plans() {
       flag= admin.viewSubscriptions();
    }

    @Then("the admin can see all active plans")
    public void the_admin_can_see_all_active_plans() {

        assertTrue(flag);
    }


}
