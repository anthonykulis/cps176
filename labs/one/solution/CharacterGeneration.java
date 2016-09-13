import java.util.Scanner;

public class CharacterGeneration {
  public static void main(String[] args){
    String name;
    String desc;
    int str, cons, dex, intel, def;
    cons = dex = intel = str = def = 5;
    Scanner sc = new Scanner(System.in);

    System.out.println("Character name: ");
    name = sc.nextLine();

    System.out.println("Character description: ");
    desc = sc.nextLine();

    str += (int)(Math.random() * 20) + 1;
    cons += (int)(Math.random() * 20) + 1;
    dex += (int)(Math.random() * 20) + 1;
    intel += (int)(Math.random() * 20) + 1;
    def += (int)(Math.random() * 20) + 1;


    /*
      Grading:
      10 points for proper printing format
      1 point for printing correct name
      1 point for printing correct description
      1 point for each attribute printed as int
      1 point for each attribute as a random int with a minimum of 5
      3 base points for combined all other work to get to printing.
    */
    System.out.println("Character Name: " + name);
    System.out.println("Character Desc: " + desc);
    System.out.println();
    System.out.println("Stats");
    System.out.println("-----");
    System.out.println("Strength: " + str);
    System.out.println("Dexterity: " + dex);
    System.out.println("Constitution: " + cons);
    System.out.println("Intelligence: " + intel);
    System.out.println("Dexterity: " + def);

  }
}
