package rpg.character;

import rpg.dice.*;
import rpg.character.player_classes.*;

import rpg.util.*;

import java.io.*;

public class Generator {

  public int characterClassID;

  Die die = new Die(20);
  String characterName, characterDescription;
  PlayerClass pc;

  public void askForCharacterClass(){
    characterClassID = Integer.valueOf(Dialog.askFor("Choose Class:\n  1. Warrior\n  2. Sorcerer\nEnter a 1 or 2: "));
  }

  public void askForCharacterName(){
    characterName = Dialog.askFor("Character Name: ");
  }

  public void askForCharacterDescription(){
    characterDescription = Dialog.askFor("Character Description: ");
  }

  public boolean askForCharacterSave(){
    return Dialog.askFor("Would you like to save this character? (y/n): ").toLowerCase().charAt(0) == 'y';
  }

  public void randomlyAssignAttributes(int characterClassID){
    switch(characterClassID){
      case 1:
        pc = new Warrior();
        pc.increaseStrengthBy(die.roll());
        pc.increaseConstitutionBy(die.roll());
        pc.increaseDefenseBy(die.roll());
        pc.increaseIntelligenceBy(die.roll());
        pc.increaseDexterityBy(die.roll());
        break;
      case 2:
        pc = new Sorcerer();
        pc.increaseStrengthBy(die.roll());
        pc.increaseConstitutionBy(die.roll());
        pc.increaseDefenseBy(die.roll());
        pc.increaseIntelligenceBy(die.roll());
        pc.increaseDexterityBy(die.roll());
        break;
      default:
        System.err.println("Invalid class ID");
        System.exit(1);
    }

    pc.setCharacterName(characterName);
    pc.setCharacterDescription(characterDescription);

  }

  public String toString(){
    return pc.toString();
  }

  public void save(){
    pc.save();
  }

}
