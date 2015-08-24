public static long fib (int n) 
{
	final int MAX_N = 92;

        final String ERROR_MESSAGE = "\nThe number entered must be " +
            "greater than 0 and at most " + MAX_N + ".";

        long previous,
             current,
             temp;

        if (n <= 0 || n > MAX_N)
            throw new IllegalArgumentException (ERROR_MESSAGE);
  	if (n <= 2) 
    		return 1;
  	previous = 1;
  	current = 1;
  	for (int i = 3; i <= n; i++) 
  	{
    		temp = current;
    		current = current + previous;
    		previous = temp;    
  	} // for
  	return current;
} // method fib
