import java.util.Scanner;

public class CharacterCreation {


    public static void main (String args[]) {


        int strength = 5,
                dexterity = 5,
                constitution = 5,
                intelligence = 5,
                defense = 5;

        Scanner userinput = new Scanner(System.in);
        System.out.print("Enter your characters name: ");
        String name = userinput.nextLine();
        System.out.println("Your characters name is: "+ name);

        Scanner characterdescriptioninput = new Scanner(System.in);
        System.out.print("Enter your characters description: ");
        String description = characterdescriptioninput.nextLine();
        System.out.println("Your characters description is: "+ name);
        System.out.println("-------------------------");


        System.out.println("");
        System.out.println("Character Name: "+name);
        System.out.println("Character Desc: "+description);
        System.out.println("");
        System.out.println("Stats");
        System.out.println("-----");
        System.out.println("Strength: "+strength);
        System.out.println("Dexterity: "+dexterity);
        System.out.println("Constitution: "+constitution);
        System.out.println("Intelligence: "+intelligence);
        System.out.println("Defense: "+defense);
        System.out.println("");
        System.out.println("-------------------------");

        System.out.println("");


         strength = (int) ((Math.random())*20+1) + strength;

         intelligence = (int) ((Math.random())*20+1)  + intelligence;

         dexterity = (int) ((Math.random())*20+1)  + dexterity;

         constitution = (int) ((Math.random())*20+1)  + constitution;

         defense = (int) ((Math.random())*20+1)  + defense;

        System.out.println("Your leveled up strength level is : "+strength);
        System.out.println("Your leveled up intelligence level is : "+intelligence);
        System.out.println("Your leveled up dexterity level is : "+dexterity);
        System.out.println("Your leveled up constitution level is : "+constitution);
        System.out.println("Your leveled up defense level is : "+defense);

        System.out.println("Your Final Stats:");
        System.out.println("------------------");
        System.out.println("Character Name: "+name);
        System.out.println("Character Desc: "+description);
        System.out.println("");
        System.out.println("Stats");
        System.out.println("-----");
        System.out.println("Strength: "+strength);
        System.out.println("Dexterity: "+dexterity);
        System.out.println("Constitution: "+constitution);
        System.out.println("Intelligence: "+intelligence);
        System.out.println("Defense: "+defense);
        System.out.println("");
        System.out.println("-------------------------");

        System.out.println("");

    }
}