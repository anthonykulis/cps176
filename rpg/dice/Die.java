package rpg.dice;

public class Die {
  private int _sides = 6;

  public Die(int sides){
    if(sides < 2) return;
    this._sides = sides;
  }

  public int roll(){
    return (int)(Math.random() * this._sides) + 1;
  }

  public int roll(int offset){
    return this.roll() + offset;
  }
}
