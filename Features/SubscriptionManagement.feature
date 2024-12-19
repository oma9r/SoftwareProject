Feature: Subscription Management

  Scenario: Client Subscribes to a Premium Plan
    Given a client is logged in
    When the client selects the "Premium" plan
    Then the client's subscription is activated
    And the client can access premium features


  Scenario: Admin views Subscription Plans
    Given an admin is logged in
    When the admin views the subscription plans
    Then the admin can see all active plans