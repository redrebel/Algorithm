package hackerrank.largest_palindrome_product;
import java.io.*;
import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 3. 23..
 *
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler004
 * A palindromic number reads the same both ways. The smallest 6 digit palindrome made from the product of two 3-digit numbers is 101101=143×707101101=143×707.

 Find the largest palindrome made from the product of two 3-digit numbers which is less than NN.

 Input Format
 First line contains TT that denotes the number of Solution cases. This is followed by TT lines, each containing an integer, NN.

 Output Format
 Print the required answer for each Solution case in a new line.

 Constraints
 1≤T≤1001≤T≤100
 101101<N<1000000

 Sample Input
 2
 101110
 800000

 Sample Output
 101101
 793397
 */
public class Solution {
  public static boolean chkPal(int num){
    int a0 = num/100000;
    int a1 = (num/10000)%10;
    int a2 = (num/1000)%10;
    int a3 = (num/100)%10;
    int a4 = (num/10)%10;
    int a5 = num%10;
    if(a0==a5 && a1==a4 && a2==a3)
      return true;
    return false;
  }
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(;t>0;t--){
      int input = in.nextInt();
      int result = 0;
      for(int i=143;i<=999;i++){
        for(int j=707;j<=999;j++){
          int num = i*j;
          if(num > input){
            break;
          }
          if(chkPal(num)){
            if(num > result)
              result = num;
          }
        }
      }
    System.out.println(result);
    }
  }
}
