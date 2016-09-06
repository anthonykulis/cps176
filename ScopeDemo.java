public class ScopeDemo {
  public static void main(String[] args){
    int x = 4;
    if(true){
      int x = 3;
    }
    System.out.println(x);
  }
}
