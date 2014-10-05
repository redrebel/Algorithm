package pearls.chapter1;

import java.util.*;

/**
 * Created by cjred77@gmail.com on 2014. 10. 5..
 *
 */
public class ComparableExample {
    //Arrays

    public static void main(String args[]){
        Customer[] arr = new Customer[]{
                new Customer("헤더 로클리어",1961, "Heather Deen Locklear"),
                new Customer("데미 무어", 1962, "Demetria Gene Guynes"),
                new Customer("안젤라 바셋", 1958, "Angela Bassett"),
                new Customer("신디 크로퍼드", 1966, "Cintia Ann Crawford"),
                new Customer("캐서린 제타 존스", 1969, "Catherine Jones")
        };

        printArr(arr, "Before Array sort Using Default sort");
        //배열 정렬(클래스의 정의된 기본정렬)
        Arrays.sort(arr);
        printArr(arr, "\nAfter Array sort Using Default sort");

        //어린나이순으로 정렬
        Arrays.sort(arr,new YoungOrderComparator());
        printArr(arr, "\nAfter array sort Using YoungOrderComparator");

        List list = Arrays.asList(arr);
        Collections.shuffle(list);  //무작위로 섞음
        printList(list, "\nBefore List sort Using Default sort");

        Collections.sort(list);
        printList(list, "\nAfter List sort Using Default sort");

        Collections.sort(list, new EngNameComparator());
        printList(list, "\nAfter List sort Using EngNameComparator");

        Set set = new TreeSet(list);
        System.out.println("\nAfter Making Set Using Default sort \n" + set);

        Set set2 = new TreeSet(new YoungOrderComparator());
        set2.addAll(list);
        System.out.println("\nAfter Making set Using YoungOrderComparator\n" + set2);

    }

    static void printArr(Customer[] a, String title){
        System.out.println(title);
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }

    static void printList(List l, String title){
        System.out.println(title);
        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }
    }
}

class Customer implements Comparable{
    String name;
    int birthYear;
    String engName;

    public Customer(String name, int birthYear, String engName){
        this.name = name;
        this.birthYear = birthYear;
        this.engName = engName;
    }

    public String toString(){
        return name + "(" + engName + ")" + birthYear + "년생";
    }

    @Override
    public int compareTo(Object o) {
        return name.compareTo(((Customer)o).name);
    }
}

class YoungOrderComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int by1 = ((Customer)o1).birthYear;
        int by2 = ((Customer)o2).birthYear;

        return (by1 < by2) ? -1 : ((by1 == by2) ? 0 : 1);
    }
}

// 영문이름으로 정렬
class EngNameComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        String en1 = ((Customer)o1).engName;
        String en2 = ((Customer)o2).engName;

        return (en1).compareTo(en2);
    }
}