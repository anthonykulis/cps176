# Java Fundamentals

* How exciting! We have gotten passed all that introductory goodness and now can focus on Java.
* What makes Java different from say C?
  * We have heard the "higher" level concept, the JVM, portability, but what you haven't heard is that Java is *Object Orientated*.

## Object Orientated vs Procedural
* Procedural code is code that relies on a procedure.
  * Step 1 then step 2, etc
* While Java does have some procedural programming that we need to do (called a driver), we will rely on reusable items called Objects

### What is an Object?
* An object is a container of information. We write an object as a *class* and *instantiate* that class as an object or a *class instance*.
* The idea behind an object it that it holds some unique data and methods belonging to its concept.
  * For example - A *bottle* would be an object. A bottle can hold liquid. It can be fitted with a label. It can be capped and uncapped. It can be filled and it can pour. Notice how this is unique to a bottle? Notice how I didn't say it is a soda bottle? We can actually derive a soda bottle from a bottle, but more on this way later.
* Objects provide us with these 4 concepts:
  1. Abstraction
  2. Encapsulation
  3. Inheritance
  4. Polymorphism

* These are called the **The four pillars of Object Orientated Programming**
  * Note we might talk about Inheritance and Polymorphism, but these two topics will belong to the second course in the CPS series.

#### Abstraction
* Abstraction is simply the idea that I can *abstract* out ideas from a model. These ideas may overlap from object to object. This allows us to "pull those abstractions" out to a "lower level" model. This is how we abstract. We will cover this in detail much later.

#### Encapsulation
* Encapsulation is the idea that we do not need to expose "how we did something" to another developer that will use our code. We simply provide them an *API* (Application Programmers Interface) which allows them to call a method of an object and "magically" those said steps are completed. As I introduce how to use a method, I will introduce further the concept of Encapsulation.

## 2.1 Parts of a Java Program
* The book wants to introduce those "black box" items I told you just to do but not understand. At this point, I want those to remain black box. We will cover them in detail later in the semester and I will to introduce them one at a time.

## 2.2 The `print` and `println` methods
* Again, the book is exposing some black box items that I believe are too early to cover. When we get to using objects I will explain these methods.

## 2.3 Variables and Literals
* Variables allow us to create *side effects* of a machine state. These variables provide two purposes.
  1. Variables allow for the user to easily identify the purpose of said variable.
  2. Variables reference data that is meant to be used later (a *side effect*)

* Variables must follow legal Syntax
  * The first character must be one of the letters a-z or A-Z, an underscore `_`, or a dollar sign `$`
  * After the first character, you may use the letters a-z, A-Z, the digits 0-9, underscores, or dollar signs
  * Uppercase and lowercase letters are distinct - `a` is **not** the same as `A`
    * `ageOfDog` is not the same as `ageofdog` or any other permutation
  * Identifiers cannot include spaces

* Literals are values that we wish to store to a variable.
  * `int five = 5;`

* Literals are automatically 'cast' to their literal type by how their syntax.
  * type `String` - `"Im a string"`
  * type `char` - `'a'`
  * Example:
    * `String a = "a";` - the double quotes syntax requires a type `String` to store the literal to.
    * `char a = 'a';` - the single quotes syntax requires a type `char` to store the literal to.
  * some types are determined by their left hand side type
    * `int num = 4;`
    * `long num = 4;`
    * `byte num = 4;`

* Literals can be used anonymously
  * `System.out.println("I am an anonymous literal")`

### Variables and Types
* A variable **MUST** have a type in Java. These types can be *primitives* or *referenced*

## 2.4 Primitive Data Types
* All variables must have a data type
  * This is called *typed*, so not to confuse you will actually t-y-p-i-n-g letters
  * It refers to what *type* of memory we be used and what rules shall apply to it.
* Primitives are often called *scalars*
* These data types fit in the *stack* whether they are *byte wide*, *word wide*, or even require multiple words to fully describe. Repeat ***these variables are stored in the stack***
* Java has 8 primitive types. These are **SUPER TESTABLE** - means you're guaranteed to be tested on this.
  1. byte
  2. short
  3. int
  4. long
  5. float
  6. double
  7. char
  8. boolean
