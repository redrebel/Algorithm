package datastructure.list.linkedlist.implement;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by red on 2016. 2. 15..
 */
public class Main {
  public static void main(String[] args){
    LinkedList numbers = new LinkedList();
//    numbers.addFirst(30);
//    numbers.addFirst(20);
//    numbers.addFirst(10);
    numbers.addLast(10);
    numbers.addLast(20);
    numbers.addLast(30);

//    System.out.println(numbers.size());
//    System.out.println(numbers.get(1));
    System.out.println(numbers);
//    System.out.println(numbers.indexOf(40));
    LinkedList.ListIterator i =  numbers.listIterator();
    while(i.hasNext()){
      System.out.println(i.next());
    }
  }

}
