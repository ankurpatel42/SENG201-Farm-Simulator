package farmsimulator;

import java.util.ArrayList;

/** This class is the main class for the game, it
 *  contains all the game logic such as variables
 * and methods that are used with other classes.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */

public class GameEnvironment {
	
	/**
	 * The farmer object, this is the object controlled by the user/player.
	 */
	private Farmer farmer = null;
	/**
	 * The length of the game specified by the user. 
	 */
	private int gameLength = 0;
	/**
	 * The farm object, this is the object that the user specifies by choosing one of four Farm objects to create.
	 */
	private Farm farm;
	/**
	 * The Animal object, animal objects are created and placed on the Farm after being purchased by the user from the General Store.
	 */
	private Animal animal;
	/**
	 * The Crop object, crop objects are created and placed on the Farm after being purchased by the user from the General Store.
	 */
	private Crop crop;
	/**
	 * The Item object, item objects are created and placed on the Farm after being purchased by the user from the General Store.
	 */
	private Item item;
	/**
	 * The GeneralStore object, the GeneralStore object is where the user purchases/creates Animal, Crop, and Item objects.
	 */
	private GeneralStore store;
	/** 
	 * The message displayed to the user after performing actions within the game.
	 */
	private String message;
	
	/**
	 * Creates/Instantiates the farm after showing the characteristics to the user. The Farm is intialized with certain values depending 
	 * on what Farm option the user has chosen.
	 * 
	 * @param farmNameChosen		The farm name chosen by the user.			
	 * @param moneyAvailable		The current amount of money available to the user when the game begins.
	 * @param cropGrowthRate		The crop growth rate of the farm.
	 * @param animalHealthiness		The initial healthiness of animals on the farm.
	 * @param animalHappiness		The initial happiness of animals on the farm.
	 */
	public void createFarm(String farmNameChosen, double moneyAvailable, int cropGrowthRate, int animalHealthiness, int animalHappiness) {
		farm = new Farm(farmNameChosen, moneyAvailable, cropGrowthRate, animalHealthiness, animalHappiness);
	}
	
	/**
	 * Creating/Instantiating the general store.
	 */
	public void createGeneralStore() {
		store = new GeneralStore();
	}
	
