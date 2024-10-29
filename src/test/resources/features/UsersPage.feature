Feature: Users Page

  Scenario: Admin verifies the Users page
    Given User logs in to the system
    When  User navigates to "Users" page
    Then  User verifies the dashboard title is "Users"

  Scenario: Admin Can create a User
    Given User logs in to the system
    When  User navigates to "Users" page
    Then  User verifies the dashboard title is "Users"
    When  User fills out the form to create a new user
    Then  verifies that the alert title is "Success"
