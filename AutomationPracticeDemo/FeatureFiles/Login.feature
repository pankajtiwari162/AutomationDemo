Feature: Login


@Smoke
  Scenario: to test the login with valid credentials
  	Given user open the browser
    When user clicks on Sign_In link
    When user enter username "automationwithpankaj@gmail.com"
    And user enter password as "test@1234"
    And user clicks on sign in
    Then user should be logged in successfully
    And user logout from the application