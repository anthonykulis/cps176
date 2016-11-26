import java.util.Scanner;
import java.io.*;
public class FlatFileDatabase{

   private final String PATH = "table\\";
   public void createTable(String file, String columns) throws IOException{
      //must start with a #
      if (!(columns.startsWith("#"))){
         return false;
      }
      if (!(columns.split("::").length < 2)){
         return false;
      }

      PrintWriter writer = new PrintWriter(PATH + fileName);
      writer.println(columns);
      writer.close();
   }
   public void destroyTable(String name){
      File f = new File(PATH + table);
      return f.delete();

   }
   public boolean create(String record, String file){
      PrintWriter pw = PrintWriter(new FileWriter(PATH + file, true));
      pw.println(record);
      pw.close();
   }
   public String findOne(String value,String table){

     /*
      compile time errors for no reason
      -5 pts
     */
      System.out.println(new

      String line = null;
      String record = null;
      boolean recordNotFound = true;
      while(recordNotFound && sc.hasNext()){
         line = sc.next();
         if(recordNotFound == line){
            recordNotFound = false;
            record = line;
         }
      }
      return record;
      String[] sr = record.split();
      reckey = sr[0];
   }

   public boolean update(String key,String value){
      FlatFileDatabase.findone(String value,String table);
      Scanner option = new scanner;

      /*
        you never prompt to use to do this. the method is update. not
        would you like to update. plus, its a compile time error.

        marked off for no update logic
        -5 pts
      */
      System.out.println(Would you like to update the file?);
      if(option = yes){
         Scanner name = new scanner;
         System.out.println(Enter in the name of record)
         record.renameTo(name);
      }

   }

   /*
    Just call update with no value.

    -5 pts
   */
   public boolean destroy(String key){
      FlatFileDatabase.findone(String value,String table);
      Scanner option = new scanner;
      System.out.println(Would you like to record the file?);
      if(yes){
         record.delete(value);
      }
   }
}
