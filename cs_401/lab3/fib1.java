public static long fib (int n)  
{
	final int MAX_N = 92;

        final String ERROR_MESSAGE = "\nThe number entered must be " +
            "greater than 0 and at most " + MAX_N + ".";

        if (n <= 0 || n > MAX_N)
            throw new IllegalArgumentException (ERROR_MESSAGE);
  	if (n <= 2 )
    	    return 1;
    	return fib (n - 1) + fib (n - 2); 
} // method fib
