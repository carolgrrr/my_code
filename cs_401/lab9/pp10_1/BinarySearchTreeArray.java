import java.util.*;

public class BinarySearchTreeArray<E> extends AbstractSet<E>
{
	
	protected Entry<E> [] tree;

	protected int 	root,
					size;

	public BinarySearchTreeArray()
	{

		root = -1;
		size = 0;
	}

	public boolean add (E element)  
    {
        if (root == -1) 
        {
            if (element == null)
                throw new NullPointerException();
            root = 0;
            size++;             
            return true;
        } // empty tree
        else 
        {
            int temp = root;
            int comp;

/*            while (true) 
            {
                comp =  ((Comparable)element).compareTo (tree[temp].element);
                if (comp == 0)
                    return false;
                if (comp < 0)            
                	if (tree[temp].left != -1)
//                        temp = tree[temp].left;
                    else 
                    {
//                    	tree[]
  //                      temp = tree[temp].left = element;
                        size++;                             
                        return true;
                    } // tree[temp].left == null
//                    else if (temp.right != -1)
//                        tree[temp] = tree[temp].right;
                    else 
//                    {
                        tree[temp].right = element;
                        size++;                           
                        return true;
                    } // tree[temp].right == null
                }
            } // while
    */
            return true;
        } // root not null
    } // method add


	protected Entry<E> getEntry (Object obj)
	{
		int temp = root;
		int comp;

		while (temp != -1)
		{
			comp = ((Comparable)obj).compareTo (tree [temp].element);
			if (comp == 0)
				return tree[temp];
			else if (comp < 0)
				temp = tree[temp].left;
			else
				temp = tree[temp].right;
		} // while
		return null;
	} // method getEntry


	protected static class Entry<E>
	{
		protected E element;

		protected int 	left = -1,
						right = -1,
						parent = -1;
	
		public Entry()
		{

		}

		public Entry (E e, int p)
		{
			this.element = e;
			this.parent = p;
		}
	} // class Entry



}