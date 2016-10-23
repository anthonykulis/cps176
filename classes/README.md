# Classes
You have been creating classes since day one. Now we will partailly formalize the approach which will allow you to have re-usable and extensible code.

## Class Signature
We will only concern ourselves in the course with `public` classes and only one signature.

Example:

```java
public class Example{}
```

While modifiers are available, they will not be introduced until the following course. Our keyword `public` states that any other class can create an instance of this class. The next keyword `class` states that this is a class. *Example* is our class name. This means we need to save this class in a file named `Example.java`.  Finally, we use the `{}` to declare the scope of the class.

## Class Constructor
A *Constructor* is a special type of method that defines what a class should do upon instantiation.

```java
public class Example {
  public Example(){
    // do something
  }
}
```

Its signature gets a visibility modifier, and for this course it will only be `public`, followed by the class name. This **must** match exactly.

### Constructor Parameters
You may give a constructor any number of parameters you see fit. Expanding our previous example:

```java
public class Example{
  public Example(String name){
    // do something, preferably with name
  }
}
```

### Constructor Overloading
Similar with methods, you may overload a constructor. Depending on which arguments you pass as parameters determines which constructor is called.

```java
public class Example{
  public Example(){
    // do something
  }

  public Example(String name){
    // do something
  }
}
```
### Constructors are optional
You do not need to provide a constructor. Proof of this is whenever you created a class for course work and simply went into the `main` method.

```java
public class Example {
  public static void main(String[] args){
    // do something
  }
}
```

## The Main Method
The `main` method is optional. It is what is used by the JVM to *enter* the application. If a class does not have a `main` method, it cannot be called directly by the JVM, instead, you must use another class to access it.
  * On a side note, you can have a class with a `main` method and **not** have it be the head of the application. This is useful for testing your methods if you are not using a testing suite.

Now that you understand method parameters, you should realize the `main` method passes an array of type `String`. This array are the arguments used in the command line call of the application via `java MyApp`. Cell 0 is the first argument. So in `java MyApp`, the `args` array will be empty, but if I called `java MyApp dog cat horse`, I will be passed an array of size 3 with the values of `dog, cat, horse` accessible by the variable `args`.

## Scope
By now you should have realized that anything declared inside curly braces belongs to the construct that defined the scope. Classes are no different. This means you can declare variables in the class and have them fully available within that class.

```java
public class Example {
  public int number = 4;
  int anotherNumber;
  private int yetAnotherNumber;
  public final double PI = 3.14;
  public static final double E = 2.718;
  private String name;
  private Example example = new Example();
}
```

In the above I have declared a bunch of *member variables*. They are called *member variables* here because they belong to the class. We do not typically use this term outside the variables belonging to a class.

### Member Variable Modifiers
* `public int number = 4` - here we said the `int` number is publicly  accessible from the class instance. We also said we will set its value to 4. Since it is publicly accessible via the instance, we can simple use `example.number = 6` or however to change its value. Typically this is not a good approach because it violates our `encapsulation` principles of OOP.

* `int anotherNumber` - this member variable is not publicly accessible. Since no visibility modifier is given, it defaults to a protected state only allowing member classes of the package to access it. More on this in a later course.

* `private in yetAnotherNumber` - this member variable is private, meaning only *this* class can access it. This is how we want to encapsulate our data.

* `public final double PI = 3.14` - the `final` keyword here means this double cannot be changed after setting its initial value.

* `public static final double E = 2.718` - the `static` keyword here means this double is a *class variable*. It does **not** need an instance to access it but rather just the class name, e.g. `Example.E` will provide that value.
  * On a side note, `public static void main(String[] args)` should make much more sense on how it works now.

* `private String name` - yes, you can use other classes in other classes. This is called a *composite* class. Another term you will hear is that this is called a `has-a` relationship. Both are the same thing and important to know.

* `private Example example = new Example()` - this is purposely confusing. I wanted to show you can instantiate any class as a member variable. In this case, we are instantiating a composite of the same type.

### The `this` keyword
Whenever we are in an instance of a class, we can use the keyword `this` to signify *this* particular instance. When accessing member variables and methods it is *preferred* to use the keyword `this` over accessing the member variable without. The following example shows why.

Example:

```java
public class Example {
  private int num = 0;

  public void setNum(int num){
    // would num = num make sense?
    this.num = num;
  }

  public void increment(){
    // while no name conflict, syntactically this is preferred.
    this.num++;
  }
}

public class ExampleDriver {
  public static void main(String[] args){
    Example one = new Example();
    Example two = new Example();

    one.setNum(4);

    // which instance in increment does each of these
    // modify? the keyword this is that instance.
    one.increment();
    two.increment();
  }
}
```

#### Returning `this`
You can return yourself!!!! This allows for chaining of methods. If you have a method that returns `void`, it might be wiser to return the class type instead.

Example:

```java
public class Rectangle {
  private double bottomTopLength = 0;
  private double leftRightLength = 0;

  public Rectangle setbottomTopLength(double length){
    this.bottomTopLength = length;
    return this;
  }

  public Rectangle setLeftRightLength(double length){
    this.leftRightLength = length;
    return this;
  }

  public double getArea(){
    return this.bottomTopLength * this.leftRightLength;
  }
}

public class RectangleDriver {
  public static void main(String[] args){
    Rectangle r = new Rectangle();

    /*
      chaining methods in action.
      You do not have to line up the dots to use this,
      I simply did this for space reasons. You can use them
      on the same line - see commented line below
    */
    double area = r.setLeftRightLength(4.0)
                   .setbottomTopLength(5.0)
                   .getArea();

    // r.setLeftRightLength(4.0).setbottomTopLength(5.0).getArea()
  }
}
```

What is happening in the chaining is pretty simple. From the right half of the assignment we use `r` to mutate the left and bottom. This returns `this`, which is `r`. That means we can replace the method call on return with `r` and call the mutator to set top and bottom. Since that returns `this`, we can then use it to get the area, which returns a double, assigning it to a variable `area` of type  `double`.

* Broken down, this is the concept:
```java
// with parenthesis for "clarity"
double area = ((r.setLeftRightLength(4.0)).setbottomTopLength(5.0)).getArea();

// after the setLeftRightLength, this is returned, which is r
double area = (r.setbottomTopLength(5.0)).getArea();

// after the setbottomTopLength, this is returned, which is r
double area = r.getArea();
```

### Accessor and Mutator Methods
Accessors and Mutators are methods that allow us to control how a member variable is updated or read. Since all mutable member variables should be of `private` visibility, this makes compete sense.

Example:

```java
public class Example {
  private int num;
  private String name;

  // mutators
  public void setNum(int num){ this.num = num; }

  public void setName(String name){

    //force to lower case
    this.name = name.toLowerCase();

  }

  // accessors
  public int getNum(){ return this.num; }

  public String getName(){
    //force to uppercase
    return this.name.toUpperCase();
  }
}
```

## Tidbits
* Never create member variables in the class that do not belong to the class. People have a mentality to create a class meant to be reused but test it with the `main` method and put the `main` methods variables into class scope.
