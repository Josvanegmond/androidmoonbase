package spaceappschallenge.moonville.businessmodels;

import java.util.List;

public class MoonBase {
	protected int researchLabSize;
	protected int researchPoints;
	protected int prospectingLevel;
	protected List<Resource> storedResources;
	//chosenMoonSite
	protected int money;
	protected List<Building> builtBuildings;
	protected List<MegaProject> builtMegaProjects;

	public MoonBase(int researchLabSize, int researchPoints,
			int prospectingLevel, List<Resource> storedResources, int money,
			List<Building> builtBuildings) {
		super();
		this.researchLabSize = researchLabSize;
		this.researchPoints = researchPoints;
		this.prospectingLevel = prospectingLevel;
		this.storedResources = storedResources;
		this.money = money;
		this.builtBuildings = builtBuildings;
	}
	
	

}
