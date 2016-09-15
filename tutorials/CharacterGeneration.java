public class CharacterGeneration {

  public void askForCharacterName(){}

  public void askForCharacterDescription(){}

  public void randomlyAssignAttributes(){}

  public String toString(){
    return "";
  }

  public static void main(String[] args){

    // create instance of this class so we can use its instance methods.
    CharacterGeneration character = new CharacterGeneration();

    character.askForCharacterName();
    character.askForCharacterDescription();
    character.randomlyAssignAttributes();
    System.out.println(character);
  }
}
