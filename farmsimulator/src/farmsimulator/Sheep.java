package farmsimulator;

/** 
 * This class contains attributes and methods for a Sheep object. This class extends the Animal Class.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */


public class Sheep extends Animal {
	
	/**
	 * Sheep constructor. This class creates an instance of Sheep by providing initial values to its parent class' constructor.
	 */
	public Sheep(String nameForSheep, int initialHappiness, int initialHealthiness) {
		super(nameForSheep, 50, 0, initialHappiness, initialHealthiness);
	}
	
	/**
	 * String representation of a Sheep object.
	 */
	public String toString() {
		return getAnimalName() + " (Sheep)    :     " + getAnimalHealthiness() + "     :     " + getAnimalHappiness();
	}

}
