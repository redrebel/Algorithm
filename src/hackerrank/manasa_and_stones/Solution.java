package hackerrank.manasa_and_stones;

import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 4. 4..
 * https://www.hackerrank.com/challenges/manasa-and-stones/copy-from/18976418
 *
 */
public class Solution {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for(;T>0;T--) {
      int n = in.nextInt();
      int a = in.nextInt();
      int b = in.nextInt();

      if(a>b){
        // increasing oder
        int temp=a;
        a=b;
        b=temp;
      }
      else if(a==b){
        // if same a and b then result's count is one.
        int result = (n-1)*a;
        System.out.print(result +"\n");
        continue;
      }

      for(int i=(n-1); i>=0; i--){
        int j = (n-1)-i;
        int result = (a*i) + (b*j);
        System.out.print(result);
        if(i>0) System.out.print(' ');
        else System.out.print('\n');
      }
    }
  }
}
