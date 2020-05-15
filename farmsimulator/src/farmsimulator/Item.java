package farmsimulator;

/** 
 * This class contains attributes and methods for the Item objects.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */

public abstract class Item {
	
	/**
	 * The price of the item.
	 */
	private double price = 0;
	/**
	 * The name of the item.
	 */
	private String name = null;
	/**
	 * The amount the item speeds up crop harvest time.
	 */
	private int cropHarvestSpeedUpTime = 0;
	/**
	 * The amount the item increases animal happiness.
	 */
	private int animalHappinessIncrease = 0;
	
	/**
	 * Item constructor for crop items.
	 * 
	 * @param name						The name of the item.
	 * @param price						The price of the item.
	 * @param cropHarvestSpeedUpTime	The crop harvest speed up time of the item.
	 */
	public Item (String name, double price, int cropHarvestSpeedUpTime) {
		this.name = name;
		this.price = price;
		this.cropHarvestSpeedUpTime = cropHarvestSpeedUpTime;
	}
	
	/**
	 * Item constructor for animal items.
	 * 
	 * @param price					The price of the item.
	 * @param increase				The animal happiness increase of the item.
	 * @param name					The name of the item.
	 */
	public Item (double price, int increase, String name) {
		this.price = price;
		this.animalHappinessIncrease = increase;
		this.name = name;
	}
	
	/**
	 * Item constructor for a water item.
	 * 
	 * @param name				The name of the item.
	 * @param increase			The crop harvest speed up time of the item.
	 */
	public Item (String name, int increase) {
		this.name = name;
		this.cropHarvestSpeedUpTime = increase;
	}
	
	/**
	 * String representation of item objects.
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * Gets the price of the item.
	 * 
	 * @return				A double which is the price of the item.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Gets the name of the item.
	 * 
	 * @return				A string which is the name of the item.
	 */
	public String getItemName() {
		return name;
	}

	/**
	 * Gets the crop harvest speed up tome of the item.
	 * 
	 * @return				An integer which is the crop harvest speed up time of the item.
	 */
	public int getHarvestSpeedUpTime() {
		return cropHarvestSpeedUpTime;
	}
	
	/**
	 * Gets the animal happiness increase of the item.
	 * 
	 * @return				An integer which is the animal happiness increase of the item.
	 */
	public int getAnimalHappinessIncrease() {
		return animalHappinessIncrease;
	}
}
