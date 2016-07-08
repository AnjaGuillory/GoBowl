# Use Case Model

**Author**:  6300Summer16Team07, Anja Guillory, Arthur Wanner

| Version | Description     |
| --------|:---------------:|
| V1      | Initial version |
| V2      | Updated use case for edit customer to log customer in via id card|



## 1 Use Case Diagram

Actor:  Bowling Alley Manager (Manager)
Use Cases:  Add Customer, Edit Customer, Print Customer Card


![](https://lh3.googleusercontent.com/hpLztHjqMcDQp2ppTkIbEKqHd_xcGoApEuFQFFnP7AcIkyBkNZIYpaFQWJj73pxURS4FdJwgGqj55unZ2CfWkNhg9ETp8e8tSLwmfYwncZNkfEvNutwowV-eDcjpPUBM_RKzCVs1a7UmMLTXBJuyvItbDMaIq1xFPDR8lM0YCcekysIPJ0xI1mBnvElfpRI60n0xUmJ2MAHtc7kYRZCU0aJPm6NVQI0BXj8cDLikx0fWxXL7gVHLNG5fFlm_FmP9xCHruoDMHGg2zSP9ra-hMduJSJrD6R0-_Y7PJGALHqncow-HdEdrPDMGW8k5DStHWrxvgGoEsCbreUv3csC9JbhWPfb_SQVkVV6zsTj6SWqqw9gCm_A7Hp90JdJG6H_Ge4p6_jHQSlC8v4ZM9f6UWNI83mkay6q9XOXMtl-b3_vSTcLIB6ZpbuT2nGorRsJleFIA_Mx_fuWSI1oBsaoK3Ok93UXPz95JUWEAEZ0I3tBO9-wDdCM59JijIqhIvOea0vye8taCvm4gI9zwCpmNVPKOd0zS2ECIQneCH0kfwg9DjzyjNWwG1pUmfZVV6LkbnNVlVhI7GVCz_QJ4QwobeR66wnheUbSL=w1346-h599-no)


Actor:  Bowling Alley Customer (Customer)
Use Cases:  Request Lane, Checkout 

![](https://lh3.googleusercontent.com/persMYDkZhEj8ZMYpbm55-k_vUg3TFNrLjrR1ZABFBQJHei3UtIneGseCyMpybwpzjy6kfUqHlXbW-qUPkrMont-F6oZi3btAMTADPxjAbC12ZO5Y_gRY4k087jFLpEUrLfP2rEYQNKvZZQHFUlkb5ngjhvEO11FkCDYhzE9e_-HwtCca4c4mkXoPFaH0usJ9b8yrnwqMCt5EqYH6eQ-x5QGlb_S90Wv6kBa24f1EZbPEE0XhbfvylAAa3WEjSRtqpqlBZNaHzhxRU65LckcF7dil7i0poVx4-c-4ae7FGy2eqNYh3lbW9MYu79DdXvXOdABMz1UB6faFj5a-SjnmDO9mhlAeO-gHkuQGYuM7YgMTfEguKQgNeyJpik-Ve6B2SX3YyWViBNS6s0JwoFX4hV2aAMKItqxLd775DTkkYgsr165yKQE0L0BOwi5oXI_2Y7eDTs2DUh53eoC_qQXGBbl0HQMfeeHeeCnp_UX4FTgBpFSDlbx9IkCU9Ck8arzEbcbzrAwnmaP7TPAkzjtmZbMaQ7Kd-I-GOkNwjJj8vKN_RpNInCel8Jpmr8ETeD0cB5vtlN0KB7KI6nmCZcrFTtrXTtaP4Ta=w904-h599-no)

## 2 Use Case Descriptions

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
- Manager scans the customer id card.
- The system displays the information for the customer in editable form fields.
- The Manager modifies the customer name or email address.
- The manager chooses "Save" after data is entered.
- A confirmation dialog is displayed and the manager chooses "Yes" to confirm the data.
- The customer information is saved.
- A new customer card is printed and manager gives card to customer.

Alternate Scenario:

- The manager signs into the system.
- Manager chooses "Edit Customer" from the menu system.
- Manager scans the customer id card.
- The system cannot find a customer.
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



### Use Case: Print Customer Card

Requirements:  A new customer card can be printed if their original is lost or damaged.

Pre-conditions:  The customer is already in the system.

Post-conditions:  A new customer card is printed for the customer

Normal Scenario:

- The manager signs into the system.
- Manager chooses "Print Customer Card" from the menu.
- Manager enters the unique customer email address.
- If customer is found, then a new customer card is printed.
- The system returns back to the main menu.

Alternate Scenario:

- The manager signs into the system.
- Manager chooses "Print Customer Card" from the menu.
- Manager enters the unique customer email address.
- If customer is not found, the system returns back to email entry form to try again.
- The manager chooses "Cancel" to return back to the main menu.


### Use Case:  Request Lane

Requirements:  The customer can request a lane by scanning their customer card and choosing the number of players.  The other customers then scan their cards as well.  Customers must be registered to play.  If a lane is available it is assigned to the customer group.

Pre-conditions:  All customers are registered and a lane is available.

Post-conditions:  The customers are assigned a lane to bowl on.

Normal Scenario:

- The customer signs into the system.
- The customer chooses "Request Lane" from the available menu options.
- If a lane is available the systems prompts the customer to scan their card.
- The system scans the customer card.
- The customer enters the number of bowlers.
- The system scans the remaining customer cards one at a time.
- After all customer cards are scanned, the system displays the lane number.
- The customer then chooses "Exit" to return back to the main menu.

Alternate Scenario:

- The customer signs into the system.
- The customer chooses "Request Lane" from the available menu options.
- If a lane is not available the systems informs the customer.
- The system returns to the main menu.

### Use Case:  Checkout

Requirements:  When customers are done bowling they need to checkout of the system.  They are prompted to pay via credit card and optionally save their scores.

Pre-conditions:  The customers are done bowling.

Post-conditions:  The customers have payed for their games and saved their scores.

Normal Scenario:

- The customer signs into the system.
- The customer chooses "Checkout" from the available menu options.
- The customer enters the lane number on which they were bowling.
- The system asks the customer if anyone would like to save their score.
- If customer answers yes, then the system displays a list of players to choose from.
- For all customers who want to save their score, choose the player and enter the score.
- Customer chooses "Done" to indicate finished entering scores.
- The system prompts the customer how many ways to evenly split the bill.
- The customer enters 2.
- The system prompts the customer to scan 2 credit cards, each being charged the same amount.
- The system prints receipts and returns to main menu.

Alternative Scenario:

- The customer signs into the system.
- The customer chooses "Checkout" from the available menu options.
- The customer enters the lane number on which they were bowling.
- The system asks the customer if anyone would like to save their score.
- If customer answers no, then the system moves on to collect payment.
- The system prompts the customer how many ways to split the bill.
- The customer enters 1.
- The system prompts the customer to scan 1 credit card to pay the whole bill.
- The system prints receipts and returns to main menu.

Exceptional Scenario:

- The customer signs into the system.
- The customer chooses "Checkout" from the available menu options.
- The customer enters the lane number on which they were bowling.
- The system asks the customer if anyone would like to save their score.
- If customer answers no, then the system moves on to collect payment.
- The system prompts the customer how many ways to split the bill.
- The customer enters 1.
- The system prompts the customer to scan 1 credit card to pay the whole bill.
- The credit card is rejected by the system and prompts the customer to try again.
- The customer uses a different credit card and the system scans it.
- The system prints receipts and returns to main menu.




