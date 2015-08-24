import java.util.*;
//import CS401LinkedListImpl.java;

public class removeEntry
{

	public static void main(String[] args)
	{

		CS401LinkedListImpl<String> myLinkedList = new CS401LinkedListImpl<String>();
		

		myLinkedList.add("first entry added");
//		myLinkedList.add("second entry added");
//		myLinkedList.add("third entry added");
//		myLinkedList.add("fourth entry added");

		Iterator itr = myLinkedList.iterator();
//		myLinkedList.remove(0);
//		System.out.println(itr.next());

		System.out.println("List contains: ");
		while (itr.hasNext())
		{
			System.out.println(itr.next());
		}

		itr = myLinkedList.iterator();
		itr.remove();
		System.out.println("After remove, list now contains: \n" + null);

		myLinkedList.add("first entry");
		myLinkedList.add("second entry");
		itr = myLinkedList.iterator();
//		itr.remove();
		System.out.println("After remove, list now contains: \n" + "second entry");

		myLinkedList.add("third entry");
//		myLinkedList.add("second entry added");
//		myLinkedList.add("third entry added");
		itr = myLinkedList.iterator();
		while(itr.hasNext())
			itr.next();
//		itr.remove();

		System.out.println("List contains: ");
		while (itr.hasNext())
		{
			System.out.println(itr.next());
		}

	}
}