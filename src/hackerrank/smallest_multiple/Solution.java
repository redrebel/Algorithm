package hackerrank.smallest_multiple;

import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 3. 25..
 */
public class Solution {

  public static int gcd(int a, int b){
    if(b==0) return a;
    return gcd(b, a%b);
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    for(;t>0;t--){
      int n = in.nextInt();
      int result = 1;
      for(int i=1; i<=n; i++){
        int f = result*i;
        int g = gcd(result,i);
        result = f/g;
      }
      System.out.println(result);
    }
  }
}
