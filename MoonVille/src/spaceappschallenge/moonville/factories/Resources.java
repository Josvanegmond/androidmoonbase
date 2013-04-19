/*
 * Singleton Class which keeps information about available resources. It also holds information about all possible resources.
 */
package spaceappschallenge.moonville.factories;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.businessmodels.*;

public class Resources {
	private static Resources instance = null;
	protected ArrayList<Resource> allResources;
	protected ArrayList<Resource> availableResources;

	protected Resources() {
		// I think during construction, it should read "allResources" from a
		// file or db
		this.allResources = new ArrayList<Resource>();
		this.availableResources = new ArrayList<Resource>();

		// All resources. Need to retrieve from XML
		this.allResources.add(new Resource("Helium-3", 20, 0.2));
		this.allResources.add(new Resource("Regolith", 20, 0.2));

		// Sample resources present at some stage of the game.
		this.allResources.add(new Resource("Helium-3", 10, 0.1));
		this.allResources.add(new Resource("Regolith", 10, 0.2));
	}

	public Resources getInstance() {
		if (Resources.instance == null) {
			Resources.instance = new Resources();
		}
		return Resources.instance;
	}

	// Setters and Getters
	public List<Resource> getAllResources() {
		return allResources;
	}

	public void setAllResources(ArrayList<Resource> allResources) {
		this.allResources = allResources;
	}

	public List<Resource> getAvailableResources() {
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
