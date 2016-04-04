package hackerrank.sum_squar_difference;

import java.util.Scanner;

import static java.lang.Math.pow;

/**
 * Created by cjred77@gmail.com on 2016. 3. 29..
 */
public class Solution {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(;t>0;t--){
      int n = in.nextInt();
//      long squarOfSum = (long)pow(n*(n+1)/2,2);
//      long sumOfSquar = (long)n*(n+1)*(2*n+1)/6;
//      long result = (squarOfSum-sumOfSquar);
      long result = n*(n+1)*(3*n*n-n-2);
      System.out.println(result);
    }
  }
}
