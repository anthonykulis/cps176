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
    float someFloat = 1.3434;

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

### Variable Caveats

## 2.5 Arithmetic Operators
