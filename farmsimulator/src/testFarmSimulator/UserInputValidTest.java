package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import farmsimulator.GameEnvironment;

class UserInputValidTest {
	
	private GameEnvironment game = new GameEnvironment();

	@Test
	public void isValidInputLengthGreaterThanThreeAndLessThanFifteen() {
		String testInput = "validinput";
		assertTrue(game.userInputValid(testInput));
	}
	
	@Test
	public void isValidInputLengthTooSmall() {
		String testInput = "t";
		assertFalse(game.userInputValid(testInput));
	}
	
	@Test
	public void isValidInputLengthTooBig() {
		String testInput = "testtesttesttesttesttesttesttest";
		assertFalse(game.userInputValid(testInput));
	}
	
	@Test
	public void isValidInputContainsNumbers() {
		String testInput = "Tes65tna3e";
		assertFalse(game.userInputValid(testInput));
	}
	
	@Test
	public void isValidInputContainsSpecialCharacters() {
		String testInput = "test!@#$%^&*()";
		assertFalse(game.userInputValid(testInput));
	}
	
	@Test
	public void isValidBlankInput() {
		String testInput = "      ";
		assertFalse(game.userInputValid(testInput));
	}
	

}
