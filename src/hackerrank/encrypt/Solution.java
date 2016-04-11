package hackerrank.encrypt;

import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 4. 5..
 */
public class Solution {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String s = in.next();
    int L = s.length();
    double sqrt = Math.sqrt(L);
    int rows = (int)Math.round(sqrt);
    int column = (int)Math.ceil(sqrt);
    String result = "";
    for(int i=0; i<column; i++){
      for(int j=0; j<rows; j++){
        int pos = i + column*j;
        if(pos>=L) continue;
        result += String.valueOf(s.charAt(pos));
      }
      result += " ";
    }
    System.out.println(result);
  }
}
