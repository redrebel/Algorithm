package datastructure.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cjred77@gmail.com on 2016. 9. 13..
 */
public class ArrayLists {
  public static void main(String[] args){
    List<Character> lista = new ArrayList<>();
    lista.add('e');
    lista.add('l');
//Thread.dumpStack();
    if(lista.contains('e')){
      System.out.println("find");
    } else {
      System.out.println("no find");
    }
  }
}
