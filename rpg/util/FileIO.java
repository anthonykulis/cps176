package rpg.util;

import java.io.*;

public class FileIO {

  public static void saveCharacter(String file, String data){
    try {
      PrintWriter writer = new PrintWriter(file, "UTF-8");
      writer.println(data);
      writer.flush();
      writer.close();
    } catch (FileNotFoundException e){
      e.printStackTrace();
      System.exit(1);
    } catch (UnsupportedEncodingException e){
      e.printStackTrace();
      System.exit(1);
    }
  }
}
