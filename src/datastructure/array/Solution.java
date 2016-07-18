package datastructure.array;
/*
https://www.hackerrank.com/challenges/array-left-rotation
 */
import java.util.*;

public class Solution {
  public static void printArr(int[] arr){
    for(int i:arr){
      System.out.print(i+" ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // the number of integer
    int n = sc.nextInt();
    // the number of left rotations
    int d = sc.nextInt();

    // cut the rotation size
    d = d%n;

    int[] arr = new int[n];
    for(int i=0; i<n; i++ ){
      arr[i] = sc.nextInt();
    }
    //printArr(arr);

    int[] otherArr = new int[n];
    for(int i=0; i<n; i++){
      // point that have to left rotation move
      int pos = (i+n-d)%n;
      otherArr[pos] = arr[i];
    }
    printArr(otherArr);
  }
}