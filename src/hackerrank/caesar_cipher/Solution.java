package hackerrank.caesar_cipher;

import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 3. 30..
 */
public class Solution {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    String s = in.nextLine();
    int k = in.nextInt();
    String result = "";

    int cap = 'Z'-('A'-1);
    k %= cap;
    for(int i=0; i<n; i++){
      char c = s.charAt(i);
      if(c>='A'&&c<='Z'){
        c += k;
        if(c>'Z') c -= 'Z'-('A'-1);
      }
      if(c>='a' && c<='z'){
        c += k;
        if(c>'z') c -= 'z'-('a'-1);
      }
      result += String.valueOf(c);
    }

    System.out.println(result);
  }
}
