import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlatFileDatabase {

    static FlatFileDatabase ffd = new FlatFileDatabase();

    public boolean writeColumns(String columnMeta, String fileName) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter(fileName);
        writer.write(columnMeta);
        writer.close();
        return true;

    }

    //Creating a table here along with its name with no entries
    public boolean createTable(String name) throws IOException {
        /*
          Use constants in place of repeated literals -1 pt
        */
        File file = new File("tables\\"+name);
        return file.createNewFile();
    }
    //finding and destorying table
    public boolean destroyTable(String deleteFile) {
        File file = new File("tables\\"+deleteFile);
        return file.delete();
    }

    //finding some string specific thing

    /*
      Incorrect method header. Needed public String findOne(String key, String value, String directory);
      With this, we would pass a key (eg name) and a value (eg anthony). Then we would find the first
      record where the key == value, in otherwords name == "anthony" and return that entire record.

      -3pt for incomplete and incorrect logic
    */
    public String findOne(String folder,String value) throws IOException {
        String line = null;
        int lineNumber = 0;
        BufferedReader in = new BufferedReader(new FileReader("tables\\" + folder));

        /*
          You have to parse out the value (which is a key)
        */
        while (!(line = in.readLine()).equals(value)) {
            lineNumber++;
        }

        return "Your string is on: " + lineNumber;
    }

    public boolean stringUpdate(String oldValue, String newValue,String fileName) throws IOException {


        //declaring the type of text I want to use as the base language
        Charset charset = StandardCharsets.UTF_8;
        Path path = Paths.get("tables\\" + fileName);

        /*
        Intuitive way to handle this. Nice job investigating an alternative approach.
        You still needed to verify the record was there to be updated though.
        */
        //getting the value of all string in a file within the utf 8 language
        String content = new String(Files.readAllBytes(path), charset);
        content = content.replace(oldValue, newValue);
        Files.write(path, content.getBytes(charset));

        /*
          If we are returning true, then somewhere we need to return false.
          In this case, if the record was not found, we would return false.

          -1 pt.
        */
        return true;

    }
    public boolean destroy(String oldValue,String fileName) throws IOException{
        return ffd.stringUpdate(oldValue,"",fileName);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("What file name do you want to create? \n");
        String table = sc.nextLine();
        try {
            ffd.createTable(table);
        } catch (IOException e) {
            System.out.println();
        }

        System.out.print("Which file do you want to delete?\n");
        String deleteFile = sc.nextLine();
        ffd.destroyTable(deleteFile);

        System.out.print("Which file do you want to write the lines to?\n");
        String replacedFile = sc.nextLine();
        System.out.print("What words to write?\n");
        String replaceWords = sc.nextLine();
        try {
            ffd.writeColumns(replaceWords,"tables\\"+replacedFile);
        } catch (FileNotFoundException e){
            System.out.println("Error\n");
        }

        System.out.print("What folder do you want to search in to find a string?\n");

        String folder = sc.nextLine();
        System.out.println("What string do you want to find?\n");
        String stringToFind = sc.nextLine();

        try {
            String foundOnLine = ffd.findOne(folder,stringToFind);
            System.out.println(foundOnLine);
        } catch(IOException e) {
            System.out.println("Error\n");
        }



        System.out.print("What value whould you like to update?\n");
        String replaceOldValue = sc.nextLine();
        if (!replaceOldValue.equals("")) {
            System.out.print("What would you like to replace it with?\n");
            String replaceNewValue = sc.nextLine();
            System.out.print("What folder is this in? \n");
            String inAFolder = sc.nextLine();
            try {
                ffd.stringUpdate(replaceOldValue, replaceNewValue, inAFolder);
            } catch (IOException e) {
                System.out.println("Cant find what your looking for");
                e.printStackTrace();
            }
        }
        System.out.print("What words do you wish to delete?\n");
        String deleteWords = sc.nextLine();
        if (!deleteWords.equals("")) {
            System.out.print("What folder is this in? \n");
            String deleteInFolder = sc.nextLine();
            try {
                ffd.destroy(deleteWords, deleteInFolder);
            } catch (IOException e) {
                System.out.println("Cant find what your asking");
                e.printStackTrace();
            }
        }
    }
}
