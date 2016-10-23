# Lab Eight

## Theme - Database
This will finish off your Flat file database!

You will be required to modify your database adapter, `FlatFileDatabase.java` so that it uses your `Model` inherited classes.

The submission file *must* be named `FlatFileDatabase.java` and hence your class name needs to follow that paradigm.

This lab will be complete enough that you can use this class we will create to persist any text based data and hence should be reused until you learn more to extend it outwards.

## Minimum Requirements
You will need to refactor your `FlatFileDatabase.java` source to handle our new classes from lab 7. I provide the new class signatures needed.

1. `public void createTable(Model model)`
2. `public void destroyTable(Model model`
3. `public boolean create(Model model)`
4. `public Model[] find(String key, String value)`
4. `public Model findOne(String value)`
5. `public boolean update(Model model)`
6. `public boolean destroy(Model model)`


## Tips
* Reuse your code. You created `toColumns()` and `toRecord()` for a reason.
* You will need to turn a formatted `String` into a record.
* In  `find` and `findOne`, use your second constructor to easily create the models.

## Grading
This is your last of the 8 programming assignments. This means it is worth 25 points.

## Due Date
This assignment will be due December 1, 2016 at 9am. We will use as much lab time as possible to complete this.

## Solution
The solution will be posted on the due date at the due time. Because of so, there will be no extra time afforded to complete this assignment.
