# Test Plan

**Author**:  Arthur Wanner 

| Version | Description     |
| --------|:---------------:|
| V1      | Initial version |
| V2      | Added system test cases |

## 1 Testing Strategy

### 1.1 Overall strategy


The Go Bowl application will initially be developed with system and unit testing.  Integration testing and regression testing will possibly be added in a future deliverable. 


### 1.2 Test Selection

Initally the functional (black box) testing will be performed with unit testing defined in a future deliverable.


### 1.3 Adequacy Criterion

System tests will be performed manually using an android device.  Test coverage will be used to examine the quality of any unit tests.


### 1.4 Bug Tracking

Bugs encountered in development will be processed by the team as testing development progresses.  Email communication will allow team members to relay information in short time.

### 1.5 Technology

Android, JUnit tests, automated integration tests if time permits. 

## 2 Test Cases

| Add Customer | Ideal use case |
| --------|:---------------:|
| Purpose | Test the functionality of adding a new Customer to the system. |
| Steps | Tap "Manager" button.  Tap "New Customer" button.  Fill in first name, last name, and email address.  Tap "Create Bowler!".
| Expected Result | System displays dialog confirming creation of Customer |
| Actual Result | Dialog is displayed showing first name |
| Pass/fail Info | Test passes if confirmation dialog is shown |

| Add Customer | Do not fill in all of information |
| --------|:---------------:|
| Purpose | Add new customer but don't supply all of the necessary information |
| Steps | Tap "Manager" button.  Tap "New Customer" button.  Fill in first name but ommit last name and email address.  Tap "Create Bowler!".
| Expected Result | System displays error dialog and then returns to data entry screen  |
| Actual Result | Success dialog is displayed showing first name |
| Pass/fail Info | Test passes if failure confirmation dialog is shown and returns to data-entry form |
| ** This test is not currently passing ** |

| Edit Customer | Ideal Use Case |
| --------|:---------------:|
| Purpose | Test editing of customer |
| Steps | Tap "Manager" button.  Tap "Edit Customer" button.  Tap "Scan Card Now".  The customer's information is displayed in editable text fields.  Make edits to information.  Tap "Save Bowler!" button. |
| Expected Result | System displays success dialog showing changed data for conirmation |
| Actual Result | Edit functionality is currently not implemented |
| Pass/fail Info | Test passes if success dialog is shown and returns to Manager menu |
| ** This test is not currently passing ** |

| Print Customer Card | Ideal Use Case |
| --------|:---------------:|
| Purpose | Basic test of Reprinting of Customer id card |
| Steps | Tap "Manager" button.  Tap "Reprint Card" button.  Enter in email address or last name to search by.  Tap "search" button.  Print success displayed and returns to main menu.    |
| Expected Result | System displays print success dialog confirming customer found and printed. |
| Actual Result | System display print success dialog for customer. |
| Pass/fail Info | Test passes if success dialog is shown and returns to Manager menu |

| Print Customer Card | Customer Not Found |
| --------|:---------------:|
| Purpose | test of Reprinting of Customer id card and customer info not found |
| Steps | Tap "Manager" button.  Tap "Reprint Card" button.  Enter in email address or last name to search by.  Tap "search" button.  "Not Found" dialog box is displayed.  Tap "Back" button to return to manager menu.  |
| Expected Result | System displays "Not Found" dialog. |
| Actual Result | System display "Not Found" dialog for customer. |
| Pass/fail Info | Test passes if success dialog is shown |




