package hackerrank.utopia_tree;

/**
 * Created by cjred77@gmail.com on 2016. 3. 17..
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int a0 = 0; a0<t; a0++){
      int n = in.nextInt();
      double result = Math.pow(2, Math.ceil(n/2.0)+1)-(n%2+1);
      System.out.println((int)result);
    }
  }
}
