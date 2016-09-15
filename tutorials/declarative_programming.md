# Declarative Programming
While writing code is a science, being declarative while you write code is an art. We want to avoid confusing imperative logic until we absolutely must handle it, and when we do have to become imperative, we want that to be as small and concise as possible. This means before we worry about the nitty-gritty, we think about attacking our problem from the top, from "black box" ideas. Our initial black box ideas should be very basic, eg: `doWork()`, `jump()`, or even `askForUserName()`.

## Attacking the top layer
If you imagine a text base game with character generation, the first thing we probably want to do is create the class for character generation.

```java
public class CharacterGeneration {
  public static void main(String[] args){

  }
}
```

There, done. We have a class to work with and I threw a main method in so we can use it as a driver. Pretty simple so far.

When thinking about how to create a new character, the first thing we'd probably want to do is to ask "What is your character's name?". Instead of writing out the print statement "Whats ....", then scan in the user result, then store that result in a type `String`, lets just *black box* the concept. Let us simply `askForCharacterName()`.

```java
public class CharacterGeneration {
  public static void main(String[] args){
    askForCharacterName();
  }
}
```

Now, some of you reading this will immediately realize an issue with instance/class operations. That is fine. Let's leave that our for right now. We will handle it soon.

The next thing we probably want to do is ask for a character description. Typically in RPGs, especially text based ones, users like to describe their character. So lets follow our same pattern as with asking for a character name.

```java
public class CharacterGeneration {
  public static void main(String[] args){
    askForCharacterName();
    askForCharacterDescription();
  }
}
```

Ok. This is starting to take shape. In a RPG, a character is going to need random `int`s assigned to their attributes. Some games may allow for the user to manually assign points as they see fit, but for our game, we will just randomly assign them. Reading this last sentence, it makes sense that we will  `randomlyAssignAttributes`. See how that is very descriptive? This is what we want. So lets write that in.

```java
public class CharacterGeneration {
  public static void main(String[] args){
    askForCharacterName();
    askForCharacterDescription();
    randomlyAssignAttributes();
  }
}
```

This seems like that would be it to create a character. Maybe some games will do more, ours wont. But there is still one thing we need to do and that is print our the character's stats. But since we have Java, we know that the `toString()` method can be overloaded and we can simply print by using `System.out.println(character)`, so lets put that in.

```java
public class CharacterGeneration {
  public static void main(String[] args){
    askForCharacterName();
    askForCharacterDescription();
    randomlyAssignAttributes();
    System.out.println(character);
  }
}
```

That's it. We have a fully functioning character generation in *concept*. We obviously have lots of compile time errors, so no need to compile yet. But we knocked of that top layer of *black boxes*. But before we go into the next layer, let's make our code compilable.

### Making the code compilable

The first thing glaring issue is that we have no methods even though we are calling them. So lets add them in with the assumption of `public` visibility and `void` returns except our `toString` method which is overloaded from `Object`.

```java
public class CharacterGeneration {

  public void askForCharacterName(){}

  public void askForCharacterDescription(){}

  public void randomlyAssignAttributes(){}

  public String toString(){
    return "";
  }

  public static void main(String[] args){
    askForCharacterName();
    askForCharacterDescription();
    randomlyAssignAttributes();
    System.out.println(character);
  }
}
```

Ok. I have added in the return type of `String` for `toString()` but just returned an empty string to make it legal. Notice how all the methods except main are *instance* methods? This means I need an instance of `CharacterGeneration` to use them. So let's do that and tidy up our main method.

```java
public class CharacterGeneration {

  public void askForCharacterName(){}

  public void askForCharacterDescription(){}

  public void randomlyAssignAttributes(){}

  public String toString(){
    return "";
  }

  public static void main(String[] args){

    // create instance of this class so we can use its instance methods.
    CharacterGeneration character = new CharacterGeneration();

    character.askForCharacterName();
    character.askForCharacterDescription();
    character.randomlyAssignAttributes();
    System.out.println(character);
  }
}
```

There we go. 100% legal code. Of course it doesn't do anything of practicality, but we can now dive into the instance methods, or our second layer of *black boxes*.