* The first 6 of this list are number types.
* The seventh is for a character
* The eighth is the logical TRUE|FALSE data type.

### The byte
* Size 1 byte
* Covers integers from -128 to 127
  * Outside the scope of this class, but the MSB is the signed bit, this is why 0 to 255 isn't represented
* Number 128 or bigger, or -129 or smaller, will not fit in a byte.
* Declared in code as `byte someByte`, where `someByte` is my variable name and `byte` is its type.

### The short
* Size 2 bytes
* Covers integers from -32768 to 32767
* Declared in code as `short someShort`, where `someShort` is my variable name and `short` is its type.

### The int
* Your most common integer representation - *int* is shorthand for *integer*
* Size 4 bytes (one word on a 32bit system)
* Covers integers from -2147483648 to 2147483647
* Declared in code as `int someInt`, where `someInt` is my variable name and `int` is its type

### The long
* Size 8 bytes
* Covers integers from -9e18 to 9e18
* Declared in code as `long someLong`, where `someLong` is my variable name and `long` is its type.

### The float
* This is the first non-integer number representation
* It is 4 bytes wide
* Covers floating numbers (decimals) from +/-3.4e-38 to +/-3.4e-38 with 7 digits of accuracy
* Declared in code as `float someFloat`, where `someFloat` is my variable name and `float` is its type.

### The double
* This is the most common decimal type used
* It is 8 bytes wide
* It covers floating numbers from +/-1.7e-308 to +/-1.7e308 with 15 digits of accuracy
* Declared in code as `double someDouble`, where `someDouble` is my variable name and `double` is its type.

### The char
* Size 2 bytes
* Represents a character in unicode - not ascii, hence the two bytes instead of 1
* Declared in code as `char someChar`, where `someChar` is my variable name and `char` is its type.

### The boolean
* Size 1 byte
* Represents a TRUE|FALSE value
* Declared in code as `boolean someBoolean`, where `someBoolean` is my variable name and `boolean` is its type.

## Coding example of these 8 Primitives

```java
public class PrimtiveExamples {

  public static void main(String args[]){

    // byte example
    byte someByte = 100;

    // short example
    short someShort = 900;

    // int example
    int someInt = 10000;

    // long example
    long someLong = 10000000000000000000;

    // float example
    float someFloat = 1.3434f;

    // double example
    double someDouble = 1.2345678;

    /*
      char example
      notice the single quotes!
      double quotes will change the right hands side data type to a String - not a char
    */
    char someChar = 'a';

    // boolean example
    boolean someBoolean = false;

  }
}
```

### Variable Assignment and Initialization
* Initialization occurs when the variable is allocated space and assigned an address.
  * The amount allocated depends on the primitive size and some underlying Java information that is beyond the scope of this class (headers, etc)

* Assignment of values occur when the literal right hand side (or possibly another variable of the same type), is assigned via the assignment operator to the left. The right hand side type must match (or be capable of being converted to) the left hand side type.
  * Assigning a literal - `int num = 3;`
  * Assigning a variable to a variable - `int anotherNum = num`;
    * In this case, the value of `num` is given to the value of `anotherNum`
    * This means if I change `num` to 4, the value of `anotherNum` remains 3.
      * Later, we will see *reference variables* where the above is ***NOT*** true.

* Java will default variables not initialized to the typed representation of 0
  * `int num;` will be typed and set to a default value of 0
  * `String someEmptyString;` will be typed and set to a default value of `null`
  * `null` and `0` both have the same "value" but will need to be referenced as their type indicates.

### Variable Caveats
* I think this is obvious, but variables only hold one value at a time.
```java
int four = 4;
four = 5;

// what is the value of four?
```

## 2.5 Arithmetic Operators

* Three types of arithmetic operators
  1. Unary
  2. Binary
  3. Ternary

