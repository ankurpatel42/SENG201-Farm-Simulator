package farmsimulator;

import java.util.ArrayList;

public class GeneralStore {
	
	private ArrayList<Item> itemList = null;
	private String message;
	private double money;
	
	public ArrayList<Item> viewItemsForSale() {
		return itemList;
	}
	
	public String purchaseItem(Item item, GameEnvironment game) {
		money = game.getFarm().getMoneyAvailable();
		if (money < item.getPrice()){
			message = "Sorry, You have insuffcient funds to purchase this item";
		}
		else {
			money = money - item.getPrice();
			game.getFarm().setMoneyAvailable(money);
			game.getFarm().addNewItem(item);
			message = "You have purchased one " + item.getItemName();
		}
		return message;
	}
	
	public String purchaseAnimal(Animal animal, GameEnvironment game) {
		money = game.getFarm().getMoneyAvailable();
		if (money < animal.getAnimalPurchasePrice()){
			message = "Sorry, You have insuffcient funds to purchase this animal";
		}
		else {
			money = money - animal.getAnimalPurchasePrice();
			game.getFarm().setMoneyAvailable(money);
			game.getFarm().addAnimalToList(animal);
			message = "You have purchased " + animal.getAnimalName();
		}
		return message;
	}
	
	public String purchaseCrop(Crop crop, GameEnvironment game) {
		money = game.getFarm().getMoneyAvailable();
		if (money < crop.getCropPurchasePrice()){
			message = "Sorry, You have insuffcient funds to purchase this crop";
		}
		else {
			money = money - crop.getCropPurchasePrice();
			game.getFarm().setMoneyAvailable(money);
			game.getFarm().addCropToList(crop);
			message = "You have purchased one " + crop.getCropName();
		}
		return message;
	}
}
