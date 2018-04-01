package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


import main.Backpack;
import main.CalculatorService;
import main.CalculatorServiceImpl;
import main.Container;

public class BackpackTest {
	
	
	/*
	 * Test object - object used to TEST some object. 
	 * We need to create calculator to fulfill dependency required in
	 * Container object's constructor.
	 */
	
	/*
	 * Domain object - object under the test. In that case: Container is
	 * an object under test method. We are testing Container - thus it's domain
	 * object. 
	 */
	private CalculatorService calculator;
	private CalculatorService exceptionCalc;
	private Exception testException;
	private class CalculatorException implements CalculatorService{

		private Exception testException;
		
		
		public CalculatorException(Exception testException) {
			super();
			this.testException = testException;
		}

		@Override
		public Double plus(double a, double b) throws Exception{
			throw new Exception("Exception");
		}

		@Override
		public double minus(double a, double b) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	/*
	 * Before odpala te metode przed ka¿dym z testów. 
	 */
	@Before
	public void initializeVars() {
		System.out.println("Initialize calc");
		calculator = new CalculatorServiceImpl();
		
		testException = new Exception("Test exception thrown!");
		exceptionCalc = new CalculatorException(testException);
	}
	
	/*
	 * BeforeClass odpala te metode raz przed wszystkimi testami, ale metoda musi byæ static, czyli zasoby bêd¹ wspólne dla obu metod.
	 */
	
//	@BeforeClass
//	public static void initializeVars() {
//		System.out.println("Initialize calc");
//		calculator = new CalculatorServiceImpl();
//	}
//	
	@Test
	public void shouldHaveCalc() throws Exception {
		System.out.println("Calc instance: "+calculator);
		Container container = new Backpack(calculator);
		Assert.assertNotNull(container.getCalculator());		
	}
	
	@Test
	public void shouldAdd() throws Exception {
		System.out.println("Calc instance: "+calculator);
		Container container = new Backpack(calculator);
		Assert.assertEquals(5, container.getCalculator().plus(2, 3), 0);
	}
	
	@Test(expected = Exception.class)
	public void shouldThrowError() throws Exception {
		Container container = new Backpack(exceptionCalc);
		container.getCalculator().plus(3, 4);
	}
	
	//Test musi sie zakoñczyæ przed 10ms
	@Test(timeout = 10)
	// Test mo¿na zignorowaæ
	@Ignore(value = "Ignore the test")
	public void shouldEndInTime() throws Exception {
		for(int i = 0; i < 1000000; i++) {
			Container container = new Backpack(calculator);
			Assert.assertEquals(5, container.getCalculator().plus(2, 3), 0);
		}
	}

}
