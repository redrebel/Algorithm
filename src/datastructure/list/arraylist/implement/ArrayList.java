package datastructure.list.arraylist.implement;

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
    add(0,element);
  }

  public Object remove(int index){
    Object removed = elementData[index];
    for(int i = index;i<size-1;i++){
      elementData[i] = elementData[i+1];
    }
    size--;
    return removed;
  }

  public Object removeLast(){
    return remove(size-1);
  }

  public Object removeFirst(){
    return remove(0);
  }

  public Object get(int index){
    return elementData[index];
  }

  public int size(){
    return size;
  }

  public int indexOf(Object o){
    for(int i=0; i<size(); i++){
      if(elementData[i].equals(o)){
        return i;
      }
    }

    return -1;
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

  public ListIterator listIterator(){
    return new ListIterator();
  }

  public class ListIterator{
    int nextIndex = 0;
    public Object next(){
      return elementData[nextIndex++];
    }

    public boolean hasNext(){
      return size() > nextIndex;
    }

    public Object previous(){
      return elementData[--nextIndex];
    }

    public boolean hasPrevious(){
      return nextIndex > 0;
    }

    public void add(Object object){
      ArrayList.this.add(nextIndex++, object);
    }

    public void remove(){
      ArrayList.this.remove(--nextIndex);
    }
  }

}
