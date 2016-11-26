# Lab Six

## Theme - Database
We will continue extending our flat-file database. This will be easier than the last in such that you only need to write one more method in our CRUD ops.

This lab will continue until lab 8, incrementing so that upon completion of lab 8, you will have a full functioning flat file database.

The submission file *must* be named `FlatFileDatabase.java` and hence your class name needs to follow that paradigm.

This lab will be complete enough that you can use this class we will create to persist any text based data and hence should be reused until you learn more to extend it outwards.

## Minimum Requirements
You will be required to extend our very basic database driver to handle an additional CRUD method, `find` on a ***flat-file database*** tables.

1. `public String[] find(String key, String value)` - This method will allow us to search for all hits of a key that match a value. This means it will need to return an array of type `String` containing each record that matches our key/value pair.

2. `public String findOne(String key, String value)` - While not a new method, you will need to update this method to remove the repeated code use. Simply leverage your new `find` method, expecting an array returned, then simply returning the only item in that array as the proper return type for this method.


## Tips
* Be declarative
* Be DRY (dont repeat yourself!)

## Grading
This is your sixth of the 8 programming assignments. This means it is worth 25 points.

## Due Date
This assignment will be due November 8, 2016 at 9am. We will use as much lab time as possible to complete this.

## Solution
The solution will be posted on the due date at the due time. Because of so, there will be no extra time afforded to complete this assignment.
