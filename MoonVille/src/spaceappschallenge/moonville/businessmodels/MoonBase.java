package spaceappschallenge.moonville.businessmodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.factories.Buildings;

public class MoonBase implements Serializable {
	protected int researchLabSize;
	protected int researchPoints;
	protected int prospectingLevel;
	protected List<Resource> storedResources;

	// chosenMoonSite
	protected int money;
	private int inMonth = 0;

	protected BuildingTree builtBuildings;
	protected List<MegaProject> builtMegaProjects;

	protected GameDetails gameDetails;

	public MoonBase(int researchPoints, int prospectingLevel, int money) {
		this.researchLabSize = 1;
		this.researchPoints = researchPoints;
		this.prospectingLevel = prospectingLevel;
		this.storedResources = new ArrayList<Resource>(); // or hashmap? not
															// sure yet...
		this.money = money;

		// only add starting base
		this.builtBuildings = new BuildingTree();
		this.builtBuildings.add(Buildings.getInstance().getBuilding(
				"Lunar Base"));

		this.gameDetails = GameDetails.getInstance();
	}

	public boolean canSpend(int expenditure) {
		if (expenditure <= money) {
			return true;
		} else
			return false;
	}

	//
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

	public void setBuiltBuildings(BuildingTree builtBuildings) {
		this.builtBuildings = builtBuildings;
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

}
