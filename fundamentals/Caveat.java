public class Caveat {
  public static void main(String[] args){

    int threeQuarters = 3/4;

    // what does this print out?
    System.out.println(threeQuarters);

    // what does this print out?
    System.out.println(3/4);

    double threeFifths = 3/5;

    // what does this print out?
    System.out.println(threeFifths);

    // Tricky one here - can you figure out what fourFifths will print as?
    double fourFifths = 4/5;
    int castDown = fourFifths;
    fourFifths = castDown;

    System.out.println(fourFifths);

  }
}
