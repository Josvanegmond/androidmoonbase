/*
 * Singleton Class which keeps information about all and currently available buildings.
 */
package spaceappschallenge.moonville.managers;

import java.util.List;

import spaceappschallenge.moonville.businessmodels.Building;

public class BuildingManager {
	private static BuildingManager instance=null;
	protected List<Building> allBuildings;
	protected List<Building> availableBuildings;
	
	protected BuildingManager(){
		//Read all the buildings from flat file or db
	}
	
	public BuildingManager getInstance(){
		if(instance==null)
			instance=new BuildingManager();
		return instance;
	}

	public List<Building> getAllBuildings() {
		return allBuildings;
	}

	public void setAllBuildings(List<Building> allBuildings) {
		this.allBuildings = allBuildings;
	}

	public List<Building> getAvailableBuildings() {
		return availableBuildings;
	}

	public void setAvailableBuildings(List<Building> availableBuildings) {
		this.availableBuildings = availableBuildings;
	}
	
	//Getters and Setters
	
	
}
