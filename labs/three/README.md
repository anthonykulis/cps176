# Lab Three

## Theme - RPG Character Creation Part 3
I have taken all the excellent work completed across labs 1 and 2 and abstracted them for better use. You will use these abstractions to rewrite your driver, once again, but instead using the classes I provided. You will also use `if-else` statements to provide the player an option of creating a Warrior or Sorcerer player class. Finally, you will also use an `if-else` statement to allow the player to save their character to a file. You will not have to actually write that code to write to file, nor handle creating the player classes, I have already done that for you. This is simply an exercise on using `if-else` properly.

## Minimum Requirements
For this lab, you will be required to collect via the rpg.character.Generator class:
  1. The Character Name
  2. A description of the Character (eg class, looks, w/e)
  3. The Character Class
  4. Have the Generator class update the attributes of the selected player class.
  5. Print out a character sheet (name, description, stats) to the terminal.
  6. Provide an option via the Generator to save the player class and attributes to file.

## Tips
* You will need to download the `rpg` package correctly. I will demonstrate this in class, but without the proper download, your code will never work. So make sure you ask if you missed how to set this up.
  * In your root directory, you will need
    1. The driver named `LoadingPrompt.java`
    2. The directory `rpg` with all its children

* You will need to instantiate the `Generator` class.
* You will use the instantiated `Generator` to ask for:
  * character name
  * character description
  * character class <- this is new!!!!

* Hint on the above, check with the `Generator` class to see the names of the methods you need to call. They may or may not be the same as the ones you declared.

* You will then need to check with an `if-else` if the user entered the appropriate class via the `Generator` class member variable `characterClassID`. This is not a static variable since the user gets to decide its value. But a value of `1` indicates a `Warrior`, and a value of `2` indicates a `Sorcerer`. We can/will add more options later when you learn to build classes. If the user entered any value besides a `1` or `2`, you must exit the program (for now). If they did enter a correct value, you may continue onward.

* Upon a correct player class selection, you will then roll for their attributes like the previous lab. Again, all the work you completed in the previous lab has been encapsulated, so the methods are available for you in the `Generator` class to re-use. There is one caveat though, I changed the `randomlyAssignAttributes` method to accept an `int` to identify which player class we will roll attributes for. The reason for this is because a `Warrior` has a different set of base attributes then a `Sorcerer`. You will pass the previous `characterClassID` as a parameter to this method. If you do not pass a correct value, the code will throw an error and exit.

* Once you have rolled for your player classes attributes, you will then print the stats out to the terminal as you did before. Simply leverage the `Generator` classes `toString` method as you did before.

* The user will finally have the option to save the character generated. You can prompt the user for this option using the `askForCharacterSave` method. Check its return type. It is a `boolean`. This means if the player selected any variant of `y`, the class returns a `true`, otherwise `false`. Use that response in your `if-else` to determine if you should save the character using the `Generator` classes `save` method.
  * For right now, we will only exit if the user doesn't select a `y` variant. Later when we learn loops, we will repeat the process until the user selects a `y`.

* I have provided a template of `LoadingPrompt.java` in this repositories root directory. If you download the entire repository as a .zip file, you can then start working on that file directly. If you need to clean up for room, you may delete in that expanded .zip everything but `LoadingPrompt.java` and the `rpg` directory.

## Grading
This is your third of the 8 programming assignments. This means it is worth 25 points. And with this one, from now on, if your submission is declarative, I will give you 5 points extra credit towards the assignment.

## Due Date
This assignment will be due Thursday October 6, 2016 at 8:00am. We will use as much lab time as possible to complete this.

## Solution
The solution will be posted on the due date at the due time. Because of so, there will be no extra time afforded to complete this assignment.
