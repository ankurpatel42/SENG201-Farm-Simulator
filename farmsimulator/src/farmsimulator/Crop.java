package farmsimulator;

public class Crop extends Farm{

	private float cropPurchasePrice = 0;
	private float cropMoneyGiven = 0;
	private int daysTillHarvest = 0;

	public Crop () {

	}
	
	public int getDaysTillHarvest() {
		return daysTillHarvest;
	}
	
	public float getCropPurchasePrice() {
		return cropPurchasePrice;
	}
	
	public void setDaysTillHarvest(int days) {
		daysTillHarvest = days;
	}

	public float getCropMoneyGiven() {
		return cropMoneyGiven;
	}
	
	public void tendCrops(Item choice) {
		Farmer.useAction();
		daysTillHarvest -= choice.getHarvestSpeedUpTime();
		if (daysTillHarvest <= 0) {
			daysTillHarvest = 0;
		}
	}
	
	public void harvestCrops() {
		Farmer.useAction();
		if (daysTillHarvest > 0) {
			System.out.Println("Sorry your crops are not ready for Harvest yet");
		}
		else {
			Farm.setMoneyAvailible(cropMoneyGiven);
		}
	}
}
