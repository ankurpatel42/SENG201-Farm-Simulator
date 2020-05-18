package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import farmsimulator.Corn;
import farmsimulator.Cow;
import farmsimulator.Farm;
import farmsimulator.Farmer;
import farmsimulator.GeneralStore;
import farmsimulator.Rice;
import farmsimulator.Sheep;
import farmsimulator.Wheat;

class NextDayTest {

	GeneralStore store = new GeneralStore();
	
	@Test
	public void cropGrow() {
		Wheat crop = new Wheat();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
		store.purchaseCrop(crop, farm);
		farmer.moveToNextDay(farm, farm.getCropList(), farm.getItemsOwned(), farm.getAnimalList(), 5);
		assertEquals(3, crop.getDaysTillHarvest());
	}
	
	@Test
	public void highCropGrowth() {
		Corn crop = new Corn();
		Farm farm = new Farm("Test", 1000, 4, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
		store.purchaseCrop(crop, farm);
		farmer.moveToNextDay(farm, farm.getCropList(), farm.getItemsOwned(), farm.getAnimalList(), 5);
		assertEquals(0, crop.getDaysTillHarvest());
	}
	
	@Test
	public void dailyAnimalBonus() {
		Sheep animal = new Sheep("Test", 5, 5);
		Farm farm = new Farm("Test", 1000, 1, 5, 5);
		Farmer farmer = new Farmer("TestFarmer", 30);
		store.purchaseAnimal(animal, farm);
		farmer.moveToNextDay(farm, farm.getCropList(), farm.getItemsOwned(), farm.getAnimalList(), 5);
		assertEquals(1000 - 50 + 10, farm.getMoneyAvailable());
	}
	
	@Test
	public void dailyMessage() {
		Cow animal = new Cow("Test", 5, 5);
		Rice crop = new Rice();
		Farm farm = new Farm("Test", 1000, 1, 5, 5);
		Farmer farmer = new Farmer("TestFarmer", 30);
		store.purchaseAnimal(animal, farm);
		store.purchaseCrop(crop, farm);
		String message = farmer.moveToNextDay(farm, farm.getCropList(), farm.getItemsOwned(), farm.getAnimalList(), 5);
		assertEquals("You earnt a $10.00 from your happy animals, you are now on day 2 out of 5", message);
	}


}
