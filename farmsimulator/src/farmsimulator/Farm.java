package farmsimulator;

import java.util.ArrayList;

public class Farm {
	
	private static String farmName = null;
	private static double moneyAvailable = 0;
	private static double cropGrowthRate = 0;
	private static int animalHappiness = 0;
	private static int farmTidiness = 0;
	private static ArrayList<Animal> animalsList = null;
	private static ArrayList<Crop> cropsList = null;
	private static int gameLength = 0;
	private static ArrayList<Item> itemsOwned = null;
	
	public static String getFarmName() {
		return farmName;
	}
	
	public static double getMoneyAvailable() {
		return moneyAvailable;
	}
	
	public static void setMoneyAvailable(double amount) {
		moneyAvailable = amount;
	}
	
	public static double getCropGrowthRate() {
		return cropGrowthRate;
	}
	
	public static int getAnimalHappiness() {
		return animalHappiness;
	}
	
	public static int getFarmTidiness() {
		return farmTidiness;
	}
	
	public static ArrayList<Animal> getAnimalsList() {
		return animalsList;
	}
	
	public static void addAnimal(Animal animal) {
		animalsList.add(animal);
	}
	
	public static ArrayList<Crop> getCropsList() {
		return cropsList;
	}
	
	public static void addCrop(Crop crop) {
		cropsList.add(crop);
	}
	
	public static void setGameLength(int chosenGameLength) {
		gameLength = chosenGameLength;
	}
	
	public static int getGameLength() {
		return gameLength;
	}
	
	public static void farmType(int optionChosen) {
		if (optionChosen == 1) {
			moneyAvailable = 300;
			cropGrowthRate = 2.5;
			animalHappiness = 5;
		}
		else if (optionChosen == 2) {
			moneyAvailable = 500;
			cropGrowthRate = 3.5;
			animalHappiness = 3;
		}
		else if (optionChosen == 3) {
			moneyAvailable = 700;
			cropGrowthRate = 4.5;
			animalHappiness = 8;
		} 
		else if (optionChosen == 4) {
			moneyAvailable = 1000;
			cropGrowthRate = 1.5;
			animalHappiness = 2;
		}
		else {
			System.out.println("You have not entered a valid option.");
		}
		
		
	}
	
	public static ArrayList<Item> getItemsOwned(){
		return itemsOwned;
	}
	
	public static void addNewItem(Item item){
		itemsOwned.add(item);
	}
	
	
}
