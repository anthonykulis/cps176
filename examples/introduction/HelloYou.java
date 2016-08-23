import java.util.Scanner;

/*
  A simple class that asks the user their name and
  then prints out "Hello, [name]"
*/

public class HelloYou {

  //main method - application entry point
  public static void main(String args[]){

    // Scanner class that reads various inputs. Passing the System.in for input
    Scanner scanner = new Scanner(System.in);

    // Ask the user who they are
    System.out.println("What is your name?");

    // Enable the input prompt and read the next string the user types after they hit enter
    String name = scanner.next();

    // Concatenate the users name with hello and print it out
    System.out.println("Hello, " + name + ".");

    // Just because I like cats (not really)
    System.out.println("I like cats!");
  }
}
