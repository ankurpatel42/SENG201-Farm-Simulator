package farmsimulator;

public abstract class Animal {
	
	private double animalPurchasePrice = 0;
	private double animalMoneyGiven = 0;
	private double animalHealthiness = 0;
	private double animalHappiness = 0;
	private String name;
	private GameEnvironment game;
	private String message;
	
	
	public Animal (String name, double animalPurchasePrice, double animalMoneyGiven, double animalHealthiness, double animalHappiness, GameEnvironment game) {
		this.animalPurchasePrice = animalPurchasePrice;
		this.animalMoneyGiven = animalMoneyGiven;
		this.animalHealthiness = animalHealthiness;
		this.animalHappiness = animalHappiness;
		this.name = name;
		this.game = game;
	}
	
	public double getAnimalPurchasePrice() {
		return animalPurchasePrice;
	}
	
	public void setAnimalName(String nameChosenForAnimal) {
		name = nameChosenForAnimal;
	}
	
	public String getAnimalName() {
		return name;
	}
	
	public double getAnimalMoneyGiven() {
		return animalMoneyGiven;
	}
	
	public String feedAnimal(Item choice) {
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
	
	public String playWithAnimal() {
		if (game.useFarmerAction() == true) {
			animalHappiness += 3;
			message = "You have played with " + name;
		}
		else {
			message = "You have no actions left for the day, move to next day to complete this action";
		}
		return message;
	}
	
	public void setAnimalHealthiness(double initialHealthiness) {
		animalHealthiness = initialHealthiness;
	}
	
	public void setAnimalHappiness(double initialHappiness) {
		animalHappiness = initialHappiness;
	}
	
	public double getAnimalHealthiness() {
		return animalHealthiness;
	}
	
	public double getAnimalHappiness() {
		return animalHappiness;
	}

	
	
}
