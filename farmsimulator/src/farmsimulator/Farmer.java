package farmsimulator;

public class Farmer {
	
	private String farmerName = null;
	private double bonus;
	private int actionsLeft = 2;
	private int dayNum = 1;
	
	public Farmer (String inputFarmerName) {
		farmerName = inputFarmerName;
	}
	
	public String getFarmerName() {
		return farmerName;
	}
	
	public int getActionsLeft() {
		return actionsLeft;
	}
	
	public Boolean useAction() {
		if (actionsLeft > 0) {
			actionsLeft--;
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getDayNum() {
		return dayNum;
	}
	
	
	public String moveToNextDay(GameEnvironment game) {
		dayNum += 1;
		actionsLeft = 2;
		for (Crop crop : game.getCropsOwned()) {
			crop.dayPassed(game);
		}
		bonus = 0;
		for (Animal animal : game.getAnimalsOnFarm()) {
			bonus += 0.1 * animal.getAnimalHappiness();
		}
		game.setFarmMoneyAvailable(bonus + game.getFarmMoneyAvailable());
		return ("You earnt a $" + bonus + " from you happy animals, you are now on day " + dayNum + " out of " + game.getGameLength());
	}
	
	
	
	public void tendToFarmLand(GameEnvironment game) {
		for (Crop crop : game.getCropsOwned()) {
			crop.setDaysTillHarvest(crop.getDaysTillHarvest() - 1);
		}
		for (Animal animal : game.getAnimalsOnFarm()) {
			double add = (animal.getAnimalHappiness() + 1);
			animal.setAnimalHappiness(add);
		}
	}
	
	
	/*
	public static void visitGeneralStore(GeneralStore store) {
		System.out.println("Items for sale: " + store.viewItemsForSale());
	}
	
	public String toString() {
		return "I'm a farmer and my name is " + farmerName;
	}
	*/

	public double getBonus() {
		return bonus;
	}
	
}