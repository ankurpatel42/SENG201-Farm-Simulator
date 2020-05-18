package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import farmsimulator.Carrot;
import farmsimulator.Crop;
import farmsimulator.Farm;
import farmsimulator.Farmer;

class CropHarvestTest {

	@Test
	public void testHarvest() {
		Carrot crop = new Carrot();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
		crop.setDaysTillHarvest(0);
		String message = crop.harvestCrops(farmer, farm, farm.getCropList());
		assertEquals("Crop harvested and you earnt $250.0", message);
	}
	
	@Test
	public void testHarvestMoney() {
		Carrot crop = new Carrot();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
		crop.setDaysTillHarvest(0);
		crop.harvestCrops(farmer, farm, farm.getCropList());
		assertEquals(1250, farm.getMoneyAvailable());
	}
	
	@Test
	public void testCropList() {
		Carrot crop = new Carrot();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		farm.addCropToList(crop);
		Farmer farmer = new Farmer("TestFarmer", 30);
		crop.setDaysTillHarvest(0);
		crop.harvestCrops(farmer, farm, farm.getCropList());
		ArrayList<Crop> test = new ArrayList<Crop>();
		assertEquals(test, farm.getCropList());
	}
	
	@Test
	public void testUnreadyHarvest() {
		Carrot crop = new Carrot();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
		String message = crop.harvestCrops(farmer, farm, farm.getCropList());
		assertEquals("Sorry your crops are not ready for Harvest yet, still 3 day(s) left", message);
	}
	
	@Test
	public void testUndreadyHarvestMoney() {
		Carrot crop = new Carrot();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
		crop.harvestCrops(farmer, farm, farm.getCropList());
		assertEquals(1000, farm.getMoneyAvailable());
	}
	
	@Test
	public void testCropList0() {
		Carrot crop = new Carrot();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		farm.addCropToList(crop);
		Farmer farmer = new Farmer("TestFarmer", 30);
		crop.harvestCrops(farmer, farm, farm.getCropList());
		ArrayList<Crop> test = new ArrayList<Crop>();
		test.add(crop);
		assertEquals(test, farm.getCropList());
	}
	
	@Test
	public void testHarvestNoActions() {
		Carrot crop = new Carrot();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
		farmer.useAction();
		farmer.useAction();
		crop.setDaysTillHarvest(0);
		String message = crop.harvestCrops(farmer, farm, farm.getCropList());
		assertEquals("You have no actions left for the day, move to next day to complete this action", message);
	}
	
	@Test
	public void testNoActionHarvestMoney() {
		Carrot crop = new Carrot();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		Farmer farmer = new Farmer("TestFarmer", 30);
		farmer.useAction();
		farmer.useAction();
		crop.setDaysTillHarvest(0);
		crop.harvestCrops(farmer, farm, farm.getCropList());
		assertEquals(1000, farm.getMoneyAvailable());
	}
	
	@Test
	public void testCropListNoAction() {
		Carrot crop = new Carrot();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		farm.addCropToList(crop);
		Farmer farmer = new Farmer("TestFarmer", 30);
		farmer.useAction();
		farmer.useAction();
		crop.setDaysTillHarvest(0);
		crop.harvestCrops(farmer, farm, farm.getCropList());
		ArrayList<Crop> test = new ArrayList<Crop>();
		test.add(crop);
		assertEquals(test, farm.getCropList());
	}

}
