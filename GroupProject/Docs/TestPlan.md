# Test Plan

**Author**:  Arthur Wanner 

| Version | Description     |
| --------|:---------------:|
| V1      | Initial version |

## 1 Testing Strategy

### 1.1 Overall strategy


The Go Bowl application will initially be developed with system and unit testing.  Integration testing and regression testing will possibly be added in a future deliverable.  Deliverable 2 will define a sample of initial system tests attempting to cover most use cases.  Initial unit test will be pursued in deliverable 3.


### 1.2 Test Selection

Initally the functional (black box) testing will be performed with unit testing defined in a future deliverable.


### 1.3 Adequacy Criterion

Test coverage will be used to examine the quality of tests in future iterations.


### 1.4 Bug Tracking

Bugs encountered in development will be processed by the team as testing development progresses.  Email communication will allow team members to relay information in short time.

### 1.5 Technology

Android, JUnit tests, automated integration tests if time permits. 

## 2 Test Cases

| Add Customer | Basic use case |
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

| Edit Customer |  |
| --------|:---------------:|
| Purpose | Test editing of customer |
| Steps | Tap "Manager" button.  Tap "Edit Customer" button.  Tap "Scan Card Now".  The customer's information is displayed in editable text fields.  Make edits to information.  Tap "Save Bowler!" button. |
| Expected Result | System displays success dialog showing changed data for conirmation |
| Actual Result | Edit functionality is currently not implemented |
| Pass/fail Info | Test passes if success dialog is shown and returns to Manager menu |
| ** This test is not currently passing ** |




