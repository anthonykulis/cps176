# If-Else Statements

## 3.1 The `if` statement
* The `if` statement is used to create a decision structure, which allows a program to have more than one path of execution.

### If-Else Grammar

```java
if(boolean expression is true) statement
*optional else statement
```

### Dissecting the Grammar

* `if` - is a keyword. By using this keyword the compiler *expects* the remaining *if-else* grammar or it will throw a compiled time error.

* `(boolean expression is true)` - the keyword `if` tells the compiler that if the following expression is true, then execute the `if` scope.

```java
if(true){
  System.out.println("I am true");
}
```

* The `statement` belonging to the `(boolean expression is true)` is the scoped code that will execute when the expression is true.

* Optionally, we can add an `else` clause to the statement.

  * This `if-else` will always execute the `if` portion

```java
if(true){
  System.out.println("I am true");
} else {
  System.out.println("I will never run");
}
```

  * This `if-else` will always execute the `else` portion

```java
if(false){
  System.out.println("I will never run");
} else {
  System.out.println("I am false");
}
```
  * You are **NOT** required to have an `else` portion.

### Exploring the boolean expression
* In the examples provided so far, I used literal booleans to demonstrate execution of the `if-else` statement. Obviously, if we could only use literals, this `if-else` would be completely useless. The whole idea of `if-else` is to accommodate for values we do not know at compile time but rather learn at run time.

```java
// collect some unknown compile time information
System.out.println("What is your age?");
age = scanner.nextInt();

// decide what to do with that information
if(age > 20){
  party.giveBeerCup();
} else {
  party.kickMinorOut();
}
```

* Here we used the `>` *rational operator* to determine the condition of the statement.
  * `>`, `<`, `>=`, `<=`, `==`, `!=`
  * The `>`, `<`, `>=`, `<=` are pretty self-explanatory and are used in every day math and logic.
  * The `==` and `!=` might be new to you.    
    * `==` means equals to, as opposed to `=` being equals to in math, but ***assigned to*** in Java.
    * `!=` means not equal to.

* Rational operators **only** compare the value stored in the stack!!!
  * This means comparing equality in objects this way only compares their address on the heap!!!
  * This also means any primitive can be compared for equality using these rational operators
    * Trickery ensues! Since type `char` is a primitive, is `a` greater than or equal to `A`?
      * Well this depends on where it ends up in the ASCII or UNICODE tables!
      * Trick when comparing type `char` is to change the case to same case and then compare.

```java
int x = 4;
int y = 4;

// obviously prints `x equals y`
if(x == y){
  System.out.println("x equals y");
} else {
  System.out.println("x does not equal y");
}
```

```java
String name = new String("anthony");
String myName = new String("anthony");

// name != myName - reference addresses differ
if(name == myName){
  System.out.println("name equals myName");
} else {
  System.out.println("name does not equal myName");
}
```

```java
String name = "anthony";

// here we are not assigning the value "anthony" via the variable name, but
// rather assigning the reference address of name to the variable myName
String myName = name;

// name == myName - reference addresses are the same
if(name == myName){
  System.out.println("name equals myName");
} else {
  System.out.println("name does not equal myName");
}
```

### Side Note - Programming Styles
* Java allows us to have a bit of style when coding. Just because we may differ on style doesn't mean the code executes differently.

* In an `if-else` statement, if only a single line of code is to be executed, you may omit the `{` and `}`. This **does not** affect scope.

```java
if(true) System.out.println("Works");

if(true){ System.out.println("Works"); }

if(true)
  System.out.println("Works");

// don't do this one
if(true)
System.out.println("Works");
```

* Similarly, you can do the same for the `else` scope block.

```java
if(false) System.out.println("Something that will never execute");
else System.out.println("Works");

if(false){ System.out.println("Something that will never execute"); }
else { System.out.println("Works"); }

if(false)
  System.out.println("Something that will never execute");
else
  System.out.println("Works");

// don't do this one
if(false)
System.out.println("Something that will never execute");
else
System.out.println("Works");
```

* I highly suggest you do not do "fancy" coding. The entire point to writing code is for the next engineer behind you to come into your code and be able to pick up where you left off. If you try to be fancy to impress her, all you will end up doing is annoying her, annoying your boss she is taking so long to decipher your code, and annoying your wife you are not getting pay raises as frequently as you thought you would.

