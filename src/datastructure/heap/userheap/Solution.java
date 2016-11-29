package datastructure.heap.userheap;

/**
 * Created by cjred77@gmail.com on 2016. 11. 23..
 */
public class Solution {
  public static void main(String... args){
    MinHeap<Integer> minHeap = new MinHeap<>();
    minHeap.add(10);
    minHeap.add(30);
    minHeap.add(20);
    minHeap.add(21);
    minHeap.add(23);
    minHeap.add(2);
    System.out.println(minHeap);
  }


}