## Second layer of black boxes
I will cover each method as a sub-section to this sub-section.

### Character Name
Of course, we need to ask for, scan from terminal, and store the character name. So let's write that pseudo-code in. I will not code it because this is actually a solution to an ongoing course's homework, but for the tutorials sake, imagine it is code.

```java
public void askForCharacterName(){
  /*
  Ask for character's name
  Scan user input from terminal
  Assign to an already initialized variable `String characterName`
  */
}
```

Pretty simple, yes? But you may say, "That is not declarative, it is imperative". Of course, but we shall make it declarative soon enough. Also, if you read my comments, you will realize I said "an already initialized variable". Hint, hint. We will need to scope that variable appropriately, but we will do that later as our code unfolds.

### Character Description
Again, same as for the name, we need to ask for the description, scan it from the terminal, then store it an a variable.

```java
public void askForCharacterDescription(){
  /*
  Ask for character's description
  Scan user input from terminal
  Assign to an already initialized variable `String characterDescription`
  */
}
```

### Randomly Assign Attributes
Ok, we need to assign a random value to attributes. We will make the assumption that we are rolling a 20 sided die and that the attribute we are affecting will have a minimum `int` value of 5 and a maximum value of 25.

```java
public void randomlyAssignAttributes(){
  /*
  Roll for attribute strength
  Roll for attribute intelligence
  ...
  ...
  ...
  Roll for attribute defense
  */
}
```

Again, pseudocode is required here for the assignment purposes, but imagine that is legal code that gives an `int` value of 5 to 25.

### Overload toString()
Pretty simple intro stuff here, we need to overload this class' `toString()` method so that when we call it the user gets something meaningful instead of an instance address.

```java
public String toString(){
  /*
  return [characterStatSheet];
  */
}
```

Again, because of assignment requirements, I have excluded that actual code for pseudocode, so use your imagination.

### Turning imperative to declarative
So you may have noticed that I repeat my code every now and again in the imperative steps. This is where we break that out and tackle our second layer of *black boxes*. In the `askForCharacter....` methods, you see I do that same thing twice, but with different prompts and different variables to store the response. Let us refactor that into another black box by adding a method `_askFor(String prompt)`.

```java
public class CharacterGeneration {

  ...
  ...
  ...

  private String _askFor(String prompt){
    /*
    prompt user
    scan input from terminal
    return response
    */
  }
}
```

This now allows us to reduce both of the `askForCharacter...` methods.

```java
public void askForCharacterName(){
  characterName = this.askFor("Character Name: ");
}

public void askForCharacterDescription(){
  characterDescription = this.askFor("Character Description: ");
}
```

And just like that, our methods internals are declarative. So let's look at the second repetitive portion, rolling for attributes.

While you may be thinking that the math to get to a random `int` between 5 and 25 is `(int)(Math.random() * 20) + 6)`, and if we moved that into a method `_roll()`, it may be just more code and just as much repetitive, and you'd be correct. But the advantage here is we decided to change the roll from a random `int` ranging from 10 to 30, it is only one line of code to change instead of how ever many attributes we have. So lets break that out by adding a new method `_roll()`. Please note, that if you're reading this and not in my 100 level class, they haven't learned loops, arrays, nor class creation yet, so yes, there are easier ways, this is only a tutorial on being declarative.

```java
public class CharacterGeneration {
  ...
  ...
  ...
  private int _roll(){
    return (int)(Math.random() * 20) + 6;
  }
}
```

And then let's replace that in our `randomlyAssignAttributes` method.

```java
public void randomlyAssignAttributes(){
  strength = this._roll();
  intelligence = this._roll();
  ...
  ...
  ...
  defense = this.roll();
}
```

There we go. Very descriptive and declarative code. Our helper methods have been reduced to their minimal work required, so the imperative logic is small and easily manageable. Lets look at our class so far. It still needs a bit more work.

