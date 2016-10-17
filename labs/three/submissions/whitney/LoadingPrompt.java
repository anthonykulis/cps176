import rpg.character.Generator;
import rpg.character.player_classes.*;

 public class LoadingPrompt {

  public static void main(String[] args){
   // Create Generator
   Generator gen = new Generator();
   // ask for character name
   gen.askForCharacterName();
   // Ask for character Description
   gen.askForCharacterDescription();
   // Ask for character class
   gen.askForCharacterClassID();
   gen.askForCharacterSave();
   gen.randomlyAssignAttributes(gen.classID);
   System.out.println(gen);
   }

  }
