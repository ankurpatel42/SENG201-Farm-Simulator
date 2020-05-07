package farmsimulator;

public class Farmer {
	
	private static String farmerName = null;
	private int farmerAge = 0;
	private double bonus;
	private static int actionsLeft = 2;
	private static int dayNum = 1;
	
	public Farmer (String inputFarmerName) {
		farmerName = inputFarmerName;
	}
	
	public String getFarmerName() {
		return farmerName;
	}
	
	public int getActionsLeft() {
		return actionsLeft;
	}
	
	public int getAge() {
		return farmerAge;
	}
	
	public static void useAction() {
		if (actionsLeft == 0) {
			System.out.println(farmerName + " has no actions left for today");
		}
		else {
			actionsLeft--;
			if (actionsLeft == 0) {
				System.out.println(farmerName + " has run out of actions for today");
			}
		}
	}
	
	public int getDayNum() {
		return dayNum;
	}
	
	public void moveToNextDay() {
		if (dayNum > GameEnvironment.getGameLength()) {
			System.out.println("You cannot move to the next day as this is your last day.");
		} else {
			dayNum++;
			actionsLeft = 2;
			Crop.dayPassed();
			for (Animal animal : Farm.getAnimalList()) {
				bonus = getBonus() + 0.1 * animal.getAnimalHappiness();
			}
			Farm.setMoneyAvailible(Farm.getMoneyAvailable() + bonus);
		}
	}
	
	public void tendToFarmLand() {
		useAction();
		for (Crop crop : Farm.getCropList()) {
			crop.setDaysTillHarvest(crop.getDaysTillHarvest() - 1);
		}
		for (Animal animal : Farm.getAnimalList()) {
			animal.setAnimalHappiness(animal.getAnimalHappiness() + 1);
		}
	}
	
	public static void visitGeneralStore(GeneralStore store) {
		System.out.println("Items for sale: " + store.viewItemsForSale());
	}
	
	public String toString() {
		return "I'm a farmer and my name is " + farmerName;
	}

	public double getBonus() {
		return bonus;
	}
	
}
