package farmsimulator;

import java.util.ArrayList;

/** 
 * This class contains attributes and methods for the Farmer object.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */

public class Farmer {
	
	/**
	 * The name of the farmer
	 */
	private String farmerName = null;
	/**
	 * The bonus earned by the farmer.
	 */
	private double bonus;
	/**
	 * The number of actions the farmer has.
	 */
	private int actionsLeft = 2;
	/**
	 * The farmer's day number on their journey.
	 */
	private int dayNum = 1;
	
	/**
	 * Farmer constructor.
	 * 
	 * @param inputFarmerName		The name of the farmer.
	 */
	public Farmer (String inputFarmerName) {
		farmerName = inputFarmerName;
	}
	
	/**
	 * Get the farmer name.
	 * 
	 * @return			A string that is the name of the farmer.
	 */
	public String getFarmerName() {
		return farmerName;
	}
	
	/**
	 * Actions left.
	 * 
	 * @return			A integer which is the number of actions left for the farmer per day.
	 */
	public int getActionsLeft() {
		return actionsLeft;
	}
	
	/**
	 * Perform an action.
	 * 
	 * @return			A boolean which states whether or not a farmer can perform an action.
	 */
	public Boolean useAction() {
		if (actionsLeft > 0) {
			actionsLeft--;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Get the day number.
	 * 
	 * @return			A integer which is the current day number of the farmer's journey.
	 */
	public int getDayNum() {
		return dayNum;
	}
	
	
	/**
	 * Move to next day on the farm.
	 * 
	 * @param farm				The farm being played on.
	 * @param cropsOwned		The crops currently owned.
	 * @param itemsOwned		The items currently owned.
	 * @param animalsOwned		The animals currently owned.
	 * @param gameLength		The length of the game.
	 * @return						A string which states whether or not the farmer can move to the next day or not.
	 */
	public String moveToNextDay(Farm farm, ArrayList<Crop> cropsOwned, ArrayList<Item> itemsOwned, ArrayList<Animal> animalsOwned, int gameLength) {
		dayNum += 1;
		actionsLeft = 2;
		for (Crop crop : cropsOwned) {
			crop.dayPassed(farm);
		}
		bonus = 0;
		for (Animal animal : animalsOwned) {
			bonus += 2 * animal.getAnimalHappiness();
		}
		farm.setMoneyAvailable(bonus + farm.getMoneyAvailable());
		String bonusFormatted = String.format("%.2f", bonus);
		return ("You earnt a $" + bonusFormatted + " from your happy animals, you are now on day " + dayNum + " out of " + gameLength);
	}
	
	
	/**
	 * Tend to the farm land, increases crop harvest time and animal happiness.
	 * 
	 * @param cropsOwned		The crops currently owned.
	 * @param animalsOwned		The animals currently owned.
	 */
	public void tendToFarmLand(ArrayList<Crop> cropsOwned, ArrayList<Animal> animalsOwned) {
		for (Crop crop : cropsOwned) {
			crop.setDaysTillHarvest(crop.getDaysTillHarvest() - 1);
		}
		for (Animal animal : animalsOwned) {
			double add = (animal.getAnimalHappiness() + 1);
			animal.setAnimalHappiness(add);
		}
	}
	
	/**
	 * Gets the bonus for the farmer at the end of the day.
	 * 
	 * @return			A double which is the bonus the farmer earned.
	 */
	public double getBonus() {
		return bonus;
	}
	
}
