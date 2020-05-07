package farmsimulator;

public abstract class Animal {
	
	private float animalPurchasePrice = 0;
	private float animalMoneyGiven = 0;
	private int animalHealthiness = 0;
	private int animalHappiness = 0;
	
	public Animal (String name, float animalPurchasePrice, float animalMoneyGiven, int animalHealthiness, int animalHappiness) {
		this.animalPurchasePrice = animalPurchasePrice;
		this.animalMoneyGiven = animalMoneyGiven;
		this.animalHealthiness = animalHealthiness;
		this.animalHappiness = animalHappiness;
	}
	
	public float getAnimalPurchasePrice() {
		return animalPurchasePrice;
	}
	
	public float getAnimalMoneyGiven() {
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
