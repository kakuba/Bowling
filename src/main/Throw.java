package main;

public class Throw {
	private int numberOfThrow = 0;
	private int numberOfPins = 0;

	public Throw (int numberOfThrow, int pins) {
		this.numberOfThrow = numberOfThrow;
		this.numberOfPins = pins;
	}
	
	public int getnumberOfThrow() {
		return numberOfThrow;
	}
	public int getnumberOfPins() {
		return numberOfPins;
	}
	
}
