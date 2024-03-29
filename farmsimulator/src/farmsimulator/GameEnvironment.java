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
	 * Creating/Instantiating a water item which is then added to the list of items owned by the farmer.
	 */
	public void createWater() {
		Water water = new Water();
		addItemsOwnedByFarmer(water);
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
	
	/** Takes crop user has chosen in combo box and creates and purchases that crop
	 * 
	 * 
	 * @param cropSelected			A string selected from the combo box to purchase.
	 * @return 							A string message to be displayed in the GUI, whether purchase was successful or not
	 */
	public String createCrop(String cropSelected) {
		switch (cropSelected) {
			case "Carrot":
				message = createCarrot();
				break;
			case "Corn":
				message = createCorn();
				break;
			case "Lettuce":
				message = createLettuce();
				break;
			case "Potato":
				message = createPotato();
				break;
			case "Rice":
				message = createRice();
				break;
			case "Wheat":
				message = createWheat();
				break;
		}
		return message;
	}
	
	
	/** Takes item user has chosen in combo box and creates and purchases that item
	 * 
	 * 
	 * @param itemSelected			A string selected from the combo box to purchase.
	 * @return 							A string message to be displayed in the GUI, whether purchase was successful or not
	 */
	public String createItem(String itemSelected) {
		switch (itemSelected) {
			case "A1":
				message = createAnimalFoodOne();
				break;
			case "A2":
				message = createAnimalFoodTwo();
				break;
			case "A3":
				message = createAnimalFoodThree();
				break;
			case "F1":
				message = createFertiliserOne();
				break;
			case "F2":
				message = createFertiliserTwo();
				break;
			case "F3":
				message = createFertiliserThree();
				break;
		}
		return message;
	}
	
	/**
	 * Takes animal user has chosen in combo box and creates and purchases that animal after checking name is valid
	 * 
	 *
	 * 
	 * @param animalSelected		The animal chosen by the user to purchase.
	 * @param nameSelected			The animal name input by the user.
	 * @return							A string message to be displayed in the GUI, whether purchase was successful or not
	 */
	public String createAnimalCheck(String animalSelected, String nameSelected) {
		switch (animalSelected) {
			case "Cow":
				message = cowNameValidCheck(nameSelected);
				break;
			case "Pig":
				message = pigNameValidCheck(nameSelected);
				break;
			case "Sheep":
				message = sheepNameValidCheck(nameSelected);
				break;
		}
		return message;
	}
	
	/**
	 * Harvests the crop that the user has chosen.
	 * 
	 * @param crop					A crop object that is to be harvested.
	 * @return							A string that tells the user whether they have successfully harvested their crop.
	 */
	public String harvestCrops(Crop crop) {
		if (getCropsOwned().size() == 0) {
			message = "There are no crops on your farm yet, visit the General Store to buy them!";
		}
		else if (crop == null) {
			message = "Select an crop to harvest!";
		}
		else {
			message = crop.harvestCrops(farmer, farm, getCropsOwned());
		}
		return message;
	}
	
	/**
	 * Fertilises the crop that the user has chosen with an item the user chooses, decreasing its time till harvest.
	 * 
	 * @param crop					A crop object that is to be fertilised.
	 * @param item					An item object used to fertilise the crop object.
	 * @return							A string that tells the user whether they have successfully fertilised their chosen crop using their item of choice.
	 */
	public String fertiliseCrop(Crop crop, Item item) {
		if (getCropsOwned().size() == 0) {
			message = "There are no crops on your farm yet, visit the General Store to buy them!";
		}
		else if (crop == null) {
			message = "Select a crop to Fertilise and Fertiliser to use!";
		}
		else {
			if (item == null) {
				message = "Select a Fertiliser to use!";
			}
			else {
				message = crop.tendCrops(item, farmer, getItemsOwnedByFarmer());
			}
		}
		return message;
	}
	
	/**
	 * Tend to farm, increases amount of crops that can be grown as well as animal's happiness.
	 * 
	 * @return 		A message stating whether the farm was tended to or not depending on if animals or crops are present.
	 */
	public String tendFarm() {
		if (getAnimalsOnFarm().size() == 0 && getCropsOwned().size() == 0) {
			message = "Your farm does not have any animals or crops yet, visit the General Store to buy them.";
		}
		else if (useFarmerAction() == true) {
			farmer.tendToFarmLand(getCropsOwned(), getAnimalsOnFarm());
			message = "You tended to your farm, crops have grown and animals are happier";
		}
		else {
			message = "You cannot perform this action as you have no actions left for today.";
		}
		return message;
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
	 * Each day there is a chance a random event occurs, this method determines what happens
	 * 
	 * @return							A string that tells the user if a random event has happened and what the consequences are							 
	 */
	public String randomEvent() {
		RandomEvent event = new RandomEvent();
		return event.decideRandomEvent(farm);
	}
	
	/**
	 * Feeds an animal chosen by the user using a food item that is chosen by the user.
	 * 
	 * @param animalToBeFed			An animal object that is to be fed.
	 * @param item					An item object used to feed animals.
	 * @return							A string that tells the user whether they have successfully fed their chosen animal using their item of choice.
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
	 * @param farmerNameChosen		A string which is the chosen farmer name by the user when setting up the game.
	 * @param farmerAgeChosen		An int which is then chosen farmer age by the user when setting up the game.
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
	 * @param inputAge			The input age.
	 * @return				A boolean which states whether the age is a valid age.
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
	 * Checks whether all the inputs entered by the user is valid.
	 * 
	 * @param farmerNameChosen				The farmer name input by the user.
	 * @param farmNameChosen				The farm name input by the user.
	 * @param farmerAgeChosen				The farmer age input by the user.
	 * @return						A string which tells the user if their input is invalid, if all input is valid the game can start.
	 */
	public String allUserInputValidCheck(String farmerNameChosen, String farmNameChosen, String farmerAgeChosen) {
		if (farmerNameChosen.length() == 0 || farmNameChosen.length() == 0 || farmerAgeChosen.length() == 0) {
			message = "You must not leave any fields blank!";
		}
		else if (userInputNameValid(farmerNameChosen) == false) {
			message = "Your FARMER name must contain between 3 and 15 characters (inclusive) and not contain any numbers or special characters!";
		}
		else if (userInputNameValid(farmNameChosen) == false ) {
			message =  "Your FARM name must contain between 3 and 15 characters (inclusive) and not contain any numbers or special characters!";
		}
		else if (userInputFarmerAgeValid(farmerAgeChosen) == false) {
			message = "Your FARMER age must be an integer between 20 and 75 (inclusive)!";
		}
		else {
			message = "All checks passed, all input by user is valid.";
		}
		
		return message;
	}
	
	/**
	 * Creates the farm chosen by the user with the farm name chosen by the user by calling the method which instantiates a farm.
	 * 
	 * @param farmNameChosen		The farm name chosen by the user.
	 * @param farmChosen			The farm chosen to play by the user.
	 */
	public void createFarmChosenByUser(String farmNameChosen, String farmChosen) {
		switch(farmChosen) {
			case "Farm A":
				createFarm(farmNameChosen, 1000, 2, 5, 3);
				break;
			case "Farm B":
				createFarm(farmNameChosen, 600, 1, 5, 9);
				break;
			case "Farm C":
				createFarm(farmNameChosen, 300, 7, 8, 9);
				break;
			case "Farm D":
				createFarm(farmNameChosen, 650, 6, 7, 6);
				break;
		}
		
	}
	
	/**
	 * Checks if the name input by the user for a cow is valid.
	 * 
	 * @param nameChosenForCow			The name of the Cow chosen by the user.
	 * @return						A string which states whether the cow name is valid, and if it is creates a new cow.
	 */
	public String cowNameValidCheck(String nameChosenForCow) {
		if (nameChosenForCow == null) {
			message = "Your purchase has been cancelled.";
		}
		else if (userInputNameValid(nameChosenForCow) == false) {
			message = "That's not a valid name for your cow! Your COW name "
					+ "must contain between 3 and 15 characters (inclusive) and not contain any numbers or special "
					+ "characters!";
		}
		else if (cowNameExists(nameChosenForCow) == true) {
			message = "That cow name already exists, pick another one!";
		}
		else {
			message = createCow(nameChosenForCow);
		}
		return message;
	}
	
	/**
	 * Checks if the name input by the user for the pig is valid.
	 * 
	 * @param nameChosenForPig				The name of the pig chosen by the user.
	 * @return							A string which states whether the pig name is valid, and if it is creates a new pig.
	 */
	public String pigNameValidCheck(String nameChosenForPig) {
		if (nameChosenForPig == null) {
			message = "Your purchase has been cancelled.";
		}
		else if (userInputNameValid(nameChosenForPig) == false) {
			message = "That's not a valid name for your Pig! Your PIG name "
					+ "must contain between 3 and 15 characters (inclusive) and not contain any numbers or special "
					+ "characters!";
		}
		else if (pigNameExists(nameChosenForPig) == true) {
				message = "That pig name already exists, pick another one!";
		}
		else {
			message = createPig(nameChosenForPig);
		}
		
		return message;
	}
	
	/**
	 * Checks if the name input by the user for the sheep is valid.
	 * 
	 * @param nameChosenForSheep				The name of the sheep chosen by the user.
	 * @return							A string which states whether the sheep name is valid, and if it is creates a new sheep.
	 */
	public String sheepNameValidCheck(String nameChosenForSheep) {
		if (nameChosenForSheep == null) {
			message = "Your purchase has been cancelled.";
		}
		else if (userInputNameValid(nameChosenForSheep) == false) {
			message = "That's not a valid name for your Sheep! Your SHEEP name "
					+ "must contain between 3 and 15 characters (inclusive) and not contain any numbers or special "
					+ "characters!";
		}
		else if (sheepNameExists(nameChosenForSheep) == true) {
				message = "That sheep name already exists, pick another one!";
		}
		else {
			message = createSheep(nameChosenForSheep);
		}
		
		return message;
	}
	
	/**
	 * Begins the music for the game as soon as the game has started.
	 */
	public void playMusic() {
		MusicPlayer music = new MusicPlayer();
		music.playMusic();
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
	 * Closes the purchase animal window.
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
	 * @param args		Command line arguments.
	 */
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetUpScreen();
		game.playMusic();
	}
}

