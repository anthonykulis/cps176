import java.io.*;
import java.util.Scanner;
public class FlatFileDatabase{


   private final String PATH="table\\";

   public boolean createTable(String file, String columns){
      //create table
      //allows users to specify what meta-information is in each column.
      //check for hashtags.
      if(!columns.startsWith("#")){
         return false;
      }
      //check for the minimum amount of columns using String split.
      if(columns.split("::").length < 2){
         return false;
      }
      //write columns
      PrintWriter pw = new PrintWriter(PATH + file);
      pw.println(columns);
      pw.close();
      //try-catch-finally errors and exit




   }


   public void destroyTable(String table){
      File f = new File(PATH + table);
      f.delete();

   }

   public void create(String record, String file) throws IOException{
      PrintWriter pw = new PrintWriter(new FileWriter(PATH+file,true));
      pw.println(record);
      pw.close();
   }

   public String findOne(String key, String table){

      //open file
      File f = new File(PATH + table);
      Scanner sc = new Scanner("table.txt");

      //the variables are just placeholders
      String rawRecord = null;
      String[] splitRecord;
      String recordKey;
      String record = null;
      boolean recordNotFound = true;

      //read each line until find record
      while(recordNotFound && sc.hasNext()){
         rawRecord = sc.nextLine();
         splitRecord = rawRecord.split("::");
         rawRecord = splitRecord[0];
         if(key.equals(recordKey)){
            record = recordKey;
            recordNotFound = false;
         }
      }

      //return
      return record;

   }

   public boolean update(String key, String record, String table){

      //helper variables
      String contents = "";
      String rawRecord;
      String splitRecord[];
      String recordKey;

      //open
      File f = new File(PATH + table);
      Scanner sc = new Scanner(f);

      //search for record
      while(sc.hasNext()){
         rawRecord = sc.nextLine();
         splitRecord = rawRecord.split("::");
         rawRecord = splitRecord[0];
         if(key.equals(recordKey)){
            contents += record;
         } else {
            contents += rawRecord;
         }
      }

      f.close();

      //if found, update record
      //make private method of this and finding files
      f.create();

      /*
        Method expects a boolean, you have to return true|false
        return true successful (found a record to update and updated it)
        return false when not (no record to update)

        - 2pts
      */
      //return

      /*
        TABS! -1 pt
      */
         }

  /*
  Simply call update with no update value
  -5pts
  */
   public boolean destroy(String key, String table){
   //update
   //return update(" ");

   }

   public static void main(String[]args){
      createTable ct = new createTable();
      destroyTable dt = new destroyTable();
      findOne fo = new findOne();
      update upd = new update();

      Scanner sc = new Scanner(System.in);
      System.out.print("What would you like to do?/n/n1]create a table/n2]delete table/n3]opentable/n4]update table");
      int a = sc.nextInt();
      if(a==1){
         createTable();
      }else if(a==2){
         destroyTable();
      }else if(a==3){
         findOne();
      }else{
         update();
      }




 }
}
