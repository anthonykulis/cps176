
import rpg.character.Generator;
import rpg.character.player_classes.*;

public class LoadingPrompt {

  public static void main(String[] args){
    Generator generator = new Generator();
    PlayerClass player;

    generator.askForCharacterName();
    generator.askForCharacterDescription();
    generator.askForCharacterClass();

    int ccid = generator.characterClassID;

    if(!(ccid == 1 || ccid == 2)){
      System.err.println("You must pick either a 1 or 2, I cannot continue");
      System.exit(1);
    } else {
      generator.randomlyAssignAttributes(ccid);
    }

    System.out.println("\n" + generator);

    if(generator.askForCharacterSave()){
      generator.save();
    } else {
      System.out.println("At this point I cannot re-run the application automatically, so exiting.");
    }
  }
}
