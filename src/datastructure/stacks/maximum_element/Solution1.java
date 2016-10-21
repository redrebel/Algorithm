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
import java.util.*;

/**
 * 일반적인 배열을 스택으로써 사용한다.
 * 단점 : 미리 배열을 사이즈를 정해봐야한다.
 */
public class Solution1 {

  public static void main(String[] args) {
    int[] stack = new int[1000000];
    int top = 0;

    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    while(T-->0){
      int cmd = in.nextInt();
      if(cmd == 1){
        int n = in.nextInt();
        stack[top] = n;
        top++;
      }
      else if(cmd == 2){
        top--;
      }
      else if(cmd == 3){
        int max = 0;
        // 배열에서 최대값을 가져온다.
        for(int i = 0; i<top;i++){
          max = max < stack[i] ? stack[i] : max;
        }
        System.out.println(max);
      }
    }
  }
}