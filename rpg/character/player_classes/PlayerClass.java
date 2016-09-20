package rpg.character.player_classes;

public class PlayerClass {
  int strength, dexterity, intelligence, constitution, defense;
  String type;

  public PlayerClass(String type){
    this.type = type;
    this.strength =
    this.dexterity =
    this.intelligence =
    this.constitution =
    this.defense = 5;
  }

  public int increaseStrengthBy(int amount){
    this.strength += amount;
    return this.strength;
  }

  public int increaseDexterityBy(int amount){
    this.dexterity += amount;
    return this.dexterity;
  }

  public int increaseIntelligenceBy(int amount){
    this.intelligence += amount;
    return this.intelligence;
  }

  public int increaseConstitutionBy(int amount){
    this.constitution += amount;
    return this.constitution;
  }

  public int increaseDefenseBy(int amount){
    this.defense += amount;
    return this.defense;
  }

  public String toString(){
    return "Class: " + type + "\n\n" +
    "Stats\n" +
    "-----\n" +
    "Strength: " + this.strength + "\n" +
    "Dexterity: " + this.dexterity + "\n" +
    "Constitution: " + this.constitution + "\n" +
    "Intelligence: " + this.intelligence + "\n" +
    "Defense: " + this.defense + "\n";
  }
}
