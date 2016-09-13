/*
  Grading
  Proper print out 0/10
  Printing correct name 1 pt
  Printing correct description 1pt
  correct printed data type for each attribute 5pts
  correctly printed a random number per attribute of minimum vaue of five 1pt
    - note: you reused the same random value for each attribute
  base 3pts

  Score 11/25
*/

import java.util.Scanner;

public class CharacterCreation {
   public static void main(String[] args){
     String characterName;
     String characterDescription;
     int strength = 5;
     int dexterity = 5;
     int constitution = 5;
     int intellegence = 5;
     int defense = 5;

     Scanner scanner = new Scanner(System.in);

     System.out.println("What is your character's name");
     characterName = scanner.next();

     System.out.println("What is your character's description");
     characterDescription = scanner.next();

     strength += (int)((Math.random()*20)+1);
     dexterity += (int)((Math.random()*20)+1);
     constitution += (int)((Math.random()*20)+1);
     intellegence += (int)((Math.random()*20)+1);
     defense += (int)((Math.random()*20)+1);

     System.out.println("strength:" + strength);
     System.out.println("deterity:" + strength);
     System.out.println("constitution:" + strength);
     System.out.println("intellegence:" + strength);
     System.out.println("defense:" + strength);

   }
}
