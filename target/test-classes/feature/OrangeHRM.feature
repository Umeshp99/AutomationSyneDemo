Feature: Orange HRM Feature

Scenario: Verify all the tabs in Orange HRM Application

Given User Opens the required application
When User logs in the application
Then Verify User is on DashBoard
Then User navigates to the Admin tab
And User verifies that header of the tab is "Admin"
#Then User navigates to the PIM tab
#And User verifies that header of the tab is "PIM"
#Then User navigates to the Leave tab
#And User verifies that header of the tab is "Leave"
#Then User navigates to the Time tab
#And User verifies that header of the tab is "Time"
#Then User navigates to the Recruitment tab
#And User verifies that header of the tab is "Recruitment"
#Then User navigates to the My Info tab
#And User verifies that header of the tab is "PIM"
#Then User navigates to the Performance tab
#And User verifies that header of the tab is "Performance"
#Then User navigates to the Directory tab
#And User verifies that header of the tab is "Directory"
Then User navigates to the Buzz tab
And User verifies that header of the tab is "Buzz"
Then User closes the Browser