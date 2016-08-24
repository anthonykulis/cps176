/*
  In this Payroll example, we demonstrate numerous keywords, operators,
  punctuation, and syntax.

  I will comment on some in the line above the code, see if you can follow.
*/

// Two keywords: public and class. One identifier: Payroll
// The { is also syntax/punctuation. It identifies the beginning
// of a scope block for the class Payroll and will be closed later in the code.
// Everything in-between the Payroll's curly braces belongs to the class Payroll.
public class Payroll {


  // Three keywords: public, static, void. Three identifiers: main, Stirng, and args.
  // Five punctuation: (, ), [, ] ,and {
  // The { here starts a scope block for the method main and will be closed later in the code.
  // Everything in-between the main methods curly braces belongs to the main method.
  public static void main(String args[]){

    // One keyword: int. One identifier: hours.
    // One operator: =. One literal value: 25.0. One punctuation: ;
    int hours = 40;

    // One keyword: double. Two identifiers: grossPay and payRate.
    // One operator: =. One literal value: 25.0. Two punctuation: , and ;
    double grossPay, payRate = 25.0;

    /*
      Note, the above line can also be legally written as follows.
      It is also probably better written in the later. We want to avoid
      confusion and write clear concise code.

      double grossPay = 0.0;
      double payRate = 25.0;
    */

    // Three identifiers: grossPay, hours, and payRate. Two operators: = and *. One punctuation: ;
    grossPay = hours * payRate;

    // 4 identifiers: System, out, println, and grossPay. One literal: "Your gross pay is $"
    // 3 operators: ., ., +. Three punctuation: (, ), and ;
    System.out.println("Your gross pay is $" + grossPay);

  // This curly brace is punctuation and ends the last opened curly brace which in this case is the
  // main methds curly brace
  }

// the last closing curly brace closes the first opened curly brace which in this case belongs the class Payroll.
}
