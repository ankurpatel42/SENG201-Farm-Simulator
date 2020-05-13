package farmsimulator;

public class Cow extends Animal {
	
	public Cow () {
		super("Cow", 50, 0, 0, 0);
	}
	
	public String toString() {
		return getAnimalName() + " (Cow): " + getAnimalHealthiness() + ": " + getAnimalHappiness();
	}

}