	/**
	 * Creates/Instantiates an Animal object of type Cow after the user has successfully purchased it from the General Store. The animal's
	 * happiness and healthiness attributes are initialised to the Farm's initial animal healthiness and happiness.
	 * 
	 * @param nameForCow			The cow name chosen by the user.
	 * @return							A string that will tell the user whether or not they have successfully purchased their animal.
	 */
	public String createCow(String nameForCow) {
		animal = new Cow(nameForCow, farm.getInitialAnimalHappiness(), farm.getInitialAnimalHealthiness());
		message = store.purchaseAnimal(animal, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates an Animal object of type Pig after the user has successfully purchased it from the General Store. The animal's
	 * happiness and healthiness attributes are initialised to the Farm's initial animal healthiness and happiness.
	 * 
	 * @param nameForPig			The pig name chosen by the user.
	 * @return							A string that will tell the user whether or not they have successfully purchased their animal.
	 */
	public String createPig(String nameForPig) {
		animal = new Pig(nameForPig, farm.getInitialAnimalHappiness(), farm.getInitialAnimalHealthiness());
		message = store.purchaseAnimal(animal, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates an Animal object of type Sheep after the user has successfully purchased it from the General Store. The animal's
	 * happiness and healthiness attributes are initialised to the Farm's initial animal healthiness and happiness.
	 *  
	 * @param nameForSheep			The sheep name chosen by the user.
	 * @return							A string that will tell the user whether or not they have successfully purchased their animal.
	 */
	public String createSheep(String nameForSheep) {
		animal = new Sheep(nameForSheep, farm.getInitialAnimalHappiness(), farm.getInitialAnimalHealthiness());
		message = store.purchaseAnimal(animal, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates an Item object of type FertiliserOne after the user has successfully purchased it from the General Store.
	 * 
	 * @return							A string that will tell the user whether or not they have successfully purchased their item.
	 */
	public String createFertiliserOne() {
		item = new FertiliserOne();
		message = store.purchaseItem(item, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates an Item object of type FertiliserTwo after the user has successfully purchased it from the General Store.
	 * 
	 * @return							A string that will tell the user whether or not they have successfully purchased their item.
	 */
	public String createFertiliserTwo() {
		item = new FertiliserTwo();
		message = store.purchaseItem(item, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates an Item object of type FertiliserThree after the user has successfully purchased it from the General Store.
	 * 
	 * @return							A string that will tell the user whether or not they have successfully purchased their item.
	 */
	public String createFertiliserThree() {
		item = new FertiliserThree();
		message = store.purchaseItem(item, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates an Item object of type AnimalFoodOne after the user has successfully purchased it from the General Store.
	 * 
	 * @return							A string that will tell the user whether or not they have successfully purchased their item.
	 */
	public String createAnimalFoodOne() {
		item = new AnimalFoodOne();
		message = store.purchaseItem(item, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates an Item object of type AnimalFoodTwo after the user has successfully purchased it from the General Store.
	 * 
	 * @return							A string that will tell the user whether or not they have successfully purchased their item.
	 */
	public String createAnimalFoodTwo() {
		item = new AnimalFoodTwo();
		message = store.purchaseItem(item, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates an Item object of type AnimalFoodThree after the user has successfully purchased it from the General Store.
	 * 
	 * @return							A string that will tell the user whether or not they have successfully purchased their item.
	 */
	public String createAnimalFoodThree() {
		item = new AnimalFoodThree();
		message = store.purchaseItem(item, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates a Crop object of type Carrot after the user has successfully purchased it from the General Store.
	 * 
	 * @return							A string that will tell the user whether or not they have successfully purchased their crop.
	 */
	public String createCarrot() {
		crop = new Carrot();
		message = store.purchaseCrop(crop, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates a Crop object of type Corn after the user has successfully purchased it from the General Store.
	 * 
	 * @return							A string that will tell the user whether or not they have successfully purchased their crop.
	 */
	public String createCorn() {
		crop = new Corn();
		message = store.purchaseCrop(crop, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates a Crop object of type Lettuce after the user has successfully purchased it from the General Store.
	 * 
	 * @return							A string that will tell the user whether or not they have successfully purchased their crop.
	 */
	public String createLettuce() {
		crop = new Lettuce();
		message = store.purchaseCrop(crop, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates a Crop object of type Potato after the user has successfully purchased it from the General Store.
	 * 
	 * @return							A string that will tell the user whether or not they have successfully purchased their crop.
	 */
	public String createPotato() {
		crop = new Potato();
		message = store.purchaseCrop(crop, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates a Crop object of type Rice after the user has successfully purchased it from the General Store.
	 * 
	 * @return							A string that will tell the user whether or not they have successfully purchased their crop.
	 */
	public String createRice() {
		crop = new Rice();
		message = store.purchaseCrop(crop, farm);
		return message;
	}
	
	/**
	 * Creates/Instantiates a Crop object of type Wheat after the user has successfully purchased it from the General Store.
	 * 
	 * @return							A string that will tell the user whether or not they have successfully purchased their crop.
	 */
	public String createWheat() {
		crop = new Wheat();
		message = store.purchaseCrop(crop, farm);
		return message;
	}
	
	/**
	 * Gets the farm of which the user is using to currently play the game.
	 * 
	 * @return							The farm object that the user selected when setting up the game.
	 */
	public Farm getFarm() {
		return farm;
	}
	
	/**
	 * Gets the farm name which the user specified when setting up the game.
	 * 
	 * @return							A string which is the farm name specified by the user when setting up the game.
	 */
	public String getFarmName() {
		return farm.getFarmName();
	}
	
	/** Adds the item to the currently owned items of the user.
	 * 
	 * 
	 * @param item					An item object that is added to the items currently owned.
	 */
	public void addItemsOwnedByFarmer(Item item) {
		farm.addNewItem(item);
	}
	
	/**
	 * Harvests the crop that the user has chosen.
	 * 
	 * @param crop					A crop object that is to be harvested.
	 * @return							A string that tells the user whether they have successfully harvested their crop.
	 */
	public String harvestCrops(Crop crop) {
		return crop.harvestCrops(farmer, farm, getCropsOwned());
	}
	
	/**
	 * Fertilises the crop that the user has chosen with an item the user chooses, decreasing its time till harvest.
	 * 
	 * @param crop					A crop object that is to be fertilised.
	 * @param item					An item object used to fertilise the crop object.
	 * @return							A string that tells the user whether they have successfully fertilised their chosen crop using their item of choice.
	 */
	public String fertiliseCrop(Crop crop, Item item) {
		return crop.tendCrops(item, farmer, getItemsOwnedByFarmer());
	}
	
	/**
	 * Tend to farm, increases amount of crops that can be grown as well as animal's happiness.
	 * 
	 */
	public void tendFarm() {
		farmer.tendToFarmLand(getCropsOwned(), getAnimalsOnFarm());
	}
	
	/**
	 * User/Farmer moves to the next day, the days left on the Farm decrease by 1.
	 * 
	 * @return							A string that tells the user they have moved to the next day and what day their journey is now on.							 
	 */
	public String nextDay() {
		return farmer.moveToNextDay(farm, getCropsOwned(), getItemsOwnedByFarmer(), getAnimalsOnFarm(), getGameLength());
	}
	
	/**
	 * Feeds an animal chosen by the user using a food item that is chosen by the user.
	 * 
	 * @param animalToBeFed			An animal object that is to be fed.
	 * @param item					An item object used to feed animals.
	 * @return							A string that tells the user whetehr they have successfully fed their chosen animal using their item of choice.
	 */
	public String feedAnimal(Animal animalToBeFed, Item item) {
		return animalToBeFed.feedAnimal(item, farmer, getItemsOwnedByFarmer());
	}
	
	/**
	 * Plays with animal chosen by the user.
	 * 
	 * @param animalToBePlayedWith	An animal object that is to be played with.
	 * @return							A string that tells the user whether they have successfully played with their animal.
	 */
	public String playWithAnimal(Animal animalToBePlayedWith) {
		return animalToBePlayedWith.playWithAnimal(farmer);
	}
	
	/**
	 * All the animals currently on the farm.
	 * 
	 * @return							An arraylist that holds animal objects currently on the farm.
	 */
	public ArrayList<Animal> getAnimalsOnFarm() {
		return farm.getAnimalList();
	}
	
	/**
	 * The final animal status for the all the animals on the farm after the game has finished.
	 * 
	 * @return							A double that calculates the cumulative animal healthiness and happiness of each animal on the farm.
	 */
	public double getFinalAnimalStatus() {
		ArrayList<Animal> finalAnimals = getAnimalsOnFarm();
		
		double totalAnimalStatus = 0;
		
		for(Animal animal: finalAnimals) {
			totalAnimalStatus = totalAnimalStatus + animal.getAnimalHappiness() + animal.getAnimalHealthiness();
		}
		
		return totalAnimalStatus;
	}
	
	/**
	 * The Items currently owned.
	 * 
	 * @return							An arraylist of item objects currently on the farm.
	 */
	public ArrayList<Item> getItemsOwnedByFarmer() {
		return farm.getItemsOwned();
	}
	
	/**
	 * All the crops currently on the farm.
	 * 
	 * @return							An arraylist of crop objects currently on the farm.
	 */
	public ArrayList<Crop> getCropsOwned() {
		return farm.getCropList();
	}
	
	/**
	 * The current money available.
	 * 
	 * @return							A double which is the current amount of money available.
	 */
	public double getFarmMoneyAvailable() {
		return farm.getMoneyAvailable();
	}
	
	/**
	 * Set the amount of money available to a new value.
	 * 
	 * @param money					A double which is the new amount of money available.
	 */
	public void setFarmMoneyAvailable(double money) {
		farm.setMoneyAvailable(money);
	}
	
	/**
	 * The crop growth rate of the farm
	 * 
	 * @return						A double which is the crop growth of the farm selected by the user when setting up the game.
	 */
	public double getFarmCropGrowthRate() {
		return farm.getCropGrowthRate();
	}
	
	/**
	 * Creates/Instantiates the farmer object.
	 * 
	 * @param farmerNameChosen	A string which is the chosen farmer name by the user when setting up the game.
	 */
	public void setFarmer(String farmerNameChosen, int farmerAgeChosen) {
		farmer = new Farmer(farmerNameChosen, farmerAgeChosen);
	}
	
	/**
	 * Gets the farmer object
	 * 
	 * @return						A farmer object.
	 */
	public Farmer getFarmer() {
		return farmer;
	}
	
	/**
	 * Gets the user's farmer name they specified when setting up the game.
	 * 
	 * @return						A string which shows the farmer name chosen by the user.
	 */
	public String getFarmerName() {
		return farmer.getFarmerName();
	}
	
	/**
	 * Farmer uses an action after performing a task.
	 * 
	 * @return						A boolean which determines whether the farmer can perform an action or not depending on how many actions they have already used for the day.
	 */
	public Boolean useFarmerAction() {
		return farmer.useAction();
	}
	
	/**
	 * The amount of actions the farmer has left for the day.
	 * 
	 * @return						An integer which shows the number of actions left for the day.
	 */
	public int getFarmerActionsLeft() {
		return farmer.getActionsLeft();
	}
	
	/**
	 * Sets the game length, chosen by the user.
	 * 
	 * @param numDaysChosen		An integer which is the chosen game length by the user when setting up the game.
	 */
	public void setGameLength(int numDaysChosen) {
		gameLength = numDaysChosen;
	}
	
	/**
	 * Gets the game length which was chosen by the user
	 * 
	 * @return						An integer that shows how many days the game is to last.
	 */
	public int getGameLength() {
		return gameLength;
	}

	/**
	 * Checks whether or not what the user has entered for Farm, Farmer, and Animal names is valid.
	 * 
	 * @param name				A string which the user has entered as input for names.
	 * @return						A boolean which determines whether or not the user input is valid.
	 */
	public boolean userInputNameValid(String name) {
		
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
	
	/**
	 * Checks whether or not the farmer age input by the user is valid.
	 * 
	 * @param age
	 * @return
	 */
	public boolean userInputFarmerAgeValid(String inputAge) {
		try {
			Integer.parseInt(inputAge);
			if (Integer.parseInt(inputAge) < 20 || Integer.parseInt(inputAge) > 75) {
				return false;
			}
			else {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Checks whether the cow name entered by the user already exists or not.
	 * 
	 * @param cowNameChosen			The cow name chosen by the user.
	 * @return							A boolean which states whether the cow name exists or not.
	 */
	public boolean cowNameExists(String cowNameChosen) {
		if (farm.cowNameExists(cowNameChosen) == true) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks whether the pig name entered by the user already exists or not.
	 * 
	 * @param pigNameChosen			The pig name chosen by the user.
	 * @return							A boolean which states whether the pig name exists or not.
	 */
	public boolean pigNameExists(String pigNameChosen) {
		if (farm.pigNameExists(pigNameChosen) == true) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks whether the sheep name entered by the user already exists or not.
	 * 
	 * @param sheepNameChosen		The sheep name chosen by the user.
	 * @return							A boolean which states whether the sheep name exists or not.
	 */
	public boolean sheepNameExists(String sheepNameChosen) {
		if (farm.sheepNameExists(sheepNameChosen) == true) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Launches the setup screen window.
	 */
	public void launchSetUpScreen() {
		SetUpScreen setUpScreenWindow = new SetUpScreen(this);
	}
	
	/**
	 * Closes the setup screen window.
	 * 
	 * @param setUpScreenFrame	A SetUpScreen object which is the setup screen window.	
	 */
	public void closeSetUpScreen(SetUpScreen setUpScreenFrame) {
		setUpScreenFrame.closeSetUpScreen();
		launchMainScreen();
	}
	
	/**
	 * Launches the main screen window.
	 */
	public void launchMainScreen() {
		MainScreen mainScreenFrame = new MainScreen(this);
	}
	
	/**
	 * Closes the main screen window.
	 * 
	 * @param mainScreen		A MainScreen object which is the main screen window.
	 */
	public void closeMainScreen(MainScreen mainScreen) {
		mainScreen.closeMainScreen();
	}
	
	/**
	 * Launches the animal window.
	 */
	public void launchAnimalWindow() {
		AnimalWindow animalWindow = new AnimalWindow(this);
	}
	
	/**
	 * Closes the animal window.
	 * 
	 * @param animalWindow		A AnimalWindow object which is the animal window.
	 */
	public void closeAnimalWindow(AnimalWindow animalWindow) {
		animalWindow.closeAnimalWindow();
	}
	
	/**
	 * Launches the store window.
	 */
	public void launchStoreWindow() {
		StoreWindow storeWindow = new StoreWindow(this);
	}
	
	public void closeStoreWindow(StoreWindow storeWindowFrame) {
		storeWindowFrame.closeStoreWindow();
	}
	
	/**
	 * Launches the purchase animal window.
	 */
	public void launchPurchaseAnimalWindow() {
		PurchaseAnimal purchaseAnimalWindow = new PurchaseAnimal(this);
	}
	
	/**
	 * Closes the purchae animal window.
	 * 
	 * @param purchaseAnimalFrame		A PurchaseAnimal object which is the purchae animal window.
	 */
	public void closePurchaseAnimalWindow(PurchaseAnimal purchaseAnimalFrame) {
		purchaseAnimalFrame.closePurchaseAnimalWindow();
	}
	
	/**
	 * Launches the purchase crop window.
	 */
	public void launchPurchaseCropWindow() {
		PurchaseCrop purchaseCropWindow = new PurchaseCrop(this);
	}
	
	/**
	 * Closes the purchase crop window.
	 * 
	 * @param purchaseCropFrame		A PurchaseCrop object which is the purchase crop window.
	 */
	public void closePurchaseCropWindow(PurchaseCrop purchaseCropFrame) {
		purchaseCropFrame.closePurchaseCropWindow();
	}
	
	/**
	 * Launches the purchase items window.
	 */
	public void launchPurchaseItemWindow() {
		PurchaseItem purchaseItemWindow = new PurchaseItem(this);
	}
	
	/**
	 * Closes the purchase item window.
	 * 
	 * @param purchaseItemFrame		A PurchaseItem object which is the purchase item window.
	 */
	public void closePurchaseItemWindow(PurchaseItem purchaseItemFrame) {
		purchaseItemFrame.closePurchaseItemWindow();
	}
	
	/**
	 * Launches the crop window.
	 */
	public void launchCropWindow() {
		CropWindow cropWindow = new CropWindow(this);
	}
	
	/**
	 * Closes the crop window.
	 * 
	 * @param cropWindow		A CropWindow object which is the crop window.
	 */
	public void closeCropWindow(CropWindow cropWindow) {
		cropWindow.closeCropWindow();
	}
	
	/**
	 * Launches the final screen window.
	 */
	public void launchFinalScreen() {
		FinalScreen finalScreen = new FinalScreen(this);
	}
	
	/**
	 * Closes the final screen window.
	 * 
	 * @param finalScreen		A FinalScreen object which is the final screen window.
	 */
	public void closeFinalScreen(FinalScreen finalScreen) {
		finalScreen.closeFinalScreen();
	}
	
	/**
	 * The main method of the game, this is where the program begins by instantiating a game object and calling the launchSetUpScreen() method.
	 * 
	 * @param args		command line arguments for the application (not applicable here)
	 */
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetUpScreen();
	}
}


