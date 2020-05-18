package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import farmsimulator.Cow;
import farmsimulator.Farm;
import farmsimulator.Farmer;
import farmsimulator.GeneralStore;
import farmsimulator.Rice;

class TendFarmLandTest {

	GeneralStore store = new GeneralStore();
	
	@Test
	void tendFarmAnimalTest() {
		Cow animal = new Cow("Test", 5, 5);
		Rice crop = new Rice();
		Farm farm = new Farm("Test", 1000, 1, 5, 5);
		Farmer farmer = new Farmer("TestFarmer", 30);
		store.purchaseAnimal(animal, farm);
		store.purchaseCrop(crop, farm);
		farmer.tendToFarmLand(farm.getCropList(), farm.getAnimalList());
		assertEquals(6, animal.getAnimalHappiness());
	}
	
	@Test
	void tendFarmCropTest() {
		Cow animal = new Cow("Test", 5, 5);
		Rice crop = new Rice();
		Farm farm = new Farm("Test", 1000, 1, 5, 5);
		Farmer farmer = new Farmer("TestFarmer", 30);
		store.purchaseAnimal(animal, farm);
		store.purchaseCrop(crop, farm);
		farmer.tendToFarmLand(farm.getCropList(), farm.getAnimalList());
		assertEquals(4, crop.getDaysTillHarvest());
	}

}
