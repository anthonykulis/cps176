package rpg.characters;

import gear.*;

protected class BaseCharacter {

  // standard attributes
  private int  _strength = 5,
               _constitution = 5,
               _defense = 5,
               _intelligence = 5,
               _dexterity = 5;

  // game play
  private double _baseCriticalChance = 0.10,
                 _baseCriticalMultiplier = 0.5,
                 _basePower = 1.0 ,
                 _baseDefenseChance = 0.15;

  //character meta
  private int _level = 1,
              _hitPoints = 10,
              _mana = 15;
              _xp = 0;
              _nextLevelXP = 15;

  // game meta
  private boolean _canCharacterCrit = false;

  // character gear
  public Weapon weapon;
  public Armor head, chest, arms, wrists, legs, feet;
  public Charm ears, neck, rightRing, leftRing;

  protected BaseCharacter(){

  }

  /* accessors and mutators to all the above */
  public void setStrength(int strength){
    this._strength = strength;
    this._baseCriticalMultiplier = strength / 10;
    this._basePower = strength / 5;
  }

  public int getStrength(){ return this._strength; }

  public void setConstitution(int constitution){
    this._constitution = constitution;
    this._hitPoints = constitution * 2;
  }

  public int getConstitution(){ return this._constitution; }

  public void setDefense(int defense){
    this._defense = defense;
  }

  public int getDefense(){ return this._defense; }

  public void setIntelligence(int intelligence){
    this._intelligence = intelligence;
    this._mana = intelligence * 3;
  }

  public int getIntelligence(){ return this._intelligence; }

  public void setDexterity(int dexterity){
    this._dexterity = dexterity;
  }

  public int getDexterity(){ return this._dexterity; }

  /* accessors for base character game play */
  public double getCriticalChance(){
    return this._baseCriticalChance +
            this.weapon.getCriticalModifier() +
            this.head.getCriticalModifier() +
            this.chest.getCriticalModifier() +
            this.arms.getCriticalModifier() +
            this.wrists.getCriticalModifier() +
            this.legs.getCriticalModifier() +
            this.feet.getCriticalModifier() +
            this.ears.getCriticalModifier() +
            this.neck.getCriticalModifier() +
            this.rightRing.getCriticalModifier() +
            this.leftRing.getCriticalModifier();
  }

  public double getCriticalMultipler(){
    return this._baseCriticalMultiplier +
            this.weapon.getCriticalMultiplierModifier() +
            this.head.getCriticalMultiplierModifier() +
            this.chest.getCriticalMultiplierModifier() +
            this.arms.getCriticalMultiplierModifier() +
            this.wrists.getCriticalMultiplierModifier() +
            this.legs.getCriticalMultiplierModifier() +
            this.feet.getCriticalMultiplierModifier() +
            this.ears.getCriticalMultiplierModifier() +
            this.neck.getCriticalMultiplierModifier() +
            this.rightRing.getCriticalMultiplierModifier() +
            this.leftRing.getCriticalMultiplierModifier();
  }

  public double getPower(){
    return this._basePower +
            this.weapon.getPowerModifier() +
            this.head.getPowerModifier() +
            this.chest.getPowerModifier() +
            this.arms.getPowerModifier() +
            this.wrists.getPowerModifier() +
            this.legs.getPowerModifier() +
            this.feet.getPowerModifier() +
            this.ears.getPowerModifier() +
            this.neck.getPowerModifier() +
            this.rightRing.getPowerModifier() +
            this.leftRing.getPowerModifier();
  }

  public double getDefenseChance(){
    return this._baseDefenseChance +
            this.weapon.getDefenseChanceModifier() +
            this.head.getDefenseChanceModifier() +
            this.chest.getDefenseChanceModifier() +
            this.arms.getDefenseChanceModifier() +
            this.wrists.getDefenseChanceModifier() +
            this.legs.getDefenseChanceModifier() +
            this.feet.getDefenseChanceModifier() +
            this.ears.getDefenseChanceModifier() +
            this.neck.getDefenseChanceModifier() +
            this.rightRing.getDefenseChanceModifier() +
            this.leftRing.getDefenseChanceModifier();
  }

  protected boolean didAttackCrit(){
    if(!this._canCharacterCrit) return false
    return this.getCriticalChance() >= (Math.random() * 100);
  }

  protected boolean didEnemyAttackMiss(){
    return this.getDefenseChance() >= (Math.random() * 100);
  }

  protected void levelUp(){
    this._level++;
    this._nextLevelXP = 10 + Math.power(2, this._level);
  }
}
