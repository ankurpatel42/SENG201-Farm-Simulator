package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import farmsimulator.Animal;
import farmsimulator.AnimalFoodOne;
import farmsimulator.Corn;
import farmsimulator.Cow;
import farmsimulator.Farm;
import farmsimulator.Farmer;
import farmsimulator.FertiliserOne;
import farmsimulator.GeneralStore;
import farmsimulator.Item;

class FeedAnimalTest {
	
	private GeneralStore store = new GeneralStore();

	@Test
	public void feedAnimaltest() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer");
		Animal animal = new Cow("TestCow",0,0);
		store.purchaseAnimal(animal, farm);
		AnimalFoodOne a1 = new AnimalFoodOne();
		store.purchaseItem(a1, farm);
		String message = animal.feedAnimal(a1, farmer, farm.getItemsOwned());
		assertEquals("You have fed TestCow A1", message);
	}
	
	@Test
	public void feedAnimalItemCheck() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer");
		Animal animal = new Cow("TestCow",0,0);
		store.purchaseAnimal(animal, farm);
		AnimalFoodOne a1 = new AnimalFoodOne();
		store.purchaseItem(a1, farm);
		animal.feedAnimal(a1, farmer, farm.getItemsOwned());
		ArrayList<Item> test = new ArrayList<Item>();
		assertArrayEquals(test.toArray(), farm.getItemsOwned().toArray());
	}
	
	@Test
	public void feedAnimalNoActionTest() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer");
		farmer.useAction();
		farmer.useAction();
		Animal animal = new Cow("TestCow",0,0);
		store.purchaseAnimal(animal, farm);
		AnimalFoodOne a1 = new AnimalFoodOne();
		store.purchaseItem(a1, farm);
		String message = animal.feedAnimal(a1, farmer, farm.getItemsOwned());
		assertEquals("You have no actions left for the day, move to next day to complete this action", message);
	}
	

}
