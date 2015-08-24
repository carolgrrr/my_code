import java.util.*;

public class sevenPointTwo
{
	public static void main(String[] args)
	{
		LinkedList<Character> letters = new LinkedList<Character>();

		ListIterator<Character> itr = letters.listIterator();

		itr.add('f');
		System.out.println("added f in position 0 " + letters);
		itr.add('t');
		System.out.println("added t in position 1" + letters);
		itr.previous();
		System.out.println("moved back to position 1 " + letters);
		itr.previous();
		System.out.println("moved back to position 0 " + letters);
		itr.add('e');
		System.out.println("added e in position 0 " + letters);
		itr.add('r');
		System.out.println("added r in position 1 " + letters);
		itr.next();
		System.out.println("moved ahead to position 2 " + letters);
		itr.add('e');
		System.out.println("added e in position 2 " + letters);
		itr.add('c');
		System.out.println("added c in position 3 " + letters);
		itr = letters.listIterator();
		System.out.println("move to position 0 of LinkedList " + letters);
		itr.add('p');
		System.out.println("added p in position 0 " + letters);
	}

}