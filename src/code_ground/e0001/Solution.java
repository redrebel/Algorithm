package code_ground.e0001;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by red on 2016. 2. 1..
 * 숫자 골라내기
 */
public class Solution {
  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(System.in);

    int TC = s.nextInt();

    for (int test_case = 1; test_case <= TC; test_case++) {
      int num = s.nextInt();
      s.nextLine();
      String[] arr = s.nextLine().split(" ");

      Map<String, Integer> map = new HashMap<String, Integer>();
      for (int i = 0; i < num; i++) {
        if (map.get(arr[i]) != null) {
          map.put(arr[i], map.get(arr[i]) + 1);
        } else {
          map.put(arr[i], 1);
        }
      }

      int xor = 0;
      for (String key : map.keySet()) {

       // System.out.println("key " + key + ", value : " + map.get(key));
        if((map.get(key) % 2) == 1){
          xor = xor^(Integer.parseInt(key));
          //System.out.println("xor : " + xor);
        }
      }
      //System.out.println("result xor : " + xor);
      System.out.println("Case #" + test_case);
      System.out.println(xor);
    }
  }
}
