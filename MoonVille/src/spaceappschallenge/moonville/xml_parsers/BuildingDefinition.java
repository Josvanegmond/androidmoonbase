package spaceappschallenge.moonville.xml_parsers;

import java.util.ArrayList;

import spaceappschallenge.moonville.businessmodels.Building;
import spaceappschallenge.moonville.businessmodels.Resource;

/**
 * Provides access to the xml attributes of a building.
 * This is a read-only object, and is made by the xml parser
 */
public class BuildingDefinition
{
	private String name = "";
	private String info = "";
	private int amount = 0;
	private ArrayList<Resource> requiredResources;
	private ArrayList<Resource> outputResources;
	private ArrayList<String> requiredBuildings;
	private int inputPower = 0;
	private int outputPower = 0;
	private int requiredTurns = 0;
	private int monetaryCost = 0;
	private int xPos, yPos;
	
	/*public BuildingDefinition(String name) {
		this.name = name;
	}*/

	public BuildingDefinition(String name, String info,
			int amount, int inputPower,
			int outputPower, int monetaryCost,
			int requiredTurns,
			ArrayList<Resource> requiredResources,
			ArrayList<Resource> outputResources,
			ArrayList<String> requiredBuildings, int xPos,
			int yPos) {
		this.name = name;
		this.info = info;
		this.amount = amount;
		this.inputPower = inputPower;
		this.outputPower = outputPower;
		this.monetaryCost = monetaryCost;
		this.requiredTurns = requiredTurns;
		this.requiredResources = requiredResources;
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

	public ArrayList<String> getRequiredBuildings() {
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

	public int getMonetaryCost() {
		return monetaryCost;
	}

}
