public class dblLinkedListTest
{
	
	public static void main(String[] args)
	{

		CS401DblLinkedListImpl<String> myDblLink = new CS401DblLinkedListImpl<String>();
	
		myDblLink.add("Bill");
		myDblLink.add("Rohan");
		myDblLink.add("James");
		myDblLink.add("Krishna");
		myDblLink.add("Javier");
		myDblLink.add("Lisa");

		System.out.println("\nList printed from beginning: ");
		myDblLink.print_from_beginning();
		System.out.println("\nList printed from end: ");
		myDblLink.print_from_end();
		System.out.println("\nRemove element: " + myDblLink.remove(1));
		System.out.println("New list printed from beginning: ");
		myDblLink.print_from_beginning();
		System.out.println("\nRemove element: " + myDblLink.remove(5));
		System.out.println("New list printed from end: ");
		myDblLink.print_from_end();
		System.out.println("\nRemove element: " + myDblLink.remove(3));
		System.out.println("New list printed from beginning: ");
		myDblLink.print_from_beginning();

	}
}