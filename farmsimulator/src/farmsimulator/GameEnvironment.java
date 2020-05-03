package farmsimulator;

import java.util.Scanner;

public class GameEnvironment {
	
	private static Scanner scanner = new Scanner(System.in);
	private static int gameLength = 0;
	
	public static void gameLengthChosen() {
		
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
		
	}
	
	public static String farmerNameChosen() {
		
		String farmerName = scanner.nextLine();
		char[] farmerNameArray = farmerName.toCharArray();
		boolean farmerNameHasDigit = false;
		boolean farmerNameContainsSpecialCharacter = false;
		String specialCharacters = "!@#$%^&\\*()}{][/?.<>,;+ ";
		
		for(int i = 0; i < farmerName.length(); i++) {
			if (Character.isDigit(farmerNameArray[i])) {
				farmerNameHasDigit = true;
			}
			if (specialCharacters.contains(Character.toString(farmerNameArray[i]))) {
				farmerNameContainsSpecialCharacter = true;
			}
		}
		
		//Infinite loop that terminates only once the user has entered valid farm name according to specifications.
		while(true) {
			if (farmerName.length() < 3 || farmerName.length() > 15 || farmerNameHasDigit == true || farmerNameContainsSpecialCharacter == true) {
				System.out.print("Your farmer name must contain between 3 and 15 characters (inclusive) and not contain any numbers or special characters: ");
				farmerNameHasDigit = false;
				farmerNameContainsSpecialCharacter = false;
				farmerName = scanner.nextLine();
			} 
			else {
				break;
			}
		}
		
		return farmerName;
	}
	
	public static void farmChosenValid() {
		
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
					farmType(numFarm);
					break;
				}
			} catch (NumberFormatException e) {
				System.out.print("Please select a number between 1 and 4 (inclusive): ");
				farmChosen = scanner.nextLine();
			}
		}
		
		System.out.println("You have selected option: " + farmChosen );
	}
	
	public static void farmOptionsForPlayer() {
		
		System.out.println("What farm would you like to begin your journey on? Choose from the list below.");
		System.out.println("1. Farm A");
		System.out.println("2. Farm B");
		System.out.println("3. Farm C");
		System.out.println("4. Farm D");
		System.out.print("Please enter a number to choose what farm you would like to work with: ");
	}
	
	
	public static void farmType(int optionChosen) {
		if (optionChosen == 1) {
			Farm.setMoneyAvailible(100);
			Farm.setCropGrowthRate(2);
			Farm.setStartingAnimalHealthiness(4);
			Farm.setStartingAnimalHappiness(3);
		}
		else if (optionChosen == 2) {
			Farm.setMoneyAvailible(300);
			Farm.setCropGrowthRate(3);
			Farm.setStartingAnimalHealthiness(5);
			Farm.setStartingAnimalHappiness(5);
		}
		else if (optionChosen == 3) {
			Farm.setMoneyAvailible(500);
			Farm.setCropGrowthRate(2);
			Farm.setStartingAnimalHealthiness(7);
			Farm.setStartingAnimalHappiness(6);
		} 
		else if (optionChosen == 4) {
			Farm.setMoneyAvailible(20);
			Farm.setCropGrowthRate(3);
			Farm.setStartingAnimalHealthiness(1);
			Farm.setStartingAnimalHappiness(3);
		}
		else {
			System.out.println("You have not entered a valid option.");
		}
		
		
	}
	
	
	public static void SetUpGame() {
		
		System.out.print("How many days would you like the game to last? (Choose between 5 and 10 days): ");
		gameLengthChosen();
		
	}
	
	public static int getGameLength() {
		return gameLength;
	}
	
	public static void createFarm() {
		
		System.out.print("Give your farmer a name: ");
		
		String farmerName = farmerNameChosen();
		
		//instatiate farmer after user gives farmer their name
		Farmer farmer = new Farmer(farmerName);
		System.out.println(farmer);
		
		farmOptionsForPlayer();
		
		farmChosenValid();
		
		scanner.close();
	}
	
	public static void MainGame() {
		
	}
		

	public static void main(String[] args) {
		SetUpGame();
		createFarm();
		MainGame();
		
	}

}
