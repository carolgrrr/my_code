Here is the code for the size_p() method:
private int size_p(TreeNode<E> t)  {
      int num_nodes = 0;
      if (t == null)
        return num_nodes;
      else 
        return (1 + size_p(t.get_left()) + size_p(t.get_right()));
   }


Here is the code for the inorder_p() method:
private void inorder_p(TreeNode<E> t)  {
      if(t == null)
        return;
      inorder_p(t.get_left());
      System.out.print(t.info + " ");
      inorder_p(t.get_right());
   }


Here is the code for the preorder_p() method:
private void preorder_p(TreeNode<E> t)  {
      if(t == null)
        return;
      System.out.print(t.info + " ");
      preorder_p(t.get_left());
      preorder_p(t.get_right());
   }


Here is the code for the postorder_p() method:
private void postorder_p(TreeNode<E> t)  {
      if (t == null)
        return;
      postorder_p(t.get_left());
      postorder_p(t.get_right());
      System.out.print(t.info + " ");
   }


Here is the code for the add() method:
public void add(E info) {
      TreeNode<E> node = new TreeNode<E>(info);
       if (index == 0)  {
           root = node;
       }
       else if (index == 1)  {
          root.left = node;
       }
       else if (index == 2)  {
          root.right = node;
       }
       else if (index == 3)  {
          root.left.left = node;
       }
       else if (index == 4)  {
          root.left.right = node;
       }
       else if (index == 5)  {
          root.right.left = node;
       }
       index++;
   }


When the program is run, the output is at follows:


The tree has 6 nodes.


Preorder:
32 40 9 8 60 15 


Inorder:
9 40 8 32 15 60 


Postorder:
9 8 40 15 60 32