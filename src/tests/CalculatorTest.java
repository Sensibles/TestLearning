package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import main.CalculatorService;
import main.CalculatorServiceImpl;


public class CalculatorTest {
	
	@Test
	public void shouldAdd() throws Exception {
		CalculatorService cService = new CalculatorServiceImpl();
		Assert.assertEquals(5, cService.plus(2,3), 0);
	}
	
	@Test
	public void shouldSubtract() throws Exception {
		CalculatorService cService = new CalculatorServiceImpl();
		Assert.assertEquals(-1, cService.minus(2,3), 0);
	}

}
