import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class HelloFile {
  public static void main(String[] args){

    // set up the variables we will use
    Scanner scanner = new Scanner(System.in);
    String fileName = "";
    FileReader fileReader;
    BufferedReader bufferedReader;
    String fileText = "";

    // prompt and read our file
    System.out.println("Which file should I read?");
    fileName = scanner.next();

    //now we know the name of the file, lets read set up our
    //class instances.
    fileReader = new FileReader(fileName);
    bufferedReader = new BufferedReader(fileReader);

    // now read our file (only one line for this exercise)
    fileText = bufferedReader.readLine();

    // now print out hello, [fileText]
    System.out.println("Hello, " + fileText);

  }
}
