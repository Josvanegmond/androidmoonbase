package spaceappschallenge.moonville.xml_parsers;

import java.util.ArrayList;

import spaceappschallenge.moonville.businessmodels.Building;
import spaceappschallenge.moonville.businessmodels.Resource;

/**
 * Provides access to the xml attributes of a building.
 */
public class BuildingDefinition
{
	protected String name = "";
	protected String info = "";
	protected int amount = 0;
	protected ArrayList<Resource> requiredResources;
	protected ArrayList<Resource> outputResources;
	protected ArrayList<BuildingDefinition> requiredBuildings;
	protected int inputPower = 0;
	protected int outputPower = 0;
	protected int requiredTurns = 0;
	protected int regolithCost = 0;
	protected int monetaryCost = 0;
	private int xPos, yPos;
	
	public BuildingDefinition(String name) {
		this.name = name;
	}

	public BuildingDefinition(String name, String info,
			int amount, int inputPower,
			int outputPower, int monetaryCost,
			int regolithCost, int requiredTurns,
			ArrayList<Resource> requiredResources,
			ArrayList<Resource> outputResources,
			ArrayList<BuildingDefinition> requiredBuildings, int xPos,
			int yPos) {
		this.name = name;
		this.info = info;
		this.amount = amount;
		this.inputPower = inputPower;
		this.monetaryCost = monetaryCost;
		this.regolithCost = regolithCost;
		this.requiredTurns = requiredTurns;
		this.outputResources = outputResources;
		this.requiredBuildings = requiredBuildings;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public String getName() {
		return name;
	}

	public String getInfo() {
		return info;
	}

	public int getAmount() {
		return amount;
	}

	public ArrayList<Resource> getRequiredResources() {
		return requiredResources;
	}

	public ArrayList<Resource> getOutputResources() {
		return outputResources;
	}

	public ArrayList<BuildingDefinition> getRequiredBuildings() {
		return this.requiredBuildings;
	}

	public int getInputPower() {
		return inputPower;
	}

	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}

	public int getOutputPower() {
		return outputPower;
	}

	public int getRequiredTurns() {
		return requiredTurns;
	}

	public int getRegolithCost() {
		return regolithCost;
	}

	public int getMonetaryCost() {
		return monetaryCost;
	}

}
