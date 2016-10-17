
import rpg.character.Generator;
import rpg.character.player_classes.*;

public class LoadingPrompt {

  public static void main(String[] args){
   Generator gen = new Generator();
   /*
      Step 1: Ask for the character's name.
      Step 2: Ask for the character's descripton.
      Step 3: Ask for the character's class.
      Step 4: Randomly assign the character's attributes.
      Step 5: Ask if the user wants to save their character. If yes save.

   */

   gen.askForCharacterName();
   gen.askForCharacterDescription();
   gen.askForCharacterClass();
   gen.randomlyAssignAttributes(gen.characterClassID);
   if (gen.askForCharacterSave()){
      gen.save();
   }

   /* Missing ask for save logic -10 */

  }
}
