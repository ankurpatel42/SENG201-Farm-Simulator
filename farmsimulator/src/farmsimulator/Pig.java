package farmsimulator;

public class Pig extends Animal {
	
	public Pig () {
		super("Pig", 100, 100, 100, 100);
	}
	
	public String toString() {
		return getAnimalName() + " (Pig)";
	}


}
