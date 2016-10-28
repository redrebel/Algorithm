package datastructure.stacks.equal_stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by cjred77@gmail.com on 2016. 10. 28..
 * https://www.hackerrank.com/challenges/equal-stacks
 */
public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int n3 = in.nextInt();
    int h1[] = new int[n1];
    for(int h1_i=0; h1_i < n1; h1_i++){
      h1[h1_i] = in.nextInt();
    }
    int h2[] = new int[n2];
    for(int h2_i=0; h2_i < n2; h2_i++){
      h2[h2_i] = in.nextInt();
    }
    int h3[] = new int[n3];
    for(int h3_i=0; h3_i < n3; h3_i++){
      h3[h3_i] = in.nextInt();
    }
    int h1_h = 0;
    int h2_h = 0;
    int h3_h = 0;

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    Stack<Integer> s3 = new Stack<>();

    for(int i = h1.length-1; i>=0; i--){
      int h = h1[i];
      h1_h += h;
      s1.push(h);
    }

    for(int i = h2.length-1; i>=0; i--){
      int h = h2[i];
      h2_h += h;
      s2.push(h);
    }

    for(int i = h3.length-1; i>=0; i--){
      int h = h3[i];
      h3_h += h;
      s3.push(h);
    }

    int sHeight = 0;
    int maxHeight = 0;
    while(!s1.isEmpty() || !s2.isEmpty() || !s3.isEmpty() ){

      maxHeight = Math.max(h1_h, h2_h);
      maxHeight = Math.max(maxHeight, h3_h);

      if(h1_h == h2_h && h2_h == h3_h){
        sHeight = maxHeight;
        break;
      }

      if(!s1.isEmpty() && h1_h >= maxHeight){
        h1_h -= s1.pop();
      }

      if(!s2.isEmpty() && h2_h >= maxHeight){
        h2_h -= s2.pop();
      }

      if(!s3.isEmpty() && h3_h >= maxHeight){
        h3_h -= s3.pop();
      }
    }

    System.out.println(sHeight);
  }
}
