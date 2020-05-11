package farmsimulator;

import java.util.ArrayList;

//All of the game logic will be placed in the game environment
//The game environment instantiates farmers, crops, and animals, and places the objects where they belong.

public class GameEnvironment {
	
	private Farmer farmer = null;
	private int gameLength = 0;
	private Farm farm;
	private Animal animal;
	//private Crop crop;
	//private Item item;
	
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
	
	//same for crops and item - do later
	
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
	
	public void launchStoreWindow() {
		@SuppressWarnings("unused")
		StoreWindow storeWindow = new StoreWindow(this);
	}
	
	public void launchPurchaseAnimalWindow() {
		@SuppressWarnings("unused")
		PurchaseAnimal purchaseAnimalWindow = new PurchaseAnimal(this);
	}
	
	public void closePurchaseAnimalWindow(PurchaseAnimal purchaseAnimalFrame) {
		purchaseAnimalFrame.closePurchaseAnimalWindow();
	}
	
	public void launchPurchaseCropWindow() {
		@SuppressWarnings("unused")
		PurchaseCrop purchaseCropWindow = new PurchaseCrop(this);
	}
	
	public void closePurchaseCropWindow(PurchaseCrop purchaseCropFrame) {
		purchaseCropFrame.closePurchaseCropWindow();
	}
	
	public void launchPurchaseItemWindow() {
		@SuppressWarnings("unused")
		PurchaseItem purchaseItemWindow = new PurchaseItem(this);
	}
	
	public void closePurchaseItemWindow(PurchaseItem purchaseItemFrame) {
		purchaseItemFrame.closePurchaseItemWindow();
	}
	
	public void launchCropWindow() {
		@SuppressWarnings("unused")
		CropWindow cropWindow = new CropWindow(this);
	}
	
	public void closeCropWindow(CropWindow cropWindow) {
		cropWindow.closeCropWindow();
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetUpScreen();
	}
}
