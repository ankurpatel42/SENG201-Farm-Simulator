package farmsimulator;

import java.util.ArrayList;
import java.util.Random;

public class RandomEvent {
	
	private Random rand;
	private int rand_int;
	private String message;
	private int tracker;
	
	/**
	 * Decides if and what random event will occur that day through random numbers 
	 * 
	 * @param farm						The Farm where the random event will have its effects
	 * @return 								String with message to the user about the random event, null if one doesn't happen
	 */
	public String decideRandomEvent(Farm farm) {
		rand = new Random();
		rand_int = rand.nextInt(100);
		if (rand_int < 10) {
			message = fenceBroken(farm);
		}
		else if (rand_int < 20) {
			message = drought(farm);
		}
		else if (rand_int < 30) {
			message = winCountyFair(farm);
		}
		else {
			message = null;
		}
		return message;
	}
	
	/**
	 * Random event of a fence breaking, random number of animals escape, rest have happiness reduced
	 * 
	 * @param farm						Farm class that holds the list of animals affected
	 * @return 								String with the outcome of the broken fence for the user
	 */
	public String fenceBroken(Farm farm) {
		if (farm.getAnimalList().size() > 0) {
			rand = new Random();
			int animalsNeedGone = rand.nextInt(farm.getAnimalList().size()) + 1;
			tracker = 0;
			while (tracker < animalsNeedGone) {
				rand_int = rand.nextInt(farm.getAnimalList().size());
				farm.getAnimalList().remove(rand_int);
				tracker ++;
			}
			for (Animal animal : farm.getAnimalList()){
				animal.setAnimalHappiness(animal.getAnimalHappiness() - 2);
			}
			message = "BROKEN FENCE!!! You lost " + animalsNeedGone + " animal(s), and the rest aren't happy" ;
		}
		else {
			message = "BROKEN FENCE!!! Luckily you have no animals on the farm so you are uneffected";
		}
		return message;
	}
	
	/**
	 * Random event of a drought, half the crops are destroyed
	 * 
	 * @param farm						Farm class that holds the list of crops affected
	 * @return 								String with the outcome of the drought for the user
	 */
	public String drought(Farm farm) {
		if (farm.getCropList().size() > 0) {
			int cropsNeedGone = Math.round((farm.getCropList().size()/2));
			tracker = 0;
			rand = new Random();
			while (tracker < cropsNeedGone) {
				rand_int = rand.nextInt(farm.getCropList().size());
				farm.getCropList().remove(rand_int);
				tracker ++;
			}
			message = "DROUGHT!!! You lost " + cropsNeedGone + " crop(s)";
		}
		else {
			message = "DROUGHT!!! Luckily you have no crops so you are uneffected";
		}
		return message;
	}
	
	/**
	 * Random event of winning the country fair, money boost depends on crops and animals on farm.
	 * 
	 * @param farm						Farm class that holds the list of crops and animals and the money
	 * @return 								String with the outcome of winning the fair for the user
	 */
	public String winCountyFair(Farm farm) {
		double moneyWon = 200 + farm.getAnimalList().size() * 100 + farm.getCropList().size() * 100;
		farm.setMoneyAvailable(farm.getMoneyAvailable() + moneyWon);
		return ("WON THE COUNTY FAIR!!! You won $" + moneyWon);
	}
}
