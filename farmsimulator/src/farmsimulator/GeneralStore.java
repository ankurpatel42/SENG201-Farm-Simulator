package farmsimulator;

import java.util.ArrayList;

public class GeneralStore {
	
	private ArrayList<Item> itemList = null;
	
	public ArrayList<Item> viewItemsForSale() {
		return itemList;
	}
	
	public GeneralStore() {
		
	}
	
	public String purchaseItem(Item item) {
		double money = GameEnvironment.getFarm().getMoneyAvailable();
		String message = null;
		if (money < item.getPrice()){
			message = "Sorry, You have insuffcient funds to purchase this item";
		}
		else {
			money = money - item.getPrice();
			GameEnvironment.getFarm().addNewItem(item);
			message = "You have purchased one " + item.getItemName();
		}
		return message;
	}
	
	public String purchaseAnimal(Animal animal) {
		double money = GameEnvironment.getFarm().getMoneyAvailable();
		String message = null;
		if (money < animal.getAnimalPurchasePrice()){
			message = "Sorry, You have insuffcient funds to purchase this animal";
		}
		else {
			money = money - animal.getAnimalPurchasePrice();
			GameEnvironment.getFarm().addAnimalToList(animal);
			message = "You have purchased one " + animal.getName();
		}
		return message;
	}
	
	public String purchaseCrop(Crop crop) {
		double money = GameEnvironment.getFarm().getMoneyAvailable();
		String message = null;
		if (money < crop.getCropPurchasePrice()){
			message = "Sorry, You have insuffcient funds to purchase this crop";
		}
		else {
			money = money - crop.getCropPurchasePrice();
			GameEnvironment.getFarm().addCropToList(crop);
			message = "You have purchased one " + crop.getCropName();
		}
		return message;
	}
}
