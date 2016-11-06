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

  public static int downToZero(int num){

    Queue<Integer> queueA = new LinkedList<>();
    queueA.add(num);
    for(int cnt=0;;cnt++){
      Queue<Integer> queueB = new LinkedList<>();
      //System.out.println("\n"+cnt);
/*      if(isPrime(n)){
        n--;
        continue;
      }*/
      while (!queueA.isEmpty()) {
        int n = queueA.poll();
        //System.out.println(n + " : get");
        if (n < 1) {
          return cnt;
        }
        if (n < 2) {
          Queue<Integer> queueC = new LinkedList<>();
          queueC.add(--n);
          queueB = queueC;
          break;
        }
        int a = (int) Math.sqrt(n);
        while (a > 1) {
          if (n % a == 0) {
            int b = n / a;
            int n1 = Math.max(a, b);
            queueB.add(n1);
            //System.out.println(n + " = " + a + " x " + b);
          }
          --a;
        }

        n--;
        queueB.add(n);
      }
      queueA = queueB;
    }
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int Q = in.nextInt();
    for(;Q>0;Q--){
      int N = in.nextInt();
      int cnt = downToZero(N);
      System.out.println(N + " cnt : " + cnt);
    }
  }
}
