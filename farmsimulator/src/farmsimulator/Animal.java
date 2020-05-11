package farmsimulator;

public abstract class Animal {
	
	private double animalPurchasePrice = 0;
	private double animalMoneyGiven = 0;
	private int animalHealthiness = 0;
	private int animalHappiness = 0;
	
	
	public Animal (String name, double animalPurchasePrice, double animalMoneyGiven, int animalHealthiness, int animalHappiness) {
		this.animalPurchasePrice = animalPurchasePrice;
		this.animalMoneyGiven = animalMoneyGiven;
		this.animalHealthiness = animalHealthiness;
		this.animalHappiness = animalHappiness;
	}
	
	public double getAnimalPurchasePrice() {
		return animalPurchasePrice;
	}
	
	public double getAnimalMoneyGiven() {
		return animalMoneyGiven;
	}
	
	public void feedAnimal(Item choice, GameEnvironment game) {
		game.getFarmer().useAction();
		System.out.println("You have fed the animal " + choice.getItemName() + "!");
		animalHealthiness += 2;
	}
	
	public void playWithAnimal(GameEnvironment game) {
		game.useFarmerAction();
		animalHappiness += 3;
	}
	
	public int getAnimalHealthiness() {
		return animalHealthiness;
	}
	
	public void setAnimalHealthiness(int healthiness) {
		animalHealthiness = healthiness;
	}
	
	public int getAnimalHappiness() {
		return animalHappiness;
	}

	public void setAnimalHappiness(int i) {
		animalHappiness = i;
	}
	
	
}
