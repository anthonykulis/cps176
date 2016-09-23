// 1 point for importing scanner
import java.util.Scanner;

// 1 point for proper class definition
// 1 point for proper class name
public class TestGrader {

  // 1 point for correct main method
  public static void main(String[] args){

    // 3 point for creating scanner correctly
    Scanner scanner = new Scanner(System.in);

    // 1 point for name variable
    String name;

    // 2 points for pointsEarned and totalPointsPossible
    // 2 points for making them doubles or upcasting later
    double pointsEarned, totalPointsPossible, percentage;

    // 2 points for asking for name
    System.out.println("What is the student's name?");

    // 2 points for reading name
    name = scanner.nextLine();

    // 2 points for asking for points earned
    System.out.println("How many points did the student earn?");

    // 2 points for reading points earned
    pointsEarned = scanner.nextInt();

    // 2 points for asking for total points
    System.out.println("How many points was the test?");

    // 2 points for reading total points
    totalPointsPossible = scanner.nextInt();

    // 2 points for doing correct math
    percentage = pointsEarned / totalPointsPossible * 100;

    // 5 points for correct formatting overall (all or none)
    // 4 points for name, pointsEarned, totalPointsPossible, and percentage usage
    System.out.println("Student Name: " + name);
    System.out.println("Points Earned: " + pointsEarned);
    System.out.println("Total Points Possible: " + totalPointsPossible);

    // No number formatting required
    System.out.println("Grade for the test: " + percentage + "%");
  }
}
