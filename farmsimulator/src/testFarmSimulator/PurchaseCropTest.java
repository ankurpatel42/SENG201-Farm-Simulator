package testFarmSimulator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import farmsimulator.Carrot;
import farmsimulator.Corn;
import farmsimulator.Crop;
import farmsimulator.Farm;
import farmsimulator.GeneralStore;
import farmsimulator.Lettuce;
import farmsimulator.Potato;
import farmsimulator.Rice;
import farmsimulator.Wheat;

class PurchaseCropTest {

	private GeneralStore store = new GeneralStore();

	@Test
	public void cropListUpdate() {
		Carrot crop = new Carrot();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		store.purchaseCrop(crop, farm);
		ArrayList<Crop> test = new ArrayList<Crop>();
		test.add(crop);
		assertArrayEquals(test.toArray(), farm.getCropList().toArray());
	}
	
	@Test
	public void balanceUpdate() {
		Corn crop = new Corn();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		store.purchaseCrop(crop, farm);
		assertEquals(1000 - crop.getCropPurchasePrice(), farm.getMoneyAvailable());
	}
	
	@Test
	public void testMessage() {
		Lettuce crop = new Lettuce();
		Farm farm = new Farm("Test", 1000, 1, 1, 1);
		String message = store.purchaseCrop(crop, farm);
		assertEquals("You have purchased one Lettuce", message);
	}
	
	//Purchase Fails
	
	@Test
	public void testFailMessage() {
		Potato crop = new Potato();
		Farm farm = new Farm("Test", 0, 1, 1, 1);
		String message = store.purchaseCrop(crop, farm);
		assertEquals("Sorry, You have insuffcient funds to purchase this crop", message);
	}
	
	@Test
	public void balanceUpdate0() {
		Rice crop = new Rice();
		Farm farm = new Farm("Test", 0, 1, 1, 1);
		store.purchaseCrop(crop, farm);
		assertEquals(0, farm.getMoneyAvailable());
	}
	
	@Test
	public void cropListUpdate0() {
		Wheat crop = new Wheat();
		Farm farm = new Farm("Test", 0, 1, 1, 1);
		store.purchaseCrop(crop, farm);
		ArrayList<Crop> test = new ArrayList<Crop>();
		assertArrayEquals(test.toArray(), farm.getCropList().toArray());
	}

}
