package spaceappschallenge.moonville.businessmodels;

import java.util.ArrayList;
import java.util.List;

public class Building {
	protected String name;
	protected String info;
	protected int amount;
	protected ArrayList<Resource> inputResources;
	protected ArrayList<Building> inputBuildings;
	protected ArrayList<Building> requiredBuildings;
	protected ArrayList<Resource> outputResources;
	protected int inputPower;
	protected int outputPower;
	// These are computed each time they are needed, so no init necessary.
	protected boolean hasPower;
	protected boolean hasRequiredBuildings;
	protected boolean hasResources;

	private int monetaryCost;
	private int regolithCost;
	private int requiredTurns;
	private ArrayList<Resource> requiredResources;
	
	private int xPos, yPos;

	// required buildings
	public Building(String name, String info, int amount, int inputPower) {
		initBuilding(name, info, amount, inputPower);
	}

	protected void initBuilding(String name, String info, int amount,
			int inputPower) {
		this.name = name;
		this.info = info;
		this.amount = amount;
		this.inputPower = inputPower;
	}

	// buildings
	public Building(String name, String info, int amount, int inputPower,
			int outputPower, int monetaryCost, int regolithCost,
			int requiredTurns, ArrayList<Resource> requiredResources,
			ArrayList<Building> requiredBuildings,
			int xPos, int yPos ) {
		initBuilding(name, info, amount, inputPower);
		this.outputPower = outputPower;
		this.monetaryCost = monetaryCost;
		this.regolithCost = regolithCost;
		this.requiredTurns = requiredTurns;
		this.requiredResources = requiredResources;
		this.requiredBuildings = requiredBuildings;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	// Increases amount, if input resources/buildings fulfill required
	// resources/buildings
	public void build() {
	}

	public String getName() {
		return name;
	}

	public ArrayList<Building> getRequiredBuildings() {
		return this.requiredBuildings;
	}

	public int getOutputPower() {
		return outputPower;
	}

	public int getInputPower() {
		return inputPower;
	}

	public void setHasPower(boolean hasPower) {
		this.hasPower = hasPower;
	}

	public boolean getHasPower() {
		return hasPower;
	}

	public void setHasRequiredBuildings(boolean hasRequiredBuildings) {
		this.hasRequiredBuildings = hasRequiredBuildings;
	}

	public boolean getHasRequiredBuildings() {
		return hasRequiredBuildings;
	}

	public List<Resource> getOutputResources() {
		return outputResources;
	}

	public List<Resource> getInputResources() {
		return inputResources;
	}

	public void setHasResources(boolean hasResources) {
		this.hasResources = hasResources;
	}

	public boolean getHasResources() {
		return hasResources;
	}

	public int getMonetaryCost() {
		return monetaryCost;
	}

	public void setMonetaryCost(int monetaryCost) {
		this.monetaryCost = monetaryCost;
	}

	public int getRegolithCost() {
		return regolithCost;
	}

	public void setRegolithCost(int regolithCost) {
		this.regolithCost = regolithCost;
	}

	public int getRequiredTurns() {
		return requiredTurns;
	}

	public void setRequiredTurns(int requiredTurns) {
		this.requiredTurns = requiredTurns;
	}

	public ArrayList<Resource> getRequiredResources() {
		return requiredResources;
	}

	public int getXPos() {
		return this.xPos;
	}

	public int getYPos() {
		return this.yPos;
	}
}
