package farmsimulator;

public class Cow extends Animal {
	
	public Cow () {
		super("Cow", 100, 100, 100, 100);
	}
	
	public String toString() {
		return getAnimalName() + " (Cow): " + getAnimalHealthiness() + ": " + getAnimalHappiness();
	}

}
