@HRM_Activity_2

Feature: Adding candidate for recruitment

Scenario: Add information about a candidate for recruitment

    Given User is on Welcome page.

    When User enter"orange"and"orangepassword123"

    And Navigate to recruitment page.

    And Click on the add button to add candidate information

    And Fill out the necessary details

    And Upload a resume to the form and save 

    Then Verify that the candidate entry was created

    And Close windows.