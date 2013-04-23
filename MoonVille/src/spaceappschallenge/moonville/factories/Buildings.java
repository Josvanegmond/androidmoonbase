package spaceappschallenge.moonville.factories;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.businessmodels.Building;
import spaceappschallenge.moonville.businessmodels.Resource;
import spaceappschallenge.moonville.managers.ApplicationService;
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
	private ArrayList<Building> allBuildings;

	// a list of buildings that the player can build
	private ArrayList<Building> availableBuildings;

	protected InputStream inputStream = null;

	private Buildings() {
		this.allBuildings = new ArrayList<Building>();

		this.availableBuildings = new ArrayList<Building>();

		Buildings.context = ApplicationService.getInstance()
				.getApplicationContext();

		initAllBuildings();

	}

	public List<Building> getBuildingsByRequiredBuilding(
			Building requiredBuilding) {
		List<Building> buildingList = new ArrayList<Building>();
		for (Building building : allBuildings) {
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
			Building building = this.allBuildings.get(i);

			Log.i("Buildings", building.getName());

			ArrayList<Resource> resources = building.getRequiredResources();
			Log.i("LENGTH", "reqd resource size:" + resources.size());
			for (Resource rResource : resources) {
				Log.i("Buildings rr", rResource.getName());
			}

			ArrayList<Building> rbuilding = building.getRequiredBuildings();
			for (Building rb : rbuilding) {
				Log.i("required buildings", rb.getName());
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
	public Building getBuilding(String name) {
		Building foundBuilding = null;

		for (Building building : this.allBuildings) {
			if (building.getName().equals(name)) {
				foundBuilding = building;
				break;
			}
		}

		return foundBuilding;
	}

	// returns all available buildings
	public ArrayList<Building> getAllBuildings() {
		return this.allBuildings;
	}
}
