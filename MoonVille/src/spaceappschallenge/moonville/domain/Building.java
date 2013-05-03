//Note-Many constructors are unnecessary. Should remove them.
package spaceappschallenge.moonville.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.xml_parsers.BuildingDefinition;

/**
 * Handles a attributes of a single building in the world.
 */
public class Building implements Serializable {
	protected String name = "";
	protected int amount = 0;

	// These are computed each time they are needed, so no init necessary.
	protected boolean hasPower = false;
	protected boolean hasRequiredResources = false;
	protected boolean hasRequiredBuildings = false;

	private BuildingDefinition associatedDefinition;
	

	public Building(BuildingDefinition buildingDefinition, int amount) {
		this.name = buildingDefinition.getName();
		this.amount = amount;
		
		this.associatedDefinition = buildingDefinition;
	}

	// Setters and Getters
	public String getName() {
		return name;
	}
	
	public int getRequiredTurns()
	{
		return this.associatedDefinition.getRequiredTurns();
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean getHasPower() {
		return hasPower;
	}

	public void setHasPower(boolean hasPower) {
		this.hasPower = hasPower;
	}

	public boolean getHasRequiredResources() {
		return hasRequiredResources;
	}

	public void setHasRequiredResources(boolean hasRequiredResources) {
		this.hasRequiredResources = hasRequiredResources;
	}

	public void setHasRequiredBuildings(boolean a) {
		this.hasRequiredBuildings = a;
	}

	public boolean getHasRequiredBuildings() {
		return this.hasRequiredBuildings;
	}

	/**
	 * Returns the total output of resources.
	 * This is a list of new resource objects, containing the total output number:
	 * default produced by this building multiplied by the amount of buildings
	 */
	public List<Resource> getResourceOutput()
	{
		List<Resource> addedResources = new ArrayList<Resource>();
		List<Resource> outputResources = this.associatedDefinition.getOutputResources();
		for( Resource resource : outputResources )
		{
			Resource addedResource = new Resource( resource );
			addedResource.setAmount( resource.getAmount() * this.getAmount() );
			addedResources.add( addedResource );
		}
		
		return addedResources;
	}

	public List<Resource> getResourceInput()
	{
		List<Resource> addedResources = new ArrayList<Resource>();
		List<Resource> inputResources = this.associatedDefinition.getRequiredResources();
		for( Resource resource : inputResources )
		{
			Resource addedResource = new Resource( resource );
			addedResource.setAmount( resource.getAmount() * this.getAmount() );
			addedResources.add( addedResource );
			
		}
		
		return addedResources;
	}


	public List<String> getRequiredBuildings()
	{
		List<String> requiredBuildings = this.associatedDefinition.getRequiredBuildings();
		return requiredBuildings;
	}
	
	public int getInputPower()
	{
		return this.associatedDefinition.getInputPower();
	}
	
	public int getOutputPower()
	{
		return this.associatedDefinition.getOutputPower();
	}

}
