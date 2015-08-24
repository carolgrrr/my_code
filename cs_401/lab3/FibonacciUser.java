import java.util.*;

public class FibonacciUser
{
  public static void main (String[] args)
  {
 new FibonacciUser().run();
  } // method main

  
  /**
   *  The Fibonacci number of the integer entered has been printed.
   */
  public void run() 
  { 
      final int SENTINEL = -1;
 
     final String INPUT_PROMPT = "\n\nPlease enter the " +
        "positive integer whose Fibonacci number you want (or " +
         SENTINEL + " to quit): ";    
           
     final String FIBONACCI_MESSAGE = "\nIts Fibonacci number is ";
         
     Scanner sc = new Scanner (System.in);
    
 int n;

     while (true)
     {
        try
        {
          System.out.print (INPUT_PROMPT);
          n = sc.nextInt();
          if (n == SENTINEL)
           break;        
          System.out.println (FIBONACCI_MESSAGE + fib (n));
        }//try
        catch (Exception e)
        {
          System.out.println (e);
          sc.nextLine();
        }//catch Exception      
     }//while     
  } // method run

  /**
   *  The Fibonacci number of the int n has been returned.
   * 
   * @param n an int whose Fibinacci number will be returned.
   *          n > 0.
   * 
   * @return a long containing the Fibonacci number of n.
   *
   * @throws IllegalArgumentException - if n <= 0 or > 92 (note 
   *         that fib (93) is larger than Long.MAX_VALUE).
   *
   */
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
  } // fib
  
} // class FibonacciUser
