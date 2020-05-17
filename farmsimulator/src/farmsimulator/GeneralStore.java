package farmsimulator;

import java.util.ArrayList;

/** 
 * This class contains attributes and methods for the GeneralStore object.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */

public class GeneralStore {
	
	/**
	 * The items list for items on sale.
	 */
	private ArrayList<Item> itemList = null;
	/**
	 * The message shown to the user.
	 */
	private String message;
	/**
	 * The amount of money the user currently has.
	 */
	private double money;
	
	public GeneralStore(){
		
	}
	
	/**
	 * Shows the items currently for sale.
	 * 
	 * @return				An arraylist of items that are currently for sale.
	 */
	public ArrayList<Item> viewItemsForSale() {
		return itemList;
	}
	
	/**
	 * Purchasing an item.
	 * 
	 * @param item			The item to be bought.
	 * @param farm			The farm which the item will be placed on.
	 * @return					A string which states whether the item purchase has been successful or not.
	 */
	public String purchaseItem(Item item, Farm farm) {
		money = farm.getMoneyAvailable();
		if (money < item.getPrice()){
			message = "Sorry, You have insuffcient funds to purchase this item";
		}
		else {
			money = money - item.getPrice();
			farm.setMoneyAvailable(money);
			farm.addNewItem(item);
			message = "You have purchased one " + item.getItemName();
		}
		return message;
	}
	
	/**
	 * Purchasing an animal.
	 * 
	 * @param animal		The animal to be bought.
	 * @param farm			The farm which the animal will be placed on.
	 * @return					A string which states whether the animal purchase has been successful or not.
	 */
	public String purchaseAnimal(Animal animal, Farm farm) {
		money = farm.getMoneyAvailable();
		if (money < animal.getAnimalPurchasePrice()){
			message = "Sorry, You have insuffcient funds to purchase this animal";
		}
		else {
			money = money - animal.getAnimalPurchasePrice();
			farm.setMoneyAvailable(money);
			farm.addAnimalToList(animal);
			message = "You have purchased " + animal.getAnimalName();
		}
		return message;
	}
	
	/**
	 * Purchasing a crop.
	 * 
	 * @param crop			The crop to be bought.
	 * @param farm			The farm which the crop will be placed on.
	 * @return					A string which states whether the crop purchase has been successful or not.
	 */
	public String purchaseCrop(Crop crop, Farm farm) {
		money = farm.getMoneyAvailable();
		if (money < crop.getCropPurchasePrice()){
			message = "Sorry, You have insuffcient funds to purchase this crop";
		}
		else {
			money = money - crop.getCropPurchasePrice();
			farm.setMoneyAvailable(money);
			farm.addCropToList(crop);
			message = "You have purchased one " + crop.getCropName();
		}
		return message;
	}
}
