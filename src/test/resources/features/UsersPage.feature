Feature: Users Page

  Scenario: Admin verifies the Users page
    Given User logs in to the system
    When  User navigates to "Users" page
    Then  User verifies the dashboard title is "Users"