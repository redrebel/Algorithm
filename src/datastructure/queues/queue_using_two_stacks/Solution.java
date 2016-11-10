package datastructure.queues.queue_using_two_stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by cjred77@gmail.com on 2016. 11. 10..
 * https://www.hackerrank.com/challenges/queue-using-two-stacks
 */
public class Solution {
  static Stack<Integer> input = new Stack<>();
  static Stack<Integer> output = new Stack<>();

  public static void enqueue(int n){
    input.add(n);
  }

  public static int dequeue(){
    if(output.isEmpty()){
      while(!input.isEmpty()){
        output.add(input.pop());
      }
    }
    return output.pop();
  }

  public static void print(){
    if(output.isEmpty()){
      while(!input.isEmpty()){
        output.add(input.pop());
      }
    }
    System.out.println(output.peek());
  }

  public static void main(String... args){
    Scanner in = new Scanner(System.in);

    int q = in.nextInt();
    while(q-->0){
      int type = in.nextInt();
      switch (type){
        case 1:
          enqueue(in.nextInt());
          break;
        case 2:
          dequeue();
          break;
        case 3:
          print();
          break;
        default:
          break;
      }
    }
  }
}
