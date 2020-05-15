package farmsimulator;

/** 
 * This class contains attributes and methods for Animal objects.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */

public abstract class Animal {
	
	/**
	 * The purchase price of the animal.
	 */
	private double animalPurchasePrice = 0;
	/**
	 * The money bonus given by the animal at the end of a day.
	 */
	private double animalMoneyGiven = 0;
	/**
	 * The healthiness of an animal.
	 */
	private double animalHealthiness = 0;
	/**
	 * The happiness of an animal.
	 */
	private double animalHappiness = 0;
	/**
	 * The name of the animal.
	 */
	private String name;
	/**
	 * The message shown to the user.
	 */
	private String message;
	
	/**
	 * Animal constructor.
	 * 
	 * @param name					The name of the animal.		
	 * @param animalPurchasePrice	The purchase price of the animal.
	 * @param animalMoneyGiven		The bonus given by the animal.
	 * @param animalHealthiness		The healthiness of the animal.
	 * @param animalHappiness		The happiness of the animal.
	 */
	public Animal (String name, double animalPurchasePrice, double animalMoneyGiven, double animalHealthiness, double animalHappiness) {
		this.animalPurchasePrice = animalPurchasePrice;
		this.animalMoneyGiven = animalMoneyGiven;
		this.animalHealthiness = animalHealthiness;
		this.animalHappiness = animalHappiness;
		this.name = name;
	}
	
	/**
	 * The purchase price of the animal.
	 * 
	 * @return				A double which is the purchase price of the animal.
	 */
	public double getAnimalPurchasePrice() {
		return animalPurchasePrice;
	}
	
	/**
	 * Sets the animal name chosen by the user.
	 * 
	 * @param nameChosenForAnimal		A string which is the animal name input by the user.
	 */
	public void setAnimalName(String nameChosenForAnimal) {
		name = nameChosenForAnimal;
	}
	
	/**
	 * The animal's name.
	 * 
	 * @return				A string which is the animal's name.
	 */
	public String getAnimalName() {
		return name;
	}
	
	/**
	 * The amount of money given by the animal.
	 * 
	 * @return				A double which is the amount of money given by the animal at the end of a day.
	 */
	public double getAnimalMoneyGiven() {
		return animalMoneyGiven;
	}
	
	/**
	 * Feed the animal
	 * 
	 * @param choice	The item of choice that is to be fed to the animal.
	 * @param game		The GameEnvironment object.
	 * @return				A string that states whether the animal has been successfully fed.
	 */
	public String feedAnimal(Item choice, GameEnvironment game) {
		if (game.useFarmerAction() == true) {
			animalHealthiness += choice.getAnimalHappinessIncrease();
			game.getItemsOwnedByFarmer().remove(choice);
			message = "You have fed " + name + " " + choice.getItemName();
		}
		else {
			message = "You have no actions left for the day, move to next day to complete this action";
		}
		return message;
	}
	
	/**
	 * Play with the animal
	 * 
	 * @param game		The GameEnvironment object.
	 * @return				A string that states whether the animal has been played with or not.
	 */
	public String playWithAnimal(GameEnvironment game) {
		if (game.useFarmerAction() == true) {
			animalHappiness += 3;
			message = "You have played with " + name;
		}
		else {
			message = "You have no actions left for the day, move to next day to complete this action";
		}
		return message;
	}
	
	/**
	 * 
	 * Sets the initial happiness level of the animal.
	 * 
	 * @param initialHealthiness	The initial healthiness level of the animal when the game starts.
	 */
	public void setAnimalHealthiness(double initialHealthiness) {
		animalHealthiness = initialHealthiness;
	}
	
	/**
	 * Sets the initial happiness level of the animal.
	 * 
	 * @param initialHappiness		The initial happiness level of the animal when the game starts.
	 */
	public void setAnimalHappiness(double initialHappiness) {
		animalHappiness = initialHappiness;
	}
	
	/**
	 * Gets the healthiness level of the animal.
	 * 
	 * @return			A double which is the animals current health level.				
	 */
	public double getAnimalHealthiness() {
		return animalHealthiness;
	}
	
	/**
	 * Gets the happiness level of the animal.
	 * 
	 * @return			A double which is the animals current happiness level.
	 */
	public double getAnimalHappiness() {
		return animalHappiness;
	}

	
	
}
