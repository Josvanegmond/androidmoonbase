/*
 * Singleton Class which keeps information about available resources. It also holds information about all possible resources.
 */
package spaceappschallenge.moonville.managers;

import java.util.List;

import spaceappschallenge.moonville.businessmodels.*;

public class ResourceManager {
	private static ResourceManager instance = null;
	protected List<Resource> allResources;
	protected List<Resource> availableResources;
	
	protected ResourceManager() {
		//I think during construction, it should read "allResources" from a file or db
	}

	public ResourceManager getInstance() {
		if (instance == null)
			instance = new ResourceManager();
		return instance;
	}

	//Setters and Getters
	public List<Resource> getAllResources() {
		return allResources;
	}
	
	public void setAllResources(List<Resource> allResources) {
		this.allResources = allResources;
	}

	public List<Resource> getAvailableResources() {
		return availableResources;
	}

	public void setAvailableResources(List<Resource> availableResources) {
		this.availableResources = availableResources;
	}
		
}
