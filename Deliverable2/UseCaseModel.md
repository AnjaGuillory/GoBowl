# Use Case Model

*This is the template for your use case model. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**:  6300Summer16Team07 

| Version | Description     |
| --------|:---------------:|
| V1      | Initial version |
*In case you revise this document in later deliverables, increase the version number and concisely describe what you modified. For example:*

| *Version* | *Description*       | 
| ----------|:-------------------:|
| *V1*      | *Initial version*   |
| *V2*      | *Updated Sections 2 and 3 basd on better understanding of the system* |
| *...*     | *...*               |

## 1 Use Case Diagram

*This section should contain a use case diagram with all the actors and use cases for the system, suitably connected.*

Actor:  Bowling Alley Manager (Manager)
Use Cases:  Add Customer, Edit Customer, Print Customer Card

Actor:  Bowling Alley Customer (Customer)
Use Cases:  Request Lane, Checkout 

## 2 Use Case Descriptions

*For each use case in the use case diagram, this section should contain a description, with the following elements:*

- *Requirements: High-level description of what the use case must allow the user to do.*
- *Pre-conditions: Conditions that must be true before the use case is run.*
- *Post-conditions Conditions that must be true once the use case is run.*
- *Scenarios: Sequence of events that characterize the use case. This part may include multiple scenarios, for normal, alternate, and exceptional event sequences. These scenarios may be expressed as a list of steps in natural language or as sequence diagrams.*

### Use Case:  Add Customer
Requirements:  The "Add Customer" Use Case allows the Manager to add a new Customer to the system so that they may bowl.

Pre-conditions:  The customer is not in the system yet.

Post-conditions:  The new customer is successfully added to the system and a customer card is printed.

Normal Scenario:

- Manager signs into system.
- Manager chooses "Add Customer" from the available menu options.
- Manager enters customer name and email address into the system.
- The manager chooses "Create" after data is entered.
- A confirmation dialog is displayed and the manager chooses "Yes" to confirm the data.
- The new customer is added to the system.
- The customer card is printed and manager gives card to customer.

Alternate Scenario:

- Manager signs into system.
- Manager chooses "Add Customer" from the available menu options.
- Manager enters customer name and email address into the system.
- The manager clicks "Create" after data is entered.
- A confirmation dialog is displayed and the manager chooses "No" because data is inaccurate.
- The manager fixes the data, clicks "Create" and confirms the correct data.
- The customer card is printed and manager gives card to customer.

Exceptional Scenario:

- Manager signs into system.
- Manager chooses "Add Customer" from the available menu options.
- Manager enters customer name and email address into the system.
- The manager chooses "Create" after data is entered.
- A confirmation dialog is displayed and the manager chooses "Yes" to confirm the data.
- The system detects duplicate customer because email address already exists in the system.
- The system rejects the creation and returns to the data entry form.
- The manager aborts the operation by choosing "Cancel" and returning back to the main menu.


### Use Case:  Edit Customer Information
Requirements:  A customer who is already in the system wishes to modify their customer information.  The manager can modify the name or email address and save the changes.

Pre-conditions:  The customer to be modified is in the system already.

Post-conditions:  The customer information is updated and a new customer card is printed.

Normal Scenario:

- The manager signs into the system.
- Manager chooses "Edit Customer" from the menu system.
- Manager enters the unique customer email address.
- The system displays the information for the customer in editable form fields.
- The Manager modifies the customer name or email address.
- The manager chooses "Save" after data is entered.
- A confirmation dialog is displayed and the manager chooses "Yes" to confirm the data.
- The customer information is saved.
- A new customer card is printed and manager gives card to customer.

Alternate Scenario:

- The manager signs into the system.
- Manager chooses "Edit Customer" from the menu system.
- Manager enters the unique customer email address.
- The system cannot find a customer for the entered email.
- The manager chooses "Cancel" to exit back to the main menu.

Exceptional Scenario:

- The manager signs into the system.
- Manager chooses "Edit Customer" from the menu system.
- Manager enters the unique customer email address.
- The system displays the information for the customer in editable form fields.
- The Manager modifies the email address.
- The manager chooses "Save" after data is entered.
- A confirmation dialog is displayed and the manager chooses "Yes" to confirm the data.
- The system detects duplicate customer because email address already exists in the system.
- The system rejects the creation and returns to the data entry form.
- The manager aborts the operation by choosing "Cancel" and returning back to the main menu.







