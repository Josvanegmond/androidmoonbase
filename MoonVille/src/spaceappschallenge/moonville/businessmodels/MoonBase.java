package spaceappschallenge.moonville.businessmodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.factories.Buildings;

/**
 * Handles information about the game world, including resources, research 
 * points, prospecting and buildings.
 */
public class MoonBase implements Serializable {
	protected int researchLabSize;
	protected int researchPoints;
	protected int prospectingLevel;
	protected List<Resource> storedResources;

	// chosenMoonSite
	protected int money;
	private int inMonth = 0;

	// TODO: Merge building tree and list.
	protected BuildingTree builtBuildings;
	protected List<Building> builtBuildingsList; //couldnt work with tree, not enough functionality, not enough time to understand -Jos
	protected List<MegaProject> builtMegaProjects;

	protected GameDetails gameDetails;

	public MoonBase(int researchPoints, int prospectingLevel, int money) {
		this.researchLabSize = 1;
		this.researchPoints = researchPoints;
		this.prospectingLevel = prospectingLevel;
		this.storedResources = new ArrayList<Resource>(); // or hashmap? not
															// sure yet...
		this.builtBuildingsList = new ArrayList<Building>();
		this.money = money;

		// only add starting base
		this.builtBuildings = new BuildingTree();
		this.builtBuildings.add(new Building("Lunar Base", 1));

		this.gameDetails = GameDetails.getInstance();
	}

	public boolean canSpend(int expenditure) {
		if (expenditure <= money) {
			return true;
		} else
			return false;
	}

	public boolean spend(int expenditure) {
		if (canSpend(expenditure)) {
			this.money -= expenditure;
			return true;
		} else
			return false;
	}

	public void sell(int income) {
		this.money += income;
	}

	public int getResearchLabSize() {
		return researchLabSize;
	}

	public void setResearchLabSize(int researchLabSize) {
		this.researchLabSize = researchLabSize;
	}

	public int getResearchPoints() {
		return researchPoints;
	}

	public void setResearchPoints(int researchPoints) {
		this.researchPoints = researchPoints;
	}

	public int getProspectingLevel() {
		return prospectingLevel;
	}

	public void setProspectingLevel(int prospectingLevel) {
		this.prospectingLevel = prospectingLevel;
	}

	public List<Resource> getStoredResources() {
		return storedResources;
	}

	public void setStoredResources(List<Resource> storedResources) {
		this.storedResources = storedResources;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public BuildingTree getBuiltBuildings() {
		return builtBuildings;
	}
	
	public List<Building> getBuildBuildingsList() {
		return this.builtBuildingsList;
	}

	public void setBuiltBuildings(BuildingTree builtBuildings) {
		this.builtBuildings = builtBuildings;
	}
	
	/**
	 * Creates a new building or increases the amount if one already exists.
	 * 
	 * @param name Name of the building to add.
	 */
	public void addBuilding(String name) {
		for (Building b : builtBuildingsList) {
			if (b.getName() == name) {
				b.setAmount(b.getAmount() + 1);
				return;
			}
		}
		// Need to insert building
		Building b = new Building(name, 1);
		builtBuildingsList.add(b);
		builtBuildings.add(b);
	}
	
	/**
	 * Returns total number of buildings of this type.
	 */
	public int getBuildingAmount(String name) {
		for (Building b : builtBuildingsList) {
			if (b.getName() == name)
				return b.getAmount();
		}
		return 0;
	}

	public List<MegaProject> getBuiltMegaProjects() {
		return builtMegaProjects;
	}

	public void setBuiltMegaProjects(List<MegaProject> builtMegaProjects) {
		this.builtMegaProjects = builtMegaProjects;
	}

	public int getMonth() {
		return inMonth;
	}

	public void setMonth(int inMonth) {
		this.inMonth = inMonth;
	}
	
	public void incrementMonth(){
		++this.inMonth;
	}

}
