package farmsimulator;

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
	 * The number of actions the farmer.
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
	 * Move to the next day.
	 * 
	 * @param game			GameEnvironment object.
	 * @return					A string which states whether or not the farmer can move to the next day or not.
	 */
	public String moveToNextDay(GameEnvironment game) {
		dayNum += 1;
		actionsLeft = 2;
		for (Crop crop : game.getCropsOwned()) {
			crop.dayPassed(game);
		}
		bonus = 0;
		for (Animal animal : game.getAnimalsOnFarm()) {
			bonus += 0.1 * animal.getAnimalHappiness();
		}
		game.setFarmMoneyAvailable(bonus + game.getFarmMoneyAvailable());
		return ("You earnt a $" + bonus + " from you happy animals, you are now on day " + dayNum + " out of " + game.getGameLength());
	}
	
	
	/**
	 * Tend to the farm land, increases crop harvest time and animal happiness.
	 * 
	 * @param game			GameEnvironment object.
	 */
	public void tendToFarmLand(GameEnvironment game) {
		for (Crop crop : game.getCropsOwned()) {
			crop.setDaysTillHarvest(crop.getDaysTillHarvest() - 1);
		}
		for (Animal animal : game.getAnimalsOnFarm()) {
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
