package datastructure.stacks.maximum_element;

/**
 * Created by cjred77@gmail.com on 2016. 10. 17..
 *
 * https://www.hackerrank.com/challenges/maximum-element
 * input :
 10
 1 97
 2
 1 20
 2
 1 26
 1 20
 2
 3
 1 91
 3
 * output
 26
 91
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Stack 을 사용한다.
 * 장점 : 스택의 사이즈가 커져도 3(최대값 조회)의 시간복잡도 성능이 일정하다. O(1)
 * 단점 : 2개의 스택을 사용하므로 공간복잡도가 상대적으로 커진다.
 */
public class Solution3 {

  public static void main(String[] args) {

    // input 을 저장한다.
    Stack<Integer> stack = new Stack<>();
    // 최대값을 저장한다.
    Stack<Integer> max = new Stack<>();

    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    while(T-->0){
      int cmd = in.nextInt();
      if(cmd == 1){
        int n = in.nextInt();
        stack.push(n);
        if(max.size() == 0 || max.peek() < n){
          max.push(n);
        }
      }
      else if(cmd == 2){
        int pop = stack.pop();
        if(pop == max.peek()){
          max.pop();
        }
      }
      else if(cmd == 3){

        System.out.println(max.peek());
      }
    }
  }
}