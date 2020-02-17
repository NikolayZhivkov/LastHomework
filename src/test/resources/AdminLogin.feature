Feature: Admin Login Scenarios - POSITIVE
  As an admin user I want to successfully be able to
  login and logout from the admin panel


  Scenario Outline: : : Successful admin login
    Given the user is on the admin login page
    When the user logs in using username "<username>" and password "<password>"
    And the user clicks on the login button
    And the user should successfully log in into the admin panel
#    When the user is on admin dashboar page
    And admin clic on navigation bar on the menu sales-orders and check the select menu
    And the user clicks on the extension menu and then search specific detail
    Then the user verify the search and go and click on the logout button


    Examples:
      | username | password   |
      | admin    | parola123! |




