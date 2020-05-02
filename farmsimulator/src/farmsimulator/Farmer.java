package farmsimulator;

public class Farmer {
	
	private String farmerName = null;
	private int actionsLeft = 0;
	private int farmerAge = 0;
	
	public Farmer () {
		
	}
	
	public String getFarmerName() {
		return farmerName;
	}
	
	public int getActionsLeft() {
		return actionsLeft;
	}
	
	public void useAction() {
		actionsLeft -= 1;
	}
	
	public int getAge() {
		return farmerAge;
	}
	
	public void tendToFarmLand() {
		useAction();
		for (Crop crop : Farm.getCropsList()) {
			crop.setDaysTillHarvest(crop.getDaysTillHarvest() - 1);
		}
		//All Animal Happiness Increases//
	}
}
