package assn04;

public class Main {
  public static void main(String[] args) {
    /*
    This is a basic example of how to create a BST and add values to it.
    You should add more examples and use this class to debug your code
    */
    BST<Integer> bst = new NonEmptyBST<Integer>(78);
     // bst = bst.insert(78);
      bst = bst.insert(31);
      bst = bst.insert(13);
      bst = bst.insert(38);
      bst = bst.insert(10);
      bst = bst.insert(12);
      bst = bst.insert(40);
      bst = bst.insert(39);
      bst = bst.insert(47);
      bst = bst.insert(87);
      bst.printPreOrderTraversal();
      System.out.println();
      bst.printPostOrderTraversal();

  }

}
