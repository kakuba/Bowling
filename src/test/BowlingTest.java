package test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import main.Bowling;

public class BowlingTest {

	@Test
	public void shouldReturnZeroAtBeginning() {
		//given
		Bowling bowling = new Bowling();
		Integer expectedResult = 0;
		//when
		Integer result = bowling.score();
		//then
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void shouldReturnSixWhenThrownSixPins() {
		//given
		Bowling calculator = new Bowling();
		Integer rolledSix = 6;
		calculator.roll(rolledSix);
		//when
		Integer result = calculator.score();
		//then
		Assert.assertEquals(rolledSix, result);
	}
	
	@Test
	public void shouldReturnSixWhenThrownFourAndTwoPins() {
		//given
		Bowling calculator = new Bowling();
		Integer firstRolledFour = 4;
		Integer secondRolledTwo = 2;
		calculator.roll(firstRolledFour);
		calculator.roll(secondRolledTwo);
		//when
		Integer result = calculator.score();
		//then
		Assert.assertEquals(Integer.valueOf(6), result);
	}
	@Test
	public void shouldReturnTenWhenThrownTenPins() {
		//given
		Bowling calculator = new Bowling();
		Integer rolledTen = 10;
		calculator.roll(rolledTen);
		//when
		Integer result = calculator.score();
		//then
		Assert.assertEquals(rolledTen, result);
	}
	@Test
	public void shouldReturnTwentyTwoWhenThrownTenPinsAndSix() {
		//given
		Bowling bowling = new Bowling();
		Integer firstRolledTen = 10;
		Integer secondRolledSix = 6;
		bowling.roll(firstRolledTen);
		bowling.roll(secondRolledSix);
		//when
		Integer result = bowling.score();
		//then
		Assert.assertEquals(Integer.valueOf(22), result);
	}
	@Test
	public void shouldReturnThirtyWhenThrownTenPinsAndSixAndFourPins() {
		//given
		Bowling bowling = new Bowling();
		Integer firstRolledTen = 10;
		Integer secondRolledSix = 6;
		Integer secondRolledFour = 4;
		bowling.roll(firstRolledTen);
		bowling.roll(secondRolledSix);
		bowling.roll(secondRolledFour);
		//when
		Integer result = bowling.score();
		//then
		Assert.assertEquals(Integer.valueOf(30), result);
	}
	@Test
	public void shouldReturnThirtyWhenThrownFourPinsAndSixAndTenPins() {
		//given
		Bowling bowling = new Bowling();
		Integer firstRolledTen = 10;
		Integer secondRolledSix = 6;
		Integer secondRolledFour = 4;
		bowling.roll(secondRolledSix);
		bowling.roll(secondRolledFour);
		bowling.roll(firstRolledTen);
		//when
		Integer result = bowling.score();
		//then
		Assert.assertEquals(Integer.valueOf(30), result);
	}
	@Test
	public void shouldReturnOneHundertAndOneWhenThrownFourPinsAndSixAndTenPins() {
		//given
		Bowling bowling = new Bowling();
		List<Integer> rolls = Arrays.asList(6,3,10,7,1,9,1,10,10,2,5);
		rolling(rolls, bowling);
		//when
		Integer result = bowling.score();
		//then
		Assert.assertEquals(Integer.valueOf(101), result);
	}
	@Test
	public void shouldReturnOneHundertTwentyNineWhenThrownFourPinsAndSixAndTenPins() {
		//given
		Bowling bowling = new Bowling();
		List<Integer> rolls = Arrays.asList(6,3,10,7,1,9,1,10,10,2,5,10,7,2);
		rolling(rolls, bowling);
		//when
		Integer result = bowling.score();
		//then
		Assert.assertEquals(Integer.valueOf(129), result);
	}
	@Test
	public void shouldReturnCorrectScore() {
		//given
		Bowling bowling = new Bowling();
		List<Integer> rolls = Arrays.asList(10,9,1,5,5,7,2,10,10,10,9,0,8,2,9,1,10);
		rolling(rolls, bowling);
		//when
		Integer result = bowling.score();
		//then
		Assert.assertEquals(Integer.valueOf(187), result);
	}
	@Test
	public void shouldReturnCorrectScore2() {
		//given
		Bowling bowling = new Bowling();
		List<Integer> rolls = Arrays.asList(10,9,1,5,5,7,2,10,10,10,9,0,8,2,10,10,10);
		rolling(rolls, bowling);
		//when
		Integer result = bowling.score();
		//then
		Assert.assertEquals(Integer.valueOf(198), result);
	}
	@Test
	public void shouldReturnCorrectScore3() {
		//given
		Bowling bowling = new Bowling();
		List<Integer> rolls = Arrays.asList(10,9,1,5,5,7,2,10,10,10,9,0,10,10,10,10);
		rolling(rolls, bowling);
		//when
		Integer result = bowling.score();
		//then
		Assert.assertEquals(Integer.valueOf(208), result);
	}
	@Test
	public void shouldTrueIfItIsFinished() {
		//given
		Bowling bowling = new Bowling();
		List<Integer> rolls = Arrays.asList(10,9,1,5,5,7,2,10,10,10,9,0,10,10,10,10);
		rolling(rolls, bowling);
		//when
		bowling.score();
		Boolean result = bowling.isFinished();
		//then
		Assert.assertTrue(result);
	}
	@Test
	public void shouldFalseIfItIsNotFinished() {
		//given
		Bowling bowling = new Bowling();
		List<Integer> rolls = Arrays.asList(10,9,1,5,5,7,2,10,10,10,9,0,10,10,10);
		rolling(rolls, bowling);
		//when
		bowling.score();
		Boolean result = bowling.isFinished();
		//then
		Assert.assertFalse(result);
	}
	@Test
	public void shouldFalseIfItIsSeventhRound() {
		//given
		Bowling bowling = new Bowling();
		List<Integer> rolls = Arrays.asList(10,9,1,5,5,7,2,10,10,10);
		rolling(rolls, bowling);
		//when
		bowling.score();
		Boolean result = bowling.isFinished();
		//then
		Assert.assertFalse(result);
	}
	@Test
	public void shouldFalseIfItIsNotStarted() {
		//given
		Bowling bowling = new Bowling();
		//when
		bowling.score();
		Boolean result = bowling.isFinished();
		//then
		Assert.assertFalse(result);
	}

	private void rolling(List<Integer> rolls, Bowling bowling) {
		for (int i = 0; i < rolls.size(); i++) {
			bowling.roll(rolls.get(i));
		}
	}
	
	
	
	
}
