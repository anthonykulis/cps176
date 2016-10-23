# Lab Seven

## Theme - Database
We will continue improving our flat-file database. This lab create our `CharacterModel` class and demonstrate *encapsulation* and introduce *inheritance* via *abstraction*.

This lab will continue until lab 8, incrementing so that upon completion of lab 8, you will have a full functioning flat file database.

The submission file *must* be named `FlatFileDatabase.java` and hence your class name needs to follow that paradigm.

This lab will be complete enough that you can use this class we will create to persist any text based data and hence should be reused until you learn more to extend it outwards.

## Minimum Requirements
Create a class named `CharacterModel`. The classes signature is as follows. I have *black boxed* in some inheritance. For now, create a class named `Model` and `DataModel` exactly as I provide and inside of `CharacterModel`, I complete the inheritance calls for you. You will need to fill out the rest.

`Model.java` ->

```java
public abstract class Model {
  private String _name;
  abstract public String toRecord();
  abstract public String toColumns();
}
```

`FlatFileModel.java` ->

```java
public class FlatFileModel extends Model {
  public FlatFileModel(String name){
    this._name = name;
  }

  public String toRecord(){ return null; }
  public String toColumns(){ return null; }
}
```

`CharacterModel.java` ->

```java
public class CharacterModel extends FlatFileModel{
  public CharacterModel(String name){
    super(name);
  }

  public CharacterModel(String name, String rawRecord){
    super(name);
    // populate the class using the raw record data
  }

  // do accessors and mutators

  // provide a toRecord method that formats the values for record creation

  // provide a toColumns method that formats the columns for table creation

}
```

1. You will need to provide *all* the accessor and mutator methods to the `CharacterModel`. This means you will also need to create all the member variables as well.

2. Create a method named `toRecord` that will provide you a `String` that will be later used in lab 8 for your `create` and `update` methods.

3. Create a method named `toColumns` that will provide the meta information needed for table creation.

4. In the second constructor, use the `rawRecord` to populate your member variables via the mutator methods.

## Tips
* Don't worry about why I did the inheritance here, but if you're curious, I did it so we can use any class that is eventually inherited from `Model` in our FlatFileDatabase.
* Make sure both `Model.java` and `FlatFileModel.java` are in the same level of directory as your `CharacterModel`,

## Grading
This is your seventh of the 8 programming assignments. This means it is worth 25 points.

## Due Date
This assignment will be due November 22, 2016 at 9am. We will use as much lab time as possible to complete this.

## Solution
The solution will be posted on the due date at the due time. Because of so, there will be no extra time afforded to complete this assignment.
