Lab 17 (p. 430 & website)
Estimating the Height of a Binary Search Tree


Quick Quiz: Assume that a definition of the height method has been developed. Which one of the following includes a correct call to that method from a method outside of the BinarySearchTree class?
a. System.out.println (HEIGHT_MESSAGE + height());
b. System.out.println (HEIGHT_MESSAGE + height (myTree));
c. System.out.println (HEIGHT_MESSAGE + myTree.height()); *correct answer
d. System.out.println (HEIGHT_MESSAGE + myTree.height (t));


Correct Answer: (c)


Quick Quiz: Which of the following pairs contains the code for generating a randomdouble (in the range from 0.0 inclusive to 1.0 exclusive) and the code for log2n?
a. Math.random (n); Math.log (n)
b. Math.random (n); Math.log (n) / Math.log (2)
c. Math.random(); Math.log (n) / Math.log (2) *correct answer
d. Math.random(1.0); Math.log (n) / Math.log (2)


Correct Answer: (c)


HYPOTHESIS


1. Define several unit-test methods to validate the height() method. 

@Test
    public void testHeight1() 
    {                                                              
        tree.add ("b"); 
        tree.add ("a");
        tree.add ("c");           
        assertEquals (tree.height(), 2);         
    } // method testHeight1


@Test
    public void testHeight2() 
    {                                                              
        tree.add ("b"); 
        tree.add ("a");
        tree.add ("c");
        tree.add (“d”);
        tree.add (“e”);
       tree.add(“f”);           
        assertEquals (tree.height(), 4);         
    } // method testHeight2


@Test
    public void testHeight3() 
    {                                                              
        tree.add ("f"); 
        tree.add ("a");
        tree.add ("c");           
        assertEquals (tree.height(), 3);         
    } // method testHeight3




2. Define the height method.


Hint: make height() a one-line wrapper method for the following
        recursive method:

  /**
   * Returns the height of the subtree rooted at p.
   *
   * @param p -- an Entry that is the root of the subtree.
   *
   * @return the height of the subtree rooted at p.
   */
   protected int h (Entry<E> p) 
  {
     if (p.h() == -1)
        return -1;
      else
     return (1 + Math.max(p.left.h(), p.right.h())
  } // method h

   /**
   * Returns the height of this BinarySearchTree object.
   *
   * @return an int containing the height of this BinarySearchTree object.
   */
public int height()
{
        return Math.max(h(this.left), h(this.right));
}
3. For a given value for n, write the code to conduct 20 trials.




CONCLUSION


Include your final code for the height, h and run methods, and the test methods you added to BinarySearchTreeTest. What is the average height of a BinarySearchTree with 10 elements? What values were printed for the 5 runs with n = 1000, 2000, 4000, 8000, and 16000? What is your estimate of the average height of a binary search tree as a function of log2 n? Possible but INCORRECT estimates are 4 log2 n and 0.2 log2n.


Test methods:
@Test
    public void testHeight1() 
    {                                                              
        tree.add ("b"); 
        tree.add ("a");
        tree.add ("c");           
        assertEquals (tree.height(), 2);         
    } // method testHeight1


@Test
    public void testHeight2() 
    {                                                              
        tree.add ("b"); 
        tree.add ("a");
        tree.add ("c");
        tree.add (“d”);
        tree.add (“e”);
       tree.add(“f”);           
        assertEquals (tree.height(), 4);         
    } // method testHeight2


@Test
    public void testHeight3() 
    {                                                              
        tree.add ("f"); 
        tree.add ("a");
        tree.add ("c");           
        assertEquals (tree.height(), 3);         
    } // method testHeight3




 protected int h (Entry<E> p) 
  {
     if (p.h() == -1)
        return -1;
      else
     return (1 + Math.max(p.left.h(), p.right.h())
  } // method h

public int height()
{
        return Math.max(h(this.left), h(this.right));
}


The average height for a binary search tree with 10 elements is 4.


n = 1000 -  15
n = 2000 -  16
n = 4000 -  18
n = 8000 -  20
n = 16000 - 22


My estimate for the average height of a Binary Search Tree is 1.5 log2 n


Programming Project 10.1 (p.449)




Test Vector 1 


Output After Insertion:
        Element        parent        left        right
0        dog                -1        2        1
1        turtle                0        3        5
2        cat                0        -1        -1
3        ferret                1        -1        4
4        shark                3        6        -1        
5        whale                1        -1        -1
6        porpoise        4        -1        -1


Output After Deleting ferret:
        Element        parent        left        right
0        dog                -1        2        1
1        turtle                0        4        5
2        cat                0        -1        -1
3        -1                -1        -1        -1
4        shark                1        5        4
5        whale                1        6        -1
6        porpoise        3        6        -1




Test Vector 2


Output After Insertion:
        Element        parent        left        right
0        -3                -1        -1        1
1        18                0        2        3
2        4                1        -1        4        
3        99                1        8        7
4        50                2        5        9
5        23                4        6        -1
6        5                5        -1        -1
7        101                3        -1        -1
8        77                3        -1        -1
9        87                4        


Output After Deleting 50:
        Element        parent        left        right
0        -3                -1        -1        1
1        18                0        2        3
2        4                1        -1        4
3        99                1        5        7
4        -1                -1        -1        -1
5        23                3        6        -1
6        5                5        -1        -1
7        101                3        -1        -1
8        77                3        -1        -1
9        87                4        -1        -1