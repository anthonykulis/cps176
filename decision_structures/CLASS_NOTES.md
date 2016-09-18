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
String name = "anthony";
String myName = "anthony";

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
## 3.4 The If-Else-If Statement
## 3.5 Logical operators
## 3.6 Comparing String objects
## 3.7 Variable Declaration and Scope
## 3.8 The Ternary Operator (AKA Conditional Operator)
## 3.9 The Switch Statement
## 3.10 String formatting
