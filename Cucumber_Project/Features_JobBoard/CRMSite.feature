
@CRMSiteTests
Feature: Test the CRM Site functionalities
 
     @countDashlets
     Scenario: Count Dashlets on CRM Site homepage
     Given User logs on to CRM Site page
     When User counts the number of Dashlets and print them on console
     And Close the browser for CRM activity

     @createLeads
     Scenario Outline: Create leads using parameterization
     Given User logs on to CRM Site page
     When User Navigate to create Leads
     And Select the Leads option
     And Clicks on Create Lead option
     And User enters the values"<FirstName>"and"<LastName>"and"<EmailID>"
     And Click save buton to finish
     Then Navigates to the View Leads Page to see results
     And Close the browser for CRM activity
     
     Examples:
    |FirstName|LastName|EmailID      |
     |Deary   |Russo   |Daery@abc.com|
    
     @meetingSchedule
     Scenario Outline: Schedule a meeting and invite members
     Given User logs on to CRM Site page
     When User navigates to Activities option
     And Select the Meeting option
     And Clicks on Schedule a Meeting option
     And User first enters the"<FirstMember>"and add to meeting
     And User second enters the"<SecondMember>"and add to meeting
     And User third enters the"<ThirdMember>" and add to meeting 
     And Enter other details to Save the Meeting
     Then Navigates to the View Meetings Page
     And confirm the meeting
     And Close the browser for CRM activity
     
     Examples:
     |FirstMember|SecondMember|ThirdMember  |
     |Daniel      |Denise      |Diana    |
     
     @createproduct
     Scenario Outline: Creation of Product
      Given User logs on to CRM Site page
     When Clicks on Create Product option
     And User navigates to All option
     And Select the Product option
     And Clicks on Create Product option
     And User  enters product name as"<ProductName>"
     And Enter other details as"<Price>"to Save the Product
     And Navigates to the View Products Page
     And Close the browser for CRM activity
     
     
			Examples:
     |ProductName |Price |
     |Product3203 |Rs.422   |
     
     
     