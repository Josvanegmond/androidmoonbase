package spaceappschallenge.moonville.businessmodels;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.factories.Buildings;

public class MoonBase
{	
	protected int researchLabSize;
	protected int researchPoints;
	protected int prospectingLevel;
	protected List<Resource> storedResources;
	
	//chosenMoonSite
	protected int money;
	protected List<Building> builtBuildings;
	protected List<MegaProject> builtMegaProjects;

	
	public MoonBase( int researchPoints, int prospectingLevel, int money )
	{
		this.researchLabSize = 1;
		this.researchPoints = researchPoints;
		this.prospectingLevel = prospectingLevel;
		this.storedResources = new ArrayList<Resource>(); //or hashmap? not sure yet...
		this.money = money;
		
		//only add starting base
		this.builtBuildings = new ArrayList<Building>();
		this.builtBuildings.add( Buildings.getInstance().getBuilding( "Lunar Base" ) );
	}

}
