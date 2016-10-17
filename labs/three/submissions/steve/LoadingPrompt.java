
import rpg.character.Generator;
import rpg.character.player_classes.*;

public class LoadingPrompt {

   public static void main(String[] args){
  
      Generator generator = new Generator();
      int classID;
           
      generator.askForCharacterName();
      generator.askForCharacterDescription();
      generator.askForCharacterClass();
      classID = generator.characterClassID;
      if (classID != 1 && classID != 2){
         System.out.println("That is not a valid class selection. Please select 1 or 2."+
                            "Exiting program.");
         System.exit(0);
      }
     
      generator.randomlyAssignAttributes(generator.characterClassID);
      System.out.println(generator);
      if (generator.askForCharacterSave()){
         generator.save();
      }
   }
}
