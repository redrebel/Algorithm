package datastructure.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cjred77@gmail.com on 2016. 8. 20..
 * AVL tree(Georgy Adelson-Velsky and Landis' tree, named after the inventors)
 */
public class SelfBalancingTree {
  /**
   * input 1,2,3,4,5,...
   * @param values
   */
  public SelfBalancingTree(int... values){
    System.out.println("init : ");
    for(int value: values){
      root = insertNode(root,value);
    }
    printTree();
    System.out.println();
  }

  /**
   * input "1 2 3 4 5 6"
   * @param s
   */
  public SelfBalancingTree(String s){
    System.out.println("init : ");
    String[] values = s.split(" ");
    for(String value: values){
      root = insertNode(root,Integer.parseInt(value));
    }
    printTree();
    System.out.println();
  }

  /**
   * Node
   */
  class Node{
    int val;  // Value
    int ht; // Height
    Node left;  // Left child
    Node right; // Right child
  }

  Node root = null;

  /**
   * printTree , Postorder Traversal, recursion
   * @param root
   */
  protected void printTree(Node root){

    if(root!=null){
      printTree(root.left);
      printTree(root.right);
      System.out.print(root.val+"("+root.ht+")");
      System.out.print(", ");
    }
  }

  /**
   * main printTree
   */
  public void printTree(){
    System.out.print("[");
    printTree(root);
    System.out.println("]");
  }

  /**
   * renewal HT
   * @param node
   * @return
   */
  protected int getNewHt(Node node){
    return Math.max(height(node.left), height(node.right)) + 1;
  }

  protected void rightLeftToRightRight(Node root){
    Node tmp = root.right;
    root.right = root.right.left;
    tmp.left = root.right.right;
    root.right.right = tmp;

    root.right.right.ht = getNewHt(root.right.right);
    root.right.ht = getNewHt(root.right);
  }

  protected void leftRightToLeftLeft(Node root){
    Node tmp = root.left;
    root.left = root.left.right;
    tmp.right = root.left.left;
    root.left.left = tmp;

    root.left.left.ht = getNewHt(root.left.left);
    root.left.ht = getNewHt(root.left);

  }

  protected Node rightRightToBalanced(Node root){
    Node tmp = root;
    root = root.right;
    tmp.right = root.left;
    root.left = tmp;

    root.left.ht = getNewHt(root.left);
    root.ht = getNewHt(root);
    return root;
  }

  protected Node leftLeftToBalanced(Node root){
    Node tmp = root;
    root = root.left;
    tmp.left = root.right;
    root.right = tmp;

    root.right.ht = getNewHt(root.right);
    root.ht = getNewHt(root);
    return root;
  }

  public Node balance(Node root){
    //printTree(root);
    //System.out.println();

    int balanceFactor = height(root.left) - height(root.right);

    //System.out.println(root.val + "("+ root.ht+ ") : "+
    //        " left("+ height(root.left) + "), right("+ height(root.right) + ") " + balanceFactor);

    if(balanceFactor > 1){
      //left is bigger
      if(height(root.left.right) > height(root.left.left)){
        System.out.println(root.val + " : leftRight");
        leftRightToLeftLeft(root);
      }
      if(height(root.left.right) < height(root.left.left)) {
        System.out.println(root.val + " : leftLeft ");
        root = leftLeftToBalanced(root);
      }
    }
    else if(balanceFactor < -1){
      // right is bigger
      if(height(root.right.left) > height(root.right.right)){
        System.out.println(root.val + " : rightLeft");
        rightLeftToRightRight(root);
      }
      if(height(root.right.left) < height(root.right.right)) {
        System.out.println(root.val + " : rightRight");
        root = rightRightToBalanced(root);
      }
    }
    //printTree(root);
    //System.out.println();
    return root;
  }

  protected Node insertNode(Node root, int val){
    if(root==null){
      Node node = new Node();
      node.val = val;
      node.ht = 0;
      return node;
    }
    if(root.val > val){
      //System.out.println("intput left : "+val);
      root.left = insertNode(root.left, val);
    }
    else {
      //System.out.println("intput right : "+val);
      root.right = insertNode(root.right, val);
    }

    root.ht = getNewHt(root);
    root = balance(root);
    return root;
  }

  public int height(Node root){
    if(root == null){
      return -1;
    }
    return root.ht;
  }

  public void insert(int val){
    System.out.println("insert : "+val);
    root = insertNode(root,val);
    printTree();
    System.out.println();
  }

  public static void main(String[] agrs){

    //SelfBalancingTree avl = new SelfBalancingTree(3,2,4,5,6);
    //String initValue = "14 25 21 10 23 7 26 12 30 16";
    String initValue = "14 25 21 10 23 7 26 12 30 16";
    SelfBalancingTree avl = new SelfBalancingTree(initValue);
    avl.insert(19);

    avl.printTree();


  }
}
