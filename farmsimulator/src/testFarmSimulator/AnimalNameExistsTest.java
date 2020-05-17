package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import farmsimulator.Animal;
import farmsimulator.Cow;
import farmsimulator.Farm;
import farmsimulator.Pig;
import farmsimulator.Sheep;

class AnimalNameExistsTest {
	

	@Test
	public void cowNameExistsTest() {
		Farm testfarm = new Farm("Test", 0, 0, 0, 0);
		Animal testanimal = new Cow("Bob", 0, 0);
		testfarm.addAnimalToList(testanimal);
		assertEquals(true, testfarm.cowNameExists("Bob"));
	}
	
	@Test
	public void cowNameExistsCaseSensitiveTest() {
		Farm testfarm = new Farm("Test", 0, 0, 0, 0);
		Animal testanimal = new Cow("Bob", 0, 0);
		testfarm.addAnimalToList(testanimal);
		assertEquals(true, testfarm.cowNameExists("boB"));
	}
	
	@Test
	public void cowNameDoesNotExistTest() {
		Farm testfarm = new Farm("Test", 0, 0, 0, 0);
		Animal testanimal = new Cow("Bob", 0, 0);
		testfarm.addAnimalToList(testanimal);
		assertEquals(false, testfarm.cowNameExists("Jack"));
	}
	
	@Test
	public void pigNameExistsTest() {
		Farm testfarm = new Farm("Test", 0, 0, 0, 0);
		Animal testanimal = new Pig("Bob", 0, 0);
		testfarm.addAnimalToList(testanimal);
		assertEquals(true, testfarm.pigNameExists("Bob"));
	}
	
	@Test
	public void pigNameExistsCaseSensitiveTest() {
		Farm testfarm = new Farm("Test", 0, 0, 0, 0);
		Animal testanimal = new Pig("Bob", 0, 0);
		testfarm.addAnimalToList(testanimal);
		assertEquals(true, testfarm.pigNameExists("boB"));
	}
	
	@Test
	public void pigNameDoesNotExistTest() {
		Farm testfarm = new Farm("Test", 0, 0, 0, 0);
		Animal testanimal = new Pig("Bob", 0, 0);
		testfarm.addAnimalToList(testanimal);
		assertEquals(false, testfarm.pigNameExists("Jack"));
	}
	
	@Test
	public void sheepNameExistsTest() {
		Farm testfarm = new Farm("Test", 0, 0, 0, 0);
		Animal testanimal = new Sheep("Bob", 0, 0);
		testfarm.addAnimalToList(testanimal);
		assertEquals(true, testfarm.sheepNameExists("Bob"));
	}
	
	@Test
	public void sheepNameExistsCaseSensitiveTest() {
		Farm testfarm = new Farm("Test", 0, 0, 0, 0);
		Animal testanimal = new Sheep("Bob", 0, 0);
		testfarm.addAnimalToList(testanimal);
		assertEquals(true, testfarm.sheepNameExists("boB"));
	}
	
	@Test
	public void sheepNameDoesNotExistTest() {
		Farm testfarm = new Farm("Test", 0, 0, 0, 0);
		Animal testanimal = new Sheep("Bob", 0, 0);
		testfarm.addAnimalToList(testanimal);
		assertEquals(false, testfarm.sheepNameExists("Jack"));
	}

}
