import java.util.Scanner;

public class CharacterGeneration2{

   Scanner scanner =new Scanner(System.in);

   String characterName;

   String characterDescription;

   int strength = 5,

       dexterity = 5,

       constitution = 5,

       intelligence = 5,

       defense = 5;

  

   public void collectCharacterName(){

      System.out.print("What is your Character's name?");

        characterName = scanner.nextLine();

   }

  

   public void collectCharacterDescription(){

      System.out.print("What is your Character's description?");

        characterDescription = scanner.nextLine();

   }

   public void randomlyUpdateAttributes(){

      strength += _roll();

      dexterity += _roll();        

      constitution += _roll();        

      intelligence += _roll();

      defense += _roll();

   }

   public String toString(){

      return "Character Name: " + characterName + "\n" +

             "character Desc: " + characterDescription + "\n" +

             " " + "/n" +

             "Stats" + "\n" +

             "=====" + "\n" +

             "Strength: " + strength + "\n" +

             "Dexterity: " + dexterity + "\n" +

             "Constitution: " + constitution + "\n" +

             "Intelligence: " + intelligence + "\n" +

             "Defense: " + defense + "\n";

   }

   private int _roll(){

      return (int)(Math.random()*20)+1;

   }

   public static void main(String[]args){

      CharacterGeneration2 characterSheet = new CharacterGeneration2();

      characterSheet.collectCharacterName();

      characterSheet.collectCharacterDescription();

      characterSheet.randomlyUpdateAttributes();

      System.out.println(characterSheet);

   }     

}