### Unary operators
* Only require one operand
* Eg: `-5` or `-number` where `number` was defined as `int number = 5;`
* List -
  * `+` - positive
  * `-` - negative
  * `++` - adds 1 to value
  * `--` - subtracts 1 from value
  * `!` - negates boolean value
* Note: `- 1` or `+ 1` does not work. Unary operators must "touch" the operand they function on. This means no spaces.

```java
public class UnaryOperators {
  public static void main(String[] args){

    // unary - operator to make negative number
    int number = -1;

    // unary + operator makes the number positive
    number = +1;

    /* unary -- subtract one, making number now equal to 0.
       realize, you do not need to assign the change for it to take place.

       same as number = number - 1;
    */
    number--;

    /* unary ++ adds one, making the number now equal to 1.
       as with the -- operator, you do not need to assign this operator for
       changes to take affect

       same as number = number + 1;
    */
    number++;

    boolean falsey = false;

    // unary ! flips boolean values
    falsey = !falsey;
  }
}
```

### Binary Operators
* Not binary as in 0100101, but binary in that it works on two operators.
* Eg: `sum = 3 + 5;`
* List -
  * `+` - adds two numbers
  * `-` - subtracts two numbers
  * `*` - multiplies two numbers
  * `/` - divides two numbers
  * `%` - remainder of two numbers, pronounced *Modulus*

* While the addition, subtraction, multiplication, and division are trivial, modulus can be tricky

```java
public class ModulusOperator {
  public static void main(String[] args){

    int number = 108;

    /*
      to highlight the most used reason for modulus we will loop from number
      to 0 and print if the next number is odd or even. The trick here is to
      realize that any number under modulus 2 is either 0 or 1. If the remained of any number divided by 2 is 0, then it must be an even number.
    */
    while(number >= 0){

      // even!
      if(number % 2 == 0){
        System.out.println(number + " is even");
      }
      // odd
      else {
        System.out.println(number + " is odd");
      }

      number--;
    }
  }
}
```

#### Caveats with Integer Division
* Imagine I had the following - note this will not compile, so dont waste your time trying... yet!

```java
  public class Caveat {
    public static void main(String[] args){

      int threeQuarters = 3/4;

      // what does this print out?
      System.out.println(threeQuarters);

      // what does this print out?
      System.out.println(3/4);

      double threeFifths = 3/5;

      // what does this print out?
      System.out.println(threeFifths);

      // Tricky one here - can you figure out what fourFifths will print as?
      double fourFifths = 4/5;
      int castDown = fourFifths;
      fourFifths = castDown;

      System.out.println(fourFifths);

    }
  }
```

* Real numbers can be *cast* into Integer numbers losing precision - `3.4 -> 3`
* Integers can be cast up to real numbers `1 -> 1.00`

### Order Precedence
* Same as regular math (eg PEDMA)
* Highest to lowest
  1. `-` - unary negation
  2. `* / %`
  3. `+ -`

* Associativity of operators is as to be expected as well
 1. `-` - works on number to right of it (right to left)
 2. `* / %` - left to right
 3. `+ -` - left to right

### The Math Class
* You will notice not all match operators were stated.
* The `Math` class covers the more *complicated* math functions
  * `double result = Math.pow(2.0, 4.0);`
  * `double result = Math.sqrt(9.0);`

## 2.6 Combined Operators
* Some things get annoying to type repeatedly
  * `number = number + 1`
* Java provides *shortcuts* via the *combined operators*
  * `number += 1` - same as `number = number + 1;`
  * `number *= 2` - same as `number = number * 2;`
  * `number /= 16` - same as `number = number / 16;`
  * `number -= 5` - same as `number = number - 5;`
  * `number %= 2` - same as `number = number % 2;`
* Notice how each example above *reuses* the variable being operated on? That is a must when using combined operators
* You can also expand this with more binary numbers
  * `number %= 2 + 5` - same as `number = number % 2 + 5;`
* Try

```java
public class Experiment {
  public static void main(String[] args){
    int number = 4;
    number += 3 % 2;

    // Is it 5 or 1? Why?
    System.out.println(number);
  }
}
```

