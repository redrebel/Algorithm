package mathbook.smallest_multiple;

import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 11. 3..
 * 임의의 숫자가 x 가 주어졌을때 x = a * b 를 만족하고 a 와 b 의 합이 가장 작은 경우의 a 와 b 를 구하시오.
 * 첫번째 줄에 입력하는 T 는 테스트 횟수
 * 그 다음 줄부터 T 만큼 입력 받아서 각각의 N 에 대하여 N = a * b 형식으로 출력하시요
 * 예)
 * input
 * 3
 * 3
 * 32
 * 23532
 * output
 * 3 = 1 X 3
 * 32 = 4 X 8
 * 23532 = 148 X 159
 */
public class Solution {
  public static void proc(int num){
    for(int i=(int)Math.sqrt(num); i>=1; i--){
      if(num%i==0){
        System.out.println(num + " = " + i + " X " + num/i);
        return;
      }
    }
  }
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    // 테스트 횟수
    int T = in.nextInt();

    while(T-->0){
      int num = in.nextInt();
      proc(num);
    }

  }
}
