package main;

import java.util.ArrayList;
import java.util.List;

public class Bowling implements BowlingGame {

	private List<Integer> pins = new ArrayList<Integer>();
	public static int numberOfThrow = 0;
		
	
	@Override
	public void roll(int numberOfPins) {
		pins.add(numberOfPins);

	}

	@Override
	public int score() {
		int result = 0;
		List<Throw> throwList = new ArrayList<>();
		throwList = makeThrowList(pins);
		result = addBasicPoint(result, throwList);
		result += addFirstBonusPoint(throwList); 
		result += addSecondBonusPoint(throwList); 
		if (throwList.size() != 0) {
			numberOfThrow = throwList.get(throwList.size()-1).getnumberOfThrow();
		}
		return result;
	}



	public List<Throw> makeThrowList(List<Integer> pins2) {
		int throwNumber = 0;
		List<Throw> throwList = new ArrayList<>();
		for (int i = 0; i < pins.size(); i++) {
			throwList.add(new Throw(throwNumber, pins.get(i)));
			throwNumber = doubleIncreaseIfTenPins(pins.get(i), throwNumber);
		}
		return throwList ;
	}

	@Override
	public boolean isFinished() {
		boolean result = false;
		if (numberOfThrow == 22) {
			result = true;
		}
		return result;
	}
	
	
	
	private int addBasicPoint(int result, List<Throw> throwList) {
		for (int i = 0; i < pins.size(); i++) {
			if (throwList.get(i).getnumberOfThrow() <= 22) {
				result = result + pins.get(i);
			}
		}
		return result;
	}
	
	private int addFirstBonusPoint(List<Throw> throwList) {
		int bonusPoint = 0;
		for (int i = 1; i < pins.size(); i++) {
			if (pins.get(i-1) == 10 && throwList.get(i).getnumberOfThrow() <= 18){
				bonusPoint = bonusPoint + pins.get(i);
			}
		}
		
		return bonusPoint;
	}
	private int addSecondBonusPoint(List<Throw> throwList) {
		int bonusPoint = 0;
		for (int i = 2; i < throwList.size(); i++) {
			if (throwList.get(i-2).getnumberOfPins() == 10 && throwList.get(i).getnumberOfThrow() <= 19) {
				bonusPoint = bonusPoint + pins.get(i);
			} else if ((throwList.get(i-1).getnumberOfPins()+throwList.get(i-2).getnumberOfPins()) == 10 && throwList.get(i).getnumberOfThrow()%2 == 0 && throwList.get(i).getnumberOfThrow() <= 18) {
				bonusPoint = bonusPoint + pins.get(i);
			}
		}
		
		return bonusPoint;
	}
	
	private int doubleIncreaseIfTenPins(Integer pins, int number) {
		if (pins == 10){
			number++;
		}
		number++;
		return number;
	}

	
}
