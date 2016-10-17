import java.util.Scanner;

public class CharacterGeneration2{
   Scanner scanner = new Scanner(System.in);
   String characterName;
   String characterDescription;
   int strength = 5;
   int dexterity = 5;
   int constitution = 5;
   int intellegence = 5;
   int defense = 5;

   public void collectCharacterName(){
      System.out.println("What is your character's name");
      characterName = scanner.nextLine();
   }
   
   public void collectCharacterDescription(){
      System.out.println("What is your character's description");
      characterDescription = scanner.nextLine();
   }
   
   public void randomlyUpdateAttributes(){
      strength += _roll();
      dexterity += _roll();
      constitution += _roll();
      intellegence += _roll();
      defense += _roll();

   }
   
   public String toString(){
      return "Name: " + characterName + "\n" +
      "Description: " + characterDescription + "\n" +
      "Stats\n" +
      "-----\n" +
      "Strength: " + strength + "\n" +
      "Dexterity: " + dexterity + "\n" +
      "Constitution: " + constitution + "\n" +
      "Intelligence: " + intellegence + "\n" +
      "Defense: " + defense + "\n";
   }
   
   private int _roll(){
      return (int)((Math.random()*20)+1);
   }
   
   public static void main(String[] args){
      CharacterGeneration2 characterSheet = new CharacterGeneration2();
      characterSheet.collectCharacterName();
      characterSheet.collectCharacterDescription();
      characterSheet.randomlyUpdateAttributes();
      System.out.println(characterSheet);
   
   }
}