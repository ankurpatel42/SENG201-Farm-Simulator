package farmsimulator;

public class Farmer {
	
	private String farmerName = null;
	private int farmerAge = 0;
	private static int actionsLeft = 0;
	private static int dayNum = 1;
	
	public Farmer (String inputFarmerName) {
		farmerName = inputFarmerName;
	}
	
	public String getFarmerName() {
		return farmerName;
	}
	
	public int getActionsLeft() {
		return actionsLeft;
	}
	
	public int getAge() {
		return farmerAge;
	}
	
	public static void useAction() {
		actionsLeft--;
	}
	
	public int getDayNum() {
		return dayNum;
	}
	
	public static void moveToNextDay() {
		if (dayNum > GameEnvironment.getGameLength()) {
			System.out.println("You cannot move to the next day as this is your last day.");
		} else {
			dayNum++;
		}
	}
	
	public void tendToFarmLand() {
		useAction();
		for (Crop crop : Farm.getCropList()) {
			crop.setDaysTillHarvest(crop.getDaysTillHarvest() - 1);
		}
		//All Animal Happiness Increases//
	}
	
	public String toString() {
		return "I'm a farmer and my name is " + farmerName;
	}
	
}
