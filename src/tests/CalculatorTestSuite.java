package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value=org.junit.runners.Suite.class)
@SuiteClasses(value={CalculatorTest.class,
ParameterizedTest.class,
BackpackTest.class})
public class CalculatorTestSuite {

}
