package farmsimulator;

public class Cow extends Animal {
	
	public Cow (String nameForCow, int initialHappiness, int initialHealthiness, GameEnvironment game) {
		super(nameForCow, 50, 0, initialHappiness, initialHealthiness, game);
	}
	
	public String toString() {
		return getAnimalName() + " (Cow): " + getAnimalHealthiness() + ": " + getAnimalHappiness();
	}
	
}
