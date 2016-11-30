package datastructure.heap.userheap;


/**
 * Created by cjred77@gmail.com on 2016. 11. 21..
 */
public class MinHeap<E> extends AbstractHeap<E> {

  public MinHeap(){this(DEFAULT_INITIAL_CAPACITY);}

  /**
   * 가용치를 지정한 경우
   * @param initialCapacity
   */
  public MinHeap(int initialCapacity){
    this.heap = new Object[initialCapacity];
  }

  protected void siftUp(int k, E o){
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

}
