import java.util.*;   

class Unnatural<E> implements Comparator<E>
{
  protected Comparator<E> comp;
       
    public Unnatural (Comparator<E> comp)
    {
      this.comp = comp;
    } // constructor
       
    public int compare (E e1, E e2) 
    {
      int result = compare((E)(((FairElement<E>)e1).element), (E)(((FairElement<E>)e2).element)); ;
      if (result != 0)
        return result;
      return (int)(((FairElement<E>)e1).count - ((FairElement<E>)e2).count);         
    } // method compare
} // class Unnatural
