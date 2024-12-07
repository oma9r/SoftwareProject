Feature: Content Management

  Scenario: Admin Approves Wellness Article
    Given an admin is logged in
    When an instructor submits a wellness article
    Then the admin reviews the article
    Then the article is published

  Scenario: Admin Rejects Wellness Tip
    Given an admin is logged in
    When an instructor submits a wellness tip
    Then the admin reviews the tip
    And the admin rejects the tip
    Then the tip is not published

  Scenario: Admin Handles User Feedback
    Given an admin is logged in
    When a client submits feedback
    Then the admin reviews the feedback
