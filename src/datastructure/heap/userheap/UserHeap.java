package datastructure.heap.userheap;

/**
 * Created by cjred77@gmail.com on 2016. 11. 28..
 */
public interface UserHeap<E> {
  // 힙의 최초 가용치를 지정하지 않으면 기본갑을 사용한다
  int DEFAULT_INITIAL_CAPACITY = 11;
  int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
  boolean add(E o);
  E peek();
  E poll();
  boolean remove(E o);

}