## 2.7 Number conversion
* I have already hinted on this when showing how a number can be cast.
* Highest to lowest
  * double
  * float
  * long
  * int
  * short
  * byte
* If we cast to a lower level number we can lose precision or value. I hope this is intuitive when thinking about the size of each primitive.
* Going downwards in size of type is called `narrowing conversion`
  * Java will throw an error on narrowing conversion
* Going upwards in size of type is called `widening conversion`

### Cast operators
* So far you have seen automatic casting, but we can do it manually.
  * `double d = (double) someInt;`
* Since we cannot cast down (narrowing) automatically, manual casting may be required.
  * Try to now code the above class `Caveat`, fixing the downcasts using manual casting.

### Mixed Integer Operators
* Java has some gotcha moments!  

```java
short firstNumber = 10,
      secondNumber = 20,
      thirdNumber;
```

* If I add the first short to the second short, the resulting data type should be a short right?
  * Well no. Its an `int`, and hence  `thirdNumber = firstNumber + secondNumber` would cause an error.
  * Remember, you are assigning the **OUTPUT** of the arithmetic operation to the `thirdNumber`, the math operation can occur without the need to store its value in a variable. The storing of the value is a `side effect` ***separate*** from the action of doing the addition.

## 2.8 `final` Keyword
* The `final` keyword is used to make a variable into a constant
* A constant cannot be changed during runtime
  * Remember, runtime is as the program executes and compile time is as the program compiles
  * Constants must be initialized with a value
    * `final double PI = 3.14;`
  * Use constants in a logical setting, eg `double balance = amount * .069`. Here, `.069` would make more sense if it was a constant `final double interestRate = .069;`

## 2.9 The `String` class
* We have seen 8 primitives dealing with numbers, true|false, and bytes.
* Yet if we have say a name `Anthony Kulis`, we cannot store that in any of those primitives.
  * Since we cannot store that in a primitive, we need to use an `object`
  * An *object* is an **instance** of a *class*
* The `String` class has many *methods* allowing us to use a string.
  * These methods are known as mutators and accessors - but more on that later.

### Difference between a Class and an Object
* The programmer writes the Class.
  * They determine what attributes the class must have  
    * Eg `volume` in a bottle
  * They write methods to access and mutate those attributes
  * Think of the class as a blueprint of the object

* The programmer then *instantiates* the class - this actually happens during runtime
  *  `String dogName = new String("Cujo");`
  * During runtime when the Java Virtual Machine encounters the above line, it translates the class into an object. This object is then stored in what is known as the *heap* and a reference address to that object is stored in the *stack*
    * The above is *very, very, very* important to remember

  * Because some things occur so often Java has built in some short cuts.
    * `String dogName = "Cujo";` is the same as `String dogName = new String("Cujo");`
    * But this doesn't work for any object, only a string since anything in-between `""` is a *string literal*
      * In fact, any literal assigned to the corresponding object works.
        * `double` is primitive but `Double` is the object, so `Double d = 34.4;` works as well.

