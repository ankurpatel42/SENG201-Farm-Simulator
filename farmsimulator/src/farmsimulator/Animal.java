package farmsimulator;

public class Animal extends Farm {
	
	private float animalPurchasePrice = 0;
	private float animalMoneyGiven = 0;
	private int animalHealthiness = 0;
	private int animalHappiness = 0;
	
	public Animal () {
		animalHealthiness = Farm.getStartingAnimalHealthiness();
		animalHappiness = Farm.getStartingAnimalHappiness();
	}
	
	public float getAnimalPurchasePrice() {
		return animalPurchasePrice;
	}
	
	public float getAnimalMoneyGiven() {
		return animalMoneyGiven;
	}
	
	public void feedAnimal(Item choice) {
		System.out.println("You have fed the animal " + choice.getItemName() + "!");
		animalHealthiness += 2;
	}
	
	public void playWithAnimal() {
		animalHappiness += 3;
	}
	
	public int getAnimalHealthiness() {
		return animalHealthiness;
	}
	
	public int getAnimalHappiness() {
		return animalHappiness;
	}
	
	
}
