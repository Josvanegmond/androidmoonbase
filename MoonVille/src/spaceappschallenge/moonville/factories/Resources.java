/*
 * Singleton Class which keeps information about available resources. It also holds information about all possible resources.
 */
package spaceappschallenge.moonville.factories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import spaceappschallenge.moonville.R;
import android.content.Context;
import android.util.Log;

import spaceappschallenge.moonville.businessmodels.*;
import spaceappschallenge.moonville.managers.ApplicationService;
import spaceappschallenge.moonville.xml_parsers.ResourceXMLParser;

public class Resources {
	private static Resources instance = null;
	protected static Context context;
	protected ArrayList<Resource> allResources;
	protected ArrayList<Resource> availableResources;
	protected InputStream inputStream = null;

	protected Resources() {
		Resources.context = ApplicationService.getInstance()
				.getApplicationContext();
		// I think during construction, it should read "allResources" from a
		// file or db
		this.allResources = new ArrayList<Resource>();
		this.availableResources = new ArrayList<Resource>();

		// // All resources. Need to retrieve from XML
		// this.allResources.add(new Resource("Helium-3", 20, 0.2));
		// this.allResources.add(new Resource("Regolith", 20, 0.2));
		//
		// // Sample resources present at some stage of the game.
		this.availableResources.add(new Resource("Helium-3", 10, 0.1));
		this.availableResources.add(new Resource("Regolith", 10, 0.2));
		context = ApplicationService.getInstance().getApplicationContext();
		inputStream = context.getResources().openRawResource(R.raw.resources);

		Log.i("Resources", "trying to read from xml parser");
		try {
			ResourceXMLParser xmlParser = new ResourceXMLParser(inputStream);
			try {
				allResources = xmlParser.parse();
				for (Resource resource : allResources) {
					Log.i("resource",
							"name" + resource.getName() + " amount:"
									+ resource.getAmount() + " quality:"
									+ resource.getQuality());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Log.e("Resources","There was problem while parsing the xml file");
				e.printStackTrace();
			}
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			Log.e("Resources","XMLParser could not be instantiated");
			e.printStackTrace();
		}
		Log.i("Resources","done reading from xml");

	}

	public static Resources getInstance() {

		if (Resources.instance == null) {
			Resources.instance = new Resources();
		}
		return Resources.instance;
	}

	// Setters and Getters
	public ArrayList<Resource> getAllResources() {
		return allResources;
	}

	public void setAllResources(ArrayList<Resource> allResources) {
		this.allResources = allResources;
	}

	public ArrayList<Resource> getAvailableResources() {
		return availableResources;
	}

	public void setAvailableResources(ArrayList<Resource> availableResources) {
		this.availableResources = availableResources;
	}

	public Resource getResource(String name) {
		Resource foundResource = null;

		for (Resource resource : this.allResources) {
			if (resource.getName().equals(name)) {
				foundResource = resource;
				break;
			}
		}

		return foundResource;
	}
}
