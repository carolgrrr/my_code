import java.util.Iterator;

public class CS401DblLinkedListImpl<E> implements CS401CollectionInterface<E> 
{
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int s = 1;

   public CS401DblLinkedListImpl()
   {
      head = tail = null;
   }

   public boolean is_empty()
   {
      if (head == null) 
          return true;

      return false;
   }

   public boolean is_full() { return false; }

   public int size()
   {
      return size_r(head) - 1;
      /*
       * Note that an iterative solution that traverses the list from
       * the front would be as follows:
       * 
       * LinkEntry<E> temp;
       * int i = 0;
       *
       * for (temp = head; temp != null; temp = temp.next)
       *      i++;
       * return i;
       */
   }

   public boolean add(int index, E e)
   {
      throw new UnsupportedOperationException();
   }

   /*
    * Add e to the end of the doubly linked list.
    * Returns true - if e was successfully added, false otherwise.
    */
   public boolean add(E e)
   {
      
      LinkEntry<E> ne = new LinkEntry<E>();
      ne.element = e;

      if (head == null && tail == null)
      {
        head = tail = ne;
        //System.out.println("Added " +ne.element);
      }
      else
      {
        ne.previous = tail;
        tail.next = ne;
        tail = ne;
        //System.out.println("Added " +ne.element);
      }

      /** Add code here **/

      /*
      LinkEntry<E> ne = new LinkEntry<E>();
      ne.element = e;

      if (head == null && tail == null)
      {
          head = tail = ne;
      }
      else
      {
         tail.next = ne;
         tail = ne;
      }
      
      return true;


      */


      return true;
   }

   /*
    * Remove the nth element in the list.  The first element is element 1.
    * Return the removed element to the caller.
    */
   public E remove(int n)
   {
      /** Add code here **/
      LinkEntry<E> removeLink = new LinkEntry<E>();
      removeLink = head;
      //System.out.println("Element to remove is: " + removeLink.element + "?");
      for(int count = 1; count <n; count++)
      {
        //System.out.println("Count is: " + count);
        removeLink = removeLink.next;
        //System.out.println("Element to remove is: " + removeLink.element + "?");

      }

      if (removeLink == head)
      {
        //System.out.println("removeLink is head");
        head = head.next;
        //System.out.println("head is head.next");
        head.previous = null;
        //System.out.println("head.prev is null");
      } 
      else if (removeLink == tail)
      {
        //System.out.println("removeLink is tail");
        //previous.next = null;
        tail = tail.previous;
        tail.next = null;
      }
      else
      {
        //System.out.println("removeLink is in the middle");
        removeLink.previous.next = removeLink.next;
        removeLink.next.previous = removeLink.previous; 
      }

        
      return removeLink.element;
   }

   /*
    * Print the doubly linked list starting at the beginning.
    */
   public void print_from_beginning()
   {
      /** Add code here **/

      LinkEntry printLink = new LinkEntry();
      printLink = head;
      while (printLink != null)
      {
        System.out.println(printLink.element);
        printLink = printLink.next;
      }
      return;
   }

   /*
    * Print the doubly linked list starting the end.
    */
   public void print_from_end()
   {
      LinkEntry printLink = new LinkEntry();
      printLink = tail;
      while (printLink != null)
      {
        System.out.println(printLink.element);
        printLink = printLink.previous;
      }
      return;
   }

   public E remove()
   {
      throw new UnsupportedOperationException();
   }

   public E get(int index)
   {
      throw new UnsupportedOperationException();
   }

   public boolean contains(E e)
   {
      throw new UnsupportedOperationException();
   }

   private int size_r(LinkEntry<E> head)  /* Think about this recursive call! */
   {
      if (head != null)
         s = s + size_r(head.next);
      return s;
   }
   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;
      protected LinkEntry<E> previous;

      protected LinkEntry() { element = null; next = previous = null; }
   }
} /* CS401LinkedListImpl<E> */
