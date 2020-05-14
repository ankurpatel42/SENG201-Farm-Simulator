package farmsimulator;

public class Pig extends Animal {
	
	public Pig (String nameForPig, int initialHappiness, int initialHealthiness) {
		super(nameForPig, 75, 0, initialHappiness, initialHealthiness);
	}
	
	public String toString() {
		return getAnimalName() + " (Pig)    :     " + getAnimalHealthiness() + "     :     " + getAnimalHappiness();
	}


}