* Finally, notice how I didn't use a `;` at the end of any `if` nor `else`? This is because they do not belong. A `;` is for ending a statement. If you follow the grammar, you will see that they are not needed.
  * Then you might ask, legitimately, why is there no `;` at the very end of the block? This is because scope (`{` and `}`) blocks do not require `;` as you have noticed with declaring methods or your class.

## 3.3 Nesting IF-Else Statements
* You can nest `if-else` statements
  * Avoid doing *deep* nesting
  * Typically a *linter* will limit you to 5 deep
  * Most software companies will limit you to less in their own linters

```java
boolean isTrue = FakeClass.isItTrue();
boolean isItReallyTrue = FakeClass.isItReallyTrue();

if(isTrue){
  if(isItReallyTrue){
    // do something that seems true and is really true
  } else {
    // do something that is true but not really true
  }
} else {
  if(isItReallyTrue){
    // do something that doesn't seem true but really is true
  } else {
    // do something that isn't true at all
  }
}
```

## 3.4 The If-Else-If Statement
* Alternatively, if feasible, we can *chain* `if-else` statements.
* Useful when we have complex boolean logic

```java
boolean isItSam = FakeClass.isItSam();
boolean isItMary = FakeClass.isItMary();

if(isItSam && isItMary){
  // do something regarding both sam and mary if needed
} else if(isItSam){
  // do something only for sam if needed
} else if(isItMary){
  // do something only for mary if needed
} else {
  // do something regarding neither sam nor mary if needed
}
```

* The above `if-else-if` covers the following truth table

| Condition      |   |  Sam | Mary  |
|----------------|---|------|-------|
| !Sam && !Mary  |   |  F   | F     |
| !Sam && Mary   |   |  F   | T     |
| Sam && !Mary   |   |  T   | F     |
| Sam && Mary    |   |  T   | T     |

* Of course, this is a simple example, it may become much more complicated.

## 3.5 Logical operators

| Logical Operator | Meaning | Effect |

* `&&` - **AND** - Connects multiple boolean expressions into one. All expressions must be true for the overall expression to be true.
* `||` - **OR** - Connects multiple boolean expressions into one. Only one expression must evaluate to `true` for the overall expression to be true.
* `!` - **NOT** - Negates an expression or combination of expressions if using `(` and `)`. This means if it evaluates to `false`, then expression will be `true`, and vice-versa

```java
if(false && true){
  /*
    this will never enter this scope block
    in fact, this will never look at the
    second condition because false and
    anything is always false - this is
    called 'short circuiting'
  */
}

if(true && false){
  // will never enter the scope block
}

if(false || true){
  // this will enter the scope block
}

if(true || false){
  /*
    this will enter the scope block and
    it will short circuit the false portion
    because true or anything is always true
  */
}

if(!true || false){
  // not true or false is false or false - this will not enter
}

if(!false){
  // not false is true, so it will enter
}

if(!false && true){
  // this will enter
}

if(!(false || true)){
  // evaluates as (false || true) -> true and not
  // true is false, so will not enter
}

if(!(false && true)){
  // evaluates as (false && true) -> false and not
  // false is true, so will enter
}

if(!(false && !true)){
  // does this enter? hint: short circuited
}

if(!(false || (!true && false))){
  // does this enter?
}

int x = 5;

if(x > 3 && x <= 5){
  // does this enter?
}

if(x >4 && x < 5){
  // does this enter?
}

if(x > 3 && -x > 5){
  // does this enter?
}

if(Math.pow(2, x) < 129){
  // does this enter?
}

if(Math.pow(2, Math.pow(2, 1/x)) == x){
  //does this enter?
}

if(FakeClass.alwaysReturnsTrue()){
  // does this enter?
}
```

## 3.6 Comparing String objects
* You have better have learned by now that `String` is stored on the heap.
  * Also, you have better have a good understanding that if I wrote `myName == someName` where both of those are equal to `Anthony`, that you are comparing addresses and not values.

* So how do we compare type `String` values?
  * Hint - open Java 8 API and look for `String`

* Fortunately we have learned declarative programming techniques already and you should have a good guess what a good method name should be.
  * `myName.equals(someName)`

* Now write a simple program to compare type `String` literal values **and** reference values.
  * What are your three outputs and why?

```java
public class StringComparison {
  public void static main(String[] args){
    String myName = "Anthony";
    String someName = "Anthony";

    // Step 1 - print out reference value comparison
    // Step 2 - print out literal value comparison

    myName = someName;

    //Step 3 - print out reference value comparison again.

  }
}
```

* Now because *some* people, not naming names, likes to be case insensitive, review the Java 8 API and locate a method for comparing strings without caring about case.
  * Then complete the following program

