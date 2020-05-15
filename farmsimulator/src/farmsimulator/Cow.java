package farmsimulator;

/** 
 * This class contains attributes and methods for a Cow object. This class extends the Animal Class.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */


public class Cow extends Animal {
	
	/**
	 * Cow constructor. This class creates an instance of Cow by providing initial values to its parent class' constructor.
	 * 
	 * @param nameForCow			The name given to the cow.
	 * @param initialHappiness		The initial happiness of the cow depending on what type of farm the user chose.
	 * @param initialHealthiness	The initial healthiness of the cow depending on what type of farm the user chose.
	 */
	public Cow (String nameForCow, int initialHappiness, int initialHealthiness) {
		super(nameForCow, 100, 0, initialHappiness, initialHealthiness);
	}
	
	/**
	 * String representation of a Cow object.
	 */
	public String toString() {
		return getAnimalName() + " (Cow)    :     " + getAnimalHealthiness() + "     :     " + getAnimalHappiness();
	}
	
}
