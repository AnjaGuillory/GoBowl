# GoBowl Alley Management: Project Plan

- **Author**: Anja
- **Created**: 6/29/2016
- **Last Revised**: 6/29/2016
- **Version**: 1.0

<table border="1">
<tr>
<td>Version</td>
<td>Description</td>
</tr>
<tr>
<td>1.0</td>
<td>Initial Version</td>
</tr>
</table>
## 1 Introduction
> GoBowl Alley Management System: is used to conduct customer requests as well as information and alley maintenance.


## 2 Process Description

<table border="1">
<tr>
<td>Name</td>
<td>Description</td>
<td>Entrance criteria</td>
<td>Exit Criteria</td>
</tr>
<tr>
<td>Customer Lane Request</td>
<td> Processes the signing in and registration for an open lane for the requesting customer.</td>
<td>
<table border="1">
<li>scan customer card</li>
<li>edit customer information as needed</li>
<li>find an open lane</li>
</table></td>
<td>
<ul>
<li>customer signed in successfully</li>
<li>lane acquired by customer</li>
<li>session time started</li>
</ul></td>
</tr>
<tr>
<td>Adding Customer</td>
<td> Add new customer information to the database as needed for registration and a new customer card
</td>
<td>
<ul>
<li>customer information</li>
<li>upload to database</li>
</ul></td>
<td>
<ul>
<li>customer card print</li>
<li>customer information saved in database</li>
</ul></td>
</tr>
<tr>
<td>Updating Customer Information</td>
<td> Edit customer information upon notification of change in name, address, phone number, etc.</td>
<td> 
<ul>
<li>updated customer information</li>
<li>upload change to database</li>
</ul></td>
<td>
<ul>
<li>updated customer information shown in database</li>
<li>new customer card printed</li>
</ul></td>
</tr>
<tr>
<td>Lane Run</td>
<td> During bowling session, hold bowling party, save scores under each player, as well as the session time for charging purposes.</td>
<td>
<ul>
<li>bowler names</li>
<li>score</li>
<li>session start time</li>
<li>session end time</li>
</ul></td>
<td>
<ul>
<li>list of scores for each</li>
<li>total session time record</li>
</ul>
</td>
</tr>
<tr>
<td>Customer Check Out</td>
<td>
	Charging customer(s) appropriately for session time, reopening corresponding lane for use, VIP status check, and allowing customer to save scores.
</td>
<td>
<ul>
<li>customer credit card</li>
<li>total bill charge</li>
<li>scores list</li>
<li>customer's YTD total</li>
</ul>
</td>
<td>
<ul>
<li>Bill paid in total</li>
<li>Scores saved in database</li>
<li>YTD total update in database</li>
<li>VIP status update if needed</li>
<li>Lane reopened</li>
</ul>
</td>
</tr>
</table>

- *Activity name (verb or verb phrase)*
- *Activity description (concise paragraph)*
- *Entrance criteria (inputs needed for the activity)*
- *Exit criteria (outputs produced by the activity and how you know it has been completed satisfactorily)*

## 3 Team

<table border="1">
<tr>
<td>Role</td>
<td>Responsibilities</td>
<td>Team Member(s)</td>
</tr>
<tr>
<td>Project Manager</td>
<td>Oversees progress and maintenance of project, assuring that the objectives are being met according to design and planning.</td>
<td></td>
</tr>
<tr>
<td>Developer</td>
<td>Writes the classes and their functions according to plan as illustrated in design. Updates and resolves faults and/or errors as need be. Updates behavior according to current design description.</td>
<td></td>
</tr>
<tr>
<td>Tester</td>
<td>Ensures that the behavior is as desired. Flags any misbehavior or unplanned behavior for the developer to research and resolve.</td>
<td></td>
</tr>
</table>