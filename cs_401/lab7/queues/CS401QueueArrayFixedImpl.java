/* 
 * Fixed front implementation of a Queue using arrays */

public class CS401QueueArrayFixedImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public CS401QueueArrayFixedImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }

   public void add(E element) {

      // ensure capacity
      if (back == capacity)
      {
         System.out.println("\nThe queue is full.");
      }
      data[back] = element;
      back++;
     
   }

   public E remove()  {
      E element = data[front];
      
      if(back > 0)
      {
         for (int i = 0; i < back; i++)
         {
            data [i] = data[i+1];
         }
         back --;
      }
      return element;
   }
   public E peek()  {
      E element = data[front];

      if (back == 0)
         return null;
      return element;

   }

   public boolean is_empty()  {

      if (back == 0)
         return true;
      return false;

   }

   public boolean is_full()  {

      if (back == capacity)
         return true;
      return false;

   }
}
