package datastructure.stacks.simple_text_editor;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by cjred77@gmail.com on 2016. 10. 25..
 * https://www.hackerrank.com/challenges/simple-text-editor
 *
 */
public class Solution {

  public static void main(String[] args){
    StringBuilder sb = new StringBuilder();
    Stack<String> stack = new Stack<>();
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for(int i = 0; i<T; i++){

      int t = in.nextInt();
      int k;
      switch (t){
        case 1:
          stack.push(sb.toString());
          String s = in.next();
          sb.append(s);
          //System.out.println(s);
          break;
        case 2:
          stack.push(sb.toString());
          k = in.nextInt();
          sb.delete(sb.length()-k, sb.length());
          break;
        case 3:
          k = in.nextInt();
          System.out.println(sb.charAt(k-1));
          break;
        case 4:
          sb.setLength(0);
          sb.append(stack.pop());
      }
    }
  }
}
