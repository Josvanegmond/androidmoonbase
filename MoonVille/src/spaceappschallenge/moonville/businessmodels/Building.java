//Note-Many constructors are unnecessary. Should remove them.
package spaceappschallenge.moonville.businessmodels;

import java.io.Serializable;
import java.util.List;

import spaceappschallenge.moonville.xml_parsers.BuildingDefinition;
import android.util.Log;

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
		List<Resource> outputResources = this.associatedDefinition.getOutputResources();
		for( Resource resource : outputResources )
		{
			resource.setAmount( resource.getAmount() * this.getAmount() );
		}
		
		return outputResources;
	}

	public List<Resource> getResourceInput()
	{
		List<Resource> inputResources = this.associatedDefinition.getRequiredResources();
		for( Resource resource : inputResources )
		{
			resource.setAmount( resource.getAmount() * this.getAmount() );
		}
		
		return inputResources;
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
