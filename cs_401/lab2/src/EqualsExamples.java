
public class EqualsExamples {

	public static void main(String[] args) {
		// Shows examples of each of the five properties for 
		// overriding the Object class's equals method
		
		FullTimeEmployee empX = new FullTimeEmployee("Jane", 50000);
		FullTimeEmployee empY = new FullTimeEmployee("Jane", 50000);
		FullTimeEmployee empZ = new FullTimeEmployee("Jane", 50000);
		
		System.out.println("Employee x: " + empX.toString());
		
		// reflexivity: x.equals(x) should return true
		System.out.println("REFLEXIVITY");
		System.out.println("x.equals(x) is: " + empX.equals(empX));
		System.out.println("\n");
		
		// symmetry: x.equals(y) returns the same result as y.equals(x) 
		System.out.println("SYMMETRY");
		System.out.println("Employee y: " + empY.toString());
		System.out.println("x.equals(y) is: " + empX.equals(empY));
		System.out.println("y.equals(x) is: " + empY.equals(empX));
		System.out.println("\n");
		
		// transitivity: if x.equals(y) returns true and y.equals(z) returns true
		// then x.equals(z) should return true
		System.out.println("TRANSITIVITY");
		System.out.println("Employee z: " + empZ.toString());
		System.out.println("x.equals(y) is: " + empX.equals(empY));
		System.out.println("y.equals(z) is: " + empY.equals(empZ));
		System.out.println("x.equals(z) is: " + empX.equals(empZ));
		System.out.println("\n");
		
		// consistency: multiple invocations of x.equals(y) should consistently
		// return true or consistently return false
		System.out.println("CONSISTENCY");
		for(int i = 1; i <= 10; i++){
			System.out.println("Invocation "+i+" - x.equals(y) is: " + empX.equals(empY));
		}		
		System.out.println("\n");
			
		// actuality: x.equals(null) should return false
		System.out.println("ACTUALITY");
		System.out.println("x.equals(null) is: " + empX.equals(null));
		

	}

}
