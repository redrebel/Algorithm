package datastructure.list.arraylist.implement;

/**
 * Created by red on 2016. 2. 15..
 */
public class Main {

  public static void main(String[] args){
    ArrayList list = new ArrayList();

    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    //System.out.println(list);
    list.add(2,25);
    list.addFirst(5);
    System.out.println(list);
    System.out.println(list.get(2));
    System.out.println(list.size());
    System.out.println(list.indexOf(200));

    ArrayList.ListIterator li = list.listIterator();
    while(li.hasNext()){
      System.out.println(li.next());
    }

    while(li.hasPrevious()){
      System.out.println(li.previous());
    }

    /*while (li.hasNext()){
      Integer number = (Integer)li.next();

      if(number == 30){
        li.add(35);
      }
    }
    System.out.println(list);*/

    while (li.hasNext()){
      Integer number = (Integer)li.next();

      if(number == 20){
        li.remove();
      }
    }
    System.out.println(list);
  }

}
