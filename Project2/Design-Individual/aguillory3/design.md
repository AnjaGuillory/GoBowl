<h1>Design Clarification Document</h1>

<p>Classes:</p>
<ul>
<li>Customer</li>
Attributes:
<p>customerCard - carries String. I decided not to make this a class just because if the customer does not have a customerCard then the String would be null. Else when the customer scans the card, the card will hold the proper encoding relating to the customer's ID.

<p>totalForYear - carries an Integer to hold the total in purchases made in order to count for the VIP program.</p>

<p>creditCard - carries a struct to hold credit card</p>

<li>Lane</li>
Methods:
<p>getLanePlayers - gives list of players for that lane for the customer to add scores when checking out</p>

<p>getLaneSessionTime - gives the total session time so that the bill can be calculated accordingly.</p>

<li>System</li>

Methods:
<p>calcBill - the system will calculate the bill as the charge so that the payment processing can then receive a transaction and give receipt</p>

<p>handleBillSplit - handles splitting the bill before setting the bill</p>

<p>setBill - sets the bill in the customer attributes so that the bill will show under the customer's name and would zero out when the bill is paid. </p>

<p>setScore - the system will set the score to the given customer as chosen by the user</p>

<p>addTotalForYear - would add the bill paid by the specific customer to that customer's total purchases for the year.</p>

<li>Date and Time</li>
<p>The date and time utilities are for the system to use to calculate the respective hours and the date to determine the bill calculation </p>
</ul>