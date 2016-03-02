package datastructure.list.doublylinkedlist.implement;

/**
 * Created by cjred77@gmail.com on 2016. 2. 23..
 */
public class DoublyLinkedList {
  // size of list
  private int size = 0;
  // first node
  private Node head;
  // last node
  private Node tail;

  public class Node {
    Object data;
    Node prev;
    Node next;

    public Node(Object input) {
      this.data = input;
      prev = null;
      next = null;
    }

    public String toString() {
      return String.valueOf(this.data);
    }
  }
  public void addFirst(Object input) {
    // Create Node
    Node newNode = new Node(input);
    newNode.next = head;
    if (head != null) {
      head.prev = newNode;
    }

    head = newNode;
    size++;

    if (head.next == null) {
      tail = head;
    }
  }

  public void addLast(Object input) {
    // Create Node
    Node newNode = new Node(input);

    if (size == 0) {
      addFirst(input);
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
      size++;

    }
  }

  private Node node(int index) {
    Node x = null;

    if (index < size / 2) {
      x = head;
      for (int i = 0; i < index; i++) {
        x = x.next;
      }
    } else {
      x = tail;
      for (int i = size - 1; i > index; i--) {
        x = x.prev;
      }
    }

    return x;
  }

  public void add(int index, Object input) {
    if (index == 0) {
      addFirst(input);
    }
    else{
      Node temp1 = node(index-1);
      Node temp2 = temp1.next;

      Node newNode = new Node(input);
      temp1.next = newNode;
      newNode.next = temp2;

      if(temp2 != null) {
        temp2.prev = newNode;
      }
      newNode.prev = temp1;

      if(newNode.next == null){
        tail = newNode;
      }
      size++;
    }
  }

  public Object removeFirst(){
    Node temp = head;

    head = temp.next;

    Object returnData = temp.data;
    temp = null;

    if(head != null){
      head.prev = null;
    }

    size--;
    return returnData;
  }

  public Object remove(int index){
    if(index == 0){
      removeFirst();
    }

    Node temp = node(index - 1);
    Node todoDeleted = temp.next;

    temp.next = temp.next.next;

    if(temp.next != null){
      temp.next.prev = temp;
    }

    Object returnData = todoDeleted.data;

    todoDeleted = null;

    size--;

    return returnData;
  }

  public Object removeLast() {
    return remove(size-1);
  }

  public Object get(int index){
    Node temp = node(index);
    return temp.data;
  }

  public int indexOf(Object data){
    Node temp = head;

    int index = 0;
    while(temp.data != data){
      temp = temp.next;
      index++;
      if(temp == null){
        return -1;
      }
    }
    return index;
  }

  public int size(){
    return size;
  }

  public String toString(){
    if(head == null) {
      return "[]";
    }

    Node temp = head;
    String str = "[";

    while(temp.next != null){
      str += temp.data + ", ";
      temp = temp.next;
    }

    str += temp.data + "]";

    return str;
  }

  public class Iterator {
    Node lastReturned = null;
    Node next = null;
    int nextIndex;

    public Iterator(){
      next = head;
      nextIndex = 0;
    }

    public Object next(){
      lastReturned = next;
      next = next.next;
      nextIndex++;
      return lastReturned.data;
    }

    public boolean hasNext(){
      return nextIndex < size();
    }

    public Object prev(){
      if(next == null){
        lastReturned = next = tail;
      }
      else {
        lastReturned = next = next.prev;
      }

      nextIndex--;
      return lastReturned.data;
    }

    public boolean hasPrev(){
      return nextIndex > 0;
    }

    public void add(Object input){
      Node newNode = new Node(input);

      if(lastReturned == null){
        head = newNode;
        next.prev = newNode;
      } else {
        lastReturned.next = newNode;
        newNode.prev = lastReturned;
        if(next==null){
          tail = newNode;
        } else {
          next.prev = newNode;
        }
      }
      lastReturned = newNode;
      newNode.next = next;
      nextIndex++;
      size++;
    }

    /**
     * if size is 1 then throw error
     * @return
     */
    public Object remove(){
      if(lastReturned == null){
        throw new IllegalStateException();
      }

      Object todoDeleted = lastReturned.data;

      Node p = lastReturned.prev;
      Node n = lastReturned.next;

      if(p == null){
        head = n;
        lastReturned.next = null;
        n.prev = null;
        lastReturned = n;
      } else if(n == null){
        tail = p;
        p.next = null;
        lastReturned.prev = null;
        lastReturned = p;
      } else {
        p.next = n;
        n.prev = p;
        lastReturned.prev = null;
        lastReturned.next = null;
        lastReturned = p;
      }

      nextIndex--;
      size--;

      return todoDeleted;
    }

    /**
     * https://opentutorials.org/module/1335/8941
     * if size is 1 then throw error
     */
    public void remove2() {
      if (nextIndex == 0) {
        throw new IllegalStateException();
      }
      Node n = lastReturned.next;
      Node p = lastReturned.prev;

      if (p == null) {
        head = n;
        head.prev = null;
        lastReturned = null;
      } else {
        p.next = next;
        lastReturned.prev = null;
      }

      if (n == null) {
        tail = p;
        tail.next = null;
      } else {
        n.prev = p;
      }

      if (next == null) {
        lastReturned = tail;
      } else {
        lastReturned = next.prev;
      }

      size--;
      nextIndex--;

    }
  }

  public Iterator iterator(){
    return new Iterator();
  }
}
