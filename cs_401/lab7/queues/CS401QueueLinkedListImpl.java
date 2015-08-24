public class CS401QueueLinkedListImpl<E> implements CS401QueueInterface<E>  {
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int num_elements;
   private int max_elements;

   public CS401QueueLinkedListImpl()
   {
      num_elements = 0;
   }

   public CS401QueueLinkedListImpl(int max)
   {
      num_elements = 0;
      max_elements = max;
   }

   // adds new element at the tail of the linked list
   public void add(E element) {
      LinkEntry<E> le = new LinkEntry<E>();
      le.element = element;

      if(!this.is_full())
      {
         if(head == null)
         {
            head = le;
            tail = le;
         }
         else
         {
            tail.next = le;
            tail = le;            
         }
         num_elements++;
      }
      else
         System.out.println("The queue is full.");
      return;
   }

   // removes element at head of queue
   public E remove()  {
      LinkEntry<E>le = new LinkEntry<E>();

      if (!is_empty())
      {
         le.element = head.element;
         head = head.next;
         num_elements--;
      }
      return le.element;

   }

   // returns element at head of queue
   public E peek()  {

      return head.element;

   }

   // returns true if the queue is empty
   public boolean is_empty()  {

      if (head == null && tail == null)
         return true;
      return false;

   }

   // returns true if the queue is full
   public boolean is_full()  {

      if(num_elements >= max_elements)
         return true;
      return false;
   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;

      protected LinkEntry() { element = null; next = null; }
   }
}
