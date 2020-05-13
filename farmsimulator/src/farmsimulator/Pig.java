package farmsimulator;

public class Pig extends Animal {
	
	public Pig () {
		super("Pig", 100, 0, 0, 0);
	}
	
	public String toString() {
		return getAnimalName() + " (Pig): " + getAnimalHealthiness() + ": " + getAnimalHappiness();
	}


}
