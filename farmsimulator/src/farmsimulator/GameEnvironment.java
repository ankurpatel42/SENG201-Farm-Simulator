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
	
	public void createFarm(String farmNameChosen, double moneyAvailable, int cropGrowthRate, int animalHealthiness, int animalHappiness) {
		farm = new Farm(farmNameChosen, moneyAvailable, cropGrowthRate, animalHealthiness, animalHappiness);
	}
	
	public void createGeneralStore() {
		store = new GeneralStore();
	}
	
	
	public String createCow(String nameForCow) {
		animal = new Cow(nameForCow, farm.getInitialAnimalHappiness(), farm.getInitialAnimalHealthiness());
		message = store.purchaseAnimal(animal, this);
		return message;
	}
	
	public String createPig(String nameForPig) {
		animal = new Pig(nameForPig, farm.getInitialAnimalHappiness(), farm.getInitialAnimalHealthiness());
		message = store.purchaseAnimal(animal, this);
		return message;
	}
	
	public String createSheep(String nameForSheep) {
		animal = new Sheep(nameForSheep, farm.getInitialAnimalHappiness(), farm.getInitialAnimalHealthiness());
		message = store.purchaseAnimal(animal, this);
		return message;
	}
	
	public String createFertiliserOne() {
		item = new FertiliserOne();
		message = store.purchaseItem(item, this);
		return message;
	}
	
	public String createFertiliserTwo() {
		item = new FertiliserTwo();
		message = store.purchaseItem(item, this);
		return message;
	}
	
	public String createFertiliserThree() {
		item = new FertiliserThree();
		message = store.purchaseItem(item, this);
		return message;
	}
	
	public String createAnimalFoodOne() {
		item = new AnimalFoodOne();
		message = store.purchaseItem(item, this);
		return message;
	}
	
	public String createAnimalFoodTwo() {
		item = new AnimalFoodTwo();
		message = store.purchaseItem(item, this);
		return message;
	}
	
	public String createAnimalFoodThree() {
		item = new AnimalFoodThree();
		message = store.purchaseItem(item, this);
		return message;
	}
	
	public String createCarrot() {
		crop = new Carrot();
		message = store.purchaseCrop(crop, this);
		return message;
	}
	
	public String createCorn() {
		crop = new Corn();
		message = store.purchaseCrop(crop, this);
		return message;
	}
	
	public String createLettuce() {
		crop = new Lettuce();
		message = store.purchaseCrop(crop, this);
		return message;
	}
	
	public String createPotato() {
		crop = new Potato();
		message = store.purchaseCrop(crop, this);
		return message;
	}
	
	public String createRice() {
		crop = new Rice();
		message = store.purchaseCrop(crop, this);
		return message;
	}
	
	public String createWheat() {
		crop = new Wheat();
		message = store.purchaseCrop(crop, this);
		return message;
	}
	
	public Farm getFarm() {
		return farm;
	}
	
	public String getFarmName() {
		return farm.getFarmName();
	}
	
	public void addItemsOwnedByFarmer(Item item) {
		farm.addNewItem(item);
	}
	
	public String harvestCrops(Crop crop) {
		return crop.harvestCrops(this);
	}
	
	public String fertiliseCrop(Crop crop, Item item) {
		return crop.tendCrops(item, this);
	}
	
	
	public void tendFarm() {
		farmer.tendToFarmLand(this);
	}
	
	public String nextDay() {
		return farmer.moveToNextDay(this);
	}
	
	public String feedAnimal(Animal animalToBeFed, Item item) {
		return animalToBeFed.feedAnimal(item, this);
	}
	
	public String playWithAnimal(Animal animalToBePlayedWith) {
		return animalToBePlayedWith.playWithAnimal(this);
	}
	
	public ArrayList<Animal> getAnimalsOnFarm() {
		return farm.getAnimalList();
	}
	
	public double getFinalAnimalStatus() {
		ArrayList<Animal> finalAnimals = getAnimalsOnFarm();
		
		double totalAnimalStatus = 0;
		
		for(Animal animal: finalAnimals) {
			totalAnimalStatus = totalAnimalStatus + animal.getAnimalHappiness() + animal.getAnimalHealthiness();
		}
		
		return totalAnimalStatus;
	}
	
	public ArrayList<Item> getItemsOwnedByFarmer() {
		return farm.getItemsOwned();
	}
	
	public ArrayList<Crop> getCropsOwned() {
		return farm.getCropList();
	}
	
	public double getFarmMoneyAvailable() {
		return farm.getMoneyAvailable();
	}
	
	public void setFarmMoneyAvailable(double money) {
		farm.setMoneyAvailable(money);
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
	
	public Boolean useFarmerAction() {
		return farmer.useAction();
	}
	
	public int getFarmerActionsLeft() {
		return farmer.getActionsLeft();
	}
	
	public void setGameLength(int numDaysChosen) {
		gameLength = numDaysChosen;
	}
	
	
	public int getGameLength() {
		return gameLength;
	}
	
	/* Check that the user has entered the correct input */
	public boolean userInputValid(String name) {
		
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
		SetUpScreen setUpScreenWindow = new SetUpScreen(this);
	}
	
	public void closeSetUpScreen(SetUpScreen setUpScreenFrame) {
		setUpScreenFrame.closeSetUpScreen();
		launchMainScreen();
	}
	
	public void launchMainScreen() {
		MainScreen mainScreenFrame = new MainScreen(this);
	}
	
	public void closeMainScreen(MainScreen mainScreen) {
		mainScreen.closeMainScreen();
		//launchAnimalWindow();
	}
	
	public void launchAnimalWindow() {
		AnimalWindow animalWindow = new AnimalWindow(this);
	}
	
	public void closeAnimalWindow(AnimalWindow animalWindow) {
		animalWindow.closeAnimalWindow();
	}
	
	public void launchStoreWindow() {
		StoreWindow storeWindow = new StoreWindow(this);
	}
	
	public void launchPurchaseAnimalWindow() {
		PurchaseAnimal purchaseAnimalWindow = new PurchaseAnimal(this);
	}
	
	public void closePurchaseAnimalWindow(PurchaseAnimal purchaseAnimalFrame) {
		purchaseAnimalFrame.closePurchaseAnimalWindow();
	}
	
	public void launchPurchaseCropWindow() {
		PurchaseCrop purchaseCropWindow = new PurchaseCrop(this);
	}
	
	public void closePurchaseCropWindow(PurchaseCrop purchaseCropFrame) {
		purchaseCropFrame.closePurchaseCropWindow();
	}
	
	public void launchPurchaseItemWindow() {
		PurchaseItem purchaseItemWindow = new PurchaseItem(this);
	}
	
	public void closePurchaseItemWindow(PurchaseItem purchaseItemFrame) {
		purchaseItemFrame.closePurchaseItemWindow();
	}
	
	public void launchCropWindow() {
		CropWindow cropWindow = new CropWindow(this);
	}
	
	public void closeCropWindow(CropWindow cropWindow) {
		cropWindow.closeCropWindow();
	}
	
	public void launchFinalScreen() {
		FinalScreen finalScreen = new FinalScreen(this);
	}
	
	public void closeFinalScreen(FinalScreen finalScreen) {
		finalScreen.closeFinalScreen();
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetUpScreen();
	}
}
