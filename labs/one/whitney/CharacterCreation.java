/*
  Grading
  Proper print out 0/10
  Printing correct name 0pt
  Printing correct description 0pt
  correct printed data type for each attribute 0pts
  correctly printed a random number per attribute of minimum vaue of five 0pts
  base 3pts

  Score 3/25
*/

import java.util.Scanner;

public class CharacterCreation{
   public static void main(String[] args){

    String character;
    String description;
    int strength = 5;
    int dexterity = 5;
    int constitution = 5;
    int imtelligence = 5;
    int defense = 5;


    Scanner scanner = new Scanner(System.in);
    System.out.println("What is your characters name?");
    String name = scanner.next();
    System.out.println("What is your characters description?");
    String Description = scanner.next();

    int randomNumberOfstrenghtInt = (int)(Math.random()* 20) + 1;



    }
}
