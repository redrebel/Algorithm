package hackerrank.game_of_thrones;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 4. 11..
 */
public class Solution {
  public static boolean proc(String input){
    Map<String, Integer> map = new HashMap<>();
    for(int i=0; i<input.length();i++){
      String w = String.valueOf(input.charAt(i));
      Integer count = (map.containsKey(w) ? map.get(w): 0);
      map.put(w, count+1);
    }

    int checkDouble = 0;

    for(String key: map.keySet()){
      Integer count = map.get(key);
      if(count%2 == 1){
        checkDouble++;
        if(checkDouble>1){
          return false;
        }
      }
    }

    return true;
  }
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String input = in.next();
    if(proc(input)){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }

}
