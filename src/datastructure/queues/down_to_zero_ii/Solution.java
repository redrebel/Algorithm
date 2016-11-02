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
      if(isPrime(n)){
        n--;
        continue;
      }

      Queue<Integer> queue = new LinkedList<>();

      int prime = 2;
      while(true){
        if(n%prime==0){
          queue.add(prime);
          int i = n/prime;
          if(isPrime(i)){
            queue.add(i);
            break;
          }
          else{
            n=i;
            prime = 2;
          }
        }
        else {
          prime = getNextPrime(prime);
        }
      }

      int half = queue.size()/2;
      int a = 1;
      int b = 1;

      for(int i=0; !queue.isEmpty(); i++){
        // queue에서 절반으로 나눠서 각자 곱한값을 a 와 b 로 가정(하지만 틀렸음)
        if(i<half){
          a *= queue.poll();
        }
        else {
          b *= queue.poll();
        }
      }
      //System.out.println(a + " x " + b);

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
