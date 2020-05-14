package farmsimulator;

import java.util.ArrayList;

public class Farm {
	
	private String farmName = null;
	private double moneyAvailable = 0;
	private int cropGrowthRate = 0;
	private int farmTidiness = 0;
	private ArrayList<Animal> animalsList = new ArrayList<Animal>();
	private ArrayList<Crop> cropsList = new ArrayList<Crop>();
	private ArrayList<Item> itemsOwned = new ArrayList<Item>();
	private int initialAnimalHealthiness = 0;
	private int initialAnimalHappiness = 0;
	
	
	public Farm(String name, double money, int cropGrowth, int animalHealthiness, int animalHappiness) {
		farmName = name;
		moneyAvailable = money;
		cropGrowthRate = cropGrowth;
		initialAnimalHealthiness = animalHealthiness;
		initialAnimalHappiness = animalHappiness;
		Water water = new Water();
		itemsOwned.add(water);
	}
	
	public String getFarmName() {
		return farmName;
	}
	
	public void setMoneyAvailable(double newBalance) {
		moneyAvailable = newBalance;
	}
	
	public double getMoneyAvailable() {
		return moneyAvailable;
	}
	
	public int getFarmTidiness() {
		return farmTidiness;
	}
	
	public void addAnimalToList(Animal animal) {
		animalsList.add(animal);
	}
	
	public ArrayList<Animal> getAnimalList() {
		return animalsList;
	}
	
	public void addCropToList(Crop crop) {
		cropsList.add(crop);
	}
	
	public ArrayList<Crop> getCropList() {
		return cropsList;
	}
	
	public int getCropGrowthRate() {
		return cropGrowthRate;
	}
	
	public ArrayList<Item> getItemsOwned(){
		return itemsOwned;
	}
	
	public void addNewItem(Item item){
		itemsOwned.add(item);
	}
	
	public int getInitialAnimalHappiness() {
		return initialAnimalHappiness;
	}

	public int getInitialAnimalHealthiness() {
		return initialAnimalHealthiness;
	}
}
