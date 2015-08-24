(1) Lab 12 (page 281)
Quick Quiz: What should the missing code be?
a. itr.next
b. (String)itr.next()
c. itr.next() *correct answer
d. (String)myLinked.next()


Quick Quiz: What happens to the space previously allocated for a SinglyLinkedList myLinked if the following message is sent?
myLinked.clear( );
a. The space is de-allocated as soon as head is assigned the value null.
b. The space is de-allocated when the programmer explicitly removes the elements that were in the SinglyLinkedList.
c. The space is de-allocated as soon as myLinked can no longer be accessed in the program.
d. The de-allocation of space is handled by the garbage collector. *correct answer


HYPOTHESIZE:
See SinglyLinkedList.java for full code. Code for addAll method below:
public boolean addAll(Collection<? extends E> c)
{
      Iterator<? extends E> itr = c.iterator();
      if (c == null)
        throw new NullPointerException();
      else
      {
        for (E elmt : c ) 
        {
          addToFront(elmt);  
        }
        return true;
      }
  } //method addAll


TEST: When I commented out the NullPointerException, the test still succeeds. From this we can infer that the NullPointerException is thrown automatically when the method tries to add a null collection to the LinkedList.


CONCLUDE:
It was a bit tricky trying to figure out how to test the exception, but I eventually figured out that my method throws a NullPointerException whether or not this is explicitly specified in the AddAll method code. The rest of the lab was fairly straightforward.




Code added to SinglyLinkedList.java:
  public boolean addAll(Collection<? extends E> c)
  {
      Iterator<? extends E> itr = c.iterator();
      if (c == null)
        throw new NullPointerException();
      else
      {
        for (E elmt : c ) 
        {
          addToFront(elmt);  
        }
        return true;
      }
  } //method addAll


Code added to SinglyLinkedTest.java:
public void testAddAll()
    {        
        try
        {
            SinglyLinkedList<String> inputList = new SinglyLinkedList<String>();
            list = new SinglyLinkedList<String>();
            
            inputList.addToFront("element1");
            inputList.addToFront("element2");
            inputList.addToFront("element3");
            
            list.addAll(inputList);
            assertEquals (true, list.contains ("element1"));
            assertEquals (true, list.contains ("element3"));
            assertEquals (true, list.contains ("element2"));
            assertEquals (false, list.contains ("Element2"));
            assertEquals (3, list.size());
            assertEquals (false, list.isEmpty());           
        } // try        
        catch (Exception e)
        {
            fail ();
        } // catch Exception 
    } // method testAddToFront








(2) Chapter 7, Programming Exercises: 7.2 and 7.6  
7.2: I predict that the method will print out the letters in the word “perfect” from the LinkedList called letters.


In order to test this method, I stepped through the program one line at a time. I added lines to the code in my test method that print out the contents of letters after each line. I appended some text that explains what the previous line of code did as the contents of letters is printed to the console. See sevenPointTwo.java for the test class, which includes details of the actions performed in each line of code.


7.6: Hypothesize which of the following sequences of messages would now be legal:
a. itr.add(8.8); itr.next(); itr.remove();
d. itr.next(); itr.remove(); itr.add(8.8);


These are the only two sequences that will run without exception because they visit the ‘next’ element in the ListIterator before removing it. Sequences b, c, e, and f all attempt to remove elements without first visiting them, which will throw an IllegalStateException. I have included details in the test class sevenPointSix.java, commenting out all sequences that cause exceptions at runtime. I have also added comments to the offending lines explaining where the errors are encountered for each sequence, with the exception of a and d because those two run without errors.


(3) Circular singly-linked lists: A list is circular if the last element on the list refers to the first element.  See the attached ASCII-art diagram.