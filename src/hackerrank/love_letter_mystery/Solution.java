package hackerrank.love_letter_mystery;

import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 6. 14..
 */
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (; T > 0; T--) {
      byte[] b = in.next().getBytes();
      int len = b.length;
      int c = 0;
      for(int i=0; i<len/2;i++){
        c += Math.abs(b[i] - b[len-(1+i)]);
      }
      System.out.println(c);
    }
  }
}
