# Design Document

*This is the template for your design document. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: Anja
**Created**: 6/30/2016
**Last Revised**: 6/30/2016
| Version | Description     |
| --------|:---------------:|
| V1      | Initial version |

## 1 Design Considerations

*The subsections below describe the issues that need to be addressed or resolved prior to or while completing the design, as well as issues that may influence the design process.*

### 1.1 Assumptions

*Describe any assumption, background, or dependencies of the software, its use, the operational environment, or significant project issues.*

1. Processes will be done within the system, with a few done externally.
2. Database will hold customer and lane data, but no credit card data.
3. Database will be large enough to hold data used for this application
4. User will log in in accordingly as either a customer or a manager.
5. Additions and updates will be saved to the database.
6. Credit card scanner and a video camera for customer card scanning will be available at all times.
7. All charges will be paid.
8. Lanes will function appropriately.
9. Lane availability will be constantly updated.
10. Customer can save scores accordingly upon check out.

### 1.2 Constraints

*Describe any constraints on the system that have a significant impact on the design of the system.*
1. Customer will not have the capability of logging in as a manager.
2. Customer cannot directly access the database.
3. Customer cannot register without a customer card scanned by the video camera.
4. Customer cannot pay bill through automated system - must be done physically by swiping credit card.
5. Manager/Customer cannot login as or logout as another customer.

### 1.3 System Environment

*Describe the hardware and software that the system must operate in and interact with.*

OS: Android 
Hardware: 

## 2 Architectural Design

System will display a user interface with a series of buttons for processing and options.

### 2.1 Component Diagram

*This section should provide and describe a diagram that shows the various components and how they are connected. This diagram shows the logical/functional components of the system, where each component represents a cluster of related functionality. In the case of simple systems, where there is a single component, this diagram may be unnecessary; in these cases, simply state so and concisely state why.*

![](https://lh3.googleusercontent.com/TINyoYh85Qc04P2qPAgofivyrLi54L3DTe1TR9vF_8G9b7S608T8ObZjT2jKUqNuqBfchEa0VqNvE9IryOzvvuVVxbL9mkWky3hHs2D0OOvfOl8pJaHhLO2qSUW3tkVXPJbogYUk3s_wO2eyrAJd4h_ppxE1iVWI0x7CCeOvFns1dEBxw7l1v1i9u37dx3jA0YJ8GWisZJj6aSBJEiUKENrccsNLwaqSUNI32_rAvHO9AMfYonEdIOma5lmzTL9k-QPouyRu-uwfEuphYqRHTuesmHOR0z81rbbEIgzsXP-7jvV2atNldvSFNnMkHuyuI2j5Q1dHFSfTZhypId-xJA__JPhMNGlGLsLrEgCFgIssob35AKEdRQ7Fc2YWQA59UjrBbbRu76ONfsVmd-pfpIPooR82MJzTSdLTBaUVI6rx3u0Y-isnKsMFvlHM_DYfA4KHLsRCrzKd1qZh3hnq2s5b6oQiXVHqY_M3VkI566wIP70TTN9Z1wR-0rJ8fyt5-NVI4R0H8WiTMxcB9aCbRR4_edrJJtf8pTQ2lGFx7z4VVa2XXgImWafGm7dVnsu6d-DCSxHvj9-bXGA7VTtAVUyJ6yFSxt67=w463-h599-no)

customer interface
  requestlane comp used to initiate a request for a lane and invoke a search for a lane
  checkout comp used to end a session for a lane and initiate a charge invocation
  saving scores into database (for their own profile) - used to enter scores into player history. could be automated. 
  request maintenance - initiate a call for lane servicing in case of malfunction
manager interface
  search open lane comp - initiate a database query for a lane with an open status
  select lane comp - invokes a change/update to close status for the corresponding lane in the database 
  lane open - update lane status to open
  charge component - initiates a bill calculation based on date, time, and session duration
  update customer
  add customer
system
  bill transaction - charges bill to customer and opens for credit card transaction and payment processing
  lane search - searches database for a lane with an open status
  customer registration verification - verifies customer through customer card scan
### 2.2 Deployment Diagram

*This section should describe how the different components will be deployed on actual hardware devices. Similar to the previous subsection, this diagram may be unnecessary for simple systems; in these cases, simply state so and concisely state why.*
customer interface 
manager interface

## 3 Low-Level Design

*Describe the low-level design for each of the system components identified in the previous section. For each component, you should provide details in the following UML diagrams to show its internal structure.*
customer interface
  requestlane comp used to initiate a request for a lane and invoke a search for a lane
     
1. click Request Lane
2. Notify manager/system
3. Assign Lane
4. Add players 
5. Start game

  checkout comp used to end a session for a lane and initiate a charge invocation
  saving scores into database (for their own profile) - used to enter scores into player history. could be automated. 

1. click Check Out
2. Enter scores in list of players (if applicable), and save (to database)
3. Notify manager for continuation of transaction

  request maintenance - initiate a call for lane servicing in case of malfunction
1. click Request Maintenance
2. Returns acceptance of notification and turn around time
3. Responds to recipient

manager interface
  search open lane comp - initiate a database query for a lane with an open status
1. click Search for Open Lane
2. Loads from database list of open lanes

  select lane comp - invokes a change/update to close status for the corresponding lane in the database 
1. click on desired lane 
2. click Select 

  lane open - update lane status to open
1. click Reopen for lane assigned to party upon check out

  charge component - initiates a bill calculation based on date, time, and session duration
1. click Charge
2. click Split (if applicable)
	1. click number to split by
1. display full charge
1. number decreases are credit card(s) are scanned

  update customer
1. Search -> Customer
2. Select customer
3. change information accordingly
4. click Save

  add customer
1. click Add Customer
2. fill in new customer information
3. click Save

system
  bill transaction - charges bill to customer and opens for credit card transaction and payment processing
1. bill calculation opens at Charge invocation
2. subtraction as necessary
3. when at 0, close out

  lane search - searches database for a lane with an open status
1. returns corresponding lane

  customer registration verification - verifies customer through customer card scan
1. searches for customer query result 
	1. if null
		1. returns Not registered
	1. if display
		1. returns Thank you

### 3.1 Class Diagram

*In the case of an OO design, the internal structure of a software component would typically be expressed as a UML class diagram that represents the static class structure for the component and their relationships.*

### 3.2 Other Diagrams

*<u>Optionally</u>, you can decide to describe some dynamic aspects of your system using one or more behavioral diagrams, such as sequence and state diagrams.*

## 4 User Interface Design
*For GUI-based systems, this section should provide the specific format/layout of the user interface of the system (e.g., in the form of graphical mockups).*

