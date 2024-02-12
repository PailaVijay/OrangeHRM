Feature: Login Functionality

Scenario: Verify login with valid credentials
Given User navigates to login page
When  User enters valid username "Admin" into username field
And   User enters valid password "admin123" into passsword field
And   User clicks on login button
Then  User should navigate to Dashboard page

Scenario: Verify login without providing any credentials
Given User navigates to login page
When  User do not enter any credentials
And   User clicks on login button
Then  User should not get into dashboard 

Scenario: Verify login with valid username and invalid password
Given User navigates to login page
When  User enters valid username "Admin" into username field
And   User enters invalid password "admin" into passsword field
And   User clicks on login button
Then  User should get warning message

Scenario: Verify login with invalid username and valid password
Given User navigates to login page
When  User enters invalid username "Admin123" into username field
And   User enters valid password "admin123" into passsword field
And   User clicks on login button
Then  User should get warning message