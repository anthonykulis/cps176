import java.util.Scanner;
public class CharacterGeneration2 {
   
   String characterName;
   String characterDescription;
   int strength = 5;
   int dexterity = 5;
   int constitution = 5;
   int intelligence = 5;
   int defense = 5;
   Scanner scanner = new Scanner(System.in);
            
   public void collectCharacterName(){
      characterName = _askFor("What is your character's name?");
   }
   
   public void collectCharacterDescription(){
      characterDescription = _askFor("How would you describe your character?");
   }
   private String _askFor(String prompt){
      System.out.println (prompt);
      return scanner.nextLine();
   }
   public void randomlyUpdateAttributes(){
      strength += _roll(20);
      dexterity += _roll(20);
      constitution += _roll(20);
      intelligence += _roll(20);
      defense += _roll(20);
   }
   
   public String toString(){
      return "\nCharacter Name: " + characterName + 
             "\nCharacter Desc: " + characterDescription + 
             "\n\nStats\n-----" + 
             "\nStrength: " + strength + 
             "\nDexterity: " + dexterity + 
             "\nConstitution: " + constitution + 
             "\nIntelligence: " + intelligence + 
             "\nDefense: " + defense;
   }
   private int _roll(int sides){
      return ((int)(Math.random()*sides)+1);
   }
   public static void main(String[] args){
      CharacterGeneration2 characterSheet = new CharacterGeneration2();
      characterSheet.collectCharacterName();
      characterSheet.collectCharacterDescription();
      characterSheet.randomlyUpdateAttributes();
      System.out.println(characterSheet);
   }  
}

        

        
