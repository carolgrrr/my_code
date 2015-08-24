import java.util.*;

public class sevenPointSix
{
	
	public static void main (String[] args)
	{

		LinkedList<Double> weights = new LinkedList<Double>();

		ListIterator<Double> itr;

		weights.add(5.3);
		weights.add(2.8);
		itr = weights.listIterator();

// 	a. No exceptions
		System.out.println("\nSequence a: ");
		itr.add(8.8);	// adds 8.8 at position 0
		System.out.println(weights);
		itr.next();		// moves to position 1
		System.out.println(weights);
		itr.remove();	// removes 5.3 to position 1
		System.out.println(weights);


//	b. Exception in thread "main" java.lang.IllegalStateException
//	at java.util.LinkedList$ListItr.remove(LinkedList.java:734)
//	at sevenPointSix.main(sevenPointSix.java:30)
/*		itr.add(8.8);
		itr.remove();	// This line throws an exception because you cannot 
						// remove elements while iterating through the list
						// we need to call itr.next to visit an element prior
						// to removing it
		itr.next();
*/

//	c. Exception in thread "main" java.lang.IllegalStateException
//	at java.util.LinkedList$ListItr.remove(LinkedList.java:734)
//	at sevenPointSix.main(sevenPointSix.java:42)
/*		itr.next();
		itr.add(8.8);
		itr.remove();	// This line throws an exception because you cannot 
						// remove elements while iterating through the list
						// we need to call itr.next to visit an element prior
						// to removing it
*/

//  d. No exceptions 
		System.out.println("\nSequence d: ");
		itr.next();		// moves to position 0
		System.out.println(weights);
		itr.remove();	// removes element at position 0
		System.out.println(weights);
		itr.add(8.8);	// adds 8.8 at position 0
		System.out.println(weights);


//	e. Exception in thread "main" java.lang.IllegalStateException
//	at java.util.LinkedList$ListItr.remove(LinkedList.java:734)
//	at sevenPointSix.main(sevenPointSix.java:60)
/*		itr.remove();	// This line throws an exception because you cannot 
						// remove elements while iterating through the list
						// we need to call itr.next to visit an element prior
						// to removing it
		itr.add(8.8);
		itr.next();
*/

//	f. Exception in thread "main" java.lang.IllegalStateException
//	at java.util.LinkedList$ListItr.remove(LinkedList.java:734)
//	at sevenPointSix.main(sevenPointSix.java:71)
/*		itr.remove();	// This line throws an exception because you cannot 
						// remove elements while iterating through the list
						// we need to call itr.next to visit an element prior
						// to removing it
		itr.next();
		itr.add(8.8);
*/

	}


}