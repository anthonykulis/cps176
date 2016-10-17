import rpg.character.Generator;
import rpg.character.player_classes.*;

public class LoadingPrompt {
  public static void main(String[] args){
       Generator g = new Generator();
       
       g.askForCharacterName();
       g.askForCharacterDescription();
       g.askForCharacterClass();
       g.randomlyAssignAttributes(g.CharacterClassID);
       System.out.println(g);


  }

}

