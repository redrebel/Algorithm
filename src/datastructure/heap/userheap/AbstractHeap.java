package datastructure.heap.userheap;

import java.util.Arrays;

/**
 * Created by cjred77@gmail.com on 2016. 11. 30..
 */
public abstract class AbstractHeap<E> implements UserHeap<E>{
  // 데이터가 담겨질 배열
  protected Object[] heap;
  // 비어있는 힙의 사이즈는 0
  protected int size = 0;

  protected void grow(){
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

  protected abstract void siftUp(int k, E o);

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
