package rpg.util;

import java.util.Scanner;

public class Dialog {

  public static String askFor(String prompt){
    Scanner sc = new Scanner(System.in);
    System.out.print(prompt);
    return sc.nextLine();
  }


}
