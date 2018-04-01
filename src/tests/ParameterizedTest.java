package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.CalculatorService;
import main.CalculatorServiceImpl;


/**
 * @Test class A test class is the container for @Test methods. 
 
	
	
	@Runner The Runner class runs tests. JUnit 4 is backward compatible and
	will run JUnit 3 tests.
	
	@Suite The Suite allows you to group test classes together. 
		The default @Suite scans your test class for any methods that you annotated with
		@Test. Internally, the default Suite creates an instance of your test class for each @Test
		method. JUnit then executes every @Test method independently from the others to
		avoid potential side effects.
 */


@RunWith(value = Parameterized.class)
public class ParameterizedTest {
	private double expected;
	private double valueOne;
	private double valueTwo;

	@Parameters
	public static Collection<Integer[]> getTestParameters() {
		return Arrays.asList(new Integer[][] { { 2, 1, 1 }, // expected, valueOne, valueTwo
				{ 3, 2, 1 }, // expected, valueOne, valueTwo
				{ 4, 3, 1 }, // expected, valueOne, valueTwo
		});
	}

	public ParameterizedTest(double expected, double valueOne, double valueTwo) {
		this.expected = expected;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}

	@Test
	public void sum() throws Exception {
		CalculatorService calc = new CalculatorServiceImpl();
		assertEquals(expected, calc.plus(valueOne, valueTwo), 0);
	}
}