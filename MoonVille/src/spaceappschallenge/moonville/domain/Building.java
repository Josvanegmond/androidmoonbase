package spaceappschallenge.moonville.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import spaceappschallenge.moonville.SerializablePair;

import spaceappschallenge.moonville.factories.MoonBaseManager;
import spaceappschallenge.moonville.xml_parsers.BuildingDefinition;

/**
 * Handles attributes of single building in the world.
 */
public class Building implements Serializable {
	
	private static final long serialVersionUID = -219378277763518936L;
	protected BuildingDefinition buildingDefinition = null;
	protected int age;
	protected boolean constructed = false;
	// If it is active, then it can provide output. It is deactivated when
	// requirements are not fulfilled.
	protected boolean active = false;

	public Building(BuildingDefinition buildingDefinition, int age) {
		this.buildingDefinition = buildingDefinition;
		this.age = age;
	}
	
	
	/**
	 * Perform all the necessary updates
	 */
	public void updateNextTurn() {
		updateAge();
		MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
		if (moonBase.canProvideResources(buildingDefinition
				.getRequiredResources())) {
			if (moonBase
					.hasBuildings(buildingDefinition.getRequiredBuildings())) {
				if (moonBase.hasPower(buildingDefinition.getInputPower())) {
					moonBase.decreaseResources(buildingDefinition
							.getRequiredResources());// Consume resources
					moonBase.decreasePower(buildingDefinition.getInputPower());// Consumer
																				// power
					this.active = true;// Activate
					Log.i("active: ",this.buildingDefinition.getName()+" is active");
					generateOutput();// Provide output
					return;
				}
				else Log.i("updateNextTurn() "," no power for "+this.buildingDefinition.getName());
			}
			else Log.i("updateNextTurn() "," no building for "+this.buildingDefinition.getName());
			
		}
		else Log.i("updateNextTurn() "," no resources for "+this.buildingDefinition.getName());
		this.active = false;
	}

	/**
	 * Add its outputs (power and resources) to Moonbase
	 */
	protected void generateOutput() {
		MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
		moonBase.addPower(buildingDefinition.getOutputPower());// generate power
		moonBase.increaseResources(buildingDefinition.getOutputResources());// generate resources
	}

	/**
	 * Increment age and update "constructed" boolean
	 */
	protected void updateAge() {
		++this.age;
		if (this.age >= this.buildingDefinition.getRequiredTurns()) {
			this.constructed = true;
		}
	}

	/**
	 * Check if a building can be constructed
	 * 
	 * @return
	 */
	public boolean canBeConstructed() {
		return true;
	}

	public boolean isConstructed() {
		return this.constructed;
	}

	// Setters and getters
	public BuildingDefinition getBuildingDefinition() {
		return buildingDefinition;
	}

	public void setBuildingDefinition(BuildingDefinition buildingDefinition) {
		this.buildingDefinition = buildingDefinition;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void setConstructed(boolean constructed){
		this.constructed=constructed;
	}
	
	

}
