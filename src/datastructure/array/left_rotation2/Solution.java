package datastructure.array.left_rotation2;

/**
 * Created by cjred77@gmail.com on 2016. 7. 18..
 * https://www.hackerrank.com/challenges/array-left-rotation
 * more small memory use.
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
    int i = 0;
    int data = arr[i];
    while(n-->0){
      // pick
      i = (i+n-d)%n;
      int tmp = arr[i];
      arr[i] = data;
      data = tmp;
    }
    printArr(arr);
  }
}