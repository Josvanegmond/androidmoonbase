//Note-Many constructors are unnecessary. Should remove them.
package spaceappschallenge.moonville.businessmodels;

import java.io.Serializable;
import java.util.ArrayList;

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


	public Building(String name, int amount) {
		this.name = name;
		this.amount = amount;
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

}
