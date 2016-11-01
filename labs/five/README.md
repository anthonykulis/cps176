# Lab Five

## Theme - Database
We will divert from our RPG theme and create a simple class that you can use for simple persistency in later adventures. This will be an extensive lab! It will cover both topics of File IO and Methods. Do not think you can do this lab the night before it is due. This lab, and all subsequent labs will be difficult and time consuming.

This lab will continue until lab 8, incrementing so that upon completion of lab 8, you will have a full functioning flat file database.

The submission file *must* be named `FlatFileDatabase.java` and hence your class name needs to follow that paradigm.

This lab will be complete enough that you can use this class we will create to persist any text based data and hence should be reused until you learn more to extend it outwards.

## Minimum Requirements
You will be required to write a very basic database driver to handle `create`, `read`, `update`, and `destroy` methods (CRUD methods) on a ***flat-file database*** tables. For this lab, you will be able to call upon this class to write and read data from a file. We will have 6 primary methods:

1. `public boolean createTable(String name)` - this will create the table in the database according to the name passed. If the table already exists, it will return false. If there is an error, it will throw an exception for the user to catch. All tables will be stored relatively in a directory named `tables`. The table will have meta-information but be labeled with `#` at the beginning. The `#` will be our indicator we should ignore this row unless doing meta operations. The first meta-information we will use is the labels for each column. We shall cover this more in class.

2. `public void destroyTable(String name)` - this will delete the table and if it does not exist, throw an exception for the user to catch.

3. `public boolean create(String record)` - for now, we will use a `String` as the record to insert. It will be **appended** to the table already opened. If the table is not opened, throw an exception. Realize the user may request a record that doesn't exist.

4. `public String findOne(String value)` - This is our `Read` part of the CRUD operations. We determined that our character name is going to be unique. What we will do so this fits *any* table is *assume* the first column in the table will always be unique. This means you loop the file until you find that key and return that row of data as a string. If no record exists, return the appropriate value.

5. `public boolean update(String key, String value)` - For this method, you will create a temporary `String` to house every record in the table. When encountering our record to update, instead of concatenating the tables record, you will concatenate the updated record and continue onwards concatenating the tables record until you have reached the end. Once you have the entire table in one `String`, you will then empty the file, writing its new contents. This can be tricky! Pay attention how you open a file. For adding records you will need a `File` opened that is in append mode or you will drop it's contents, for update, you will need a `File` not opened in append mode.

6. `public boolean destroy(String key)` - This method will remove the record identified by the `value` passed. Reference the `update` method for this, but instead of writing an update record, simply update it with nothing.


## Tips
* Be declarative
* Be DRY (dont repeat yourself!)

## Grading
This is your fifth of the 8 programming assignments. This means it is worth 25 points.

## Due Date
This assignment will be due November 1, 2016 at 9am. We will use as much lab time as possible to complete this.

## Solution
The solution will be posted on the due date at the due time. Because of so, there will be no extra time afforded to complete this assignment.
