//Note-Many constructors are unnecessary. Should remove them.
package spaceappschallenge.moonville.businessmodels;

import java.util.ArrayList;
import java.util.List;

public class Building {
	protected String name = "";
	protected String info = "";
	protected int amount = 0;
	protected ArrayList<Resource> requiredResources;
	protected ArrayList<Resource> outputResources;
	protected ArrayList<Building> requiredBuildings;
	protected int inputPower = 0;
	protected int outputPower = 0;
	protected int requiredTurns = 0;
	protected int regolithCost = 0;
	protected int monetaryCost = 0;

	// These are computed each time they are needed, so no init necessary.
	protected boolean hasPower;
	protected boolean hasRequiredResources;
	protected boolean hasRequiredBuildings;

	private int xPos, yPos;

	public Building(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}

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

	public Building(String name, String info, int amount, int inputPower,
			int outputPower) {
		initBuilding(name, info, amount, inputPower);
		this.outputPower = outputPower;
	}

	public Building(String name, String info, int amount, int inputPower,
			int outputPower, ArrayList<Resource> requiredResources) {
		initBuilding(name, info, amount, inputPower, outputPower,
				requiredResources);
	}

	// buildings
	public Building(String name, String info, int amount, int inputPower,
			int outputPower, int monetaryCost, int regolithCost,
			int requiredTurns, ArrayList<Resource> requiredResources,
			ArrayList<Resource> outputResources,
			ArrayList<Building> requiredBuildings, int xPos, int yPos) {
		initBuilding(name, info, amount, inputPower, outputPower,
				requiredResources);
		this.monetaryCost = monetaryCost;
		this.regolithCost = regolithCost;
		this.requiredTurns = requiredTurns;
		this.outputResources = outputResources;
		this.requiredBuildings = requiredBuildings;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	protected void initBuilding(String name, String info, int amount,
			int inputPower, int outputPower,
			ArrayList<Resource> requiredResources) {
		initBuilding(name, info, amount, inputPower);
		this.outputPower = outputPower;
		this.requiredResources = requiredResources;

	}

	public Building(String name, String info, int amount, int inputPower,
			int outputPower, int requiredTurns, int regolithCost,
			int monetaryCost, ArrayList<Resource> requiredResources,
			ArrayList<Resource> outputResources) {
		initBuilding(name, info, amount, inputPower, outputPower,
				requiredResources);
		this.requiredTurns = requiredTurns;
		this.regolithCost = regolithCost;
		this.monetaryCost = monetaryCost;
		this.outputResources = outputResources;

	}

	// Setters and Getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ArrayList<Resource> getRequiredResources() {
		return requiredResources;
	}

	public void setRequiredResources(ArrayList<Resource> requiredResources) {
		this.requiredResources = requiredResources;
	}

	public ArrayList<Resource> getOutputResources() {
		return outputResources;
	}

	public void setOutputResources(ArrayList<Resource> outputResources) {
		this.outputResources = outputResources;
	}

	public int getInputPower() {
		return inputPower;
	}

	public void setInputPower(int inputPower) {
		this.inputPower = inputPower;
	}

	public int getOutputPower() {
		return outputPower;
	}

	public void setOutputPower(int outputPower) {
		this.outputPower = outputPower;
	}

	public int getRequiredTurns() {
		return requiredTurns;
	}

	public void setRequiredTurns(int requiredTurns) {
		this.requiredTurns = requiredTurns;
	}

	public int getRegolithCost() {
		return regolithCost;
	}

	public void setRegolithCost(int regolithCost) {
		this.regolithCost = regolithCost;
	}

	public int getMonetaryCost() {
		return monetaryCost;
	}

	public void setMonetaryCost(int monetaryCost) {
		this.monetaryCost = monetaryCost;
	}

	public boolean getHasPower() {
		return hasPower;
	}

	public void setHasPower(boolean hasPower) {
		this.hasPower = hasPower;
	}

	public boolean getHasRequiredResources() {
		return hasRequiredResources;
	}

	public void setHasRequiredResources(boolean hasRequiredResources) {
		this.hasRequiredResources = hasRequiredResources;
	}

	public int getXPos() {
		return xPos;
	}

	public void setXPos(int xPos) {
		this.xPos = xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setYPos(int yPos) {
		this.yPos = yPos;
	}

	public ArrayList<Building> getRequiredBuildings() {
		return requiredBuildings;
	}

	public void setRequiredBuildings(ArrayList<Building> requiredBuildings) {
		this.requiredBuildings = requiredBuildings;
	}

	public void setHasRequiredBuildings(boolean a) {
		this.hasRequiredBuildings = a;
	}

	public boolean getHasRequiredBuildings() {
		return this.hasRequiredBuildings;
	}

}
