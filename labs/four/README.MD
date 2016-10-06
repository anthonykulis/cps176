# Lab Four

## Theme - RPG Character Creation Part 4
We currently are on character creation. At a later date we will choose whether or not we want to enter this part of the game, but for now, we need to finish it off. This lab will complete this part of the series.

## Minimum Requirements
For this lab, you will modify lab 3 so that we remain in character creation until the user selects a *legal* option.

### Part 1 of lab
In lab 3, we offered to pick one of two classes. This will remain as such, but now if they do not pick `1` or `2`, you will catch that error and loop until they pick a legal value.

### Part 2 of lab
When we ask if the player if they want to save their character, if they select no, we currently exit. We will expand this concept out to a more fulfilling user experience. When we ask if they wish to save and they answer `yes`, then we will continue as we did. But now if they respond with `no`, then we will prompt the user if they wish to `exit` or `start over`. If they choose `exit`, we will exit without save. If they choose `start over`, then we will start the character creation process all over, reusing the same instance. Hint: this means not re-instantiating the `Generator`, but rather re-using all the variables provided.

## Tips
* You will need to download the `rpg` package correctly. I will demonstrate this in class, but without the proper download, your code will never work. So make sure you ask if you missed how to set this up.
  * In your root directory, you will need
    1. The driver named `LoadingPrompt.java`
    2. The directory `rpg` with all its children

* I have provided a template of `LoadingPrompt.java` in this repositories root directory. If you download the entire repository as a .zip file, you can then start working on that file directly. If you need to clean up for room, you may delete in that expanded .zip everything but `LoadingPrompt.java` and the `rpg` directory.

## Grading
This is your third of the 8 programming assignments. This means it is worth 25 points. And with this one, from now on, if your submission is declarative, I will give you 5 points extra credit towards the assignment.

## Due Date
This assignment will be due Thursday October 18, 2016 at 8:00am. We will use as much lab time as possible to complete this.

## Solution
The solution will be posted on the due date at the due time. Because of so, there will be no extra time afforded to complete this assignment.
