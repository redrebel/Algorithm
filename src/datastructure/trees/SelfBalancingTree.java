package datastructure.trees;

/**
 * Created by cjred77@gmail.com on 2016. 8. 20..
 * AVL tree(Georgy Adelson-Velsky and Landis' tree, named after the inventors)
 */
public class SelfBalancingTree {
  class Node{
    int val;  // Value
    int ht; // Height
    Node left;  // Left child
    Node right; // Right child
  }

  Node root = null;

  protected void printTree(Node root){

    if(root!=null){
      /*if(root.ht==0){
        System.out.print("[ ");
      }*/
      printTree(root.left);
      printTree(root.right);
      System.out.print(root.val+"("+root.ht+")");
      /*if(root.ht==0){
        System.out.println(" ]");
      }
      else*/
        System.out.print(", ");

    }
  }

  public void printTree(){
    System.out.print("[");
    printTree(root);
    System.out.println("]");
  }

  protected void rightLeftToRightRight(Node root){
    Node tmp = root.right;
    root.right = root.right.left;
    root.right.right = tmp;
    tmp.left = null;

  }

  protected Node rightRightToBalanced(Node root){
    Node tmp = root;
    root = root.right;
    root.left = tmp;
    tmp.right = null;
    return root;
  }

  protected void leftRightToLeftLeft(Node root){
    Node tmp = root.left;
    root.left = root.left.right;
    root.left.left = tmp;
    tmp.right = null;

  }

  protected Node leftLeftToBalanced(Node root){
    Node tmp = root;
    root = root.left;
    root.right = tmp;
    tmp.left = null;
    return root;
  }

  public void balance(){
    printTree();
    //rightLeftToRightRight(root);
    leftRightToLeftLeft(root);
    printTree();
    //root = rightRightToBalanced(root);
    root = leftLeftToBalanced(root);
    printTree();
  }
  protected Node insertNode(Node root, int val){
    if(root==null){
      Node node = new Node();
      node.val = val;
      node.ht = 0;
      return node;
    }
    if(root.val > val){
      root.left = insertNode(root.left, val);
    }
    else {
      root.right = insertNode(root.right, val);
    }

    root.ht = Math.max(height(root.left), height(root.right)) + 1;

    int balanceFactor = height(root.left) - height(root.right);

    System.out.println(root.val + "("+ root.ht+ ") : val="+val+
            " left("+ height(root.left) + "), right("+ height(root.right) + ") " + balanceFactor);


    return root;
  }

  public int height(Node root){
    if(root == null){
      return 0;
    }
    return root.ht;
  }

  public void insert(int val){

    root = insertNode(root,val);
    System.out.println();
  }

  public static void main(String[] agrs){

    SelfBalancingTree avl = new SelfBalancingTree();

    avl.insert(5);
    //avl.printTree();
    //avl.printTree();
    avl.insert(1);
    avl.insert(4);
    avl.balance();
    //avl.insert(7);
    //avl.insert(3);
    //avl.insert(2);
    //avl.insert(22);
    avl.printTree();
  }
}
