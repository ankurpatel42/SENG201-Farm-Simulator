package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import farmsimulator.Carrot;
import farmsimulator.Corn;
import farmsimulator.Crop;
import farmsimulator.Farm;
import farmsimulator.Farmer;
import farmsimulator.FertiliserOne;
import farmsimulator.GeneralStore;
import farmsimulator.Item;

class CropFertiliseTest {

	GeneralStore store = new GeneralStore();
	
	@Test
	public void fertilise() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer");
		Corn crop = new Corn();
		store.purchaseCrop(crop, farm);
		FertiliserOne f1 = new FertiliserOne();
		store.purchaseItem(f1, farm);
		String message = crop.tendCrops(f1, farmer, farm.getItemsOwned());
		assertEquals("You fertilised Corn using F1, now 2 day(s) to harvest", message);
	}
	
	@Test
	public void fertiliseItemCheck() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer");
		Corn crop = new Corn();
		store.purchaseCrop(crop, farm);
		FertiliserOne f1 = new FertiliserOne();
		store.purchaseItem(f1, farm);
		crop.tendCrops(f1, farmer, farm.getItemsOwned());
		ArrayList<Item> test = new ArrayList<Item>();
		//Water Item needs to be included
		//assertArrayEquals(test.toArray(), farm.getItemsOwned().toArray());
	}
	
	@Test
	public void fertiliseNoAction() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer");
		farmer.useAction();
		farmer.useAction();
		Corn crop = new Corn();
		store.purchaseCrop(crop, farm);
		FertiliserOne f1 = new FertiliserOne();
		store.purchaseItem(f1, farm);
		String message = crop.tendCrops(f1, farmer, farm.getItemsOwned());
		assertEquals("You have no actions left for the day, move to next day to complete this action", message);
	}
	
	@Test
	public void fertiliseItemCheckNoAction() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer");
		farmer.useAction();
		farmer.useAction();
		Corn crop = new Corn();
		store.purchaseCrop(crop, farm);
		FertiliserOne f1 = new FertiliserOne();
		store.purchaseItem(f1, farm);
		crop.tendCrops(f1, farmer, farm.getItemsOwned());
		ArrayList<Item> test = new ArrayList<Item>();
		test.add(f1);
		//Water Item needs to be included
		//assertArrayEquals(test.toArray(), farm.getItemsOwned().toArray());
	}

}
