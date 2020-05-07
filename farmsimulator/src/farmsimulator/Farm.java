package farmsimulator;

import java.util.ArrayList;

public class Farm {
	
	private String farmName = null;
	private double moneyAvailable = 0;
	private double cropGrowthRate = 0;
	private int farmTidiness = 0;
	private ArrayList<Animal> animalsList = new ArrayList<Animal>();
	private ArrayList<Crop> cropsList = new ArrayList<Crop>();
	private ArrayList<Item> itemsOwned = new ArrayList<Item>();
	private String type = null;
	
	
	public Farm(String name, double money, double cropGrowth) {
		farmName = name;
		moneyAvailable = money;
		cropGrowthRate = cropGrowth;
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
	
	
	public String getFarmType() {
		return type;
	}
	
	
	public ArrayList<Item> getItemsOwned(){
		return itemsOwned;
	}
	
	public void addNewItem(Item item){
		itemsOwned.add(item);
	}

	
}
