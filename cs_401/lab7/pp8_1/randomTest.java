public class randomTest
{
	public static void main(String [] args)
	{

		CarWash myCarWash = new CarWash();

		for(int i = 0; i < 5; i++)
		{
			System.out.println("Time till next arrival: "+myCarWash.calcTimeTillNextArrival(3));
			System.out.println("Service time: "+myCarWash.calcServiceTime(5));
		}

	}
}