package datastructure.heap.qheap1;

import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 11. 17..
 * https://www.hackerrank.com/challenges/qheap1
 */
public class Solution {
  // min heap
  static int[] heap = new int[100000];
  static int heapSize = 0;

  public static void swap(int pos1, int pos2){
    int tmp = heap[pos1];
    heap[pos1] = heap[pos2];
    heap[pos2] = tmp;
  }

  /**
   * @param pos
   * 입력받은 위치(pos)의 값과 부모위치(parentPos)의 값을 비교하여 자식이 작은 경우 교환하며 올라간다
   */
  public static void heapifyUp(int pos){
    int parentPos = (pos-1)/2;
    while(pos>0 && heap[parentPos] > heap[pos]){
      swap(parentPos, pos);
      pos = parentPos;
      parentPos = (pos-1)/2;

    }
  }

  public static void insert(int n){
    if(heapSize > heap.length){
      return;
    }
    heap[heapSize] = n;

    heapifyUp(heapSize);
    heapSize++;
  }

  /**
   * 입력받은 위치(pos)의 값과 자식위치(leftPos, rightPos)의 값을 비교하여 자식이 작으면 교환하며 내려간다.
   * @param pos
   */
  public static void heapifyDown(int pos){
    while(true){
      //System.out.println(heap[pos] + ", ");
      int leftPos = (pos * 2) + 1;
      int rightPos = leftPos + 1;
      if(leftPos >= heapSize){
        return;
      }else if(rightPos >= heapSize && heap[pos] > heap[leftPos]){
        swap(pos, leftPos);
        pos = leftPos;
        continue;
      }else if(heap[pos] < Math.min(heap[leftPos], heap[rightPos])){
        return;
      }

      if(heap[leftPos] < heap[rightPos]){
        swap(pos, leftPos);
        pos = leftPos;
        continue;
      } else {
        swap(pos, rightPos);
        pos = rightPos;
        continue;
      }
    }
  }

  public static void delete(int n){
    int pos;
    for(pos=0; pos<heapSize; pos++){
      if(heap[pos] == n){
        heap[pos] = heap[heapSize-1];
        heapSize--;
        break;
      }
    }

    heapifyDown(pos);
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
    int n;
    while(Q-->0){
      int type = in.nextInt();
      switch(type){
        case 1:
          n = in.nextInt();
          insert(n);
          //printHeap();
          break;
        case 2:
          n = in.nextInt();
          delete(n);
          //printHeap();
          break;
        case 3:
          System.out.println(heap[0]);
          printHeap();
          break;
      }
    }
  }
}
