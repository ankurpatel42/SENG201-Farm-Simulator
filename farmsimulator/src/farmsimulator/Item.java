package farmsimulator;

public class Item {
	
	private double price;
	private String name;
	private int cropHarvestSpeedUpTime = 0;
	private int animalHappinessIncrease = 0;
	
	// For Crop Items
	public Item (String name, double price, int cropHarvestSpeedUpTime) {
		this.name = name;
		this.price = price;
		this.cropHarvestSpeedUpTime = cropHarvestSpeedUpTime;
	}
	
	//For Animal Items
	public Item (double price, int increase, String name) {
		this.price = price;
		this.animalHappinessIncrease = increase;
		this.name = name;
	}
	
	
	//For Water
	public Item (String name, int increase) {
		this.name = name;
		this.cropHarvestSpeedUpTime = increase;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getItemName() {
		return name;
	}

	public int getHarvestSpeedUpTime() {
		// TODO Auto-generated method stub
		return cropHarvestSpeedUpTime;
	}
	
	public int getAnimalHappinessIncrease() {
		return animalHappinessIncrease;
	}
}
