import java.util.Scanner;




public class CharacterGeneration2 {
    Scanner sc = new Scanner(System.in); 
    int strength,
        dexterity,
        constitution,
        intelligence,
        defense;
    String name,description;
                        
    public void collectCharacterName() {
      name = askFor("Enter your name: ");
            
    }
    public void collectCharacterDescription() {
      description = askFor("Enter your characters description");
    }




    private String askFor(String userPrompt) {
      System.out.println(userPrompt);
      return sc.nextLine();
    }
    public void randomlyUpdateAttributes(){
    
        strength = _roll(20,5);
        intelligence = _roll(20,5);
        dexterity = _roll(20,5);
        constitution = _roll(20,5);
        defense = _roll(20,5);
        
    }
    public String toString(){
    
        return "Character Name: " + name  + "\n" +
        "Character Desc: " + description + "\n" +
        "Stats\n" +
        "-----\n" +
        "Strength: " + strength + "\n" +
        "Dexterity: " + dexterity + "\n" +
        "Constitution: " + constitution + "\n" +
        "Intelligence: " + intelligence + "\n" +
        "Defense: " + defense;    
    }
    private int _roll(int sides, int base) {
        return (int)((Math.random())*sides+1+base);
    }
    public static void main(String[] args) {
        CharacterGeneration2 characterSheet = new CharacterGeneration2();
        characterSheet.collectCharacterName();
        characterSheet.collectCharacterDescription();
        characterSheet.randomlyUpdateAttributes();  
        System.out.println(characterSheet);
        
    }
}