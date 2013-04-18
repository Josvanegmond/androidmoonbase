package spaceappschallenge.moonville.businessmodels;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.factories.Buildings;

public class MoonBase
{
	//added static since there is only 1 moonbase
	//it's a bit dirty maybe, but also makes it easier to access it everywhere when needed -Jos
	private static MoonBase instance;
	
	protected int researchLabSize;
	protected int researchPoints;
	protected int prospectingLevel;
	protected List<Resource> storedResources;
	
	//chosenMoonSite
	protected int money;
	protected List<Building> builtBuildings;
	protected List<MegaProject> builtMegaProjects;

	
	private MoonBase( int researchPoints, int prospectingLevel, int money )
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
	
	
	public void getInstance( int researchPoints, int prospectingLevel, int money )
	{
		if( MoonBase.instance == null )
		{
			MoonBase.instance = new MoonBase( researchPoints, prospectingLevel, money );
		}
	}

}
