package farmsimulator;

import java.util.ArrayList;

public abstract class Crop {

	private double cropPurchasePrice = 0;
	private double cropMoneyGiven = 0;
	private int daysTillHarvest = 0;
	private String name = null;
	private int daysGrowing = 0;
	private static ArrayList<Crop> crops = null;
	private GameEnvironment game;
	private String message;

	public Crop (String name, double cropPurchasePrice, double cropMoneyGiven, int daysTillHarvest, GameEnvironment gameEnv) {
		this.name = name;
		this.cropMoneyGiven = cropMoneyGiven;
		this.cropPurchasePrice = cropPurchasePrice;
		this.daysTillHarvest = daysTillHarvest;
		game = gameEnv;
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
	
	public static void dayPassed(GameEnvironment game) {
		crops = game.getCropsOwned();
		for (Crop crop : crops) {
			crop.setDaysTillHarvest(crop.getDaysTillHarvest() - 1);
		}
	}
	
	public String tendCrops(Item choice) {
		game.useFarmerAction();
		daysTillHarvest -= choice.getHarvestSpeedUpTime();
		if (daysTillHarvest <= 0) {
			daysTillHarvest = 0;
		}
		if (choice.getItemName() != "Water") {
			game.getItemsOwnedByFarmer().remove(choice);
		}
		return "You fertilised " + name + " using " + choice.getItemName() + ", now " + daysTillHarvest + " day(s) to harvest";
	}
	
	public String harvestCrops() {
		game.useFarmerAction();
		if (daysTillHarvest > 0) {
			message = "Sorry your crops are not ready for Harvest yet, still " + daysTillHarvest + " day(s) left";
		}
		else {
			game.getFarm().setMoneyAvailible(game.getFarmMoneyAvailable() + cropMoneyGiven);
			message = "Crop harvested and you earnt $" + cropMoneyGiven;
			game.getCropsOwned().remove(this);
		}
		return message;
	}
	
	public String toString() {
		crops = game.getCropsOwned();
		int num = crops.indexOf(this) + 1;
		String display = "Feild " + num + " (" + name + ")	" + daysTillHarvest; 
		return display;
	}
}
