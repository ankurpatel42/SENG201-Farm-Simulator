package farmsimulator;

import java.util.ArrayList;

public class Farmer {
	
	private String farmerName = null;
	private double bonus = 0;
	private int actionsLeft = 2;
	private ArrayList<Item> itemsOwned = new ArrayList<Item>();
	
	public Farmer (String inputFarmerName) {
		farmerName = inputFarmerName;
	}
	
	public String getFarmerName() {
		return farmerName;
	}
	
	public int getActionsLeft() {
		return actionsLeft;
	}
	
	public void useAction() {
		actionsLeft--;
	}
	
	public void additemToList(Item item) {
		itemsOwned.add(item);
	}
	
	public ArrayList<Item> getItemsOwned() {
		return itemsOwned;
	}
	
	/*
	public int getDayNum() {
		return dayNum;
	}
	
	/*
	public void moveToNextDay(GameEnvironment game) {
		if (dayNum > game.getGameLength()) {
			System.out.println("You cannot move to the next day as this is your last day.");
		} else {
			dayNum++;
			actionsLeft = 2;
			Crop.dayPassed(game);
			for (Animal animal : game.getFarm().getAnimalList()) {
				bonus = getBonus() + 0.1 * animal.getAnimalHappiness();
			}
			game.getFarm().setMoneyAvailible(game.getFarm().getMoneyAvailable() + bonus);
		}
	}
	*/
	
	/*
	public void tendToFarmLand(GameEnvironment game) {
		game.useFarmerAction();
		for (Crop crop : game.getFarm().getCropList()) {
			crop.setDaysTillHarvest(crop.getDaysTillHarvest() - 1);
		}
		for (Animal animal : game.getFarm().getAnimalList()) {
			animal.setAnimalHappiness(animal.getAnimalHappiness() + 1);
		}
	}
	*/
	
	/*
	public static void visitGeneralStore(GeneralStore store) {
		System.out.println("Items for sale: " + store.viewItemsForSale());
	}
	
	public String toString() {
		return "I'm a farmer and my name is " + farmerName;
	}
	*/

	public double getBonus() {
		return bonus;
	}
	
}
