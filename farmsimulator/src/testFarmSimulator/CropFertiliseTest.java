package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import farmsimulator.Corn;

import farmsimulator.Farm;
import farmsimulator.Farmer;
import farmsimulator.FertiliserOne;
import farmsimulator.GeneralStore;
import farmsimulator.Item;
import farmsimulator.Water;

class CropFertiliseTest {

	GeneralStore store = new GeneralStore();
	
	@Test
	public void fertilise() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
		Corn crop = new Corn();
		store.purchaseCrop(crop, farm);
		FertiliserOne f1 = new FertiliserOne();
		store.purchaseItem(f1, farm);
		String message = crop.tendCrops(f1, farmer, farm.getItemsOwned());
		assertEquals("You fertilised Corn using F1, now 2 day(s) to harvest", message);
	}
	
	@Test
	public void fertiliseWithWater() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
		Corn crop = new Corn();
		store.purchaseCrop(crop, farm);
		Water water = new Water();
		String message = crop.tendCrops(water, farmer, farm.getItemsOwned());
		assertEquals("You fertilised Corn using Water, now 2 day(s) to harvest", message);
	}
	
	@Test
	public void fertiliseItemCheck() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
		Corn crop = new Corn();
		store.purchaseCrop(crop, farm);
		FertiliserOne f1 = new FertiliserOne();
		store.purchaseItem(f1, farm);
		crop.tendCrops(f1, farmer, farm.getItemsOwned());
		ArrayList<Item> test = new ArrayList<Item>();
		assertArrayEquals(test.toArray(), farm.getItemsOwned().toArray());
	}
	
	@Test
	public void fertiliseNoAction() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
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
		Farmer farmer = new Farmer("TestFarmer", 30);
		farmer.useAction();
		farmer.useAction();
		Corn crop = new Corn();
		store.purchaseCrop(crop, farm);
		FertiliserOne f1 = new FertiliserOne();
		store.purchaseItem(f1, farm);
		crop.tendCrops(f1, farmer, farm.getItemsOwned());
		ArrayList<Item> test = new ArrayList<Item>();
		test.add(f1);
		assertArrayEquals(test.toArray(), farm.getItemsOwned().toArray());
	}
	
	@Test
	public void fertiliseReadyCrop() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
		Corn crop = new Corn();
		store.purchaseCrop(crop, farm);
		crop.setDaysTillHarvest(0);
		FertiliserOne f1 = new FertiliserOne();
		store.purchaseItem(f1, farm);
		String message = crop.tendCrops(f1, farmer, farm.getItemsOwned());
		assertEquals("These crops are ready to harvest, no need to fertilise them", message);
	}
	
	@Test void fertiliseReadyCropItem() {
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
		Corn crop = new Corn();
		store.purchaseCrop(crop, farm);
		crop.setDaysTillHarvest(0);
		FertiliserOne f1 = new FertiliserOne();
		store.purchaseItem(f1, farm);
		crop.tendCrops(f1, farmer, farm.getItemsOwned());
		ArrayList<Item> test = new ArrayList<Item>();
		test.add(f1);
		assertArrayEquals(test.toArray(), farm.getItemsOwned().toArray());
	}
}
