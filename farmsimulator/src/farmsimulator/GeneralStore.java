package farmsimulator;

import java.util.ArrayList;

public class GeneralStore {
	
	private ArrayList<Item> itemList = null;
	private GameEnvironment game;
	private String message;
	private double money;
	
	public GeneralStore(GameEnvironment gameEnv) {
		game = gameEnv;
	}
	
	public ArrayList<Item> viewItemsForSale() {
		return itemList;
	}
	
	public String purchaseItem(Item item) {
		money = game.getFarm().getMoneyAvailable();
		if (money < item.getPrice()){
			message = "Sorry, You have insuffcient funds to purchase this item";
		}
		else {
			money = money - item.getPrice();
			game.getFarm().setMoneyAvailible(money);
			game.getFarm().addNewItem(item);
			message = "You have purchased one " + item.getItemName();
		}
		return message;
	}
	
	public String purchaseAnimal(Animal animal) {
		money = game.getFarm().getMoneyAvailable();
		if (money < animal.getAnimalPurchasePrice()){
			message = "Sorry, You have insuffcient funds to purchase this animal";
		}
		else {
			money = money - animal.getAnimalPurchasePrice();
			game.getFarm().setMoneyAvailible(money);
			game.getFarm().addAnimalToList(animal);
			message = "You have purchased " + animal.getAnimalName();
		}
		return message;
	}
	
	public String purchaseCrop(Crop crop) {
		money = game.getFarm().getMoneyAvailable();
		if (money < crop.getCropPurchasePrice()){
			message = "Sorry, You have insuffcient funds to purchase this crop";
		}
		else {
			money = money - crop.getCropPurchasePrice();
			game.getFarm().setMoneyAvailible(money);
			game.getFarm().addCropToList(crop);
			message = "You have purchased one " + crop.getCropName();
		}
		return message;
	}
}
