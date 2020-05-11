package farmsimulator;

import java.util.ArrayList;

public class GameEnvironment {
	
	private Farmer farmer = null;
	private int gameLength = 0;
	private Farm farm;
	private Animal animal;
	
	public void setFarm(String farmNameChosen, double moneyAvailable, double cropGrowthRate, int animalHealthiness, int animalHappiness) {
		farm = new Farm(farmNameChosen, moneyAvailable, cropGrowthRate, animalHealthiness, animalHappiness);
	}
	
	public void createCow() {
		animal = new Cow();
		farm.addAnimalToList(animal);
	}
	
	public void createPig() {
		animal = new Pig();
		farm.addAnimalToList(animal);
	}
	
	public void createSheep() {
		animal = new Sheep();
		farm.addAnimalToList(animal);
	}
	
	//same for crops
	
	public Farm getFarm() {
		return farm;
	}
	
	public String getFarmName() {
		return farm.getFarmName();
	}
	
	public void tendFarm(GameEnvironment game) {
		farmer.tendToFarmLand(game);
	}
	
	public double getFarmMoneyAvailable() {
		return farm.getMoneyAvailable();
	}
	
	public double getFarmCropGrowthRate() {
		return farm.getCropGrowthRate();
	}
	
	public void setFarmer(String farmerNameChosen) {
		farmer = new Farmer(farmerNameChosen);
	}
	
	public Farmer getFarmer() {
		return farmer;
	}
	
	public String getFarmerName() {
		return farmer.getFarmerName();
	}
	
	public void useFarmerAction() {
		farmer.useAction();
	}
	
	public int getFarmerActionsLeft() {
		return farmer.getActionsLeft();
	}
	
	public void setGameLength(int numDaysChosen) {
		gameLength = numDaysChosen;
	}
	
	public ArrayList<Animal> getAnimalsOnFarm() {
		return farm.getAnimalList();
	}
	
	public int getGameLength() {
		return gameLength;
	}
	
	public void launchSetUpScreen() {
		@SuppressWarnings("unused")
		SetUpScreen setUpScreenWindow = new SetUpScreen(this);
	}
	
	public void closeSetUpScreen(SetUpScreen setUpScreenFrame) {
		setUpScreenFrame.closeSetUpScreen();
		launchMainScreen();
	}
	
	public void launchMainScreen() {
		@SuppressWarnings("unused")
		MainScreen mainScreenFrame = new MainScreen(this);
	}
	
	public void closeMainScreen(MainScreen mainScreen) {
		mainScreen.closeMainScreen();
		launchAnimalWindow();
	}
	
	public void launchAnimalWindow() {
		@SuppressWarnings("unused")
		AnimalWindow animalWindow = new AnimalWindow(this);
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetUpScreen();
	}
}
