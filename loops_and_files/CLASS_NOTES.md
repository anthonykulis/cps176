# Loops and Files

## 4.1 The Increment and Decrement Operator
* You have seen this in chapter 2 under `unary` operators.
  * `++`, `--`
    * Allows us to increment/decrement a number

```java
int num = 0;
num++;
num--;
```

* What you haven't been exposed to is the unary operator as `postfix` and `prefix` notations.

### Unary increment and decrement in postfix notation
* Postfix simply means the operator comes **after** the evaluation of the number.
* Example

```java
int num = 0;

// what is the output?
System.out.println(num++);
```

```java
int num = 0;

// what is the output?
System.out.println(num--);
```

### Unary increment and decrement in prefix notation
* Prefix simply means the operator comes **before** the evaluation of the number.
* Example

```java
int num = 0;

// what is the output?
System.out.println(++num);
```

```java
int num = 0;

// what is the output?
System.out.println(--num);
```

## 4.2 The `while` loop
* Similar in concept to the `if` statement, instead of the code taking a branch on an evaluation of the `boolean expression` found in the `if` statement grammar, the `while` loop instead *returns* to the previous point of execution *while* a `boolean expression` remains true.

* This means our grammar looks like:

```java
while(boolean expression is true) statement
```

* Of course, just like the `if` statement, the statement to execute in the while loop is under scope of the while loop and curly braces are used to denote the scope.
  * Note: For a single statement (eg `num++`), we can omit the curly braces in the same fashion as we did the `if` statement.

* Examples:

```java
while(true){
  System.out.println("Forever");
}
```

```java
int x = 0;
while(x < 10){
  x++;
}
System.out.println(x);
```

```java
while(myObject.getFalse()){
  System.out.println("I will never run");
}
```

```java
int x = 0;
int y = 1;

while(x % 2 != 0 && y % 2 != 1){
  x += 2;
  y += 2;
}
System.out.println(x + ":" + y);
```
### The `while` loop is a Pretest Loop
* This simply means that to enter the loop, the boolean expression must pass the test. In other words, to enter the loop, the boolean expression must evaluate to true.
  * Logically, to stay in the loop, the expression must also evaluate to true.

### Infinite Loops
* An infinite loop means the loop will always evaluate to true.
  * Is this a bad thing?
  * Which loops above are infinite loops?

### Scope Revisit
* By now, you have seen multitudes of scope blocks. You should also know that anything instantiated or declared in a scope block only exists for that scope.

Example:

```java
boolean running = true;
while(running){
  int x = 4;

  // x will print - declared in scope
  System.out.println(x);

  running = false;
}

// x wont print, not declared in scope
// in fact, this is a compile time error because
// of said scope
System.out.println(x);
```

```java
int x = 0;
while(++x < 10);
System.out.println(x);
```

## 4.3 Using the `while` loop for input validation
* This is your [lab 4](../labs/four)

### Concept
* Use the `while` loop to block execution progression until a valid input is reached.

* Without giving away the solution to the lab, follow this example

```java
String input;
int number = -1;

// validate the value - note the initial value of number
while(number < 1 || number > 10){
  input = JOptionPane.showInputDialog("Enter a number between 1 and 10");

  number = Integer.parseInt(input);
}
```

## 4.4 The `do-while` loop
* The `do-while` loop works exactly the same as the `while` loop, but is a **posttest** loop. This means it is guaranteed to enter the loop at least once.

* It follows then our grammar looks as this

```java
// note the semicolon! that is different
do statement while(boolean expression);
```

Examples:

```java
int x = 0;
do {
  // how many times does this print?
  System.out.println(x);
  x++;
}
while(x < 10);
```

```java
boolean f = false;
do {
  System.out.println("Do I run?");
} while(f);
```
## The `for` loop
* Realistically, we use the for loop to iterate a known quantity, although this doesn't have to be the case.

### The grammar

```java
for(Initialization, Test, Update){
  Statement
}
```

#### Initialization
* We start the grammar by initializing a value. This can be done outside the scope of the `for` loop header or inside.

```java
int x = 0;
for(x, x < 10; x++){}
```

```java
for(int x = 0; x < 10; x++){}
```

* This initialization gives us a *starting* point for our loop.

* This can be any data type that the comparison operator will work on, eg `for(char x = 'a', x < 'z'; x++)` is legal.

#### The Test
* The for loop will continue until the test fails. If the test fails *before* entering the loop, it will not enter, hence it is a **pretest** loop.

* The test *should* be a comparison operator of one of the following - `<`, `<=`, `>`, `>=`.
  * The reason you want to avoid the other comparison operators is that sometime you will not increment your update by one, but rather by a passed value. If the update occurs such that it "jumps" more than one, you may bypass your stopping condition

```java
for(int x = 0; x < n; x++) // reasonable
for(int x = 0; x != n; x++) // works, but is bad style
```

#### The Update
* The update is normally a unary operator update, but it could actually be anything that changes the value of the initialized control variable. Since typically we use the for loop to iterate a known quantity, we rarely see updates that are not unary or binary in nature.

### Using Multiple Statements in the for loop
* I believe this was taken from javascript where it was computationally expensive to keep reacquiring values, but you can actually in use multiple values in your initialization.

Example:

```java
double x, y;
for(x = 2, y = 3; x < y; x = Math.pow(x, 3), y = Math.pow(y, 2)){
  System.out.println(x + " : " +y);
}
System.out.println(x + " : " +y);
```

## 4.6 Running Totals and Sentinel Values
* A *running total* is a variable that accumulates with each iteration of a loop.
  * Try this out. Write a short program that prints the average value of every integer from 1 to 10 inclusively. In case your curious, the average is 5.5.
  * Hint, you will need a loop to loop from 1 to 10 and you will need an *accumulator* to sum the previous integer to the next integer. Once complete, divide by 10 and print it out.

* A *sentinel value* is a value that signals when the end of the loop has occurred.
  * Imagine our game where you `Enter 5 to exit`. This is a sentinel value.
  * Honestly, you will never probably use that sentinel concept

## 4.7 Nesting
* Nesting for loops is a loop inside of a loop

```java
for(int x = 0; i < 100; i++){
  for(int y = 0; y < 5; y++){
    //do something 500 times
  }
}
```

* Gotcha moments occur because of poor scope usage
Example

```java
for(int i = 0; i < 100; i++){
  for(i = 0; i < 50; i++){
    // do something forever
  }
}
```

* You can also use any pre-declared scope

```java
for(int i = 0; i < 10; i++){
  for(int j = 0; j < i; j++){
    // how many times do I run?
  }
}
```

## 4.8 The `break` and `continue` keywords

* `break` causes a loop to terminate early

```java
while(true){
  System.out.println("I only print once!");
  break;
}
```

* `continue` cause the loop to stop its current iteration and start another

```java
for(int i = 0; i < 10; i++){
  if(i < 9) continue;
  System.out.println("I only print once!");
}
```
## 4.9 Deciding which loop to use
* Typically the rule of thumb is that if a boolean condition (or null condition) will stop your loop, use a `while` or `do-while` loop. Otherwise use a `for` loop.
  * Later, in CPS215, you will learn recursion. Recursion is a kind of loop that uses methods instead of language constructs. Unlike a loop that runs until a condition is no longer met, recursion relies on stopping conditions. While similar in concept, they are actually orthogonal in practice.

## 4.10 Introduction to File I/O


## 4.11 Generating Random Numbers
