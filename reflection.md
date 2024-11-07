Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
- What worked, what didn't, what advice would you give someone taking this course in the future?

I overloaded the constructors in the subclasses. Instead of always providing all the parameters (name, address, number of floors, elevator, and others), we can choose just the ones want to specify. Overloading reduces the repetitive initialization and makes writing code more efficient. 

In the subclass Cafe, I overloaded the constructor with one that has only name and address as its parameter and another one with only address, so the user will not need to enter all the inventory values. In the subclass Library, I overloaded the constructor with one that has only name and address as its parameter as well, and a constructor that takes in the pre-existing hashtable, so the user can add an existing hashtable to the library. In the subclass House, I overloaded the constructor with one that does not take in boolean values for having a dining hall and elevator, since many houses do not have a dining hall and elevator.

I tested the override and overload methods I wrote, and they can work properly. I would advise future students to start this assignment early and fully understand the concept of overloading and overriding before starting this assignment, so they can make better decisions about what to overload. 

