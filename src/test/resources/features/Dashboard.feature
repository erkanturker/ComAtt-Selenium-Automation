Feature: Dashboard Page

  Scenario Outline: User verifies Dashboard Page
    Given User logs in to the system
    Then  User verifies the dashboard title is "Dashboard"
    Then User verifies "<role>" DashboardCard on the DashboardPage

    Examples:
      | role   |
      | Teacher|
      | Students  |
    | By Terms          |