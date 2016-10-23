# Arrays
Arrays are nothing more but segments of the program stack reserved for structuring data. Recall that we have two primary data locations in the java runtime, the *stack* and the *heap*. The stack is finite in length, hence why objects are on the heap. Since it is finite, the size of the stack is known ahead of time. Since arrays are part of the stack accessible to us, it follows the size of the array is known ahead of time.

## Structuring Data
So far we have had little concept how to house a lot of similar data. What happens when we need to manage 1000 `int`? Would we create 1000 variables of type `int`? No, we would use an array of type `int` with a size of 1000. Its really that simple.

## Declaring and instantiating an array
Declaring an array is similar to instantiating an object except it uses `[]` instead of `()`. This means the `new` keyword is required as well. One thing different than what you are used to is the type definition in the declaration process. So let us start with that only.

Imagine you needed that array of `int`

```java
int[] nums;
```

That's it. We use the typical type and postfix on the `[]`. These brackets tell the compiler I need an *array of type int* reserved. Right now, we have not said how much, to reserve, but the process has begun. So let us reserve that actual space.

```java
int[] nums = new int[1000];
```

On the right side of the assignment we have used the `new` keyword to invoke an array of type `int` with a size of 1000. You can do the same with any *primitive* or *object*.

Examples:

```java
double[] values = new double[4];
String[] names = new String[10];
Example[] examples = new Example[100];
```

### Initial values of the array
Notice how we did not give the array any explicit values? This would be the same in concept as doing `int num;`. This means if we tried to access a value in the array it would be `null`. Keep that in mind.

But what if we wanted to declare the array with values? Well, we can do that as well. I won't declare 10 values of `String` nor 100 values of `Example` but instead only give a few.

```java
double[] values = {2.0, 1.1, 4.0, 6.3};
String[] names = {"Whitney", "Steve", "Devin", "Nick", "Shay", "Anthony"};
Example[] examples = {new Example(), new Example(), new Example()};
```

When using the assignment portion with `{}` and legal values of the type inside the curly braces, you are assigning values in the same way as you would `int num = 5;`. Now when you access a particular cell in the array, the value will be that you defined.

## Accessing values in an array
Arrays are numerically accessible via an index value of type `int` and are 0 based counting systems. This means the first cell of the array has an index of 0, not 1. This allows means if I declare an array of size 100, the last cell is accessed with the index of 99, not 100.

Since the variable is an array, you can use the `[]` at the end of the variable with an index to access that cell.

```java
// myName would get Anthony
String myName = names[5];
```

What index would we need for you?

```java
String yourName = names[/* index? */];
```

You can also set values in a similar manner!

```java
names[5] = "Anthony Kulis";
```

Or loop to set a long array

```java
int[] fibSequence = new int[100];

// setting both cells 0 and 1 to 1 to meet the rules of fibonacci sequence
fibSequence[0] = fibSequence[1] = 1;

// notice how I start at 2 and go to 1 LESS than the size?
// I start at 2 because I manually set cells 0 and 1. You do not have to do that! (unless its for fib)
for(int i = 2; i < 100; i++){
  fibSequence[i] = fibSequence[i - 2] + fibSequence[i - 1];
}
```

```java
char[] alphabet = char[26];
char letter = 'a';
int i = 0;
do {

  alphabet[i++] = letter++;

  /*
    could also be written as

    alphabet[i] = letter;
    i++;
    letter++;
  */

} while(letter != 'z');
```

### Array Bounds
Arrays have bounds. This means you can only access cells within the bounds set at initialization. If you declare a size 100, you cannot access any cell past 99 nor any cell before 0.

### Array Typing
If you declare an array to be of type `int`, then all cells must be of type `int`. This follows for all primitives but loosens for objects. Since *inheritance* is part of OOP, it is possible to type an array to a type that is a parent of the type you are using. Since all objects in Java are of super type `Object` eventually, we could do the following, although you **NEVER** should. When we learn inheritance and polymorphism, we can then set upper bounds to prevent unseen issues from arising.

```java
Object[] objects = new Object[100];
objects[0] = new Example();
objects[1] = new String("dog");
```

### Array Resizing
Did you declare an array of size 3 and now need 4? Whoops. You will have to create a new array. Does this mean you should declare an array of size one triple zillion billion when you don't know how many you will need, nope. You will run out of finite stack space. So how do you handle this?

#### First, getting the array length
You will not always know how long the array is. This occurs because a user may pass your class the array. So you need a technique to get that length. This is accomplished by accessing the `length` attribute of the array.

```java
String[] names = {"Bob", "Mary", ..., "Some name"};

System.out.println(names.length);

```

#### Copying arrays
The variable used to name an array is a reference to the stack. If an array is of size 3, the variable will point to cell 0 and reserve that address of cell 0, plus the offset of the size. This explains why we are 0 based indices, but doesn't explain how to copy arrays.

```java
int[3] nums = {1, 2, 3};

// does not work
int[4] bigger = nums;
```

We need to manually copy the values from one variable reference plus offset to another variables reference plus offset.


