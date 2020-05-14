package farmsimulator;

public abstract class Crop {

	private double cropPurchasePrice = 0;
	private double cropMoneyGiven = 0;
	private int daysTillHarvest = 0;
	private String name = null;
	private int daysGrowing = 0;
	private String message;
	private static int fieldCounter = 0;
	private int fieldNumber = 0;

	public Crop (String name, double cropPurchasePrice, double cropMoneyGiven, int daysTillHarvest) {
		this.name = name;
		this.cropMoneyGiven = cropMoneyGiven;
		this.cropPurchasePrice = cropPurchasePrice;
		this.daysTillHarvest = daysTillHarvest;
		fieldCounter++;
		fieldNumber = fieldCounter;
	}
	
	public int getFieldNumber() {
		return fieldNumber;
	}
	
	public String getCropName() {
		return name;
	}
	
	public int getDaysGrowing() {
		return daysGrowing;
	}
	
	public int getDaysTillHarvest() {
		return daysTillHarvest;
	}
	
	public double getCropPurchasePrice() {
		return cropPurchasePrice;
	}
	
	public void setDaysTillHarvest(int days) {
		daysTillHarvest = days;
	}

	public double getCropMoneyGiven() {
		return cropMoneyGiven;
	}
	
	public void dayPassed(GameEnvironment game) {
		daysTillHarvest -= game.getFarm().getCropGrowthRate();
	}
	
	public String tendCrops(Item choice, GameEnvironment game) {
		if (game.useFarmerAction() == true) {
			daysTillHarvest -= choice.getHarvestSpeedUpTime();
			if (daysTillHarvest <= 0) {
				daysTillHarvest = 0;
			}
			if (choice.getItemName() != "Water") {
				game.getItemsOwnedByFarmer().remove(choice);
			}
			message = "You fertilised " + name + " using " + choice.getItemName() + ", now " + daysTillHarvest + " day(s) to harvest";
		}
		else {
			message = "You have no actions left for the day, move to next day to complete this action";
		}
		return message;
	}
	
	public String harvestCrops(GameEnvironment game) {
		if (game.useFarmerAction() == true) {
			game.useFarmerAction();
			if (daysTillHarvest > 0) {
				message = "Sorry your crops are not ready for Harvest yet, still " + daysTillHarvest + " day(s) left";
			}
			else {
				game.getFarm().setMoneyAvailable(game.getFarmMoneyAvailable() + cropMoneyGiven);
				message = "Crop harvested and you earnt $" + cropMoneyGiven;
				game.getCropsOwned().remove(this);
			}
		}
		else {
			message = "You have no actions left for the day, move to next day to complete this action";
		}
		return message;
	}
	
	public String toString() {
		String display = "Feild " + getFieldNumber() + " (" + name + ")	" + daysTillHarvest; 
		return display;
	}
	
}
