package farmsimulator;

import java.util.Scanner;

public class GameEnvironment {
	
	public static void SetUpGame() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("How many days would you like the game to last? (Choose between 5 and 10 days): ");
		
		int numberOfDaysChosen = scanner.nextInt();
		
		while (numberOfDaysChosen < 5 || numberOfDaysChosen > 10) {
			System.out.print("Please enter a number between 5 and 10: ");
			numberOfDaysChosen = scanner.nextInt();
		}
		
		System.out.println("What farm would you like to begin your journey on? Choose from the list below.");
		System.out.println("1. Farm A");
		System.out.println("2. Farm B");
		System.out.println("3. Farm C");
		System.out.println("4. Farm D");
		System.out.print("Please enter a number to choose what farm you would like to work with: ");
		
		int optionChosen = scanner.nextInt();
		System.out.println("You have selected option " + optionChosen);
		
		scanner.close();
		
		Farm.setGameLength(numberOfDaysChosen);
		Farm.farmType(optionChosen);
	}
		

	public static void main(String[] args) {
		SetUpGame();
		System.out.println(Farm.getGameLength());
		System.out.println(Farm.getAnimalHappiness());
		System.out.println(Farm.getCropGrowthRate());
	}

}
