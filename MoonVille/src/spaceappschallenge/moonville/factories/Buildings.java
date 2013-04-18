package spaceappschallenge.moonville.factories;

import java.util.ArrayList;

import spaceappschallenge.moonville.businessmodels.Building;

//singleton class
public class Buildings
{
	private static Buildings instance;

	//a list of all possible buildings
	private ArrayList<Building> allBuildings;
	
	//a list of buildings that the player can build
	private ArrayList<Building> availableBuildings;
	
	
	private Buildings()
	{	
		this.allBuildings = new ArrayList<Building>();
		
		this.availableBuildings = new ArrayList<Building>();

		
		//TODO: hardcoding buildings... yeah... xml or other source would be better :)
		this.allBuildings.add(
				new Building( "Lunar Base",
					"Heart of operations, your entire industry revolves around this base." +
					"It provides all communications to and from Earth and other space industry companies," +
					"as well as a research lab to conduct groundbreaking research on efficiency," +
					"quality and unlocking new exotic materials.",
					0, null, null, null, null, 0, 0 )
		);

		this.allBuildings.add(
				new Building( "Regolith Mine",
					"This is your most important building. The Regolith mine will provide you with" +
					"the dirtlayer covering the moon to extract the basic elements from.",
					0, null, null, null, null, 0, 0 )
		);
	}
	
	
	public static Buildings getInstance()
	{
		//TODO: when loading existing game, this factory should be replaced by the saved one, not create a new one
		
		if( Buildings.instance == null )
		{
			Buildings.instance = new Buildings();
		}
		
		return Buildings.instance;
	}


	//returns a building object according to its name
	public Building getBuilding( String name )
	{
		Building foundBuilding = null;
		
		for( Building building : this.allBuildings )
		{
			if( building.getName().equals( name ) )
			{
				foundBuilding = building;
				break;
			}
		}
		
		return foundBuilding;
	}


	//returns all available buildings
	public ArrayList<Building> getAllBuildings()
	{
		return this.allBuildings;
	}
}
