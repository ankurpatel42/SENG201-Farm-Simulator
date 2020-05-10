package farmsimulator;

import java.util.ArrayList;

public class GeneralStore {
	
	private ArrayList<Item> itemList = null;
	
	public ArrayList<Item> viewItemsForSale() {
		return itemList;
	}
	
	public void purchaseItem(Item item, GameEnvironment game) {
		double money = game.getFarm().getMoneyAvailable();
		if (money < item.getPrice()){
			System.out.println("Sorry, You have insuffcient funds to purchase this item");
		}
		else {
			money = money - item.getPrice();
			game.getFarm().addNewItem(item);
		}
	}
	
	public void purchaseAnimal(Animal animal, GameEnvironment game) {
		double money = game.getFarm().getMoneyAvailable();
		if (money < animal.getAnimalPurchasePrice()){
			System.out.println("Sorry, You have insuffcient funds to purchase this animal");
		}
		else {
			money = money - animal.getAnimalPurchasePrice();
			game.getFarm().addAnimalToList(animal);
		}
	}
	
	public void purchaseCrop(Crop crop, GameEnvironment game) {
		double money = game.getFarm().getMoneyAvailable();
		if (money < crop.getCropPurchasePrice()){
			System.out.println("Sorry, You have insuffcient funds to purchase this crop");
		}
		else {
			money = money - crop.getCropPurchasePrice();
			game.getFarm().addCropToList(crop);
		}
	}
}
