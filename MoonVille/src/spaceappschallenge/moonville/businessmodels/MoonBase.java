package spaceappschallenge.moonville.businessmodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

/**
 * Handles information about the game world, including resources, research 
 * points, prospecting and buildings.
 */
public class MoonBase implements Serializable
{
	protected int researchLabSize;
	protected int researchPoints;
	protected int prospectingLevel;
	protected List<Resource> storedResources;

	// chosenMoonSite
	protected int money;
	private int inMonth = 0;

	protected BuildingTree builtBuildings;
	
	//not implemented yet
	//protected List<MegaProject> builtMegaProjects;

	protected GameDetails gameDetails;

	public MoonBase(int researchPoints, int prospectingLevel, int money)
	{
		this.researchLabSize = 1;
		this.researchPoints = researchPoints;
		this.prospectingLevel = prospectingLevel;
		this.storedResources = new ArrayList<Resource>(); // or hashmap? not
															// sure yet...
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
	
	/*
	public List<Building> getBuildBuildingsList() {
		return this.builtBuildingsList;
	}
*/
	
	public void setBuiltBuildings(BuildingTree builtBuildings) {
		this.builtBuildings = builtBuildings;
	}
	
	/**
	 * Creates a new building or increases the amount if one already exists.
	 * 
	 * @param name Name of the building to add.
	 */
	public void addBuilding(String name) {
		Building existing = builtBuildings.getBuilding(name);
		if (existing != null) {
			existing.setAmount(existing.getAmount() + 1);
			Log.d("test", "++");
		}
		else {
			builtBuildings.add(new Building(name, 1));
			Log.d("test", "new");
		}
	}
	
	/**
	 * Returns total number of buildings of this type.
	 */
	public int getBuildingAmount(String name) {
		Building b = builtBuildings.getBuilding(name);
		if (b != null)
			return b.getAmount();
		else
			return 0;
	}
	
	public Building getBuilding(String name) {
		return builtBuildings.getBuilding(name);
	}

	public boolean canBuild(String name) {
		return builtBuildings.canBuild(name);
	}
	
//	Not implemented yet
//
//	public List<MegaProject> getBuiltMegaProjects() {
//		return builtMegaProjects;
//	}
//
//	public void setBuiltMegaProjects(List<MegaProject> builtMegaProjects) {
//		this.builtMegaProjects = builtMegaProjects;
//	}

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
