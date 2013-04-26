//Note-Many constructors are unnecessary. Should remove them.
package spaceappschallenge.moonville.businessmodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.factories.Buildings;
import spaceappschallenge.moonville.xml_parsers.BuildingDefinition;

/**
 * Handles a attributes of a single building in the world.
 */
public class Building implements Serializable {
	protected String name = "";
	protected int amount = 0;

	// These are computed each time they are needed, so no init necessary.
	protected boolean hasPower;
	protected boolean hasRequiredResources;
	protected boolean hasRequiredBuildings;

	private BuildingDefinition associatedDefinition;
	

	public Building(String name, int amount) {
		this.name = name;
		this.amount = amount;
		
		this.associatedDefinition = Buildings.getInstance().getBuilding( this.name );
	}

	// Setters and Getters
	public String getName() {
		return name;
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
		List<Resource> outputResources = this.associatedDefinition.getOutputResources();
		for( Resource resource : outputResources )
		{
			resource.setAmount( resource.getAmount() * this.getAmount() );
		}
		
		return outputResources;
	}

}
