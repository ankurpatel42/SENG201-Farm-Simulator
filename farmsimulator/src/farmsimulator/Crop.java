package farmsimulator;

import java.util.ArrayList;

public abstract class Crop {

	private double cropPurchasePrice = 0;
	private double cropMoneyGiven = 0;
	private int daysTillHarvest = 0;
	private String name = null;
	private int daysGrowing = 0;
	private static ArrayList<Crop> crops = null;

	public Crop (String name, double cropPurchasePrice, double cropMoneyGiven, int daysTillHarvest) {
		this.name = name;
		this.cropPurchasePrice = cropPurchasePrice;
		this.daysTillHarvest = daysTillHarvest;
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
		crops = game.getFarm().getCropList();
		for (Crop crop : crops) {
			crop.setDaysTillHarvest(crop.getDaysTillHarvest() - 1);
		}
	}
	
	public void tendCrops(Item choice, GameEnvironment game) {
		game.useFarmerAction();
		daysTillHarvest -= choice.getHarvestSpeedUpTime();
		if (daysTillHarvest <= 0) {
			daysTillHarvest = 0;
		}
	}
	
	public void harvestCrops(GameEnvironment game) {
		game.useFarmerAction();
		if (daysTillHarvest > 0) {
			System.out.println("Sorry your crops are not ready for Harvest yet");
		}
		else {
			game.getFarm().setMoneyAvailible(cropMoneyGiven);
		}
	}
}
