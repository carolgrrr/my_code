Program Output:


Bubble sort of data file takes 1.89861888E8 seconds
Insertion sort of data file takes 814080.0 seconds
Selection sort of data file takes 7.861504E7 seconds




Sort Methods:


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




public static void swap (Object[] x, int a, int b)
{
        Object temp = x[a];
        x[a] = x[b];
        x[b] = temp;
} // method swap