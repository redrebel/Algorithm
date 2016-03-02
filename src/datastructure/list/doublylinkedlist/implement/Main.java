package datastructure.list.doublylinkedlist.implement;

/**
 * Created by cjred77@gmail.com on 2016. 2. 23..
 */
public class Main {
  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();

    list.addFirst(10);
    //list.addLast(20);
//    list.addLast(30);
//    list.add(2, 25);
    System.out.println(list);


    DoublyLinkedList.Iterator i = list.iterator();
//
//    while(i.hasNext()){
//      if(i.next().equals(20)){
//        i.remove();
//      };
//    }
//    System.out.println(list);
    i.next();
//    i.next();
    i.remove2();
    System.out.println(list);


//    while(i.hasPrev()){
//      System.out.println(i.prev());
//    }
    //System.out.println(list.get(2));
//    System.out.println(list.indexOf(25));
  }
}
