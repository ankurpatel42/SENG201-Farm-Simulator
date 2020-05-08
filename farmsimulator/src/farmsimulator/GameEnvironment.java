package farmsimulator;

import java.util.Scanner;

public class GameEnvironment {
	
	private static Scanner scanner = new Scanner(System.in);
	private static int gameLength = 0;
	private static Farmer farmer = null;
	private static Farm farm = null; //Not sure whether to leave this private or make public, if public change 'getFarm()' to 'farm' in other 
	//classes (Crop, Farmer, GeneralStore)
	
	public static Farm getFarm() {
		return farm;
	}
	
	public static int getGameLength() {
		return gameLength;
	}
	
	private static int farmChosenValid() {
		
		int farmNumberChosen = 0;
		String farmChosen = scanner.nextLine();
		
		//Infinite loop that terminates only once the user has entered a valid farm number according to specifications.
		while(true) {
			try {
				int numFarm = Integer.parseInt(farmChosen);
				if (numFarm < 1 || numFarm > 4) {
					System.out.print("Please select a number between 1 and 4 (inclusive): ");
					farmChosen = scanner.nextLine();
				} 
				else {
					farmNumberChosen = numFarm;
					break;
				}
			} catch (NumberFormatException e) {
				System.out.print("Please select a number between 1 and 4 (inclusive): ");
				farmChosen = scanner.nextLine();
			}
		}
		
		System.out.println("You have selected option: " + farmChosen );
		
		return farmNumberChosen;
	}
	
	private static void farmOptionsForPlayer() {
		
		System.out.println("What farm would you like to begin your journey on? Choose from the list below.");
		System.out.println("1. Farm A");
		System.out.println("2. Farm B");
		System.out.println("3. Farm C");
		System.out.println("4. Farm D");
		System.out.print("Please enter a number to choose what farm you would like to work with: ");
	}
	
	private static boolean checkCharsValid(String name) {
		
		char[] farmerNameArray = name.toCharArray();
		
		for(int i = 0; i < name.length(); i++) {
			if (!(Character.isLetter(farmerNameArray[i]))) {
				return false;
			}
		}
		
		return true;
	}
	
	
	private static String nameChosen(String nameFor) {
		
		String farmerName = scanner.nextLine();
		
		//Infinite loop that terminates only once the user has entered valid farm name according to specifications.
		while(true) {
			if (farmerName.length() < 3 || farmerName.length() > 15 || checkCharsValid(farmerName) == false) {
				System.out.print("Your " + nameFor + " farmer name must contain between 3 and 15 characters (inclusive) and not contain any numbers or special characters: ");
				//farmerNameNotValid = false;
				farmerName = scanner.nextLine();
			} 
			else {
				break;
			}
		}
		
		return farmerName;
	}
	
	
	private static void createFarm() {
		
		System.out.print("Give your farmer a name: ");
		
		String farmerName = nameChosen("farmer");
		
		//instatiate farmer after user gives farmer their name
		farmer = new Farmer(farmerName);
		
		System.out.print("Name your farm: ");
		String farmName = nameChosen("farm");
		
		farmOptionsForPlayer();
		
		int farmNumberChosen = farmChosenValid();
		
		switch (farmNumberChosen) {
			case 1:
				farm = new Farm(farmName, 1000.00, 2.5, 5, 3);
				break;
			case 2:
				farm = new Farm(farmName, 600, 1.5, 5, 9);
				break;
			case 3:
				farm = new Farm(farmName, 300, 7.5, 8, 9);
				break;
			case 4:
				farm = new Farm(farmName, 650, 6.0, 7, 6);
				break;
		}
	}
			
	
	private static void SetUpGame() {
		
		System.out.print("How many days would you like the game to last? (Choose between 5 and 10 days): ");
		
		String numberOfDaysChosen = scanner.nextLine();
		
		while(true) {
			try {
				int numDays = Integer.parseInt(numberOfDaysChosen);
				if (numDays < 5 || numDays > 10) {
					System.out.print("Please enter a number between 5 and 10 (inclusive): ");
					numberOfDaysChosen = scanner.nextLine();
				} 
				else {
					gameLength = numDays;
					break;
				}
				
			} catch (NumberFormatException e) {
				System.out.print("Please enter a number between 5 and 10 (inclusive): ");
				numberOfDaysChosen = scanner.nextLine();
			}
		}
		
		createFarm();
		
	}
	
	
	private static void MainGame() {
		
		System.out.print("Choose something: ");
		int number = scanner.nextInt();
		
		while (true) {
			if (number == 1) {
				if (farmer.getDayNum() > gameLength) {
					System.out.println("You have completed the game!");
					System.out.println("Final Money: " + farm.getMoneyAvailable());
					//Farm Score
					break;
				}
				farmer.moveToNextDay();
				System.out.print("Choose something: ");
				number = scanner.nextInt();
			} 
		}
		
		scanner.close();
	}
	

	public static void main(String[] args) {
		SetUpGame();
		MainGame();
	}

}
