import java.util.*;

public class CarWashUser
{
	
	public static void main (String[] args)
	{
		new CarWashUser().run();
	} // method main

	/**
	*	Reads in all of the arrival times, runs the simulation, and calculates 
	*	the average waiting time.
	*
	*/
	public void run()
	{
		final int SENTINEL = 999;

		final String INPUT_PROMPT1 = "\nPlease enter the mean arrival time: ";
		final String INPUT_PROMPT2 = "\nPlease enter the mean service time: ";
		final String INPUT_PROMPT3 = "\nPlease enter the maximum arrival time: ";

		final String OUT_OF_RANGE = "The input must consist of a non-negative integer less than the sentinel.";

		CarWash carWash = new CarWash();

		Scanner sc = new Scanner (System.in);

		int nextArrivalTime = 0;
		int maxArrivalTime = 0;
		int meanArrivalTime = 0;
		int meanServiceTime = 0;


			System.out.print(INPUT_PROMPT1);
			try
			{
				meanArrivalTime = sc.nextInt();
				carWash.setArrivalTime(meanArrivalTime);
				if (meanArrivalTime < 0 || meanArrivalTime > SENTINEL)
					throw new NumberFormatException(OUT_OF_RANGE);
			} // try
			catch (Exception e)
			{
				System.out.println(e);
				sc.nextLine();
			} // catch
			System.out.print(INPUT_PROMPT2);
			try
			{
				meanServiceTime = sc.nextInt();
				carWash.setServiceTime(meanServiceTime);
				if (meanServiceTime < 0 || meanServiceTime > SENTINEL)
					throw new NumberFormatException(OUT_OF_RANGE);
			} // try
			catch (Exception e)
			{
				System.out.println(e);
				sc.nextLine();
			} // catch
			System.out.print(INPUT_PROMPT3);
			try
			{
				maxArrivalTime = sc.nextInt();
				if (maxArrivalTime < 0 || maxArrivalTime > SENTINEL)
					throw new NumberFormatException(OUT_OF_RANGE);
			} // try
			catch (Exception e)
			{
				System.out.println(e);
				sc.nextLine();
			} // catch

		nextArrivalTime = carWash.getCurrentTime() + carWash.calcTimeTillNextArrival(meanArrivalTime);

		while (nextArrivalTime <= maxArrivalTime)
		{
			carWash.process(nextArrivalTime);
			nextArrivalTime = carWash.getCurrentTime() + carWash.calcTimeTillNextArrival(meanArrivalTime);
			
		} // while
		carWash.finishUp();
		printResults(carWash);
	} // method run

	/**
	*	Prints the results of the simulation.
	*
	*/
	public void printResults (CarWash carWash)
	{
		final String RESULTS_HEADING = "\nHere are the results of the simulation:\n";

		LinkedList<String> results = carWash.getResults();
		System.out.println(RESULTS_HEADING);
		for (String s : results)
			System.out.println(s);
	} // method printResults

} // class CarWashUser