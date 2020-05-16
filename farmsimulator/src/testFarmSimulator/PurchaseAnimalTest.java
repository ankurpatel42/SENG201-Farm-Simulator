package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import farmsimulator.Animal;
import farmsimulator.Cow;
import farmsimulator.Farm;
import farmsimulator.GeneralStore;
import farmsimulator.Pig;
import farmsimulator.Sheep;


class PurchaseAnimalTest {

	private GeneralStore store = new GeneralStore();

	@Test
	public void animalListUpdate() {
		Cow animal = new Cow("TestCow", 1, 1);
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		store.purchaseAnimal(animal, farm);
		ArrayList<Animal> test = new ArrayList<Animal>();
		test.add(animal);
		assertArrayEquals(test.toArray(), farm.getAnimalList().toArray());
	}
	
	@Test
	public void balanceUpdate() {
		Sheep animal = new Sheep("TestSheep", 1, 1);
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		store.purchaseAnimal(animal, farm);
		assertEquals(1000 - animal.getAnimalPurchasePrice(), farm.getMoneyAvailable());
	}
	
	@Test
	public void testMessage() {
		Pig animal = new Pig("TestPig", 1, 1);
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		String message = store.purchaseAnimal(animal, farm);
		assertEquals("You have purchased TestPig", message);
	}
	
	//Purchase Fails
	
	@Test
	public void testFailMessage() {
		Pig animal = new Pig("TestPig", 1, 1);
		Farm farm = new Farm("Test", 0, 1, 1, 1);
		String message = store.purchaseAnimal(animal, farm);
		assertEquals("Sorry, You have insuffcient funds to purchase this animal", message);
	}
	
	@Test
	public void balanceUpdate0() {
		Sheep animal = new Sheep("TestSheep", 1, 1);
		Farm farm = new Farm("Test", 0, 1, 1, 1);
		store.purchaseAnimal(animal, farm);
		assertEquals(0, farm.getMoneyAvailable());
	}
	
	@Test
	public void itemListUpdate0() {
		Cow animal = new Cow("TestCow", 1, 1);
		Farm farm = new Farm("Test", 0, 1, 1, 1);
		store.purchaseAnimal(animal, farm);
		ArrayList<Animal> test = new ArrayList<Animal>();
		assertArrayEquals(test.toArray(), farm.getAnimalList().toArray());
	}

}
