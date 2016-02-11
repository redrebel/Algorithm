package data_structure.list;

/**
 * Created by red on 2016. 2. 10..
 */
public class ArrayList {
  private int size = 0;
  private final int MAXNUM = 100;

  private Object[] elementData = new Object[MAXNUM];

  public void addLast(Object element){
    elementData[size] = element;
    size++;
  }

  public void add(int index, Object element){
    for(int i = size-1;i>=index;i--){
      elementData[i+1] = elementData[i];
    }
    elementData[index] = element;
    size++;
  }

  public void addFirst(Object element){

  }

  public String toString(){
    String s = "[";
    for(int i = 0; i<size; i++){
      s = s + elementData[i];
      if(i<size-1){
         s += ",";
      }
    }
    return s + "]";
  }
  public static void main(String[] args){
    ArrayList list = new ArrayList();

    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    System.out.println(list);
    list.add(2,25);
    System.out.println(list);
  }

}
