package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import farmsimulator.Animal;
import farmsimulator.AnimalFoodOne;
import farmsimulator.Cow;
import farmsimulator.Farm;
import farmsimulator.Farmer;
import farmsimulator.GeneralStore;

class PlayWithAnimalTest {

	private GeneralStore store = new GeneralStore();

	@Test
	public void feedAnimaltest() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer");
		Animal animal = new Cow("TestCow",0,0);
		store.purchaseAnimal(animal, farm);
		String message = animal.playWithAnimal(farmer);
		assertEquals("You have played with TestCow", message);
	}
	
	@Test
	public void playWithAnimalNoActionTest() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer");
		farmer.useAction();
		farmer.useAction();
		Animal animal = new Cow("TestCow",0,0);
		store.purchaseAnimal(animal, farm);
		String message = animal.playWithAnimal(farmer);
		assertEquals("You have no actions left for the day, move to next day to complete this action", message);
	}

}
