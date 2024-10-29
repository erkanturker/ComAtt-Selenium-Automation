Feature: Users Page
  Background:
    Given User logs in to the system
    When  User navigates to "Users" page

  Scenario: Admin verifies the Users page
    Then  User verifies the dashboard title is "Users"

  Scenario: Admin Can create a User
    When  User fills out the form to create a new user
    Then  verifies that the alert title is "Success"

  Scenario: Admin Can Delete a User
    When  User locates the delete button associated with the username
    Then  verifies that the alert title is "Info"