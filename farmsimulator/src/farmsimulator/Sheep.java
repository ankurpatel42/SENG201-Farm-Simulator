package farmsimulator;

public class Sheep extends Animal {
	
	public Sheep () {
		super("Sheep", 75, 0, 0, 0);
	}
	
	public String toString() {
		return getAnimalName() + " (Sheep): " + getAnimalHealthiness() + ": " + getAnimalHappiness();
	}

}
