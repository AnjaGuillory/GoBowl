# Test Plan

**Author**:  Arthur Wanner 

| Version | Description     |
| --------|:---------------:|
| V1      | Initial version |
| V2      | Added system test cases |
| V3      | Added additional system test cases, added directions for running automated android instrumented unit tests. |

## 1 Testing Strategy

### 1.1 Overall strategy


The Go Bowl application will initially be developed with system and unit testing.  Integration testing and regression testing will possibly be added in a future deliverable. 


### 1.2 Test Selection

Initally the functional (black box) testing will be performed.  Tests are performed manually with an actual device or emulator.  System tests are listed in this document.  Basic unit testing structure has been created for V3.  See directions below for running the "BowlingSystemTest.java" run configuration.


### 1.3 Adequacy Criterion

System tests will be performed manually using an android device.  Instrumented android tests are being used for the unit tests.  To execute unit tests, see directions below.  Pass / Fail is currently being used for unit tests adequacy criterion.


### 1.4 Bug Tracking

Bugs encountered in development will be processed by the team as testing development progresses.  Email communication will allow team members to relay information in short time.

### 1.5 Technology

Android, JUnit tests, automated integration tests if time permits. 

## 2 Test Cases

### 2.1 System Test Cases

| Add Customer | Ideal use case |
| --------|:---------------:|
| Purpose | Test the functionality of adding a new Customer to the system. |
| Steps | Tap "Manager" button.  Tap "New Customer" button.  Fill in first name, last name, and email address.  Tap "Create Bowler!".
| Expected Result | System displays dialog confirming creation of Customer |
| Actual Result | Dialog is displayed showing first name |
| Pass/fail Info | Test passes if confirmation dialog is shown |

| Add Customer | Manager does not fill in all information |
| --------|:---------------:|
| Purpose | Add new customer but don't supply all of the necessary information |
| Steps | Tap "Manager" button.  Tap "New Customer" button.  Fill in first name but ommit last name and email address.  Tap "Create Bowler!".
| Expected Result | System displays error dialog and then returns to data entry screen  |
| Actual Result | Success dialog is displayed showing first name |
| Pass/fail Info | Test passes if failure confirmation dialog is shown and returns to data-entry form |


| Add Customer | Customer already exists in database |
| --------|:---------------:|
| Purpose | Disallow duplicate customer information in the database |
| Steps | Tap "Manager" button.  Tap "New Customer" button.  Fill in first name, last name and email address where email address is already in the database.  Tap "Create Bowler!".
| Expected Result | System displays "duplicate customer" error dialog and then returns to data entry screen  |
| Actual Result | "duplicate customer" dialog is displayed |
| Pass/fail Info | Test passes if "duplicate customer" error  dialog is shown and returns to data-entry form |



| Edit Customer | Ideal Use Case |
| --------|:---------------:|
| Purpose | Test editing of customer |
| Steps | Tap "Manager" button.  Tap "Edit Customer" button.  Tap "Scan Card Now".  The customer's information is displayed in editable text fields.  Make edits to information.  Tap "Save Bowler!" button. |
| Expected Result | System displays success dialog showing changed data for conirmation |
| Actual Result | "Customer updated" success dialog shown, changes confirmed when editing again. |
| Pass/fail Info | Test passes if success dialog is shown and returns to Manager menu |


| Edit Customer |  Edited Customer info already exists in database  |
| --------|:---------------:|
| Purpose | When editing customer info, newly entered email address already in database |
| Steps | Tap "Manager" button.  Tap "Edit Customer" button.  Tap "Scan Card Now".  The customer's information is displayed in editable text fields.  Make edits to information, email address changes to one that already exists in the database.  Tap "Save Bowler!" button. |
| Expected Result | System displays "duplicate customer" error dialog and returns to data entry screen |
| Actual Result | Edit functionality is currently not implemented |
| Pass/fail Info | Test passes if "duplicate customer" error dialog is shown and returns to data entry screen |
| ** This test is not currently passing ** |


| Print Customer Card | Ideal Use Case |
| --------|:---------------:|
| Purpose | Basic test of Reprinting of Customer id card |
| Steps | Tap "Manager" button.  Tap "Reprint Card" button.  Enter in the email address to search by.  Tap "search" button.  Print success displayed and returns to main menu.    |
| Expected Result | System displays print success dialog confirming customer found and printed. |
| Actual Result | System display print success dialog for customer. |
| Pass/fail Info | Test passes if success dialog is shown and returns to Manager menu |

| Print Customer Card | Customer Not Found |
| --------|:---------------:|
| Purpose | test of Reprinting of Customer id card and customer info not found |
| Steps | Tap "Manager" button.  Tap "Reprint Card" button.  Enter in email address to search by.  Tap "search" button.  "Not Found" dialog box is displayed.  Tap "Back" button to return to manager menu.  |
| Expected Result | System displays "Not Found" dialog. |
| Actual Result | System display "Not Found" dialog for customer. |
| Pass/fail Info | Test passes if success dialog is shown |


