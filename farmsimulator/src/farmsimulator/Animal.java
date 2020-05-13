package farmsimulator;

public abstract class Animal {
	
	private double animalPurchasePrice = 0;
	private double animalMoneyGiven = 0;
	private int animalHealthiness = 0;
	private int animalHappiness = 0;
	private String name;
	
	
	public Animal (String name, double animalPurchasePrice, double animalMoneyGiven, int animalHealthiness, int animalHappiness) {
		this.animalPurchasePrice = animalPurchasePrice;
		this.animalMoneyGiven = animalMoneyGiven;
		this.animalHealthiness = animalHealthiness;
		this.animalHappiness = animalHappiness;
		this.name = name;
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
	
	public void feedAnimal(Item choice) {
		//game.getFarmer().useAction()
		animalHealthiness += 2;
	}
	
	public void playWithAnimal() {
		//game.useFarmerAction();
		animalHappiness += 3;
	}
	
	public void setAnimalHealthiness(int initialHealthiness) {
		animalHealthiness = initialHealthiness;
	}
	
	public void setAnimalHappiness(int initialHappiness) {
		animalHappiness = initialHappiness;
	}
	
	public int getAnimalHealthiness() {
		return animalHealthiness;
	}
	
	public int getAnimalHappiness() {
		return animalHappiness;
	}

	
	
}
