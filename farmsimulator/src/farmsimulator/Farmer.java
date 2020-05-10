package farmsimulator;

public class Farmer {
	
	private static String farmerName = null;
	private double bonus = 0;
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
	
	public void moveToNextDay(GameEnvironment game) {
		if (dayNum > game.getGameLength()) {
			System.out.println("You cannot move to the next day as this is your last day.");
		} else {
			dayNum++;
			actionsLeft = 2;
			Crop.dayPassed(game);
			for (Animal animal : game.getFarm().getAnimalList()) {
				bonus = getBonus() + 0.1 * animal.getAnimalHappiness();
			}
			game.getFarm().setMoneyAvailible(game.getFarm().getMoneyAvailable() + bonus);
		}
	}
	
	public void tendToFarmLand(GameEnvironment game) {
		useAction();
		for (Crop crop : game.getFarm().getCropList()) {
			crop.setDaysTillHarvest(crop.getDaysTillHarvest() - 1);
		}
		for (Animal animal : game.getFarm().getAnimalList()) {
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
