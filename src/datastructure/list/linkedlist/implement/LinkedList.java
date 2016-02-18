package datastructure.list.linkedlist.implement;

/**
 * Created by red on 2016. 2. 15..
 */
public class LinkedList {
  private int size;
  private Node head;
  private Node tail;

  public class Node{
    private Object data;
    private Node next;
    public Node(Object input){
      this.data = input;
      this.next = null;
    }

    public String toString(){
      return String.valueOf(this.data);
    }
  }

  public void addFirst(Object input){
    Node newNode = new Node(input);
    newNode.next = head;
    head = newNode;
    size++;
    if(head.next == null){
      tail = head;
    }
  }

  public void addLast(Object input){
    Node newNode = new Node(input);
    if(size == 0){
      addFirst(input);
    }
    else{
      tail.next = newNode;
      tail = newNode;
      size++;
    };
  }

  private Node node(int index){
    Node x = head;
    for(int i = 0; i < index;i++){
      x = x.next;
    }
    return x;
  }

  public void add(int index, Object input){
    if(index == 0){
      addFirst(input);
    }
    else{
      Node temp1 = node(index-1);
      Node temp2 = node(index);

      Node newNode = new Node(input);
      newNode.next = temp1.next;
      temp1.next = newNode;
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

    size--;

    return returnData;
  }

  public Object remove(int index){
    if(index == 0){
      return removeFirst();
    }

    Node temp = node(index-1);
    Node todoRemoved = temp.next;
    temp.next = temp.next.next;

    if(todoRemoved == tail){
      tail = temp;
    }
    Object returnObject = todoRemoved.data;

    todoRemoved = null;
    size--;
    return returnObject;
  }

  public Object removeLast(){
    return remove(size-1);
  }

  public int size(){
    return size;
  }

  public Object get(int index){
    Node temp = node(index);

    return temp.data;
  }

  public int indexOf(Object data){
    Node temp = head;
    int index = 0;

    while(temp.data != data){
      index++;
      temp = temp.next;
      if(temp == null)
        return -1;
    }

    return index;
  }

  public ListIterator listIterator(){
    return new ListIterator();
  }

  public class ListIterator{
    Node next;
    Node lastReturned;
    int nextIndex;

    public ListIterator(){
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
  }

  public String toString(){
    if(head==null){
      return "[]";
    }

    Node temp = head;
    String str = "[";

    while(temp.next!=null){
      str += temp.data + ", ";
      temp = temp.next;
    }

    str += temp.data + "]";

    return str;
  }
}
