package farmsimulator;

public abstract class Animal {
	
	private double animalPurchasePrice = 0;
	private double animalMoneyGiven = 0;
	private int animalHealthiness = 0;
	private int animalHappiness = 0;
	private String animalName;
	
	public Animal (String name, double animalPurchasePrice, double animalMoneyGiven, int animalHealthiness, int animalHappiness) {
		this.animalName = name;
		this.animalPurchasePrice = animalPurchasePrice;
		this.animalMoneyGiven = animalMoneyGiven;
		this.animalHealthiness = GameEnvironment.getFarm().getStartingAnimalHealthiness() + animalHealthiness;
		this.animalHappiness = GameEnvironment.getFarm().getStartingAnimalHappiness() + animalHappiness;
	}
	
	public double getAnimalPurchasePrice() {
		return animalPurchasePrice;
	}
	
	public String getName() {
		return animalName;
	}
	
	public double getAnimalMoneyGiven() {
		return animalMoneyGiven;
	}
	
	public void feedAnimal(Item choice) {
		Farmer.useAction();
		System.out.println("You have fed the animal " + choice.getItemName() + "!");
		animalHealthiness += 2;
	}
	
	public void playWithAnimal() {
		Farmer.useAction();
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
