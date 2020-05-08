package farmsimulator;

import java.util.ArrayList;

public class Farm {
	
	private String farmName = null;
	private float moneyAvailable = 0;
	private float cropGrowthRate = 0;
	private int farmTidiness = 0;
	private ArrayList<Animal> animalsList = new ArrayList<Animal>();
	private ArrayList<Crop> cropsList = new ArrayList<Crop>();
	private ArrayList<Item> itemsOwned = new ArrayList<Item>();
	private int startingAnimalHealthiness = 0;
	private int startingAnimalHappiness = 0;
	
	
	public Farm(String name, float money, float cropGrowth, int animalHealthiness, int animalHappiness) {
		farmName = name;
		moneyAvailable = money;
		cropGrowthRate = cropGrowth;
		startingAnimalHealthiness = animalHealthiness;
		startingAnimalHappiness = animalHappiness;
	}
	
	
	public String getFarmName() {
		return farmName;
	}
	
	public void setMoneyAvailible(double newBalance) {
		moneyAvailable += newBalance;
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
	
	public double getCropGrowthRate() {
		return cropGrowthRate;
	}
	
	public ArrayList<Item> getItemsOwned(){
		return itemsOwned;
	}
	
	public void addNewItem(Item item){
		itemsOwned.add(item);
	}
	
	public int getStartingAnimalHappiness() {
		return startingAnimalHappiness;
	}

	public int getStartingAnimalHealthiness() {
		return startingAnimalHealthiness;
	}
}
