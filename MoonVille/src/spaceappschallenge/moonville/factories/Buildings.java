package spaceappschallenge.moonville.factories;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.Building;
import spaceappschallenge.moonville.domain.BuildingDefinition;
import spaceappschallenge.moonville.domain.Resource;
import spaceappschallenge.moonville.miscellaneous.SerializablePair;
import spaceappschallenge.moonville.xml_parsers.BuildingXMLParser;
import android.content.Context;
import android.util.Log;

/**
 * Singleton class, handles buildings.
 * 
 * As opposed to BuildingTree, this handles all buildings that exist in the game
 * (defined by xml), independent from what is built in the world.
 * 
 */
public class Buildings {
	private static Buildings instance;
	protected static Context context;

	// a list of all possible buildings
	private ArrayList<BuildingDefinition> allBuildings;

	// a list of buildings that the player can build
	private ArrayList<BuildingDefinition> availableBuildings;
	private ArrayList<BuildingDefinition> allMegaprojects;

	protected InputStream inputStream = null;

	private Buildings() {
		this.allBuildings = new ArrayList<BuildingDefinition>();

		this.availableBuildings = new ArrayList<BuildingDefinition>();

		Buildings.context = ApplicationService.getInstance()
				.getApplicationContext();

		initAllBuildings();

	}

	public List<BuildingDefinition> getBuildingsByRequiredBuilding(
			Building requiredBuilding) {
		List<BuildingDefinition> buildingList = new ArrayList<BuildingDefinition>();
		for (BuildingDefinition building : allBuildings) {
			if (building.getRequiredBuildings().contains(requiredBuilding)) {
				buildingList.add(building);
			}
		}

		return buildingList;
	}

	/*
	 * Calls the parser to initialize the ArrayList of buildings
	 */
	protected void initAllBuildings() {
		inputStream = context.getResources().openRawResource(R.raw.buildings);

		try {
			BuildingXMLParser xmlParser = new BuildingXMLParser(inputStream);
			try {
				this.allBuildings = xmlParser.parse();
				this.allMegaprojects = xmlParser.getMegaprojects();
				//printAllBuildings();
			} catch (IOException e) {
				Log.e("Buildings",
						"There was problem while parsing the xml file");
			}
		} catch (XmlPullParserException e) {
			Log.e("Buildings", "XMLParser could not be instantiated");
		}
	}

	public void printAllBuildings() {
		for (int i = 0; i < this.allBuildings.size(); i++) {
			BuildingDefinition building = this.allBuildings.get(i);

			Log.i("Buildings", building.getName());

			List<SerializablePair<Resource,Integer>> resources = building.getRequiredResources();
			Log.i("LENGTH", "reqd resource size:" + resources.size());
			for (SerializablePair<Resource, Integer> rResource : resources) {
				Log.i("Buildings rr", rResource.first.getName());
			}

			List<String> rbuilding = building.getRequiredBuildings();
			for (String rb : rbuilding) {
				Log.i("required buildings", rb);
			}
		}
	}

	public static Buildings getInstance() {
		// TODO: when loading existing game, this factory should be replaced by
		// the saved one, not create a new one
		if (Buildings.instance == null) {
			Buildings.instance = new Buildings();
		}

		return Buildings.instance;
	}

	// returns a building object according to its name
	public BuildingDefinition getBuilding(String name) {
		BuildingDefinition foundBuilding = null;

		for (BuildingDefinition building : this.allBuildings) {
			if (building.getName().equals(name)) {
				foundBuilding = building;
				break;
			}
		}

		return foundBuilding;
	}

	// returns all available buildings
	public ArrayList<BuildingDefinition> getAllBuildings() {
		return this.allBuildings;
	}
	
	public ArrayList<BuildingDefinition> getAllMegaprojects(){
		return this.allMegaprojects;
	}
}
