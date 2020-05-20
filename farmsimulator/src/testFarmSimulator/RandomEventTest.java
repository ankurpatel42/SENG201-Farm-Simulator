package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import farmsimulator.Carrot;
import farmsimulator.Corn;
import farmsimulator.Farm;
import farmsimulator.GeneralStore;
import farmsimulator.RandomEvent;
import farmsimulator.Sheep;

class RandomEventTest {
	
	private RandomEvent event = new RandomEvent();
	private String message;
	private GeneralStore store = new GeneralStore();
	
	@Test
	public void noCropsDrought() {
		Farm farm = new Farm("Test", 1000, 3, 3, 3);
		message = event.drought(farm);
		assertEquals("DROUGHT!!! Luckily you have no crops so you are uneffected", message);
	}
	
	@Test
	public void CropsLost() {
		Farm farm = new Farm("Test", 1000, 3, 3, 3);
		Carrot crop1 = new Carrot();
		store.purchaseCrop(crop1, farm);
		Corn crop2 = new Corn();
		store.purchaseCrop(crop2, farm);
		message = event.drought(farm);
		assertEquals("DROUGHT!!! You lost 1 crop(s)", message);
	}
	
	@Test
	public void noAnimalsFence() {
		Farm farm = new Farm("Test", 1000, 3, 3, 3);
		message = event.fenceBroken(farm);
		assertEquals("BROKEN FENCE!!! Luckily you have no animals on the farm so you are uneffected", message);
	}
	
	@Test
	public void AnimalsLost() {
		Farm farm = new Farm("Test", 1000, 3, 3, 3);
		Sheep animal = new Sheep("Test", 3, 3);
		store.purchaseAnimal(animal, farm);
		message = event.fenceBroken(farm);
		assertEquals("BROKEN FENCE!!! You lost 1 animal(s), and the rest aren't happy", message);
	}
	
	@Test
	public void winFair() {
		Farm farm = new Farm("Test", 1000, 3, 3, 3);
		Carrot crop1 = new Carrot();
		store.purchaseCrop(crop1, farm);
		Sheep animal = new Sheep("Test", 3, 3);
		store.purchaseAnimal(animal, farm);
		event.winCountyFair(farm);
		assertEquals(1000 - 100 - 50 + 400, farm.getMoneyAvailable());
	}
	
	@Test
	public void winFairMessage() {
		Farm farm = new Farm("Test", 1000, 3, 3, 3);
		Carrot crop1 = new Carrot();
		store.purchaseCrop(crop1, farm);
		Sheep animal = new Sheep("Test", 3, 3);
		store.purchaseAnimal(animal, farm);
		message = event.winCountyFair(farm);
		assertEquals("WON THE COUNTY FAIR!!! You won $400.0", message);
	}

}
