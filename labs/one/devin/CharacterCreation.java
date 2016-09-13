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

public class CharacterCreation {
   public static void main (String args []) {

        String characterName;

        String characterDescription;

        int strength = 5,

            dexterity = 5,

            constitution = 5,

            intelligence = 5,

            defense = 5;


        Scanner scanner = new Scanner (System.in);


        System.out.print("What is your Character's name?");

        characterName = scanner.nextLine();


        System.out.print("What is your Character's description?");

        characterDescription = scanner.nextLine();



        strength = (int)(Math.random()*20)+1 + strength;

        dexterity = (int)(Math.random()*20)+1 + dexterity;

        constitution = (int)(Math.random()*20)+1 + constitution;

        intelligence = (int)(Math.random()*20)+1 + intelligence;

        defense = (int)(Math.random()*20)+1 + defense;








        System.out.println("Character Name: " + characterName);

        System.out.println("character Desc: " + characterDescription);

        System.out.println(" ");

        System.out.println("Stats");

        System.out.println("=====");

        System.out.println("Strength: " + strength);

        System.out.println("Dexterity: " + dexterity);

        System.out.println("Constitution: " + constitution);

        System.out.println("Intelligence: " + intelligence);

        System.out.println("Defense: " + defense);








   }



}
