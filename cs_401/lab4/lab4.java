import java.util.*;

public class lab4
{
	

	public static void main(String[] args)
	{

		ArrayList<String> words = new ArrayList<String>();

		words.add("Hello");
		words.add("world");
		words.add("java");
		words.add("gouache");
		words.add("love");
		words.add("java");
		words.add("java");
		words.add("fancy");
		words.add("replacement");
		words.add("world");
		words.add("java");
		words.add("love");
		words.add("love");


		sixpointtwelve(words);

		ArrayList<String> myWords = new ArrayList<String>();

		myWords = uniquefy(words);
		System.out.println("\nThis is the ArrayList with duplicates removed:\n");
		for (String wordElement : myWords)
			System.out.println(wordElement);

	}

	// This is the code for problem 6.4
	public static void sixpointfour()
	{

		ArrayList<String> original = new ArrayList<String>();
		original.add("yes");
		ArrayList<Integer> copy = (ArrayList<Integer>)original.clone();

		System.out.println (copy.get (0));
	}



	// This is the code for problem 6.12
	public static void sixpointtwelve(ArrayList<String > words)
	{


		// index
		System.out.println("\nThis is the index output:");
		String indexWord;
		for(int i = 0; i < words.size(); i++)
		{
			indexWord = words.get(i);
			if (indexWord.length() == 4)
				System.out.println(indexWord);
		}

		// explicit iterator
		System.out.println("\nThis is the explicit iterator output: ");
		Iterator<String> itr = words.iterator();
		String itrWord;
		while (itr.hasNext())
		{
			itrWord = itr.next();
			if (itrWord.length() == 4)
				System.out.println(itrWord);
		}

		// enhanced for
		System.out.println("\nThis is the enhanced for loop output:");
		for(String forWord : words)
			if(forWord.length() == 4)
				System.out.println(forWord);

	}

	// This is the code for problem 6.13

	/**
	* In a given ArrayList, remove all duplicates.
	* The worstTime(n) is O(n^2).
	*
	* @param list - the given ArrayList
	* @return - An ArrayList that is identical to list except only the first
	* occurrence of duplicate elements remains.
	*
	* @throws NullPointerException - if list is null.
	*
	*/
	public static <T> ArrayList<T> uniquefy (ArrayList<T> list)
	{
		if (list == null)
			throw new NullPointerException();

		ArrayList<T> uniqueList = new ArrayList<T>(list);
		for (int i = 0; i < uniqueList.size(); i++)
		{
			for (int j = i-1; j >= 0; j--)
			{
				if (uniqueList.get(i) == uniqueList.get(j))
				{
					uniqueList.remove(i);
				}
			}
		}
		return uniqueList;
	}
}