package hackerrank.n_st_prime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler007
 * Created by cjred77@gmail.com on 2016. 4. 25..
 */
public class Solution {

  public static List primeList = new ArrayList<Integer>();

  public static boolean isPrime(int n){
    boolean isPrime = true;
    for(int i = 0; i<primeList.size(); i++){
      if((n%(Integer)primeList.get(i))==0){
        return false;
      }
    }
    return true;
  }

  public static int getPrime(int n){
    int listSize = primeList.size();
    if(n<=primeList.size()){
      int prime = (Integer)primeList.get(n-1);
      return prime;
    }
    for(int i = (Integer)primeList.get(listSize-1)+2; ; i++){
      if(isPrime(i)){
        primeList.add(i);
        if(primeList.size()==n){
          return i;
        }
      }
    }
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    primeList.add(2);
    primeList.add(3);
    primeList.add(5);
    int T = in.nextInt();
    for(;T>0;T--){
      int n = in.nextInt();
      long start = System.currentTimeMillis();

      int result = getPrime(n);
      System.out.println(result);
      System.out.println((float)(System.currentTimeMillis() - start));

    }
  }
}
