/*
  Grading
  Proper print out 10/10
  Printing correct name 1 pt
  Printing correct description 1pt
  correct printed data type for each attribute 5pts
  correctly printed a random number per attribute of minimum vaue of five 5pts
  base 3pts

  Score 25/25
*/

import java.util.Scanner;

public class CharacterCreate {

      public static void main(String[] args){

      String characterName;
      String characterDescription;
      int strength = 5;
      int dexterity = 5;
      int constitution = 5;
      int intelligence = 5;
      int defense = 5;
      Scanner scanner = new Scanner(System.in);

      System.out.println ("What is your character's name?");
      characterName = scanner.nextLine();

      System.out.println ("How would you describe your character?");
      characterDescription = scanner.nextLine();

      strength += ((int)(Math.random()*20)+1);
      dexterity += ((int)(Math.random()*20)+1);
      constitution += ((int)(Math.random()*20)+1);
      intelligence += ((int)(Math.random()*20)+1);
      defense += ((int)(Math.random()*20)+1);

      System.out.println ("Character Name: "+characterName);
      System.out.println ("Character Desc: "+characterDescription);
      System.out.println ("\nStats\n-----");
      System.out.println ("Strength: "+strength);
      System.out.println ("Dexterity: "+dexterity);
      System.out.println ("Constitution: "+constitution);
      System.out.println ("Intelligence: "+intelligence);
      System.out.println ("Defense: "+defense);

      }
}
