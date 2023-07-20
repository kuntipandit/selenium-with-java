@login
Feature: All test cases for positive & negative scenarios

  Background:
    Given User is in Suacedemo homepage "https://www.saucedemo.com/"

  Scenario: Login with positive/correct credentials
    When User enters correct username "standard_user"
    And User enters correct password "secret_sauce"
    Then User should be able to login

  @Login @CartItem
  Scenario Outline: Login with positive/correct credentials
    When User enters correct username "<Username>"
    And User enters correct password "<password>"
    Then User should be able to see cart_item

   Examples:

      |Username     |password    |
      |standard_user|secret_sauce|


  @InvalidLogin
  Scenario Outline: Login with invalid credentials
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see error message "<errorMessage>"


    Examples:
      |username        |password    |errorMessage                          |
      |locked_out_user |secret_sauce| Sorry, this user has been locked out.|
      |Invalid_user    |secret_sauce|Username and password do not match any user in this service|
