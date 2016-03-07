package mathbook.p140913;

/**
 * Created by cjred77@gmail.com on 2016. 3. 7..
 */
public class Fibonacci {
  public static int fibonacci(int n){
    if(n<=1){
      return n;
    }

    return fibonacci(n-2)+fibonacci(n-1);
  }
  public static void main(String[] args){
    int num = 7;
    String s = "[";
    for(int i = 1; i<=num; i++) {
      s += fibonacci(i);
      if(i<num) s += ", ";
    }
    System.out.println(s+"]");
  }
}
