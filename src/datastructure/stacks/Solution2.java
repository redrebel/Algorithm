package datastructure.stacks;

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

/**
 * ArrayList 을 스택으로써 사용한다.
 * 장점 : 미리 배열을 사이즈를 정의하지 않아도 된다.
 * 단점 : 배열의 사이즈가 커지면 3(최대값 조회)의 성능이 떨어진다.
 */
public class Solution2 {

  public static void main(String[] args) {

    int top = 0;
    List<Integer> stack = new ArrayList<>();

    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    while(T-->0){
      int cmd = in.nextInt();
      if(cmd == 1){
        int n = in.nextInt();
        stack.add(top, n);
      }
      else if(cmd == 2){
        top--;
      }
      else if(cmd == 3){
        int max = 0;
        // ArraryList 에서 최대값을 가져온다.
        for(int i = 0; i<top;i++){
          max = max < stack.get(i) ? stack.get(i) : max;
        }
        System.out.println(max);
      }
    }
  }
}