package main;

public class Backpack implements Container {

	CalculatorService calculator;

	public Backpack(CalculatorService calculator) {
		super();
		this.calculator = calculator;
	}

	@Override
	public CalculatorService getCalculator() {
		// TODO Auto-generated method stub
		return calculator;
	}

	
	
	
}
