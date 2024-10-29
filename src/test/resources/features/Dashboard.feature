Feature: Dashboard Page

  Scenario Outline: User verifies "<cardTitle>" DashboardCard on the DashboardPage
    Given User logs in to the system
    Then  User verifies the dashboard title is "Dashboard"
    Then User verifies "<cardTitle>" DashboardCard on the DashboardPage

    Examples:
      | cardTitle   |
      | Teacher     |
      | Students    |
      | By Terms    |