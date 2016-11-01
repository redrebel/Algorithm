package datastructure.stacks.waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by cjred77@gmail.com on 2016. 10. 31..
 * https://www.hackerrank.com/challenges/waiter
 */
public class Solution {
  /**
   * return next prime number
   * @param p
   * @return
   */
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
    Stack<Integer> stack = new Stack<>();
    List<Stack<Integer>> plates = new ArrayList<>();

    for(int i=0; i<N; i++){
      stack.push(in.nextInt());
    }
    int prime = 2;
    for(int i=0; i<Q; i++){
      System.out.println(prime);
      Stack<Integer> A = new Stack<>();
      Stack<Integer> B = new Stack<>();
      int stackSize = stack.size();
      for(int j=0; j<stackSize; j++){
        int number = stack.pop();
        System.out.println("mod :" + number%prime);
        if(number%prime!=0){
          A.push(number);
          System.out.println("A.push " + number);
        }
        else{
          B.push(number);
          System.out.println("B.push " + number);
        }

      }
      //get next prime number
      prime = getNextPrime(prime);
      stack = A;
      plates.add(B);

      System.out.println("A:" + A);
      System.out.println("B:" + B);
    }
    for(Stack<Integer> s : plates){
        while(s.size()!=0){
          System.out.println(s.pop());
        }
    }
    while(stack.size()!=0){
      System.out.println(stack.pop());
    }
  }
}
