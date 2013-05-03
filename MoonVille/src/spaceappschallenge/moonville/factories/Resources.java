/*
 * Singleton Class which keeps information about available resources. It also holds information about all possible resources.
 */
package spaceappschallenge.moonville.factories;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.Resource;
import spaceappschallenge.moonville.xml_parsers.ResourceDefinition;
import spaceappschallenge.moonville.xml_parsers.ResourceXMLParser;
import android.content.Context;
import android.util.Log;

/**
 * Handles all resources (directly from xml), as well as available resources 
 * (what exists in the world).
 */
public class Resources {
	private static Resources instance = null;
	protected static Context context;
	protected ArrayList<ResourceDefinition> allResources;
//	protected ArrayList<ResourceDefinition> availableResources;
	protected InputStream inputStream = null;

	protected Resources()
	{
		Resources.context = ApplicationService.getInstance()
				.getApplicationContext();
		// I think during construction, it should read "allResources" from a
		// file or db
		this.allResources = new ArrayList<ResourceDefinition>();
//		this.availableResources = new ArrayList<ResourceDefinition>();

		// // All resources. Need to retrieve from XML
		// this.allResources.add(new Resource("Helium-3", 20, 0.2));
		// this.allResources.add(new Resource("Regolith", 20, 0.2));
		//
		// // Sample resources present at some stage of the game.

		//this.setAvailableResources(availableResources);
		initAllResources();

	}

	protected void initAllResources() {
		inputStream = context.getResources().openRawResource(R.raw.resources);

		try {
			ResourceXMLParser xmlParser = new ResourceXMLParser(inputStream);
			try {
				allResources = xmlParser.parse();
			} catch (IOException e) {
				Log.e("Resources",
						"There was problem while parsing the xml file");
				e.printStackTrace();
			}
		} catch (XmlPullParserException e) {
			Log.e("Resources", "XMLParser could not be instantiated");
			e.printStackTrace();
		}
	}

	public static Resources getInstance() {

		if (Resources.instance == null) {
			Resources.instance = new Resources();
		}
		return Resources.instance;
	}

	// Setters and Getters
	public ArrayList<ResourceDefinition> getAllResources() {
		return allResources;
	}

	public void setAllResources(ArrayList<ResourceDefinition> allResources) {
		this.allResources = allResources;
	}

//	public ArrayList<ResourceDefinition> getAvailableResources() {
//		return availableResources;
//	}
//
//	public void setAvailableResources(ArrayList<ResourceDefinition> availableResources) {
//		this.availableResources = availableResources;
//		MoonBaseManager.getCurrentMoonBase().setStoredResources(
//				availableResources);
//	}

	public ResourceDefinition getResource(String name) {
		ResourceDefinition foundResource = null;

		for (ResourceDefinition resource : this.allResources) {
			if (resource.getName().equalsIgnoreCase(name)) {
				foundResource = resource;
				break;
			}
		}
		return foundResource;
	}
}
