package hackerrank.stockmax;

import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2017. 3. 2..
 * https://www.hackerrank.com/challenges/stockmax
 */

public class Solution {
  public static long stockmax(int[] prices, int N){
    int maxPrice = 0;
    long profit = 0;
    for(int i = N-1; i>=0; i--) {
      int price = prices[i];
      if (maxPrice > price) {
        profit += maxPrice - price;
      } else {
        maxPrice = price;
      }
    }
    return profit;
  }
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for(;T>0;T--) {
      int N = in.nextInt();
      int[] prices = new int[N];
      for(int i=0; i<N; i++){
        prices[i] = in.nextInt();
      }
      long profit = stockmax(prices,N);
      System.out.println(profit);
    }
  }
}
