Program Output:


Merge sort of data file takes 1.1847168E7 seconds
Quick sort of data file takes 658944.0 seconds
Heap sort of data file takes 9.2381184E7 seconds



Sort Methods:


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
                        if (((Comparable)x[k]).compareTo(x[pos]) < 0) //(Comparable)x [k - 1]).compareTo (x [k])
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
}




public static void swap (Object[] x, int a, int b)
{
        Object temp = x[a];
        x[a] = x[b];
        x[b] = temp;
} // method swap