public class Primitives {

  public static void main(String args[]){


    byte someByte = 100;
    short someShort = 10000;
    int someInt = 1000000000;
    long someLong = 1000000000;
    float someFloat = 1.3434f;
    double someDouble = 1.2345678;
    char someChar = 'a';
    boolean someBoolean = false;

    System.out.println(someByte + " " + someShort + " " + someInt + " " + someLong + " " + someFloat + " " + someDouble + " " + someChar + " " + someBoolean);

    byte _byte = 45;
    char a = 'a';
    short one = 1;
    int two = 2;
    long three = 3;
    float four = 4.0f;
    double five = 5.0;
    boolean f = false;

    System.out.println(_byte + " " + a + " " + one + " " + two + " " + three + " " + four + " " + five + " " + f);
    _byte = '!';
    a = 33;
    five = 5;


    System.out.println(_byte + "  " + a + " " + five + " " + f);

    /*
      Errors on purpose
    */
    // one = 1.0;
    // two = 1.0;
    // three = 3.0;
    // four = 4.0;
    // f = 1;
    // someShort = 1000000000;
    // someInt = 1000000000000;
    // someLong = 10000000000000;




  }
}
