package hackerrank.sherlock_and_array;

import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 6. 14..
 */
public class Solution {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for(;T>0;T--){
      int N = in.nextInt();
      Integer[] A = new Integer[N];
      in.nextLine();
      String s = in.nextLine();
      String[] arr = s.split(" ",N);
      for(int i=0; i<N; i++){
        A[i] = Integer.parseInt(arr[i]);
      }

      boolean result = false;
      int sum = 0;
      for(int a=0; a<N; a++){
        sum += A[a];
      }

      int sum1 = 0;
      int sum2 = sum;
      for(int i=0; i<N; i++){
        sum1 += (i == 0 ? 0 : A[i-1]);
        if(i==N-1){
          sum2 = 0;
        }
        else{
          sum2 -= (i == N-1 ? 0 : A[i]);
        }

        if(sum1 == sum2){
          result = true;
          break;
        }

      }
      if(result==true)           System.out.println("YES");
      else        System.out.println("NO");
    }
  }
}
