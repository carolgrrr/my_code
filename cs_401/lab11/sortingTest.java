import java.util.*;
import java.io.*;

public class sortingTest
{
	
	public static void main (String[] args) throws IOException
	{
		File ifile = new File("students.dat");
		Scanner sc = new Scanner(ifile);
		String [] myStudentArray = new String[3380];
		int i = 0;
		double startTime, finishTime, elapsedTime;

		while (sc.hasNextLine())
		{
			myStudentArray[i] = sc.nextLine();
			i++;
		}

		String [] afterBubble = myStudentArray;
		startTime = System.nanoTime();
		bubbleSort(afterBubble);
		finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println("Bubble sort of data file takes " + elapsedTime + " seconds");

		String [] afterInsertion = myStudentArray;
		startTime = System.nanoTime();
		insertionSort(afterInsertion);
		finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println("Insertion sort of data file takes " + elapsedTime + " seconds");

		String [] afterSelection = myStudentArray;		
		startTime = System.nanoTime();
		selectionSort(afterSelection);
		finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println("Selection sort of data file takes " + elapsedTime + " seconds");

	}

	public static void insertionSort(String[]x)
	{
		for (int i = 1; i < x.length; i++)
		{
			for (int k = i; k > 0 && ((Comparable)x [k - 1]).compareTo (x [k]) > 0; k--)
			{
				swap (x, k, k - 1);
			}
		}

	}

	public static void selectionSort (String[] x)
	{
		for (int i = 0; i < x.length-1; i++)
		{
			int pos = i;
			for (int k = i + 1; k < x.length; k++)
			{
				if (((Comparable)x[k]).compareTo(x[pos]) < 0) //(Comparable)x [k - 1]).compareTo (x [k])
					pos = k;
			}
			swap(x, i, pos);
		}
	} // method selectionSort

	public static void swap (Object[] x, int a, int b)
	{
		Object temp = x[a];
		x[a] = x[b];
		x[b] = temp;
	} // method swap

/*	public static void selectionSort (int [] x)
	{

		for (int i = 0; i < x.length - 1; i++)
		{
			int pos = i;
			for (int k = i; k < x.length; k++)
			{
				if (x [k] < x [pos])
				{
					pos = k;
				}
			}
			swap (x, i, pos);
		}
	} // method selectionSort
*/

	public static void bubbleSort (String[] x)
	{
		int finalSwapPos = x.length - 1, swapPos;

		while (finalSwapPos > 0)
		{
			swapPos = 0;
			for (int i = 0; i < finalSwapPos; i++)
			{
				if (((Comparable)x [i]).compareTo(x [i + 1]) > 0)
				{
					swap (x, i, i + 1);
					swapPos = i;
				}
			}
			finalSwapPos = swapPos;
		}
	}

	public static void printArray (String[] x)
	{
		for (String s: x)
			System.out.println(s);
	}

}