package rpg.character.player_classes;

import rpg.util.*;

public class PlayerClass {
  protected int _strength,
              _dexterity,
              _intelligence,
              _constitution,
              _defense;
  protected String _type,
                 _name,
                 _description;

  public PlayerClass(String type){
    this._type = type;
    this._strength =
    this._dexterity =
    this._intelligence =
    this._constitution =
    this._defense = 5;
  }

  public void setCharacterName(String name){
    this._name = name;
  }

  public void setCharacterDescription(String description){
    this._description = description;
  }

  public int increaseStrengthBy(int amount){
    this._strength += amount;
    return this._strength;
  }

  public int increaseDexterityBy(int amount){
    this._dexterity += amount;
    return this._dexterity;
  }

  public int increaseIntelligenceBy(int amount){
    this._intelligence += amount;
    return this._intelligence;
  }

  public int increaseConstitutionBy(int amount){
    this._constitution += amount;
    return this._constitution;
  }

  public int increaseDefenseBy(int amount){
    this._defense += amount;
    return this._defense;
  }

  public String toString(){
    return "Name: " + this._name + "\n" +
    "Description: " + this._description + "\n" +
    "Class: " + this._type + "\n\n" +
    "## Stats\n" +
    "## -----\n" +
    "Strength: " + this._strength + "\n" +
    "Dexterity: " + this._dexterity + "\n" +
    "Constitution: " + this._constitution + "\n" +
    "Intelligence: " + this._intelligence + "\n" +
    "Defense: " + this._defense + "\n";
  }

  public void save(String fileName, String data){
    FileIO.saveCharacter(fileName, this.toString());
  }
}
