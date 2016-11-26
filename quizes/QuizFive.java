public class QuizFive {
  private int x = 0;

  public QuizFive(){
    this.x = 4;
  }

  public Integer mystery(int n){
    while(x++ < n){
      // do nothing
    }
    return x % n;
  }

  public static void main(String[] args){
    QuizFive qf = new QuizFive();
    int mysteryValue = qf.mystery(6);
    System.out.println("mystery(6) is " + mysteryValue + " - which is " +
      (mysteryValue % 2 == 0 ? "even" : "odd"));
  }
}

/*
1. What is the return type of the instance method?

2. What is the argument(s) of the class method? Use english in the form
of [variable] of type [type]

3. How many times does the while loop cycle?

4. When first calling `mysterty`, what is the value of x?

5. Will the print statement in the main method print "even" or "odd"

*/
