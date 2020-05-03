package farmsimulator;

import java.util.ArrayList;

public class Farm {
	
	private static String farmName = null;
	private static double moneyAvailable = 0;
	private static int startingAnimalHappiness = 0;
	private static int startingAnimalHealthiness = 0;
	private static double cropGrowthRate = 0;
	private static int farmTidiness = 0;
	private static ArrayList<Animal> animalsList = null;
	private static ArrayList<Crop> cropsList = null;
	private static ArrayList<Item> itemsOwned = null;
	
	public static String getFarmName() {
		return farmName;
	}
	
	public static void setMoneyAvailible(double newBalance) {
		moneyAvailable += newBalance;
	}
	
	public static double getMoneyAvailable() {
		return moneyAvailable;
	}
	
	
	public static int getFarmTidiness() {
		return farmTidiness;
	}
	
	public static void addAnimalToList(Animal animal) {
		animalsList.add(animal);
	}
	
	public static ArrayList<Animal> getAnimalList() {
		return animalsList;
	}
	
	public static ArrayList<Crop> getCropList() {
		return cropsList;
	}
	
	public static void setCropGrowthRate(int option) {
		if (cropGrowthRate == 0) {
			cropGrowthRate = option;
		} else {
			System.out.println("You cannot change this value.");
		}
	}
	
	public static double getCropGrowthRate() {
		return cropGrowthRate;
	}
	
	public static void setStartingAnimalHealthiness(int option) {
		if (startingAnimalHealthiness == 0) {
			startingAnimalHealthiness = option;
		} else {
			System.out.println("You cannot change this value.");
		}
	}
	
	public static int getStartingAnimalHealthiness() {
		return startingAnimalHealthiness;
	}

	public static void setStartingAnimalHappiness(int option) {
		if (startingAnimalHappiness == 0) {
			startingAnimalHappiness = option;
		} else {
			System.out.println("You cannot change this value.");
		}
	}
	
	public static int getStartingAnimalHappiness() {
		return startingAnimalHappiness;
	}
	
	public static ArrayList<Item> getItemsOwned(){
		return itemsOwned;
	}
	
	public static void addNewItem(Item item){
		itemsOwned.add(item);
	}
	
	public void tendToFarmLand() {
		//useAction();
		for (Crop crop : Farm.getCropList()) {
			crop.setDaysTillHarvest(crop.getDaysTillHarvest() - 1);
		}
		//All Animal Happiness Increases//
	}

	
}
