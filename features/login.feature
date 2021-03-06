Feature: Test Facebook Login

Scenario: Validate Failure Login due to invalid password

Given Open Browser and launch facebook
When User enters user name "rohit923132@gmail.com" and password "123123" and Click Login
Then User should not be able to login and get error message
And Close browser

Scenario: Validate Successful Login

Given Open Browser and launch facebook
When User enters user name "rohit923132@gmail.com" and password "tukushashu1!" and Click Login
Then User should be able to login Successfully
And Close browser

Scenario: Validate Failure Login due to invalid User Name and password

Given Open Browser and launch facebook
When User enters user name "asfass@gmail.com" and password "123" and Click Login
Then User should not be able to login and get error message
And Close browser