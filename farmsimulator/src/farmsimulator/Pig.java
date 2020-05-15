package farmsimulator;

/** 
 * This class contains attributes and methods for a Pig object. This class extends the Animal Class.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */


public class Pig extends Animal {
	
	/**
	 * Pig constructor. This class creates an instance of Pig by providing initial values to its parent class' constructor.
	 * 
	 * @param nameForPig			The name given to the pig.
	 * @param initialHappiness		The initial happiness of the pig depending on what type of farm the user chose.
	 * @param initialHealthiness	The initial healthiness of the pig depending on what type of farm the user chose.
	 */
	public Pig (String nameForPig, int initialHappiness, int initialHealthiness) {
		super(nameForPig, 75, 0, initialHappiness, initialHealthiness);
	}
	
	/**
	 * String representation of a Pig object.
	 */
	public String toString() {
		return getAnimalName() + " (Pig)    :     " + getAnimalHealthiness() + "     :     " + getAnimalHappiness();
	}


}
