package farmsimulator;

public class Sheep extends Animal {
	
	public Sheep () {
		super("Sheep", 100, 100, 100, 100);
	}
	
	public String toString() {
		return getAnimalName() + " (Sheep)";
	}

}
