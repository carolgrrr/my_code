INCORPORATING FAIRNESS IN PRIORITY QUEUES


Quick Quiz: The input sequence given above is not the only one that produces "unfair" output -- that is, an element in the priority queue is considered to be smaller-valued than another element that has the same value but was added to the priority queue earlier. Which one of the following input sequences will produce "unfair" output?
a. *
Navdeep 3.5
Soumya 3.4
Viet 3.5

b.
Navdeep 3.5
Viet 3.5
Soumya 3.4

c.
Navdeep 3.5
Viet 3.5
Soumya 3.6

d.
Soumya 3.6
Navdeep 3.5
Viet 3.5


*Correct answer: (a)


Quick Quiz: With the above-mentioned change to thePriorityQueue class, which one of the following input sequences will produce "unfair" output?
a.
Navdeep 3.5
Soumya 3.4
Viet 3.5

b. *
Navdeep 3.5
Viet 3.5
Soumya 3.4

c.
Navdeep 3.5
Viet 3.5
Soumya 3.6

d.
Soumya 3.6
Navdeep 3.5
Viet 3.5


*correct answer


HYPOTHESIZE


class Natural<E> implements Comparator<E>
   {
       public int compare (E e1, E e2) 
       {
           int result = ((Comparable)(((FairElement<E>)e1).element)).compareTo(((FairElement)e2).element);
          
           if (result != 0)
               return result;
           return (int)(((FairElement<E>)e1).count - ((FairElement<E>)e2).count);
       } // method compare


   } // class Natural




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




TEST


Please enter student's name and GPA, or *** to quit: Navdeep 3.5
Please enter student's name and GPA, or *** to quit: Soumya 3.4
Please enter student's name and GPA, or *** to quit: Viet 3.5
Please enter student's name and GPA, or *** to quit: ***
Here are the student names and GPAs in increasing order of GPAs:
Soumya 3.4
Navdeep 3.5
Viet 3.5
Here are the student names and GPAs in alphabetical order of names:
Navdeep 3.5
Soumya 3.4
Viet 3.5

Please enter student's name and GPA, or *** to quit: Navdeep 3.5
Please enter student's name and GPA, or *** to quit: Viet 3.5
Please enter student's name and GPA, or *** to quit: Soumya 3.4
Please enter student's name and GPA, or *** to quit: ***
Here are the student names and GPAs in increasing order of GPAs:
Soumya 3.4
Navdeep 3.5
Viet 3.5
Here are the student names and GPAs in alphabetical order of names:
Navdeep 3.5
Soumya 3.4
Viet 3.5

Please enter student's name and GPA, or *** to quit: Navdeep 3.5
Please enter student's name and GPA, or *** to quit: Viet 3.5
Please enter student's name and GPA, or *** to quit: Soumya 3.6
Please enter student's name and GPA, or *** to quit: ***
Here are the student names and GPAs in increasing order of GPAs:
Navdeep 3.5
Viet 3.5
Soumya 3.6
Here are the student names and GPAs in alphabetical order of names:
Navdeep 3.5
Soumya 3.6
Viet 3.5


Please enter student's name and GPA, or *** to quit: Soumya 3.6
Please enter student's name and GPA, or *** to quit: Navdeep 3.5
Please enter student's name and GPA, or *** to quit: Viet 3.5
Please enter student's name and GPA, or *** to quit: ***
Here are the student names and GPAs in increasing order of GPAs:
Navdeep 3.5
Viet 3.5
Soumya 3.6
Here are the student names and GPAs in alphabetical order of names:
Navdeep 3.5
Soumya 3.6
Viet 3.5




CONCLUDE


class Natural<E> implements Comparator<E>
   {
       public int compare (E e1, E e2) 
       {
           int result = ((Comparable)(((FairElement<E>)e1).element)).compareTo(((FairElement)e2).element);
          
           if (result != 0)
               return result;
           return (int)(((FairElement<E>)e1).count - ((FairElement<E>)e2).count);
       } // method compare


   } // class Natural




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