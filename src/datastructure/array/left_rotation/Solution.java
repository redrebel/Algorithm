package datastructure.array.left_rotation;
/**
 * Created by cjred77@gmail.com on 2016. 7. 18..
 * https://www.hackerrank.com/challenges/array-left-rotation
 *
 * use memory size of n*2
 */
import java.util.*;

public class Solution {
  public static void printArr(int[] arr){
    for(int i:arr){
      System.out.print(i+" ");
    }
    System.out.println();
  }

  public static void leftRotation1(int[] arr, int n, int d){
    int[] otherArr = new int[n];
    for(int i=0; i<n; i++){
      // point that have to left rotation move
      int pos = (i+n-d)%n;
      otherArr[pos] = arr[i];
    }
    printArr(otherArr);
  }

  public static void leftRotation2(int[] arr, int n, int d){
    // cut the rotation size
    d = d%n;

    int[] otherArr = new int[n];

    System.arraycopy(arr,0,otherArr,n-d,d);
    System.arraycopy(arr,d,otherArr,0,n-d);

    printArr(otherArr);

  }

  public static void leftRotation3(int[] arr, int n, int d){
    if(n/2==d && n%2==0){
      // if shift n/2 and n is even then
      leftRotation2(arr, n, d);
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
      //System.out.println(i + ": " + pos + "," + tmp + "," + arr[pos]);
    }
    printArr(arr);

  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // the number of integer
    int n = sc.nextInt();
    // the number of left rotations
    int d = sc.nextInt();

    int[] arr = new int[n];
    for(int i=0; i<n; i++ ){
      arr[i] = sc.nextInt();
    }
    //printArr(arr);

    leftRotation1(arr, n, d);
    leftRotation2(arr, n, d);
    leftRotation3(arr, n, d);
    sc.close();
  }
}