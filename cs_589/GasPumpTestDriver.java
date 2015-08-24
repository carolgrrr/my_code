//import GasPump;
import java.util.*;
import java.io.*;

public class GasPumpTestDriver {

	final static String FILE_NAME = "TS.txt";
	
	public static void main(String[] args) throws FileNotFoundException{
		// create an ArrayList to store test strings
		ArrayList<String> testSuite = getTests();
		// loop through all tests in the test suite
		for(int i=0; i<testSuite.size(); i++) {
			// create new GasPump for each test
			GasPump testPump = new GasPump();
			// create tokenized string of ith test in test suite
			StringTokenizer st = new StringTokenizer(testSuite.get(i));
			// create list of each operation in the ith test
			ArrayList<String> operations = parseTest(st);
			// index to track position in the list of operations
			int operationIndex = 0;
			// loop through operations until the end of a test is reached
			while (operationIndex < operations.size()) {
				// create a string to hold the next operation in the test
				String op = operations.get(operationIndex);
				// call the method corresponding to the next operation in the test
				// also print a line indicating the return value of the method
				switch(op) {
					case "Activate":
						// increment index to read regular price
						operationIndex++;
						int a = Integer.parseInt(operations.get(operationIndex));
						// increment index to read super price
						operationIndex++;
						int b = Integer.parseInt(operations.get(operationIndex));
						System.out.println("The value returned by Activate " + a + " " + b + " is: " + testPump.Activate(a, b));
						break;
					case "Start":
						System.out.println("The value returned by Start is: " + testPump.Start());
						break;
					case "PayCredit":
						System.out.println("The value returned by PayCredit is: " + testPump.PayCredit());
						break;
					case "Reject":
						System.out.println("The value returned by Reject is: " + testPump.Reject());
						break;
					case "Cancel":
						System.out.println("The value returned by Cancel is: " + testPump.Cancel());
						break;
					case "Approved":
						System.out.println("The value returned by Approved is: " + testPump.Approved());
						break;
					case "PayCash":
						// increment index to read cash amount
						operationIndex++;
						int c = Integer.parseInt(operations.get(operationIndex));
						System.out.println("The value returned by PayCash " + c + " is: " + testPump.PayCash(c));
						break;
					case "Regular":
						System.out.println("The value returned by Regular is: " + testPump.Regular());
						break;
					case "Super":
						System.out.println("The value returned by Super is: " + testPump.Super());
						break;
					case "StartPump":
						System.out.println("The value returned by StartPump is: " + testPump.StartPump());
						break;
					case "PumpGallon":
						System.out.println("The value returned by PumpGallon is: " + testPump.PumpGallon());
						break;
					case "StopPump":
						System.out.println("The value returned by StopPump is: " + testPump.StopPump());
						break;
					case "NoReceipt":
						System.out.println("The value returned by NoReceipt is: " + testPump.NoReceipt());
						break;
					case "Receipt":
						System.out.println("The value returned by Receipt is: " + testPump.Receipt());
						break;
					case "TurnOff":
						System.out.println("The value returned by TurnOff is: " + testPump.TurnOff());
						break;
					default:
						System.out.println(op);
				}
				operationIndex++;
			}
			// print all attributes of gas pump at the end of each test
			System.out.println("End of test attribute values: ");
			testPump.printAttributes();
			System.out.println();
		}
	}

	// retuns an ArrayList of test strings read from a file
	public static ArrayList<String> getTests() throws FileNotFoundException {
		File f = new File(FILE_NAME);
		Scanner sc = new Scanner(f);
		ArrayList<String> testList = new ArrayList<String>();
		// add more tests to test list until 
		// there are no more tests to add		
		while (sc.hasNextLine()){
			testList.add(sc.nextLine());
		}
		return testList;
	}

	// returns an ArrayList of test operations in a single test
	public static ArrayList<String> parseTest(StringTokenizer tok){
		ArrayList<String> testOps = new ArrayList<String>();
		// add more operations to operation list until
		// there are no more opreations to add
		while(tok.hasMoreTokens()) {
			testOps.add(tok.nextToken());
		}
		return testOps;
	}

}