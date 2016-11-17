package datastructure.heap.qheap1;

import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 11. 17..
 * https://www.hackerrank.com/challenges/qheap1
 */
public class Solution {
  static int[] heap = new int[100000];
  static int heapSize = 0;

  public static void insert(int n){
    if(heapSize > heap.length){
      return;
    }
    heap[heapSize] = n;
    heapSize++;

    int usedPos = heapSize-1;
    int parentPost = (int)((usedPos-1)/2);
    while(usedPos>0 && heap[parentPost] > heap[usedPos]){
      int tmp = heap[parentPost];
      heap[parentPost] = heap[usedPos];
      heap[usedPos] = tmp;
      usedPos = parentPost;
      parentPost = (int)((usedPos-1)/2);

    }
  }

  public static void delete(int n){
  }

  public static void printHeap(){
    for(int i = 0; i<heapSize; i++){
      System.out.print(heap[i] + ", ");
    }
    System.out.println();
  }


  public static void main (String... args){

    Scanner in = new Scanner(System.in);
    int Q = in.nextInt();
    while(Q-->0){
      int type = in.nextInt();
      switch(type){
        case 1:
          int n = in.nextInt();
          insert(n);
          printHeap();
          break;
        case 2:
          break;
        case 3:
          break;
      }
    }
  }
}
