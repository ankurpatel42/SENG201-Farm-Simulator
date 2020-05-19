package farmsimulator;

import java.util.ArrayList;

/** 
 * This class contains attributes and methods for the Crop objects.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */

public abstract class Crop {

	/**
	 * The purchase price of the crop.
	 */
	private double cropPurchasePrice = 0;
	/**
	 * The bonus given by the crop when harvested.
	 */
	private double cropMoneyGiven = 0;
	/**
	 * The number of days till the crop can be harvested.
	 */
	private int daysTillHarvest = 0;
	/**
	 * The name/type of crop.
	 */
	private String name = null;
	/**
	 * The number of days the crop has grown for.
	 */
	private int daysGrowing = 0;
	/**
	 * The message shown to the user.
	 */
	private String message;
	/**
	 * The total number of fields currently on the farm.
	 */
	private static int fieldCounter = 0;
	/**
	 * The field number of each crop.
	 */
	private int fieldNumber = 0;

	/**
	 * Crop constructor.
	 * 
	 * @param name					The name/type of the crop.
	 * @param cropPurchasePrice		The purchase price of the crop.
	 * @param cropMoneyGiven		The amount of money given when the crop is harvested.
	 * @param daysTillHarvest		The days till the crop can be harvested.
	 */
	public Crop (String name, double cropPurchasePrice, double cropMoneyGiven, int daysTillHarvest) {
		this.name = name;
		this.cropMoneyGiven = cropMoneyGiven;
		this.cropPurchasePrice = cropPurchasePrice;
		this.daysTillHarvest = daysTillHarvest;
		fieldCounter++; 
		fieldNumber = fieldCounter;
	}
	
	/**
	 * Gets the field number of each crop.
	 * 
	 * @return			A integer which is the field number for each crop.
	 */
	public int getFieldNumber() {
		return fieldNumber;
	}
	
	/**
	 * Gets the crop's name/type.
	 * 
	 * @return			A string which is the crop's name/type.
	 */
	public String getCropName() {
		return name;
	}
	
	/**
	 * Gets the amount of days growing.
	 * 
	 * @return			An integer which is the number of days the crop has grown for.
	 */
	public int getDaysGrowing() {
		return daysGrowing;
	}
	
	/**
	 * Gets the number of days till the crop can be harvested.
	 * 
	 * @return			An integer which is the number of days till the crop can be harvested.
	 */
	public int getDaysTillHarvest() {
		return daysTillHarvest;
	}
	
	/**
	 * Gets the purchase price of the crop.
	 * 
	 * @return			A double which is the purchase price for the crop.
	 */
	public double getCropPurchasePrice() {
		return cropPurchasePrice;
	}
	
	/**
	 * Sets the days harvest for a crop.
	 * 
	 * @param days		The number of days till the crop can be harvested.
	 */
	public void setDaysTillHarvest(int days) {
		daysTillHarvest = days;
	}
	
	/**
	 * Gets the amount of money the crop gives after being harvested.
	 * 
	 * @return				A double which is the amount of money given after being harvested.
	 */
	public double getCropMoneyGiven() {
		return cropMoneyGiven;
	}
	
	/**
	 * Decreases the days till harvest when player moves to the next day.
	 * 
	 * @param farm		The farm being played on.
	 */
	public void dayPassed(Farm farm) {
		daysTillHarvest -= farm.getCropGrowthRate();
		if (daysTillHarvest < 0) {
			daysTillHarvest = 0;
		}
	}
	
	/**
	 * Tend to crops.
	 * 
	 * @param choice			The item of choice to tend the crop with.				
	 * @param farmer			The farmer which is to tend to the crop.
	 * @param itemsOwned		The items currently owned.
	 * @return						A string which states whether the crop has been successfully tended to or not.
	 */
	public String tendCrops(Item choice, Farmer farmer, ArrayList<Item> itemsOwned) {
		if (daysTillHarvest == 0) {
			message = "These crops are ready to harvest, no need to fertilise them";
		}
		else if (farmer.useAction() == true) {
			daysTillHarvest -= choice.getHarvestSpeedUpTime();
			if (daysTillHarvest <= 0) {
				daysTillHarvest = 0;
			}
			if (choice.getItemName() != "Water") {
				itemsOwned.remove(choice);
			}
			message = "You fertilised " + name + " using " + choice.getItemName() + ", now " + daysTillHarvest + " day(s) to harvest";
		}
		else {
			message = "You have no actions left for the day, move to next day to complete this action";
		}
		return message;
	}
	
	/**
	 * Harvest Crops.
	 * 
	 * @param farmer			The farmer which is to harvest the crop.
	 * @param farm				The farm which the crop is on.
	 * @param cropsOnFarm		The crops currently on the farm.
	 * @return						A string which states whether the crop has been successfully harvested or not.
	 */
	public String harvestCrops(Farmer farmer, Farm farm, ArrayList<Crop> cropsOnFarm) {
		if (daysTillHarvest > 0) {
				message = "Sorry your crops are not ready for Harvest yet, still " + daysTillHarvest + " day(s) left";
		}
		else {
			if (farmer.useAction() == true) {
				farm.setMoneyAvailable(farm.getMoneyAvailable() + cropMoneyGiven);
				message = "Crop harvested and you earnt $" + cropMoneyGiven;
				cropsOnFarm.remove(this);
			}
			else {
				message = "You have no actions left for the day, move to next day to complete this action";
			}
		
		}
		
		return message;
	}
	
	
	/**
	 * String representation of crop objects.
	 */
	public String toString() {
		String display = "Feild " + getFieldNumber() + " (" + name + ")     " + daysTillHarvest; 
		return display;
	}
	
}
