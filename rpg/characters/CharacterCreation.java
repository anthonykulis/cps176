package rpg.characters;

import java.util.Scanner;

public class CharacterCreation {

  private Scanner _scanner = new Scanner(System.in);
  private String _characterName, _characterDescription;
  private int _strength = 5,
              _dexterity = 5,
              _constitution = 5,
              _intelligence = 5,
              _defense = 5;

  public CharacterCreation(){

  }

  public void askForCharacterName(){
    System.out.println("Character Name?");
    this._characterName = this._scanner.nextLine();
  }

  public void askForCharacterDescription(){
    System.out.println("Character Description?");
    this._characterDescription = this._scanner.nextLine();
  }

  public int rollForAttribute(String name){
    if(name.equals("Strength")){
      this._strength += this.roll();
      return this._strength;
    } else if(name.equals("Dexterity")){
      this._dexterity += this.roll();
      return this._dexterity;
    } else if(name.equals("Consitution")){
      this._constitution += this.roll();
      return this._constitution;
    } else if(name.equals("Intelligence")){
      this._intelligence += this.roll();
      return this._intelligence;
    } else if(name.equals("Defense")){
      this._defense += this.roll();
      return this._defense;
    } else {
      return 0;
    }
  }

  private int roll(){
    return (int)((Math.random() * 20) + 1);
  }

  public String toString(){
    return "\n" +
    "Character Name: " + this._characterName + "\n" +
    "Character Description: " + this._characterDescription + "\n" +
    "\n" +
    "Stats\n" +
    "-----\n" +
    "Strength: " + this._strength + "\n" +
    "Dexterity: " + this._dexterity + "\n" +
    "Constitution: " + this._constitution + "\n" +
    "Intelligence: " + this._intelligence + "\n" +
    "Defense: " + this._defense + "\n\n";
  }

  public boolean save(){
    return true;
  }

}
