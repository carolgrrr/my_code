import java.util.*;
import java.lang.*;

public class QueueTest
{
	
	public static void main(String[] args)
	{
		CS401QueueArrayFixedImpl<String> fixedQ = new CS401QueueArrayFixedImpl<String>(10);
		CS401QueueArrayFloatingImpl<String> floatQ = new CS401QueueArrayFloatingImpl<String>(10);
		CS401QueueLinkedListImpl<String> linkQ = new CS401QueueLinkedListImpl<String>(10);

		fixedQ.add("one");
		fixedQ.add("three");
		fixedQ.add("four");

		System.out.println("\nFixed Front:");

		System.out.println("Removed: "+fixedQ.remove());



		floatQ.add("three");
		floatQ.add("two");
		floatQ.add("four");

		System.out.println("\nFloating Front:");
		System.out.println("Removed: "+floatQ.remove());

		linkQ.add("four");
		linkQ.add("three");
		linkQ.add("five");

		System.out.println("\nLinked List:");

		System.out.println("Removed: "+linkQ.remove());



	}

}