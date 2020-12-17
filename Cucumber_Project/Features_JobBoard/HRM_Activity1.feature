@HRM_Activity_1

Feature: Creating job vacancy

Scenario: To create a job vacancy for devops engineer 

    Given User is on Login page.

    When User enters"orange"and"orangepassword123"

    And Navigate to recruitment page

    And Click on the Vacancies menu item to navigate to the vacancies page

    And Click on the Add button to navigate to the Add Job Vacancy form

    And Fill out the necessary details and Click the Save button to save the vacancy

    Then Verify that the vacancy was created

    And Close browser.