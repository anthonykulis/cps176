public class TwoD {

  public static void main(String[] args){
    int[][] nums = {{1,2}, {3,4}};

    //print out contents of array
    System.out.print("{");
    for(int i = 0; i < nums.length; i++){
      System.out.print("{");
      for(int j = 0; j < nums[i].length; j++){
        System.out.print(nums[i][j] + (j == nums[i].length - 1 ? "}" : ", "));
      }
      if(i < nums.length - 1) System.out.print(", ");
    }
    System.out.println("}");

  }


}
