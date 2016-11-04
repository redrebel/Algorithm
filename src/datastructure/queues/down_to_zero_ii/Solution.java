package datastructure.queues.down_to_zero_ii;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 11. 2..
 * https://www.hackerrank.com/challenges/down-to-zero-ii
 */
public class Solution {
  public static boolean isPrime(int n){
    for(int i=2; i<=Math.sqrt(n);i++){
      if(n%i==0){
        return false;
      }
    }
    return true;
  }

  public static int getNextPrime(int p){
    while(true){
      p++;
      if(isPrime(p)){
        return p;
      }
    }
  }

  public static void downToZero(int n){
    for(int cnt=0;;cnt++){
      //System.out.println(n);
      if(n<=0){
        System.out.println(cnt);
        return;
      }
/*      if(isPrime(n)){
        n--;
        continue;
      }*/
      int a = (int)Math.sqrt(n);
      int b = 1;
      while (a>0){
        if(n%a==0){
          b = n/a;
          break;
        }
        --a;
      }

      if(a==1){
        n--;
        continue;
      }

      //System.out.println(n + " = " + a + " x " + b);

      n = Math.max(a, b);
    }
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int Q = in.nextInt();
    for(;Q>0;Q--){
      int N = in.nextInt();
      downToZero(N);
    }
  }
}
