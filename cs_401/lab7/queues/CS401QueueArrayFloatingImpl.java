/* 
 * Floating front and back implementation of a queue using an array */

public class CS401QueueArrayFloatingImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public CS401QueueArrayFloatingImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }

   //ensure capacity
   // data[back] = elem
   // back = back + 1 mod capacity
   public void add(E element) {
      if(data[back] == null)
      {
         data[back] = element;
         back = (back + 1) % capacity;
      }
      else
      {
         System.out.println("\nThe queue is full.");
      }
   }

   // check not empty
   //extract element from front
   // data [front] = null
   // front = front + 1 mod capacity
   public E remove()  {
      E element;
      if(data[front] == null)
      {
         System.out.println("\nThe queue is empty");
         element = null;
      }
      else
      {
         element = data[front];
         data[front] = null;
         front = (front + 1) % capacity;
      }
      return element;

   }
   public E peek()  {
      E element = data[front];   
      return element;
   }

   public boolean is_empty()  {

      if(data[front]==null)
         return true;
      return false;

   }

   public boolean is_full()  {

      if(data[back] != null)
         return true;
      return false;

   }

}
