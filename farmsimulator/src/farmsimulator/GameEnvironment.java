package farmsimulator;

import java.util.ArrayList;

//All of the game logic will be placed in the game environment
//The game environment instantiates farmers, crops, and animals, and places the objects where they belong.

public class GameEnvironment {
	
	private Farmer farmer = null;
	private int gameLength = 0;
	private Farm farm;
	private Animal animal;
	private Crop crop;
	private Item item;
	private GeneralStore store;
	private String message;
	
	public void setFarm(String farmNameChosen, double moneyAvailable, double cropGrowthRate, int animalHealthiness, int animalHappiness) {
		farm = new Farm(farmNameChosen, moneyAvailable, cropGrowthRate, animalHealthiness, animalHappiness);
		//Not sure where to call this
		store = new GeneralStore(this);
	}
	
	
	public String createCow(String nameForCow) {
		animal = new Cow();
		animal.setAnimalName(nameForCow);
		message = store.purchaseAnimal(animal);
		return message;
	}
	
	public String createPig(String nameForPig) {
		animal = new Pig();
		animal.setAnimalName(nameForPig);
		message = store.purchaseAnimal(animal);
		return message;
	}
	
	public String createSheep(String nameForSheep) {
		animal = new Sheep();
		animal.setAnimalName(nameForSheep);
		message = store.purchaseAnimal(animal);
		return message;
	}
	
	public String createFertiliserOne() {
		item = new FertiliserOne();
		message = store.purchaseItem(item);
		return message;
	}
	
	public String createFertiliserTwo() {
		item = new FertiliserTwo();
		message = store.purchaseItem(item);
		return message;
	}
	
	public String createFertiliserThree() {
		item = new FertiliserThree();
		message = store.purchaseItem(item);
		return message;
	}
	
	public String createAnimalFoodOne() {
		item = new AnimalFoodOne();
		addItemsOwnedByFarmer(item);
		message = store.purchaseItem(item);
		return message;
	}
	
	public String createAnimalFoodTwo() {
		item = new AnimalFoodTwo();
		addItemsOwnedByFarmer(item);
		message = store.purchaseItem(item);
		return message;
	}
	
	public String createAnimalFoodThree() {
		item = new AnimalFoodThree();
		addItemsOwnedByFarmer(item);
		message = store.purchaseItem(item);
		return message;
	}
	
	public String createCarrot() {
		crop = new Carrot();
		message = store.purchaseCrop(crop);
		return message;
	}
	
	public String createCorn() {
		crop = new Corn();
		message = store.purchaseCrop(crop);
		return message;
	}
	
	public String createLettuce() {
		crop = new Lettuce();
		message = store.purchaseCrop(crop);
		return message;
	}
	
	public String createPotato() {
		crop = new Potato();
		message = store.purchaseCrop(crop);
		return message;
	}
	
	public String createRice() {
		crop = new Rice();
		message = store.purchaseCrop(crop);
		return message;
	}
	
	public String createWheat() {
		crop = new Wheat();
		message = store.purchaseCrop(crop);
		return message;
	}
	
	public Farm getFarm() {
		return farm;
	}
	
	public String getFarmName() {
		return farm.getFarmName();
	}
	
	public void addItemsOwnedByFarmer(Item item) {
		farmer.additemToList(item);
	}
	
	/*
	public void tendFarm(GameEnvironment game) {
		farmer.tendToFarmLand(game);
	}
	*/
	
	public void feedAnimal(Animal animalToBeFed, Item item) {
		animalToBeFed.feedAnimal(item);
	}
	
	public void playWithAnima(Animal animalToBePlayedWith) {
		animalToBePlayedWith.playWithAnimal();
	}
	
	public ArrayList<Item> getItemsOwnedByFarmer() {
		return farmer.getItemsOwned();
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
	
	/* Check that the user has entered the correct input */
	public boolean checkTextInput(String name) {
		
		char[] nameArray = name.toCharArray();
		
		if (name.length() < 3 || name.length() > 15) {
			return false;
		}
		
		for(int i = 0; i < name.length(); i++) {
			if (!(Character.isLetter(nameArray[i]))) {
				return false;
			}
		}
		
		return true;
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
		//launchAnimalWindow();
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
