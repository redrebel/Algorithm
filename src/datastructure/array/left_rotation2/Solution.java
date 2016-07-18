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
    if(n/2==d){
      // if shift n/2 then I have Bug in my Solution
      // So other Solution blow.
      for(int i=0;i<d; i++){
        int tmp = arr[i];
        arr[i] = arr[i+d];
        arr[i+d] = tmp;
      }
      printArr(arr);
      sc.close();
      return;
    }
    //printArr(arr);
    int pos = 0;
    int data = arr[pos];
    for(int i=0;i<n; i++){
      // pick
      pos = (pos+n-d)%n;
      int tmp = arr[pos];
      arr[pos] = data;
      data = tmp;
      if(pos==0){
        pos=1;
        data=arr[pos];
      }
      System.out.println(i + ": " + pos + "," + tmp + "," + arr[pos]);
    }
    printArr(arr);
    sc.close();
  }
}