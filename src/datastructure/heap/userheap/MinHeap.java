package datastructure.heap.userheap;

import datastructure.arraylist.ArrayLists;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by cjred77@gmail.com on 2016. 11. 21..
 */
public class MinHeap<E> implements UserHeap<E> {
  // 데이터가 담겨질 배열
  private Object[] heap;
  // 비어있는 힙의 사이즈는 0
  private int size = 0;

  public MinHeap(){this(DEFAULT_INITIAL_CAPACITY);}

  /**
   * 가용치를 지정한 경우
   * @param initialCapacity
   */
  public MinHeap(int initialCapacity){
    this.heap = new Object[initialCapacity];
  }

  private void grow(){
    int oldCapacity = heap.length;
    // double size + 1
    int newCapacity = 2 * oldCapacity + 1;
    if(newCapacity > MAX_ARRAY_SIZE){
      newCapacity = MAX_ARRAY_SIZE;
    }
    heap = Arrays.copyOf(heap, newCapacity);
  }
  /**
   * Object o 를 추가한다.
   * @param o
   */
  public boolean add(E o){
    if(o == null){
      throw new NullPointerException();
    }
    int i = size;
    if(i >= heap.length){
      grow();
    }
    if(i==0){
      heap[0] = o;
    }
    else{
      siftUp(i, o);
    }
    size = i + 1;
    return true;
    //heap[size++] = o;
  }

  /**
   * 힙의 최소값을 리턴한다.
   * @return
   */
  public E peek(){
    return (size == 0) ? null : (E)heap[0];
  }

  public String toString(){
    if(size==0){
      return "[]";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for(int i=0; i<size;i++){
      sb.append(heap[i]);
      if(i == size-1){
        sb.append("]");
        break;
      }
      sb.append(", ");
    }
    return sb.toString();
  }

  public int indexOf(E o){
    if(o != null){
      for(int i = 0; i<size; i++){
        if(o.equals(heap[i])){
          return i;
        }
      }
    }
    return -1;
  }

  private void siftUp(int k, E o){
    Comparable<? super E> comp = (Comparable<? super E>) o;
    while(k>0) {
      int parent = (k - 1) >>> 1;
      Object p = heap[parent];

      if(comp.compareTo((E)p) >= 0){
        break;
      }
      heap[k] = p;
      k = parent;
    }
    heap[k] = comp;
  }

  public E poll(){
    if(size == 0) {
      return null;
    }
    Object o = heap[0];
    //heap[0] = heap[--size];
    //siftUp();
    return (E)o;

  }
  public boolean remove(E o){
    int i = indexOf(o);
    if(i != -1){
      heap[i] = heap[--size];
      heap[size] = null;
    }
    return true;
  }

}
