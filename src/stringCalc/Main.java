package stringCalc;

/**
 * Created by red on 2016. 2. 5..
 */
public class Main {

  Node top = null;

  public class Node {
    public String type;
    public char value;
    public Node left;
    public Node right;

    public Node(String type, char value){
      this.type = type;
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public void addNode(Node n){
    if(top == null){
      top = n;
      return;
    }


    if (top.type.equals("num")){
      n.left = top;
      top = n;
      return;
    }

    if(n.type.equals("op")){
      if(n.value == '*' || n.value == '/'){
        if(top.right == null){
          top.right = n;
          return;
        }
        else {
          n.left = top.right;
          top.right = n;
        }
      }
      else{
        n.left = top;
        top = n;
      }
    }
    else{
      top.right = n;
    }
  }

  public void printTree(Node n, int dep){
    if(n == null)
      return;

    System.out.println(n.value + ":" + dep);

    printTree(n.left,dep+1);
    printTree(n.right,dep+1);
  }
  public void pringTree(){
    Node tmp = top;
    while(true){
      System.out.println(top.value);
      if(top.left != null){
        System.out.println("go left child");
        top = top.left;
      }
      else {
        System.out.println("end");
        break;
      }
    }
    top = tmp;
  }
  @Override
  public String toString(){
    return "";
  }

  public void calc(String s){
    System.out.println(s);
    for(int i=0; i<s.length();i++){
      char c = s.charAt(i);
      Node n=null;
      if( c >= '0' && c<='9'){
        n = new Node("num",c);
      }
      else
        n = new Node("op", c);
      addNode(n);
    }

  }

  public static void main(String args[]){
    String s = "4+2*7-1";
    Main m = new Main();
    m.calc(s);
    m.pringTree();
    m.printTree(m.top,0);
  }
}
