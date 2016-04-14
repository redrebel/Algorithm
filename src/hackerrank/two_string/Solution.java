package hackerrank.two_string;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by cjred77@gmail.com on 2016. 4. 12..
 */
public class Solution {
  public static String comp(String a, String b){
    Set s = new TreeSet();
    for(int i=0; i<a.length();i++){
      s.add(a.charAt(i));
    }

    for(int j=0; j<b.length();j++){
      if(s.contains(b.charAt(j)))
        return "YES";
    }

    return "NO";
  }
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for(;T>0;T--){
      String a = in.next();
      String b = in.next();
      System.out.println(comp(a,b));
    }
  }
}
