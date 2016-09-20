package rpg.character;

import java.util.Scanner;
import java.io.*;

import rpg.dice.*;
import rpg.character.player_classes.*;

public class Generator {

  public int characterClassID;

  Scanner sc = new Scanner(System.in);
  Die die = new Die(20);
  String characterName, characterDescription;
  PlayerClass pc;

  public void askForCharacterClass(){
    characterClassID = Integer.valueOf(this._askFor("Choose Class:\n  1. Warrior\n  2. Sorcerer\nEnter a 1 or 2: "));
  }

  public void askForCharacterName(){
    characterName = this._askFor("Character Name: ");
  }

  public void askForCharacterDescription(){
    characterDescription = this._askFor("Character Description: ");
  }

  public boolean askForCharacterSave(){
    return this._askFor("Would you like to save this character? (y/n): ").toLowerCase().charAt(0) == 'y';
  }

  private String _askFor(String prompt){
    System.out.print(prompt);
    return sc.nextLine();
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

  }

  public String toString(){
    return "Character Name: " + characterName + "\n" +
    "Character Description: " + characterDescription + "\n" +
    pc.toString();
  }

  public void save(){
    try {
      String filePath = "rpg" + File.separator + "data" + File.separator + "characters" + File.separator;
      String fileName = filePath + characterName.replace(" " , "") + ".character";
      PrintWriter writer = new PrintWriter(fileName, "UTF-8");
      writer.println(this.toString());
      writer.close();
    } catch (FileNotFoundException e){
      e.printStackTrace();
      System.exit(1);
    } catch (UnsupportedEncodingException e){
      e.printStackTrace();
      System.exit(1);
    }
  }

  private void _saveHelper(String filePath){

  }
}
