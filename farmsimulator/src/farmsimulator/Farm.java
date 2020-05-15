package farmsimulator;

import java.util.ArrayList;

/** 
 * This class contains attributes and methods for the Farm object.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */

public class Farm {
	
	/**
	 * The name of the farm.
	 */
	private String farmName = null;
	/**
	 * The amount of money available.
	 */
	private double moneyAvailable = 0;
	/**
	 * The crop growth rate of the farm.
	 */
	private int cropGrowthRate = 0;
	/**
	 * The tidiness of the farm.
	 */
	private int farmTidiness = 0;
	/**
	 * A list of animals currently on the farm.
	 */
	private ArrayList<Animal> animalsList = new ArrayList<Animal>();
	/**
	 * A list of crops currently on the farm.
	 */
	private ArrayList<Crop> cropsList = new ArrayList<Crop>();
	/**
	 * A list of items currently owned.
	 */
	private ArrayList<Item> itemsOwned = new ArrayList<Item>();
	/**
	 * The initial healthiness levels for animals.
	 */
	private int initialAnimalHealthiness = 0;
	/**
	 * The initial happiness levels for animals.
	 */
	private int initialAnimalHappiness = 0;
	
	/**
	 * Farm constructor.
	 * 
	 * @param name					The name of the farm.
	 * @param money					The amount of money available on the farm.
	 * @param cropGrowth			The crop growth rate of the farm.
	 * @param animalHealthiness		The initial animal health level.
	 * @param animalHappiness		The initial animal happiness level.
	 */
	public Farm(String name, double money, int cropGrowth, int animalHealthiness, int animalHappiness) {
		farmName = name;
		moneyAvailable = money;
		cropGrowthRate = cropGrowth;
		initialAnimalHealthiness = animalHealthiness;
		initialAnimalHappiness = animalHappiness;
		Water water = new Water();
		itemsOwned.add(water);
	}
	
	/**
	 * Get the farm name.
	 * 
	 * @return			A string that is the name of the farm.
	 */
	public String getFarmName() {
		return farmName;
	}
	
	/**
	 * Set the money available.
	 * @param newBalance		The new value of the money available.
	 */
	public void setMoneyAvailable(double newBalance) {
		moneyAvailable = newBalance;
	}
	
	/**
	 * Gets the money available.
	 * 
	 * @return			A double which is the money currently available.
	 */
	public double getMoneyAvailable() {
		return moneyAvailable;
	}
	
	/**
	 * Gets the farm tidiness
	 * 
	 * @return			A integer which is the farm's current tidiness level.
	 */
	public int getFarmTidiness() {
		return farmTidiness;
	}
	
	/**
	 * Adds animals to the farm
	 * 
	 * @param animal		An animal to add to the farm.
	 */
	public void addAnimalToList(Animal animal) {
		animalsList.add(animal);
	}
	
	/**
	 * Animals currently on the farm.
	 * 
	 * @return			An arraylist of animals currently on the farm.
	 */
	public ArrayList<Animal> getAnimalList() {
		return animalsList;
	}
	
	/**
	 * Adds crops to the farm.
	 * 
	 * @param crop			An crop to add to the farm.
	 */
	public void addCropToList(Crop crop) {
		cropsList.add(crop);
	}
	
	/**
	 * Crops currently on the farm.
	 * 
	 * @return			An arraylist of crops currently on the farm.
	 */
	public ArrayList<Crop> getCropList() {
		return cropsList;
	}
	
	/**
	 * The crop growth rate of the farm.
	 * 
	 * @return			An integer which is the crop growth rate of the farm.
	 */
	public int getCropGrowthRate() {
		return cropGrowthRate;
	}
	
	/**
	 * Add items to farm/currently owned by the farmer.
	 * 
	 * @param item		An item to add to the farm.
	 */
	public void addNewItem(Item item){
		itemsOwned.add(item);
	}
	
	/**
	 * Items currently owned
	 * 
	 * @return			An arraylist of items currently owned.
	 */
	public ArrayList<Item> getItemsOwned(){
		return itemsOwned;
	}
	
	/**
	 * Initial happiness of animals on the farm.
	 * 
	 * @return			An integer which is the initial animal happiness level.
	 */
	public int getInitialAnimalHappiness() {
		return initialAnimalHappiness;
	}

	/**
	 * Initial healthiness of animals on the farm.
	 * 
	 * @return			An integer which is the initial animal happiness level.
	 */
	public int getInitialAnimalHealthiness() {
		return initialAnimalHealthiness;
	}
}
