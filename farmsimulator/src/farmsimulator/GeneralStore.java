package farmsimulator;

import java.util.ArrayList;

public class GeneralStore {
	
	private ArrayList<Item> itemList = null;
	
	public ArrayList<Item> viewItemsForSale() {
		return itemList;
	}
	
	public GeneralStore() {
		
	}
	
	public void purchaseItem(Item item) {
		double money = GameEnvironment.getFarm().getMoneyAvailable();
		if (money < item.getPrice()){
			System.out.println("Sorry, You have insuffcient funds to purchase this item");
		}
		else {
			money = money - item.getPrice();
			GameEnvironment.getFarm().addNewItem(item);
		}
	}
	
	public void purchaseAnimal(Animal animal) {
		double money = GameEnvironment.getFarm().getMoneyAvailable();
		if (money < animal.getAnimalPurchasePrice()){
			System.out.println("Sorry, You have insuffcient funds to purchase this animal");
		}
		else {
			money = money - animal.getAnimalPurchasePrice();
			GameEnvironment.getFarm().addAnimalToList(animal);
		}
	}
	
	public void purchaseCrop(Crop crop) {
		double money = GameEnvironment.getFarm().getMoneyAvailable();
		if (money < crop.getCropPurchasePrice()){
			System.out.println("Sorry, You have insuffcient funds to purchase this crop");
		}
		else {
			money = money - crop.getCropPurchasePrice();
			GameEnvironment.getFarm().addCropToList(crop);
		}
	}
}