```java
public class StringCaseComparison {
  pubic void static main(String[] args){
    String myNameUpperCase = "ANTHONY";
    String myNameLowerCase = "anthony";

    // Step 1 - print out literal value comparison being case sensitive
    // Step 2 - print out literal value comparison being case insensitive
  }
}
```



## 3.7 Variable Declaration and Scope
* We are skipping. You can read this on your own. This simply covers when and where you can declare variables which we have covered already.

## 3.8 The Ternary Operator (AKA Conditional Operator)
* One thing that appears frequently is a conditional assignment
* Example

```java
String val = "";

// imagine a user can input any whole number not equal to 0
if(user.getInputValue > 0) {
  val = "positive";
} else {
  value = "negative";
}
```

* The above occurs so frequently that Java (and many other languages) provides a `ternary operator` or also know as `conditional operator`
* Rewritten Example

```java
// imagine a user can input any whole number not equal to 0
String val = user.getInputValue > 0 ? "positive" : "negative";
```

* Of course, like any other `if-else` block, we can nest this.
* Expanded Example

```java
// Now imagine the user can also enter 0
String val = user.getInputValue == 0 ? "zero" : user.getInputValue > 0 ? "positive" : "negative";
```

* I can continue this until all my options are exhausted. On a side note, that can become really confusing and should be avoided.

## 3.9 The Switch Statement
* The `switch` statement is another tool we have available to branch our codes logic.
* Imagine the following chained `if-else` statement

```java
if(characterClassChoice.equals("Warrior")){
  // create a warrior
} else if(characterClassChoice.equals("Sorcerer")){
  // create a sorc
} else if(characterClassChoice.equals("Knight")){
  // create a knight
} else if(characterClassChoice.equals("Priest")){
  // create a priest
} else {
  // throw error because they didn't choose one of our options
}
```

* You can see that as our choices grow over time (eg add a thief class), so will our `if-else-if` chaining.
* Java provides a simpler alternative... with limitations, and that is the `switch` statement

### Switch Statement Grammar

```java
switch(test expression){
  case possibility_1:
  case possibility_2:
  ...
  case possibility_n:
  default:
}
```

#### Introducing the keyword `break`
* The `break` keyword tells the compiler to exit the current branch.
* In the `switch` statement, with each `case` we "branch". Unfortunately, Java doesn't exit the `switch` upon exiting a `case`. It will continue onwards executing each `case` condition after it meets the **first** `case` statement that matches the criteria.
  * This may seem awkward, but it gives the `switch` statement more power.
  * Note `default` doesn't need a break since it is the last to execute.

* Rewritten grammar with `break`

```java
switch(test expression){
  case possibility_1:
    *optional break
  case possibility_2:
    *optional break
  ...
  case possibility_n:
    *optional break
  default:
}
```

### Refactoring our `if-else-if` into a `switch`

```java
switch(characterClassChoice){
  case "Warrior":
    // create a Warrior
    break;
  case "Sorcerer":
    //create a Sorcerer
    break;
  case "Knight":
    //create a Knight
    break;
  case "Priest":
    //create a Priest
    break;
  default:
    // throw an error because they didn't choose a correct option
}
```

### Those caveats/limitations I spoke of
* The `switch` statement **only** evaluates the following data types
  * `char`, `byte`, `short`, `int`
  * As of Java 7, the `switch` statement will now also evaluate a `String` by automatically calling `.equals` method.

## 3.10 String formatting
* Strings are so important in all programming because without them, we'd have to read crazy bytes and what not. Because of so, there are many methods to format a string from something unless to something useful easily.

* Try this.

```java
public class StringFormatting{
  public static void main(String[] args){
    System.out.println("2/3 = " + (2/3) + " -> or better said, 2/3 is two thirds of " + (6/9));
  }
}
```

* You can see that we can continue this string concatenation on forever and it might get ugly.
  * One options is use `placeholders` or also known as `format specifiers`.
  * Note I changed the method name!!!

```java
public class StringFormatting{
  public static void main(String[] args){
    System.out.printf("2/3 = %f -> or better said, 2/3 is two thirds of %f\n", 2/3, 6/9);
  }
}
```

* Now look through the Java 8 API under the `String` class and find a way to prevent the `0.66666666` output and limit it to 2 places
  * output should be `0.66`

* I will not go into this much further but you should read the section to get the idea on what you can do. Alternatively, you can also go to the Java 8 API whenever your are tasked to finding a solution to your number formatting problem.
