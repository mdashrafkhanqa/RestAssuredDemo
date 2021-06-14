
Feature: Automate LeafTaps Application

@smoke
Scenario: TC001_Login and Logout

Given Launch chrome browser and load url
And enter username as DemoSalesManager
And enter password as crmsfa
When click the login button
Then it is navigated Homepage
And click the logout button
And close browser

