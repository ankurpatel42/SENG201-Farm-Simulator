package farmsimulator;

import java.util.ArrayList;

public class GeneralStore {
	
	private ArrayList<Item> itemList = null;
	private ArrayList<Item> cropList = null;
	private ArrayList<Item> animalList = null;
	
	public GeneralStore() {
		itemList = new ArrayList();
		itemList.add("Fertiliser One");
		itemList.add("Fertiliser Two");
		itemList.add("Fertiliser Three");
		itemList.add("Animal Food One");
		itemList.add("Animal Food Two");
		itemList.add("Animal Food Three");
		cropList = new ArrayList();
		cropList.add("Carrot");
		cropList.add("Corn");
		cropList.add("Lettuce");
		cropList.add("Potato");
		cropList.add("Rice");
		cropList.add("Wheat");
		animalList = new ArrayList();
		animalList.add("Cow");
		animalList.add("Pig");
		animalList.add("Sheep");
	}
	
	public ArrayList<Item> viewItemsForSale() {
		return itemList;
	}
	
	public ArrayList<Item> viewCropsForSale() {
		return cropList;
	}
	
	public ArrayList<Item> viewAnimalsForSale() {
		return animalList;
	}
	
	public void showFarmAssets() {
		money = Farm.getMoneyAvailible();
		items = Farm.getItemsOwned();
	}
	
	public void purchaseItem(Item item) {
		double money = Farm.getMoneyAvailable();
		if (money < item.getPrice()){
			System.out.println("Sorry, You have insuffcient funds to purchase this item");
		}
		else {
			money = money - item.getPrice();
			Farm.setMoneyAvailible(money);
			Farm.addNewItem(item);
		}
	}
	
	public void purchaseAnimal(Animal animal) {
		double money = Farm.getMoneyAvailable();
		if (money < animal.getAnimalPurchasePrice()){
			System.out.println("Sorry, You have insuffcient funds to purchase this animal");
		}
		else {
			money = money - animal.getAnimalPurchasePrice();
			Farm.addAnimal(animal);
		}
	}
	
	public void purchaseCrop(Crop crop) {
		double money = Farm.getMoneyAvailable();
		if (money < crop.getCropPurchasePrice()){
			System.out.println("Sorry, You have insuffcient funds to purchase this crop");
		}
		else {
			money = money - crop.getCropPurchasePrice();
			Farm.addCrop(crop);
		}
	}
}
