package farmsimulator;

public class Sheep extends Animal {
	
	public Sheep(String nameForSheep, int initialHappiness, int initialHealthiness, GameEnvironment game) {
		super(nameForSheep, 50, 0, initialHappiness, initialHealthiness, game);
	}
	
	public String toString() {
		return getAnimalName() + " (Sheep): " + getAnimalHealthiness() + ": " + getAnimalHappiness();
	}

}
