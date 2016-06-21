# Bowling Alley Manager Design Notes
Charles McGuinness  
cmcguinness6 / mcguinness@gatech.edu

## Design Review

For this project, I attempted to find the right balance between classes
that are well designed and limiting the number of
miscellaneous/helper/factory classes that a larger architecture might
use.  As part of that design, I have chosen to use static methods on
some classes as a sort of lightweight factory pattern.

For documentation purposes, I have segregated the classes into 4 stereotypes:

* _Interface_: these provide the entry point into the application from
the user interface, and represent the "contractual" interfaces of the
application.
* _Entity_: these hold data that the bowling alley wants to track over a
period of time ranging from minutes to indefinitely.  Presumably, there
is some backing mechanism, but that is not yet specified.
* _(Null)_: this is data that is created and destroyed over a short
period of time.
* _Utility_: these are the classes that interface with devices or
service providers that are external to the application and usually
invoked via prebuilt libraries.


### UI interface classes

The starting point for the design is the two classes, `Manager` and
`Customer`, which are invoked from the user interface as a result of the
interactions of managers and bowlers. I have not modeled the UI
architecture here, but I presume that a typical MVC design would have
the controller passing events and data to our application to process.
Thus, the methods on those objects are intended to support the
interaction model described in the assignment use cases, and follow
loosely the event-driven model typical of any modern user interface.

These classes are responsible for orchestrating the interaction with the
other classes in the application to carry out the business logic. The
two main classes, `Manager` and `Customer`, represent the entry point to
the application from the user interface layer (the "controller" in some
sense), and support all the functions the users wish to perform.

The assumption is that in most cases the UI will collect all the data
necessary to perform a complete transaction.  There are two exceptions
for this, both involving situations where multiple players need to be
identified and processed.


### Entities


There are several classes which represent the persistent data of the application:

* `Bowler`: this might have been called "customer" in another
application, but since that class name was used I have picked Bowler to
represent the players.  It contains all the long term information about
the Bowler, as well as static methods to find bowlers and instantiate
them (factory classes could be used instead, but it would add complexity
to the diagram without improving the design substantially).  The only
interesting wrinkle is that the class will directly trigger the
`printCard` utility method. Were the design of the card more
complicated, I might introduce more classes/helpers into the design, but
for something this simple it's overkill.  `Bowler` also holds the collection
of saved score history of the player.
* `Lane`: this represents a lane of the bowling alley and tracks its
status (free or not free).
* `Score`: this tracks the scoring of an individual bowler.  Scores are retrieved
from the scoring system at the lane via the LaneScore utility class.
* `BowlingParty`: this aggregates the individual players,
holds the lane they are assigned, and has the start and end times.  It also
uses the `LaneScore` utility class to retrieve the scores of each
player from the lane when play has concluded.
* `Rate`: This holds the table of lane rental rates (by time and day of week)
and is used in the process of computing fees.

### Normal (Transient Data)

These classes track data or processes that has a lifespan of seconds to hours,
but does not need to be persisted indefinitely.

* `Payment`: this serves as a helper class for the `Customer` class to
orchestrate the paying of fees.  It uses the credit card scanner which
produces a `CreditCard` object.  Because there is a physical, asynchronous
interaction with the users, the methods of the class return to their invoker
(`Customer`) to allow the user(s) to prepare for the next step.
* `CreditCard`: emitted from the credit card scanner and used by `Transaction`
to drive the payment of fees. Not retained after transaction is complete.

### Utility Interfaces

These classes wrap the external hardware and services used
by the system:

* `CardPrinter`: accepts a name and customer id, and generates a card along
with the appropriate QR code.
* `VideoCam`: reads the QR code off of the card in front of it and decodes it
back to a customer id.
* `CreditCardScanner`: when the customer slides the card through the scanner,
returns a CreditCard object with the information needed to authorize a payment.
(Note that this design needs to be updated to use EMV chip cards, but that's
for another semester, I suppose).
* `PaymentService`: takes credit card information (from the scanner) and a
payment amount, and charges the card.
* `LaneScore`: given a lane # and player, retrieves the score from the lane.


## Class Specific Details

This section is intended to answer any specific questions that might
arise about the functionality of the classes.

### Manager

The `Manager` class is used to handle the tasks of the manager. As There
is no persistent data at the manager level, it is anticipated that this
will be implemented as a set of static methods, much like a utility class.

The methods exposed are:
* `addCustomer`: Accepts a name and email address from the UI, creates a new
Bowler entity, and then prints a card for the person.
* `printCard`: prints a new card for a bowler.  The UI supplies an email address
which is used to look up the bowler (we assume the one and only manager
knows every customer by sight!), and then the bowler's card is printed.
* `updateCustomer`: The bowler's record is located by email address, and then
is updated with new name (*congratulations on your marriage!*) or email
address (*congratulations on your new job!*)

### Customer

The `Customer` class is used by bowlers at a self-serve station.  Each
station (if there is more than one) can have an instance associated with
it at system boot time, or the customer instance can be created when a
bowler presses the "start here" button in the UI.

The methods that can be invoked are:
* `login`: When the user indicates that they are holding their card in
front of the camera, the login method is called.  It invokes the utility
class for the video camera, which translates the QR code into a hex
number that can be used to locate the bowler.  It either returns a blank
string (for success) or an error code (perhaps the camera could not read
the card, perhaps the bowler's record could not be found, etc.)
* `requestLane`: the primary bowler indicates that they would like
a lane, and the UI has also collected the number of bowlers in total.
It creates a new Bowling party and then associates the primary bowler
with the party.  If the number of bowlers is 1, it returns True to
indicate that the bowling party is complete.  Otherwise, False, to
indicate to the UI that it needs to solicit another player.
* `nextBowler`: called when the next bowler is holding their card
in front of the camera.  Reads the bowler id, and then adds the corresponding
bowler to the party.  Returns True if that was the last bowler (and
they can star playing), False if there's more players to add,
and throws an exception if the bowler cannot be found.
* `getLane`: When the bowling party is complete, this returns the lane
number to the UI to display to send the bowlers on their way.
* `checkout`: indicates that the bowlers for lane X are done and
wish to pay.  This method finds the appropriate bowling party instance,
indicates that play has stopped (thus timestamping the end time)
and then creates a new `Payment` from the bowling party.  The Payment
then returns the total cost, which is returned to the UI.  The users
will determine how many cards they want to use.
* `pay`: The UI passes along the total number of cards, and indicates
that the next card is ready to be scanned.  The card is read, and then 1/nth
of the total cost is charged via the current `Payment` instance.
If there is a payment error, the status is returned.  If the payment
is processed, either Done is True indicating that the fees have all
been paid, or False, indicating another card is needed.
* `saveScores`: a boolean vector is passed in from the UI indicating
which player's scores need to be saved.  After this, the UI interactions are
complete.  The information is passed to BowlingParty, which in turn sends
the scores to the appropriate bowler.

### Bowler

A couple of interesting things about the `Bowler` class:
* When a new bowler is created, it also creates the 4-digit hex id.  The
precise method of ensuring uniqueness is unspecified.
* VIP status and YTD spend are maintained by the Bowler instance.  Updates
as passed in from the Bowling Party at the conclusion of play.  The
mechanism for doing the year end VIP update is not specified.

### BowlingParty

This holds the data about the bowling party and its members.  It also
passes through information to avoid having the payment class having to
talk to both bowling party and bowler (abstracting away the bowler definition
from the payment processing).
