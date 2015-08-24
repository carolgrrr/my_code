import java.util.*;

public class HeightEstimator
{  
  public static void main (String[] args)
  {
    new HeightEstimator().run();
  } // method main 

  
   public void run() 
   {  
     final String PROMPT = "\nPlease enter the number of " + 
       "elements to be inserted for the first trial: ";
  
     final String SIZE_MESSAGE = "The tree size is ";
    
     final String RATIO_MESSAGE =
         "\nThe ratio of the average height to the log, " +
         "base 2, of the tree size is ";
    
     final int SIZES = 5;
    
     final int TRIALS_PER_SIZE = 20;
  
     BinarySearchTree<Double> myTree = new BinarySearchTree<Double>();

     Random rand = new Random();
    
     Scanner sc = new Scanner (System.in);
    
     int n,
         totalHeight;

     double averageHeight;
    
     while (true)
     {
       try
       {
          System.out.print (PROMPT);
          n = sc.nextInt();
    
          for (int i = 1; i <= SIZES; i++) 
          {  
              totalHeight = 0;
              for (int j = 0; j < TRIALS_PER_SIZE; j++) 
              {

                totalHeight += myTree.height();


              } // for each trial
              System.out.println (SIZE_MESSAGE + n);
              averageHeight = (double)totalHeight / TRIALS_PER_SIZE;
              System.out.println (RATIO_MESSAGE);                           
              n *= 2;
          } // for each size
          break;
       }//try
       catch (InputMismatchException e)
       {
          System.out.println (e);
          sc.nextLine();
       }//catch InputMismatchException       
     } // while
   } // method run
  
} // class HeightEstimator
