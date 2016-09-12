# Rolling a *n* sided die

## Concept
We need to roll a die and get a minimum value of 1 and maximum value of *n* where *n* > 1. Obviously a die only has integer based numbers, so we will need to keep that in mind for later.

## Random Values
The only way we know so far to acquire a random number is using the `Math` class and its static method `random()`. If we look at the Java 8 Api for the [Math class](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html) we see that `Math.random()` returns a primitive `double` between 0 and 1, inclusively and exclusively. This means we need we will need to adjust our value so it goes from 0 - 1 to 1 - *n*.

## Adjusting the value
Before we adjust the value, I will first baby step our way through this coding process to keep things simple. First, I need to call `Math.random()` so we have a random number stored in a variable of type `double`.

```java
double randomNumber = Math.random();
```

From here on, I will refer to the `random` methods output as `randomNumber`.

Let us imagine for the tutorial that the `randomNumber` was assigned `0.985401134`. Well, `0.985401134` is not between 1 and 20, where 20 is our *n* (20 sided die).

### Scale to 20
We know that `Math.random()` returns a number between 0 and 1, but the 0 is inclusive and the 1 is exclusive. This means that we could possibly have a value assigned to `randomNumber` that is `0.00000000000000`. What will never happen is that we will get a number assigned to `randomNumber` that is greater than or equal to 1. The highest number we can get is `.999999999999999`. That is because a double has a 15 place precision.

So knowing our possible range of values returned from `Math.random()`, we need to adjust this to be able to cover any number from 1 to 20. If we take our output from `Math.random()` as described in the last paragraph and multiply it by 20 (our 20 sided die), we will end up with any number in the range of `0.00000000000000` and `19.9999999999999`. For our tutorial, I will create a new variable of type `double` to hold our scaling output.

```java
double scaledRandomNumber = randomNumber * 20;
```

Again, I will refer to the scaled random number as `scaledRandomNumber` from this point on. Realize that the first number in that range of `Math.random()` is obviously less than 1 and since our die has the smallest number of 1, this wont suffice. Similarly, the biggest number in the range is `19.9999999999999` which means we don't have a `20` value that we can roll. So this wont suffice. This means we need to *shift* this `scaledRandomNumber` value into the proper range of `1` to `20`.

We could write code to look at `randomNumber` to see its value and determine how much we have to add to make it legal, but this would require adding a `1` when `randomNumber` is `0` and `.00000000000001` when it is `19.9999999999999`. This is ugly. It would work, but it is ugly and we dont do ugly. This means there has to be a more succinct way of handling this. The easy way is to simply add `1` to `scaledRandomNumber`. I will save this into a variable named `shiftedAndScaledRandomNumber`.

```java
double shiftedAndScaledRandomNumber = scaledRandomNumber + 1;
```

Now with `shiftedAndScaledRandomNumber` we have a random number between `1` and `20`, but in all actuality, we have a random number between `1.0000000000000` and `20.999999999999`. Since dice do not have decimal places we need to get rid of those, but technically, we now have a random number between 1 and 20. Here are all three lines of code in one example:

```java
double randomNumber = Math.random();
double scaledRandomNumber = randomNumber * 20;
double shiftedAndScaledRandomNumber = scaledRandomNumber + 1;
```

So, we are pretty much done. Being said, let me reduce those 3 code samples into a succinct single line of code - step by step.

First, lets mix `randomNumber` into `scaledRandomNumber`

```java
double scaledRandomNumber = Math.random() * 20;
```

If you look at our first code example, `double randomNumber = Math.random();`, you will realize that the output of `Math.random()` is in `randomNumber`. In our second code example, `double scaledRandomNumber = randomNumber * 20;`, you can also realize that `Math.random()` can replace `randomNumber`. `randomNumber` is just a placeholder for `Math.random()`, so we can drop `randomNumber` for `Math.random()` and have the same effect:

```java
double scaledRandomNumber = Math.random() * 20;
double shiftedAndScaledRandomNumber = scaledRandomNumber + 1;
```

Similarly, `scaledRandomNumber` is just the operation of `Math.random() * 20`, and we use that variable in the `shiftedAndScaledRandomNumber` operation. Just like before, we can drop the variable `scaledRandomNumber` for the operation and have the same result. This means our succinct version of the tutorial is just:

