package hackerrank.generics;


//import java.lang.reflect.Method;

/**
 * Created by cjred77@gmail.com on 2016. 7. 8..
 */


public class Solution {

  public static <E> void printArray(E[] data){
    for(E t: data){
      System.out.println(t);
    }
  }

  public static void main(String args[]){
    Integer[] intArray = { 1, 2, 3 };
    String[] stringArray = { "Hello", "World" };

    printArray( intArray  );
    printArray( stringArray );

    if(Solution.class.getDeclaredMethods().length > 2){
      System.out.println("You should only have 1 method named printArray.");
    }
  }
}