```java
public class CharacterGeneration {

  public void askForCharacterName(){
    characterName = this.askFor("Character Name: ");
  }

  public void askForCharacterDescription(){
    characterDescription = this.askFor("Character Description: ");
  }

  public void randomlyAssignAttributes(){
    strength = this._roll();
    intelligence = this._roll();
    /*
    all the other attributes get filled in the same way
    */
    defense = this._roll();
  }

  public String toString(){
    // Whatever the rules required is built into this string.
    String characterSheet = "";

    return characterSheet;
  }

  private String _askFor(String prompt){
    /*
    prompt user
    scan their input
    return the result
    */
  }

  private int _roll(){
    return (int)(Math.random() * 20) + 6;
  }

  public static void main(String[] args){

    // create instance of this class so we can use its instance methods.
    CharacterGeneration character = new CharacterGeneration();

    character.askForCharacterName();
    character.askForCharacterDescription();
    character.randomlyAssignAttributes();
    System.out.println(character);
  }
}
```

There we go. Our character generation done declaratively. But it won't run. We are missing variables!!! Now, if you're like me and hate side effects we could go pure functional here and modify our return types, etc, but since that is WAY BEYOND the scope of this class, let's figure out where we need to put our variables. Here is my hint to you - think scope. We need the `characterName`, the `characterDescription`, and all the attributes (`strength`, `intelligence`, etc) in different methods. So we cannot declare them in a method or we'd lose scope. This means we need declare them in the class. This may be new to you, but bear with me. When we get to creating classes, you will understand why that is legal, but for now, trust me.

Lets identify our variables that we naturally created.
1. `characterName`
2. `characterDescription`
3. `strength`
4. `intelligence`
5. `defense`

Of course for the attributes I used the ellipsis `...` to signify there are more, but for the tutorials sake, let's imaging only those 3 attributes. Now I will define them at a class level scope.

```java
public class CharacterGeneration {

  // We know characterName and description are type String from the previous homework
  String characterName, characterDescription;

  // also, on the last homework we defined our attributes. This time though, we will not
  // initialize them to 5, but rather to 0 and let the _roll method handle that.
  int strength = 0;
  int intelligence = 0;
  int defense = 0;

  public void askForCharacterName(){
    characterName = this.askFor("Character Name: ");
  }

  public void askForCharacterDescription(){
    characterDescription = this.askFor("Character Description: ");
  }

  public void randomlyAssignAttributes(){
    strength = this._roll();
    intelligence = this._roll();
    /*
    all the other attributes get filled in the same way
    */
    defense = this._roll();
  }

  public String toString(){
    // Whatever the rules required is built into this string.
    String characterSheet = "My Character Sheet";

    return characterSheet;
  }

  private String _askFor(String prompt){
    /*
    prompt user
    scan their input
    return the result
    */
  }

  private int _roll(){
    return (int)(Math.random() * 20) + 6;
  }

  public static void main(String[] args){

    // create instance of this class so we can use its instance methods.
    CharacterGeneration character = new CharacterGeneration();

    character.askForCharacterName();
    character.askForCharacterDescription();
    character.randomlyAssignAttributes();
    System.out.println(character);
  }
}
```

There we go - "working code" that is declarative. Of course I left out some of the answers to the upcoming lab/homework, but I hope you get the idea.

## Review
We created 3 layers to this applications "black boxes".

Our first layer is in the main method and it simply describes "what we want to do". Anyone can read this and understand the premise of what you are trying to do. And when I say anyone, ask your mom, your dad, whoever you know that doesn't program, point them to the main method, and ask them, "What does my program do, step by step?". If they cannot tell you by reading it, you are not descriptive.

Our second layer of *black boxes* removes the repetitive code we face while writing our helper methods. You do not need to necessarily get that correct the first time. Write your code to handle the method and once you are done with all your methods, revisit the method, find out what can be extrapolated into another method and reused. This is called *refactoring*. It also handles another catch phrase of *DRY* code. *DRY* stands for *Don't Repeat Yourself*.

Finally, we have those private helper methods that cannot be broken down any further and we are forced to be imperative. But when we are imperative, we write very little imperative code. This is what we want. We do not want the next developer to come into your class and have to be confused on what you are trying to do. Of course, it doesn't have to be only 3 layers of *black boxes*. It might be more, it might be less. Let the code show you where you need to refactor. Refactor as many times as you need.

I hope that helps some when developing a program or library, and I hope that helps you have a tool kit in attacking your homework and labs.
