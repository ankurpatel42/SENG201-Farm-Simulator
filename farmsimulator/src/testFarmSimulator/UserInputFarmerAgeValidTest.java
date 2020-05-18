package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import farmsimulator.GameEnvironment;

class UserInputFarmerAgeValidTest {
	
	private GameEnvironment game = new GameEnvironment();

	@Test
	public void isValidFarmerAge() {
		String testAge = "31";
		assertTrue(game.userInputFarmerAgeValid(testAge));
	}
	
	@Test
	public void isValidFarmerAgeIsNotInteger() {
		String testAge = "t%est";
		assertFalse(game.userInputFarmerAgeValid(testAge));
	}
	
	@Test
	public void isValidFarmerAgeTooSmall() {
		String testAge = "19";
		assertFalse(game.userInputFarmerAgeValid(testAge));
	}
	
	@Test
	public void isValidFarmerAgeTooBig() {
		String testAge = "76";
		assertFalse(game.userInputFarmerAgeValid(testAge));
	}
	
	@Test
	public void isValidFarmerAgeBlankInput() {
		String testAge = "     ";
		assertFalse(game.userInputFarmerAgeValid(testAge));
	}

}
