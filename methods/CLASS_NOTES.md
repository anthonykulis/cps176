# Methods
We have already used methods, whether we wrote simple ones to create declarative statements for imperative steps, or when we call actions objects perform. Now we will look at methods in-depth. Once understood, methods should be your "go to" tactic for writing code.

## Grammar
You are not required to memorize this grammar but are required to be able to reference it as needed.

[Method Grammar](http://docs.oracle.com/javase/specs/jls/se7/html/jls-18.html)

### Modifiers
Modifiers are simply keywords that modify the methods "functionality". They either limit who can use them, how they become available, what types of objects can use them, what they promise to provide, ...

How we define our modifiers is called the **signature** of the method.

## Visibility
The chapter does not introduce visibility of methods, so I will cover them with three basic concepts.

```java
public static void main(String[] args){}
protected void myProtectedMethod(){}
private int _findBiggestInt(int[] nums){}
```

1. `public` - When a method is declared public any class importing the class containing the public method can use that method.

2. `protected` - Protected in short means only classes belonging to the `package` are allowed to access this. While we haven't learned packaging yet, you may encounter this in your progress. Knowing that this visibility is limited might help you debug an issue you encounter. Omitting the method visibility defaults to this value.

3. `private` - Only the class who owns the method may access this method. This is great to use when you have methods that have no bearing on how a user will incorporate your class. In fact, this is such a great concept that if the user doesn't need to access the method, e.g. it is a helper of some sort, it is expected to be private. Style-wise, I use an underscore to prefix the name of the method. You are not required to do so. I use the underscore so I simply know it is private later in the code. This is useful when trying to debug and when you have lots of methods to remember.

### Membership
I am not 100% if *membership* is the correct terminology, but since I cannot find a formal explanation, I will call it that. When I say membership, I am asking, does it belong to the class or the instance. Any method (or variable for that matter) that is prefixed with the keyword `static` in its signature indicates the method belongs to the class. This means you do ***not*** need an instance to access it, only the class itself.

### Generic access
We will teach generics in a later course, so they will not be required here, but a method may be *generic* such that any type of object with an optional upper and/or lower bounds may access it.

Example

```java
public static <T> uselessGeneric(){}
public static <T extends Comparable> void selectionSort(T[] a){}
```
Since you may encounter this, I will briefly describe it and explain how to use it. The `<T>` portion in the first method simply states this object will use a generic type `T`. The `T` is just made up. It can be `G`, `g`, `O`, but `T` is common. The point of the generic though is to tell the compiler that "I will use a unknown type to finish my work". It is kind of useless in this context.

If we look at the second method it makes more sense. So you know, I have trimmed down the signature for ease of reading so if you reference this elsewhere, you will see extra generic syntax I do not. What we have here is `<T extends Comparable>`. What happens here is that we are telling the compiler we are required to use the `Comparable` class' functionality so any object inside the array `T[]` passed to us must be a *child* of `Comparable`. This in-effect creates an **upper-bound**.

You will learn about inheritance in the next course, so this is only for reference if you venture out into your own programming.

### Return types
A method may choose to return a value. So far, while you were learning to be declarative, we only returned type `void`. Well `void` is not really a type since it is nothing, and hence the compiler doesn't expect anything returned. But we may choose to return any type we see fit.

```java
public int divideInts(int numerator, int denominator){
  return numerator/denominator;
}

public String toString(){
  return "I am a string";
}
```

### Method names
Method names should be concise and descriptive. Later we will learn to name our classes as nouns, so here you will be expected to name our methods as verbs. I prefer to name our methods as *verbSubject* because it is even more descriptive.

Compare the thought:

```java
public String get(String subject){
  switch(subject){
    case 'name': return name;
    // ...
    // ...
    default: //
  }
}

public String getName(){ return name; }
```

### Method Parameters
AKA - `Method Arguments`

Method paramater simply state **what is exactly required** to call this method.

```java
public int square(int n){
  return n*n;
}
```

How could I call `square` without passing a value of type `int`? This makes sense but many people fail to realize this while learning. The parameters listed in the signature are **NOT** optional unlike other languages.


#### Overloading
Overloading a method belongs in a later lecture, but again, you will encounter this repeatedly when using them, so making a side note here will help in the long run.

Imagine:

```java
public class Example {}
  public static void print(String s){}
  public static void print(int i){}
  public static void print(String s, int i){}
}
```

All three of the above methods are named `print` yet have three different sets of parameters. We shall for the sake of discussion call the one with the `String s` parameter our primary method. The second `print` method accepts a `int` instead of a `String`. This means we can call it as `Example.print(4)` as well as `Example.print("my string")`. **Both** of these are legal because the second `print` *overloads* our primary `print`.

Finally, in the third `print`, we have a different set of parameters. We could call this one with `Example.print("my string", 4)`.

We could have modified any of the modifiers as well and as long as the method name remains the same, we have overloaded the method. But realize, the only set of values we could pass as parameters is defined by the parameters found in the signatures. **Depending on which set of parameters used determines the method called.**

1. Type `String`
2. Type `int`
3. Types `String` and *then* type `int`

## Method internals
We have looked at the signature exhaustively, now lets look at the internals.

### Scope
A method's scope is determined by its `{}`. As usual, anything declared inside those curly braces are scoped to that method.

### Scalar (primitive) variables in scope
What is interesting is that the names given to the variables passed in the arguments are available to use within the scope of the method. If they happen to be the same as a variable declared up in the scope chain, they will *shadow* exactly the same as any other scope block would.

Example:

```java
public class Example {
  int x = 0;
  public void increment(int x){
    x++;
  }

  public static void main(String[] args){
    Example example = new Example();

    /*
    Both of these shadow the class variable x
    by using a method variable x. Since we declared
    x in the parameters, it is NOT the same x
    used by the class, no matter how we work it.
    */
    example.increment(4);
    System.out.println(x);

    example.increment(x);
    System.out.println(x);
  }
}
```

#### Reference (Heap) Variables in scope
Unlike primitives, reference variables work on references to an object on the heap. This means if we have a method that takes an object, we are passing it the *reference address* and not the object itself. This introduces a ***VERY*** important concept of *pass by value* versus *pass by reference*.

* In *pass by value* languages, the object is copied into a new instance. This means any work performed on the passed object will ***NOT*** affect the original object, exactly the same how the above primitive example occurs.

* In *pass by reference* languages, the object is not copied, but rather remains on the heap naturally. The reference to that object is passed. Because we can copy references easily, eg `String myString = someString`, and have both references point to the same object, that means both reference variables, `myString` and `someString` can modify the same object.

Example:

```java
public class Square {
  private double sideLength = 0;
  public Square(double sideLength){ this.side = sideLength; }
  public double getArea(){ return square.side * square.side; }
  public void setSide(double length){ square.side = length; }
}

public class Example {

  public static void makeSquareBig(Square s){
    s.setSide(100.00);
  }

  public static void main(String[] args){
    Square small = new Square(1.0);
    Example.makeSquareBig(small);
  }
}
```

* In the above example we pass `small` to our static method in `Example`. While the reference variable in the arguments is named `s`, it points to the same instance that `small` points to. This means any work done on `s` will affect `small`. This is *pass by reference*.

  * To confuse things, if you investigate this on your own, Java will tell you it is not actually *pass by reference* but *pass by value*, or at least when I learned it many years ago it did. What Java did was make a **copy** of the reference. For design sakes, instead of having to determine whether the passed argument was an object or primitive and make a copy or pass, it just copied them by default. But realize if the address was `0x000001` and you made a copy of that address, it still points to `0x000001`. So you may encounter in online discussions this argument and you may see people calling Java *pass by reference* when it is really *pass by value*. For this class, *pass by reference* removes any confusion, and will be the acceptable answer when asked on a test. *Pass by value* will be considered incorrect unless followed by the explanation why.


### Return Values
If a method declares in its signature it will return a type, it **must** return that type, eventually.

Example:

```java
// correct
public int square(int n){
  return n * n;
}

// compiler error - expected return type int
public int cube(int n){
  int cubed = n * n * n;
}

public int fib(int n){
  if(n < 0){
    throw new RuntimeException("Cannot fib out negative values");
  }

  if(n < 2){
    return 1;
  }

  // doesn't return an int immediately, but eventually, so ok.
  return fib(n - 1) + fib(n - 2);
}
```

### Stacking Methods (Hierarchical Calls)
In the above example with `public int fib(int n)` you saw me call `fib` again. This is called recursion. It is a form of stacking method calls. But before I cover that, let's look at a simpler version of stacking that you have already seen.

```java
public class Example {
  public void askForName(){
    _askFor("Provide Name");
  }

  public void askForDescription(){
    _askFor("Provide Description");
  }

  private void _askFor(String prompt){
    System.out.println(prompt);
    //...
  }
}
```

Earlier, I mentioned that a method should be named with a `verbSubject` style. This is correct for `public` consumption. But since in `Example` we are doing basically the same thing twice, but with different prompt values, we could encapsulate that work further by using a `private` helper method. When using a private helper method, it is ok to abstract the naming concept to cover all the other methods that may leverage it. The public consumption is still very descriptive, and the private consumption meant for engineers to read, is still very descriptive at the engineers domain expertise.

#### Recursion
You are not required to know recursion for this class but since it is fun to do, let us step outside what we are required to know and learn some extra material.

Recursion is a method of looping that re-uses the method to solve the same problem but on a much smaller piece of information. Let us revisit the `fib` method.

The fibonacci sequence is a mathematical set of numbers that grows exponentially. It starts as `1, 1, 2, 3, 5, 8, 13, 21, ...`. The pattern is the next value is the sum of the previous two values.  

```java
public int fib(int n){
  if(n < 0) throw new RuntimeException("Cannot fib negative numbers");
  if(n < 2) return 1;
  return fib(n-1) + fib(n-2);
}
```

Look at this closely. You see how it loops? What are the loops stopping conditions? What is the loops `statement` logic?

1. We stop if `n` is less than 0. This means if someone passes a -1 to `fib`, that with out the stopping condition, we would return a 1 for an input of -1. That would not be correct mathematically.

2. We stop if `n` is less than 2.  This is because the value of the next number is the sum of the previous two, but the caveat for our code is the first two numbers are 1's since we cannot add the previous positive `int`s.

3. Our statement is fixed into the `return` portion. Since the sequence is the sum of the previous two numbers, this makes sense. Eventually we will pass a `n` small enough to return a 1.

Lets look at this in more detail with `fib(4)`:

1. 4 is not less than 0, so ignore first `if`. 4 is not less then 2, so ignore second `if`. This leaves us with calling `return fib(3) + fib(2)`.

2. `fib(3)` will call `return fib(2) + fib(1)`. The `fib(2)` will leave us with calling `return fib(1) + fib(0)`, both of which return a 1. With the `fib(1)` call, we will be returned a 1. So we end up with `return 1 + 1 + 1` for the `fib(3)` half of `return fib(3) + fib(2)`.

3. The `fib(2)` in the second half of our first step will leave us with two fib calls of `return fib(1) + fib(0)`, both of which return a 1. This means the second half of `fib(4)` will eventually equal 2 via `return 1 + 1`.

4. With the first half of `fib(4)` equaling 3 and the second half equally 2 means that eventually the initial return statement could be replaced with `return (1 + 1 + 1) + (1 + 1)` which obviously returns 5 and if you look at the sequence `1, 1, 2, 3, 5, 8, ...`, the fourth position (starting with 0) is 5.

### Trailing Information
I will use this section to cover idea that do not really fit into any other section.

* **NEVER** have a method do more than what its name implies
  * A method should *never* print to terminal unless it is designed to do so, e.g. `displayArray(T[] someArray)`
  * A method should *never* force an exit to the program unless it is designned to do so, e.g `cleanUpAndExit()`
* Methods can and should utilize other methods.
  * Methods should not repeat functionality (DRY) found in other methods
* Methods should be the only place imperative code exists, if possible and reasonable.
* When naming public methods, a non-programmer should be able to read the class name (as a noun) and read the method name (as a verb-subject) and understand what is happening, e.g. `CharacterGenerator.askForCharacterName()` versus `MyClass.ask("Character Name:")`
