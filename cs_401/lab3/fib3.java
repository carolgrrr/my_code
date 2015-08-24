public static long fib (int n)  
{
	final int MAX_N = 92;

        final String ERROR_MESSAGE = "\nThe number entered must be " +
            "greater than 0 and at most " + MAX_N + ".";

        if (n <= 0 || n > MAX_N)
            throw new IllegalArgumentException (ERROR_MESSAGE);
  
  	return (long)((1 / Math.sqrt (5)) *
                (Math.pow((1 + Math.sqrt (5)) / 2, n)- 
           	Math.pow((1 - Math.sqrt (5)) / 2, n)));
} // method fib