```java
double shiftedAndScaledRandomNumber = Math.random() * 20 + 1;
```

In the above line of code, before we assign the output of `Math.random() * 20 + 1`, we follow basic math order of operations but with a twist. First, `Math.random()` executes. It has to. If we reordered that formula to `20 * Math.random() + 1`, we can see we cannot multiply 20 to a method. It makes no sense. From there, we can see we have a trivial math problem. Using our example return of `0.985401134` from earlier, we can *imagine* the math operation as `0.985401134 * 20 + 1`. This is a simple order of operations and you would do `0.985401134 * 20` and then `19.70802268 + 1` to get `20.70802268`.

Using our imagined `Math.random()` output, `shiftedAndScaledRandomNumber` would be assigned `20.70802268`.

* ***Optional Read - Using alternative approaches to getting our value.***
Our first option it to round the value. If we round the value, we then could suffer going from `1` to `21`. This will cause our roll to be outside of our bounds. You may think to yourself that we could have avoided adding a `1` in the beginning of modifying this number, but if you coded this out that way, you will find then that rounding will give you a range of numbers between `0` and `20`. Being said, rounding the value will not work.

  Another option is to use the floor or ceiling mathematical modifiers. Interestingly, `Math.floor()` will work here. But if you look at the API for `Math.floor`, it returns a double. So our return would actually be between `1.0` and `20.0`. `Math.ceil()` wont work because we have already added `1` and the return is a `double` and we need an `int`. We could have bypassed the addition of `1` and instead of called `Math.ceil()`, but adding 1 with a computer is always going to be faster than calling a method to get the ceiling, so we used that instead.

### Getting the correct data type

From our scaling and shifting section of the tutorial, our imagined value assigned to `shiftedAndScaledRandomNumber` was `20.70802268`. Could you imagine putting that on a 20 sided die? No. A die only has integer based numbers. We know from the declared `shiftedAndScaledRandomNumber` that it is type `double`. We also know we can cast a `double` to an `int` quite easily with `(int)`, so lets do that.

```java
double shiftedAndScaledRandomNumber = Math.random() * 20 + 1;
int randomNumberOfTypeInt = (int)shiftedAndScaledRandomNumber;
```

Now, with that simple cast, we have *truncated* off the decimal portion of the double, no matter the value. This means our `20.70902268` just lost `.70902268` and now is simply `20`. Notice **no** decimal points, no rounding, just `20`. If we apply this logic to our range of numbers that `shiftedAndScaledRandomNumber` could be (`1.0000000000000` to `20.999999999999`), no matter the random number, we will only have the set `{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}`, and hence we have our 20 possible values correctly typed for a 20 sided die.

But wait, we do not need two lines of code to do this. Again, you will notice we are casting `shiftedAndScaledRandomNumber` with `(int)`. We could rewrite that with one line of code.

```java
// THIS WONT WORK!!!!! Not yet at least
int randomNumberOfTypeInt = (int)Math.random() * 20 + 1;
```

You will notice I said this wont work. Why is that? It is because of order of operations again. What we have effectively done is said to `cast the return of Math.random() to type int`. Ok. So, let's break that down. `Math.random()` returns a `double` from `0.000000000000000` to `0.999999999999999`. If we cast that to an `int`, then we are *truncating* not rounding. This means we chop off the decimal and keep the whole part. This leaves us with `0` to `0`. If we then substitute the `0` with `(int)Math.random()`, we are left with `0 * 20 + 1`, and from order of operations, we know that will always give us a `1`. Always getting a 1 is not random.

So to fix this, we need to use parentheses to define the order of operations. This is no different in regular arithmetic if we did `4 * (5 + 4)` to get the value of `36`. So lets fix this.

```java
int randomNumberOfTypeInt = (int)(Math.random() * 20) + 1;
```

Now, from order of operations we have `Math.random() * 20`, then cast that output to a type `int`, then add `1`, which is also of type `int`. From this, on the right hand side of our operator we are left with a random value of type `int`, so we can now assign that to our `randomNumberOfTypeInt` of type `int`. Of course our variable name is excessive, so lets change it to something more meaningful.

```java
int randomRoll = (int)(Math.random() * 20) + 1;
```

There you have it. A random whole number between 1 and 20, inclusive.
