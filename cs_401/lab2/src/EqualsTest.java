import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


public class EqualsTest extends TestCase {

	private FullTimeEmployee ftex;
	private FullTimeEmployee ftey;
	private FullTimeEmployee ftez;	
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		ftex = new FullTimeEmployee("Jane", 32000);
		ftey = new FullTimeEmployee("Jane", 32000);
		ftez = new FullTimeEmployee("Jane", 32000);

	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testReflexivity() {
		
		boolean xEqualsX = ftex.equals(ftex);
		
		assertTrue(xEqualsX);
	
	}
	
	public void testSymmetry(){		
		
		boolean xEqualsY = ftex.equals(ftey);
		boolean yEqualsX = ftey.equals(ftex);
		
		assertTrue(xEqualsY);
		assertTrue(yEqualsX);		
	}
	
	public void testTransitivity(){		
		
		boolean xEqualsY = ftex.equals(ftey);
		boolean yEqualsZ = ftey.equals(ftez);
		boolean xEqualsZ = ftex.equals(ftez);
		
		assertTrue(xEqualsY);
		assertTrue(yEqualsZ);
		assertTrue(xEqualsZ);
		
	}
	
	public void testConsistency(){
		
		boolean xEqualsY = ftex.equals(ftey);
		
		assertTrue(xEqualsY);
		assertTrue(xEqualsY);
		assertTrue(xEqualsY);
		assertTrue(xEqualsY);
		assertTrue(xEqualsY);
		
	}

	public void testActuality(){
		
		boolean xEqualsNull = ftex.equals(null);
		
		assertFalse(xEqualsNull);
		
	}
}
