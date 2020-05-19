package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import farmsimulator.Farm;
import farmsimulator.FertiliserOne;
import farmsimulator.FertiliserThree;
import farmsimulator.FertiliserTwo;
import farmsimulator.GeneralStore;
import farmsimulator.Item;

class PurchaseItemTest {

	private GeneralStore store = new GeneralStore();
	
	//Purchase Completes
	
	@Test
	public void itemListUpdate() {
		FertiliserOne f1 = new FertiliserOne();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		store.purchaseItem(f1, farm);
		ArrayList<Item> test = new ArrayList<Item>();
		test.add(f1);
		assertArrayEquals(test.toArray(), farm.getItemsOwned().toArray());
	}
	
	@Test
	public void balanceUpdate() {
		FertiliserTwo f2 = new FertiliserTwo();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		store.purchaseItem(f2, farm);
		assertEquals(1000 - f2.getPrice(), farm.getMoneyAvailable());
	}
	
	@Test
	public void testMessage() {
		FertiliserThree f3 = new FertiliserThree();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		String message = store.purchaseItem(f3, farm);
		assertEquals("You have purchased one F3", message);
	}
	
	//Purchase Fails
	
	@Test
	public void testFailMessage() {
		FertiliserThree f3 = new FertiliserThree();
		Farm farm = new Farm("Test", 0, 1, 1, 1);
		String message = store.purchaseItem(f3, farm);
		assertEquals("Sorry, You have insuffcient funds to purchase this item", message);
	}
	
	@Test
	public void balanceUpdate0() {
		FertiliserTwo f2 = new FertiliserTwo();
		Farm farm = new Farm("Test", 0, 1, 1, 1);
		store.purchaseItem(f2, farm);
		assertEquals(0, farm.getMoneyAvailable());
	}
	
	@Test
	public void itemListUpdate0() {
		FertiliserOne f1 = new FertiliserOne();
		Farm farm = new Farm("Test", 0, 1, 1, 1);
		store.purchaseItem(f1, farm);
		ArrayList<Item> test = new ArrayList<Item>();
		assertArrayEquals(test.toArray(), farm.getItemsOwned().toArray());
	}

}
