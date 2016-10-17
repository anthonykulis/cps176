package rpg;

import rpg.character.Generator;
import rpg.character.player_classes.*;

public class LoadingPrompt {

 public static void main(String[] args){
 Generator g = new Generator();
     g.askForCharacterName();
     g.askForCharacterDescription();
     g.askForCharacterClass();
     if (!(g.characterClassID == 1 || g.characterClassID == 2)) {
        System.out.println("Enter 1 or 2 as a class next time");
        System.exit(1);
     }
     g.randomlyAssignAttributes(g.characterClassID);
     System.out.println(g);
     if (!g.askForCharacterSave()) {
         System.exit(1);
     }
     g.save();

 }
}