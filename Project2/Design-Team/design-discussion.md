# Group Project 1
OMSCS CS6300, Summer 2016  
Anja Guillory - anjag@gatech.edu  
Charles McGuinness - charlesjmcguinness@gmail.com

## Design 1: Anja Guillory

![Design 1](images/design1.png)

### Quick Design Philosophy

Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.

### Pros of this design:

* Lorem
* ipsum
* dolor
* sit
* amet

### Cons of this design:

* consectetur
* adipiscing
* elit

## Design 2: Charles McGuinness

![Design 2](images/design2.png)

### Quick Design Philosophy

The design was made with the intention of being able to trace actions taken at the user interface level
(which is not specified as part of this model) all the way through to the persistent entities and
hardware utility classes.  The interface classes manage the interactions with the UI, and the entity classes
hold the persistent data in the system. A few other classes exist to orchestrate business functions
around a particular use case.

### Pros of this design:

* Relatively small number of objects for a simpler, more understandable design
* Able to explain how each of the requirements is met

### Cons of this design:

* Business logic partially embedded in the "interface" classes rather than being put into free-standing classes.
* Some handwaving around utility classes (e.g., assumes there's a utility class that can read a QR code from a badge and generate the user id number).
* Unclear of all the relationships are modelled correctly.
* Was confused about use of terminology "interface" in assignment, probably should have built real java interfaces (although it seems odd when only one class implements an interface -- overkill?)

## Team Design

![Team Design](images/team-design.png)

From design 1 we took the notion of a centralized object for performing the business logic.  The assumption is
that the amount of business logic is small enough that it makes sense to centralize it.

From design 2, we took some of the  


discusses the main commonalities and differences between this design and the individual ones, and concisely justifies the main design decisions.


## Summary

concisely summarizes the lessons learnt in the process of discussing the designs, in terms of design, team work, and any other aspect that the team members consider relevant.