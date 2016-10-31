package datastructure.stacks.waiter;

import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 10. 31..
 * https://www.hackerrank.com/challenges/waiter
 */
public class Solution {
  public static int getNextPrime(int p){
    int nextPrime = ++p;
    while (true){
      boolean isPrime = true;
      for(int i=2; i<=Math.sqrt(nextPrime); i++){
        if(nextPrime % i == 0){
          isPrime = false;
          break;
        }
      }
      if(isPrime){
        return nextPrime;
      }
      nextPrime++;
    }
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int Q = in.nextInt();
    int prime = 2;
    for(int i=0; i<Q; i++){
      System.out.println(prime);
      prime = getNextPrime(prime);
    }
  }
}
