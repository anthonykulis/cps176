import rpg.characters.CharacterCreation;
import java.util.Scanner;

public class TeamNameRPG {

  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    char rollAgain;

    CharacterCreation cc = new CharacterCreation();
    cc.askForCharacterName();
    cc.askForCharacterDescription();
    cc.rollForAttribute("Strength");
    cc.rollForAttribute("Dexterity");
    cc.rollForAttribute("Consitution");
    cc.rollForAttribute("Intelligence");
    cc.rollForAttribute("Defense");
    System.out.println(cc.toString());

    System.out.println("\n" + "Would you like to roll again? (y/n)");
    rollAgain = sc.nextChar();

    if(rollAgain == 'y'){

    } else if(rollAgain == 'n'){

    } else {

    }


  }
}
