import java.util.Scanner;
public class CharacterGeneration2{
   String name;
   String description;
   int strength =5;
   int dexterity = 5;
   int constitution = 5;
   int intelligence = 5;
   int defense =5;
   Scanner sc= new Scanner(System.in);
   public void collectCharacterName(){
      System.out.println("What is your characters name");
      name = sc.nextLine();  
   }
   public void collectCharacterDescription(){
      System.out.println(" What is your characters description?");
      description = sc.nextLine();
   }
   public void randomlyUpdateAttributes(){
      strength += this._roll();
      dexterity += this._roll();
      constitution += this._roll();
      intelligence += this._roll();
      defense += this._roll();
   }
   public String toString(){
      return "\nCharcter Name: "  + name +
             "\nCharacter desc: "  + description +
             "\n\nStats\n-----" +
             "\nStrength:"  + strength +
             "\nDexterity: "  + dexterity +
             "\nConstitution: " +  constitution +
             "\nIntelligence: "  + intelligence +
             "\nDefense: "  + defense ;
             
   }
   private int _roll(){
      return ((int)(Math.random()*20)+1);   
   }
   public static void main(String[] args){
      CharacterGeneration2 charactersheet= new CharacterGeneration2();
      charactersheet.collectCharacterName();
      charactersheet.collectCharacterDescription();
      charactersheet.randomlyUpdateAttributes();
      System.out.println(charactersheet);
   }
 }