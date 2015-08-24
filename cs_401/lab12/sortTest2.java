import java.util.*;
import java.io.*;

public class sortTest2
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

		String [] afterMerge = myStudentArray;
		startTime = System.nanoTime();
		String [] mergeTemp = afterMerge.clone();
		mergeSort(afterMerge, mergeTemp, 0, afterMerge.length);
		finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println("Merge sort of data file takes " + elapsedTime + " seconds");

		String [] afterQuick = myStudentArray;
		startTime = System.nanoTime();
		quickSort(afterQuick);
		finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println("Quick sort of data file takes " + elapsedTime + " seconds");

		String [] afterHeap = myStudentArray;		
		startTime = System.nanoTime();
		heapSort(afterHeap);
		finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println("Heap sort of data file takes " + elapsedTime + " seconds");

	}

	public static void mergeSort(String[]x, String[]t, int low, int high)
	{
		int length = high - low;

		if (length < 7)
		{
			for (int i = low; i < high; i++)
			{
				for (int j = i; j > low && ((Comparable)t[j - 1]).compareTo(t[j]) > 0; j--)
					swap (t, j, j-1);
			}
			return;
		} // if length < 7

		// Sort left and right halves of x into t
		int mid = (low + high) >> 1;
		mergeSort(x, t, low, mid);
		mergeSort(x, t, mid, high);

		// If left subarray less than right subarray, copy x to t
		if (((Comparable)x[mid-1]).compareTo(x [mid]) < 0)
		{
			System.arraycopy(x, low, t, low, length);
		}

		// Merge sorted subarrays in src into dest.
		for (int i = low, p = low, q = mid; i < high; i++)
		{
			if (q >= high || (p<mid && ((Comparable)x[p]).compareTo(x[q]) <= 0))
				t[i] = x[p++];
			else
				t[i] = x[q++];
		}

	} // method mergeSort

	public static void quickSort (String[] x)
	{
		for (int i = 0; i < x.length-1; i++)
		{
			int pos = i;
			for (int k = i + 1; k < x.length; k++)
			{
				if (((Comparable)x[k]).compareTo(x[pos]) < 0) 
					pos = k;
			}
			swap(x, i, pos);
		}
	} // method quickSort

		public static void heapSort (String[] x)
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
	} // method heapSort

	public static void swap (Object[] x, int a, int b)
	{
		Object temp = x[a];
		x[a] = x[b];
		x[b] = temp;
	} // method swap



	public static void printArray (String[] x)
	{
		for (String s: x)
			System.out.println(s);
	} // method printArray
}