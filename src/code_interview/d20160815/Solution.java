package code_interview.d20160815;
import java.util.*;
/**
 * Created by cjred77@gmail.com on 2016. 8. 15..
 */
public class Solution {

  /* track1
  public static int solution(int A, int B) {
    int cnt = 1;
    int maxA = (int)Math.sqrt(A);
    maxA++;
    for(int i=A+1; i<B; i++){
      if((maxA*maxA) == i){
        cnt++;
        maxA++;
      }
    }
    return cnt;
  }*/

  public static boolean checkSored(int[] A){
    printArr(A);
    for(int i=0; i<A.length-1; i++){
      if(A[i]>A[i+1]){
        return false;
      }
    }
    return true;
  }

/*  public static boolean solution(int[] A) {
    // write your code in Java SE 8
    if(checkSored(A)){
      return true;
    }
    int[] cloneA = new int[A.length-2];
    for(int i=0; i<(A.length-1); i++){
      if(A[i] > A[i+1]){
        for(int j=i+1; j<(A.length-1); j++){
          if(A[i-1]<A[j] && A[i] < A[j+1]){
            int pos = 0;
            for(int b=0;b<A.length;b++) {
              if (b != i && b != j) {
                cloneA[pos] = A[b];
                pos++;
              }
              boolean bool = checkSored(cloneA);
              System.out.println("bool : " + bool + "   i:" + i + ", j:" + j);
              if(bool){
                return true;
              };

            }
          }
        }
      }
    }
    return false;
  }*/

  public static boolean solution(int[] A) {
    // write your code in Java SE 8

    int[] cloneA = new int[A.length];

    for(int i = 0; i < A.length; i++) {
      cloneA[i] = A[i];
    }

    Arrays.sort(cloneA);

    int cnt = 0;
    for(int j=0; j<A.length; j++){
      if(A[j] != cloneA[j]){
        cnt++;
      }
    }

    if(cnt > 2) return false;
    return true;
  }

public static void printArr(int[] a){
  for(int i=0;i<a.length;i++){
    System.out.print(a[i]);
  }
  System.out.println();
}
/* track3
public static int solution(int[] A) {
  // write your code in Java SE 8

  Arrays.sort(A);

  int[] sdt = new int[A.length];

  for(int i = 1; i<A.length; i++) {
    sdt[i] = A[i] - A[i-1];
  }

  printArr(sdt);
  int maxCnt = 0;
  int cnt = 1;
  for(int i=0; i<A.length; i++){
    if(sdt[i]==0){
      cnt++;
    }
    else{
      maxCnt = Math.max(maxCnt,cnt);
      cnt = 0;
    }
  }

  return maxCnt;
}*/

  public static void main(String[] args) {
    //System.out.println(solution(4,17));
    //int[] arr = { 1, 5, 3, 3 ,7};
    //int[] arr = { 1, 5, 3, 2 ,7};
    int[] arr = { 1, 3, 5, 3 ,4};
    //int[] arr = { 1, 5, 3, 2, 3, 2 ,7};

    //int[] arr = { 1, 3, 3, 5 ,7};
    //int[] arr = { 6, 10, 6, 9 ,7, 8};
    System.out.println(solution(arr));
    //System.out.println(checkSored(arr));
  }
}