Feature: Login functionality

  Scenario: Successful login by username and password
    Given I am on the Login page
    When I enter valid username and password
    And I click on login button
    Then I should be logged in

  Scenario Outline: Unsuccessful login with invalid user name
    Given I am on the Login page
    When I enter <username> and valid password
    And I click on login button
    Then I should not be logged in
    And Error message <error> should be displayed
    Examples:
      | username        | error                                                         |
      | locked_out_user | "Sorry, this user has been locked out."                       |
      | potato          | "Username and password do not match any user in this service" |
