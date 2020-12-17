@HRM_Activity_3

Feature: Adding multiple employees

Scenario Outline: Add multiple employees using an the Examples table

    Given User is on Welcome page

    When user enter"orange"and"orangepassword123"

    And Navigate to PIM option

    And Click on the add button to add new employee

    And Fill out the necessary details"<Firstname>"and"<Lastname>"

    Then Save and Verify that the employees have been created"<EmployeeID>"

    

Examples:

    | Firstname | Lastname |EmployeeID |

    | Denise | Russo | 2521 |

    | Amy | Russo | 2522 |    