package spaceappschallenge.moonville.xml_parsers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import spaceappschallenge.moonville.SerializablePair;

import spaceappschallenge.moonville.domain.Resource;

/**
 * Provides access to the xml attributes of a building.
 * This is a read-only object, and is made by the xml parser
 */
public class BuildingDefinition implements Serializable
{
	private final String name;
	private final String info;
	private final int amount;
	private final List<SerializablePair<Resource,Integer>> requiredResources;
	private final List<SerializablePair<Resource,Integer>> outputResources;
	private final List<String> requiredBuildings;
	private final int inputPower;
	private final int outputPower;
	private final int requiredTurns;
	private final int monetaryCost;
	private final int xPos, yPos;

	public BuildingDefinition(String name, String info,
			int amount, int inputPower,
			int outputPower, int monetaryCost,
			int requiredTurns,
			ArrayList<SerializablePair<Resource, Integer>> requiredResources,
			ArrayList<SerializablePair<Resource, Integer>> outputResources,
			ArrayList<String> requiredBuildings, int xPos,
			int yPos) {
		this.name = name;
		this.info = info;
		this.amount = amount;
		this.inputPower = inputPower;
		this.outputPower = outputPower;
		this.monetaryCost = monetaryCost;
		this.requiredTurns = requiredTurns;
		this.requiredResources = Collections.unmodifiableList(requiredResources);
		this.outputResources = Collections.unmodifiableList(outputResources);
		this.requiredBuildings = Collections.unmodifiableList(requiredBuildings);
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	//Setters and Getters
	public String getName() {
		return name;
	}

	public String getInfo() {
		return info;
	}

	public int getAmount() {
		return amount;
	}

	public List<SerializablePair<Resource,Integer>> getRequiredResources() {
		return requiredResources;
	}

	public List<SerializablePair<Resource,Integer>> getOutputResources() {
		return outputResources;
	}

	public List<String> getRequiredBuildings() {
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
