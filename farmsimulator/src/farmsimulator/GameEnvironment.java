package farmsimulator;

public class GameEnvironment {
	
	private Farmer farmer = null;
	private int gameLength = 0;
	private Farm farm;
	
	public void setFarm(String farmNameChosen, double moneyAvailable, double cropGrowthRate, int animalHealthiness, int animalHappiness) {
		farm = new Farm(farmNameChosen, moneyAvailable, cropGrowthRate, animalHealthiness, animalHappiness);
	}
	
	public Farm getFarm() {
		return farm;
	}
	
	public String getFarmName() {
		return farm.getFarmName();
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
	
	public int getFarmerActionsLeft() {
		return farmer.getActionsLeft();
	}
	
	public void setGameLength(int numDaysChosen) {
		gameLength = numDaysChosen;
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
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetUpScreen();
	}
}
