package datastructure.heap.qheap1;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 11. 22..
 * https://www.hackerrank.com/challenges/qheap1
 * PriorityQueue를 사용하는 방법
 */
public class Solution2 {
  public static void main(String ... args){
    Scanner in = new Scanner(System.in);
    int Q = in.nextInt();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    while(Q-->0){
      int type = in.nextInt();
      switch(type){
        case 1:
          int v = in.nextInt();
          minHeap.add(v);
          break;
        case 2:
          v = in.nextInt();
          minHeap.remove(v);
          break;
        case 3:
          v = minHeap.peek();
          System.out.println(v);
          break;
      }
    }
  }
}