| Request Lane | Ideal Use Case |
| --------|:---------------:|
| Purpose | test of signing up for a lane with 2 bowlers. |
| Steps | Tap "Customer" button.  Tap "Scan Card Now" button to login.  Tap "Go Bowling!" button.  Enter "2" for number of bowlers.  Tap "Let's get started!" button.  Tap "Scan Card Now" button for 2nd bowler (1st bowler scanned card initially).  Scan is successful, lane is assigned.  Tap "Done" button to exit system and go bowling.  |
| Expected Result | System displays "lane information" dialog. |
| Actual Result | System displays "lane information" dialog for customer. |
| Pass/fail Info | Test passes if "lane info" dialog is shown |


| Request Lane | No lanes available |
| --------|:---------------:|
| Purpose | test of signing up for a lane but none are available. |
| Steps | Tap "Customer" button.  Tap "Scan Card Now" button to login.  Tap "Go Bowling!" button.  System displays dialog informing no lanes available.  Return to main menu  |
| Expected Result | System displays "no lanes available" dialog. |
| Actual Result | System displays "no lanes available" dialog for customer. |
| Pass/fail Info | Test passes if "no lanes available" dialog is shown |
| Notes | This test may not be necessary for this test system if we assume unlimited number of lanes |


| Checkout | Ideal Use Case |
| --------|:---------------:|
| Purpose | test of checking out (paying) after bowling |
| Steps | Customer was prevously assigned a lane.  Tap "Customer" button.  Tap "Scan Card Now" button to login.  Tap "Finish Bowling" button.  Enter 2 for the # of credit cards to split payment.  Tap "Pay Now!" button.  Tap "Ready" button to scan 1st credit card.  Confirmation dialog box is displayed.  Tap "ok" to confirm. Tap "Ready" button to scan 2nd credit card.  Tap "ok" to confirm payment and return to main menu.  |
| Expected Result | System displays final payment confirmation dialog. |
| Actual Result | System displays final payment confirmation" dialog for customer. |
| Pass/fail Info | Test passes if 2 payment confirmation dialogs are shown |


| Checkout | Not currently assigned a lane |
| --------|:---------------:|
| Purpose | Verify that the Checkout system only works for customers who have previously been assigned a lane. |
| Steps | Customer was not previously assigned a lane.  Tap "Customer" button.  Tap "Scan Card Now" button to login.  Tap "Finish Bowling" button. The system displays an error message to uses.  Tap "ok" button to exit back to customer menu.|
| Expected Result | System displays error "Not bowling" dialog. |
| Actual Result | System displays error "Not bowling" dialog. |
| Pass/fail Info | Test passes if error "Not bowling" dialog is shown. |


| Checkout | Invalid # of credit cards (0) |
| --------|:---------------:|
| Purpose | Verify that invalid input for the # of credit cards is caught. |
| Steps | Customer was prevously assigned a lane.  Tap "Customer" button.  Tap "Scan Card Now" button to login.  Tap "Finish Bowling" button.  Enter 0 for the # of credit cards to split payment.  Tap "Pay Now!" button.  System displays error "invalid input" dialog.  Tap "ok" button.  |
| Expected Result | System displays "invalid input" dialog. |
| Actual Result | System goes into infinite loop prompting for credit cards. |
| Pass/fail Info | Test passes if system displays "invalid input" dialog. |
| ** This test is not currently passing ** |


| Checkout | Invalid # of credit cards (-1) |
| --------|:---------------:|
| Purpose | Verify that invalid input for the # of credit cards is caught. |
| Steps | Customer was prevously assigned a lane.  Tap "Customer" button.  Tap "Scan Card Now" button to login.  Tap "Finish Bowling" button.  Enter -1 for the # of credit cards to split payment.  Tap "Pay Now!" button.  System displays error "invalid input" dialog.  Tap "ok" button.  |
| Expected Result | System displays "invalid input" dialog. |
| Actual Result | Not possible to enter negative numbers with UI widget |
| Pass/fail Info | Test passes if system displays "invalid input" dialog or UI widget disallows negative numbers |

### 2.2 Automated Unit Test Cases

Instrumented Android test cases are being used for unit testing.  Note that these tests need to run on an actual device or emulator.

As of TestPlan.md V3, An inital unit test for the BowlingSystem.login() method has been created.  A run configuration has been created to execute the tests.

To run the tests, select Run->Run...->BowlingSystemTest.  Next choose your device or emulator.  Results will be shown in the Run dialog.  Note that these unit tests do not currently show coverage.
