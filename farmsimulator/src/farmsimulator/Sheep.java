package farmsimulator;

public class Sheep extends Animal {
	
	public Sheep(String nameForSheep, int initialHappiness, int initialHealthiness) {
		super(nameForSheep, 50, 0, initialHappiness, initialHealthiness);
	}
	
	public String toString() {
		return getAnimalName() + " (Sheep): " + getAnimalHealthiness() + ": " + getAnimalHappiness();
	}

}