* Java built-in classes can be found at the Java API.
  * Be sure to look at the API for your version of Javas SDK
  * You can find the version by going to the command line and typing `java -version`
    * The output will be separated by periods, eg `1.8.3`, the second set of numbers, in this case `8`, will be the JDK version. So I would reference the Java 8 API
    * The [Java 8 API](https://docs.oracle.com/javase/8/docs/api/)
    * Also make sure to reference the SE, EE, or ME release depending on your SDK used.
      * In class, we use the Standard Edition (SE)

### Static Classes
* If you have been paying attention you noticed I did something similar to `String dogName = "Cujo";`. This is called *instantiation*. Yet you have encountered some objects in your practice coding that you can just call without instantiating first, eg `System` from `System.out.println`. This is because the `System` class is declared to be static using `static` keyword. Declaring something static, whether it be a class, variable, or method means only one instance and no more of the statically declared item will exist during runtime. Being said for a class, you can call it by its class name instead of a variable instance. We will cover this in detail later, but for now, realize that if it is static, this is how you can call it.


## 2.10 Scope
* For Java scope is pretty simple. In other languages, *javascript* for example, scope confuses most programmers who are new to it. The reason for it is because they do not learn it well here.

* Every variable, primitive or object, has scope. In fact, we can have *anonymous* methods and classes in Java 8 that in-effect, provide us more control over scope.

* Imagine scope like this..
  * Look at the class rooms clock. Do you notice how you can see the clock and many other things surrounding the clock?
  * Now cup you hand around your eyes like a monocular and close your hand down until you can only see the clock.
  * The difference of the two is scope. Scope defines what parts of the program can be seen by other parts of the program. Fortunately for Java, defining and limiting scope is trivial to do.

```java
// the curly braces "opening" and "closing" ScopeDemo define the classes scope
public class ScopeDemo {

  String classScope = "I am available to the entire class and known as a class variable";

  // the curly braces opening and closing the main method define the methods scope
  public static void main(String[] args){

    String mainMethodScope = "I am available only inside the main methods scope";

    // the curly braces opening and closing the if statement define the conditions scope
    if(true){
      String ifStatementScope = "I am available only inside this if statement";
    }

    // this println will work fine. We are inside the classes scope
    System.out.println(classScope);

    // this println will work fine. We are inside the main methods scope
    System.out.println(mainMethodScope);

    // this will create a compile time error because we the variable was defined inside the if
    // statements scope. since we are out of that scope (closing curly brace), the variable is not available
    // for use.
    System.out.println(ifStatementScope);
  }

  // the curly braces opneing and closing this method are only available to this method
  public static void anotherMain(String[] args){

    // this println statement will work fine because we are in the classes scope!
    System.out.println(classScope);

    // this println statement will cause a compiler time fail because we are not in the main method
    // and hence the mainMethodScope variable is not in our current scope!!!
    System.out.println(mainMethodScope);
  }
}
```

## 2.11 Comments and Documentation
* You've seen this now and should intuitively understand it.
* Comments are notes we can leave about what our code is doing.
* The compiler will ignore them
  * Caveat - some "pre-compilers" will look for comments created certain ways and translate them into useful information. One example of this is how the Java 8 API is auto created. We will not cover this in class, but you can google "how to create java API Documentation" if you are interested. Many businesses will require this when you are writing libraries.

* Two methods to create a comment: `//` - inline and `/* comment here */` - block

```java
// I am a inline comment
int x = 4;

// every line I want a comment I have to start it with the double slash. Everything to the right of the double slashes on that line will be commented out

double y = 3.4; // I can even start the inline comment later

/*
  I am a block comment. Using the slash-star to start the comment block
  everything I type until the star-slash will be commented out.
*/
int x = 4;

String confusing = "I can even " + /* break up a line */ " and have legal code."; /* But I suggest you dont do that. Ever. */

```

## 2.12 Programming Style
* I dont want to cover programming stye. The reason is for this is well beyond the scope of this class.
* Typically a good software company will have what are called *linters* for the style they want. As you get used to the IDE you can run your own linters and you will see that if you violate the style of the linter the IDE will highlight the "error".
  * In fact, online tools will lint your code upon a push request to the repository. If it fails this test, your request will be rejected.
* There is one thing a linter is not good at catching and that is *imperative* versus *declarative* style. When you learn how to write methods, we will cover this in detail.

## 2.13 Reading Keyboard Input
* So we need to read keyboard input. This makes sense.
* Mini-quiz - What primitive would we use to read a keyboard input?
  * Hopefully you immediately realize that is a trick question.

* Since no primitive covers reading keyboard input, we obviously need a class to do it for us.

* If you recall a few practice labs ago we used the `Scanner` class.
  * Lets go to the [Scanner API](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)
  * We shall go over this page in detail.



## 2.14 Dialog Boxes
## 2.15 Common Errors to Avoid

# WARNING - FINISHING CHAPTER 2 REQUIRES AN UPCOMING TEST
