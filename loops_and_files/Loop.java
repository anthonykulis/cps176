public class Loop {
  public static void main(String[] args){
    double x, y;
    for(x = 2, y = 3; x < y; x = Math.pow(x, 3), y = Math.pow(y, 2)){
      System.out.println(x + " : " +y);
    }
    System.out.println(x + " : " +y);
  }
}
