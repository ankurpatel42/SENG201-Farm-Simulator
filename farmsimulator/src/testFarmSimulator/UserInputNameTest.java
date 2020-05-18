package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import farmsimulator.GameEnvironment;

class UserInputNameTest {
	
	private GameEnvironment game = new GameEnvironment();

	@Test
	public void isValidName() {
		String testInput = "validinput";
		assertTrue(game.userInputNameValid(testInput));
	}
	
	@Test
	public void isValidNameLengthTooSmall() {
		String testInput = "t";
		assertFalse(game.userInputNameValid(testInput));
	}
	
	@Test
	public void isValidNameLengthTooBig() {
		String testInput = "testtesttesttesttesttesttesttest";
		assertFalse(game.userInputNameValid(testInput));
	}
	
	@Test
	public void isValidNameContainsNumbers() {
		String testInput = "Tes65tna3e";
		assertFalse(game.userInputNameValid(testInput));
	}
	
	@Test
	public void isValidNameContainsSpecialCharacters() {
		String testInput = "test!@#$%^&*()";
		assertFalse(game.userInputNameValid(testInput));
	}
	
	@Test
	public void isValidNameBlankInput() {
		String testInput = "      ";
		assertFalse(game.userInputNameValid(testInput));
	}
	

}
