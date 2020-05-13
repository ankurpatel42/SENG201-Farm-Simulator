package farmsimulator;

public class Pig extends Animal {
	
	public Pig (String nameForPig, int initialHappiness, int initialHealthiness, GameEnvironment game) {
		super(nameForPig, 100, 0, initialHappiness, initialHealthiness, game);
	}
	
	public String toString() {
		return getAnimalName() + " (Pig): " + getAnimalHealthiness() + ": " + getAnimalHappiness();
	}


}