```java
for(int i = 0; i < nums.length; i++){
  bigger[i] = nums[i];
}
```

#### System.arraycopy()
Imagine you did create an array of size 3 and now need 4 cells. Java provides an relatively easy way of handing this.

```java
int[] nums = {1, 2, 3};

// now you realize you need a 4th put in!
int[] temp = new int[4];

// use the System method and copy nums to temp;
System.arraycopy(nums, 0, temp, 0, 3);

// now reference the array in temp to nums
nums = temp;
```

`System.arraycopy()` has a signature of the following: `public static void arraycopy(Object[] src, int srcPos, Object[] dest, int destPos, int length)`.
* `Object[] src` is the source array
* `int srcPos` is the position you wish to start copying from
* `Object[] dest` is the destination array
* `int destPos` is the position you wish to start copying to
* `int length` is the number of items you want to copy from `int srcPos`, not the length of the source array.

### Array Methods
Arrays have no built in methods although we use the keyword `new` in creating them. The keyword `new` simply says "reserve some space" and does not mean it is an object, and hence, an array is not an object, at least in java.



A perfect example of this is in the `main` method. Whenever you write this method, you give it parameters of `String[] args`. These are the arguments passed to the application. You have no control nor any idea how many were passed.

Example - Printing out the `main` methods args:

```java
public class Example {
  public static void main(String[] args){
    for(int i = 0; i < args.length; i++){
      System.out.print(args[i] + " ");
    }
    System.out.println();
  }
}
```

## For loop redux
Now that you have learned arrays, let's rework the `for` loop into a simpler version. This is now available to you because enough people complained to Java to have them put it in. It is called the *enhanced for loop*. I call it an iterator.

Grammar:

```java
for(dataType elementVariable : array){
  statement;
}
```

Example:

```java
// here I use some magic method to get all names in the world as an array of type string.
String[] everyUniqueNameInTheWord = magic.getAllNames();

// now I will just print them out
for(String name : everyUniqueNameInTheWord){
  System.out.println(name);
}
```

## Multi Dimensional Arrays
You probably have thought to yourself, "hey, if I can create an array of any type, can I create an array of any type of arrays?" If you have not, shame on you! But really, yes. Yes you can.

```java
int[][] numsIn2d = new int[4][4];
int[][][] numsIn3d = new int[4][4][4];
// ...
// ...
```

Would you *ever* want to take it to the max? No. Would you ever want to take it past 2 dimensions, no. But you could. You can have *n* dimensions. This means you can have as many as you see fit. I think though, the JVM will max you out and since anyone can create a JVM, it can vary from JVM provider to provider.

So we will limit our scope in class to 2D and you can extrapolate from there.

### Alternative instantiating of 2D arrays

```java
int [][] = numsIn2D = {{1,2},{3,4},{5,6}};
```

This creates an array of `new int[2][3]` with values.

```java
int[] nums = new int[5];
for(int i = 0; i < 5; i++){ num[i] = new int[5]; }
```

This is simply the longer version of `int[][] nums = new int[5][5];`


### Accessing 2D arrays
You can access the the cells of the any dimension array the same way you would a 1D array.

```java
// 2d square array with values 1,2,3,4
int[][] nums = {{1,2}, {3,4}};

//print out contents of array
for(i = 0; i < nums.length; i++){
  for(j = 0; j < nums[i].length; j++){
    System.out.print(nums[i][j] + " ");
  }
  System.out.println();
}

/* The above is the same as
  System.out.println(nums[0][0] + " " + nums[1][0] + " ");
  System.out.println(nums[1][0] + " " + nums[1][1]) + " ");
*/
```

Trying running [TwoD.java](TwoD.java).

#### Accessing a multi-dimensional arrays cell's array length
Notice how in above example I can get a cells' array length by directly accessing that cell, `nums[i]`, and calling length on that. That is because it is an array of arrays of type `int`.  But I can call upon the 1st dimension without that need, again because it is an *array of arrays of type int*.

#### Jagged Array
If you're wondering if arrays need to be rectangular, no they do not.

```java
int[] nums = new int[10];
for(int i = 0; i < 10; i++){
  nums[i] = new int[(int)(Math.random() * 100)];
}
```

The above is totally legal. How could we tell the size of each array in the cell of the first dimension?


#### Variable Length Parameters in Methods
If you are wondering, and I hope you are, you may ask yourself, "What if I needed to pass an unknown length of some type to a method, can I do this or do I need to pass an array?". You can do either! Java provide a syntax to handle this.

To do it, it only requires some simple syntax and follow some basic rules.

```java
public int sum(int... nums){
  // accessing this with the enhanced for loop
  for(int num : nums){
    //do something.
  }
}
```

This is the same as

```java
public int sum(int[] nums){
  for(int num : nums){
    //do something
  }
}
```

You can also pass extra variables, but they must occur **before** the variable length. In essence, you're telling the compiler that anything from here on out is going to be of type whatever and accessible to the variable I give it.

```java
// legal
public int sum(String name, int... nums){}

// illegal
public int sum(int... nums, String name);
```
