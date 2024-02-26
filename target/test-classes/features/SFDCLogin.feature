Feature: SFDC login feature

		Scenario: Login Error Message - 1
    Given user open salesforce application
    When user on "LoginPage"
    When user enter valid username as "priyanka@house.com"
    And user clear and enter the password field as ""
    And user click on the Login button
    Then Verify we can see the error message "Please enter your password."
    
    Scenario: Login To SalesForce -2
    Given user open salesforce application
    When user on "LoginPage"
    When user enter valid username as "priyanka@house.com"
    And user enter valid password as "Test@123"
    And user click on the Login button
 		When user on "HomePage"   
    Then user should see the Home Page "Home Page ~ Salesforce - Developer Edition";
    
    
    Scenario: Check RemeberMe - 3
    Given user open salesforce application
    When user on "LoginPage"
    When user enter valid username as "priyanka@house.com"
    And user enter valid password as "Test@123"
    And user selet the remember user name check box
    And user click on the Login button
    When user on "HomePage"
    When user Click on user menu drop down
    And user Select log out link
    When user on "LoginPage"
    Then Verify user should see username populated in textbox and remember user name chekbox checked

    
    Scenario: Forgot Password- 4A
    Given user open salesforce application
    When user on "LoginPage"
    When user click on Forgot password
    When user on "ForgotYourPasswordPage"
    When user enter username in Salesforce forgot password page
    And user click on continue button
    When user on "CheckYourEmailPage"
    Then user should see Password reset message page "We’ve sent you an email with a link to finish resetting your password."
    
    
    Scenario: Forgot Password- 4B
    Given user open salesforce application
    When user on "LoginPage"
    When user enter wrong username as "123"
    And user enter wrong password as "22131"
    And user click on the Login button
    Then Verify a error message "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
    
    
    
    
    