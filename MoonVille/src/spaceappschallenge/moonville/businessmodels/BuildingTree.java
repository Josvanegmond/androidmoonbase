package spaceappschallenge.moonville.businessmodels;

import java.util.List;

/**
 * Contains all buildings per level as of 
 * https://www.facebook.com/photo.php?fbid=10151316698507504
 * 
 * @author Felix
 *
 */
public class BuildingTree {
	String buildingName;
	List<Building> buildings;
	List<BuildingTree> childs;
	
	public BuildingTree() {
	}
	
	private BuildingTree(Building b) {
		buildings.add(b);
		buildingName = b.getName();
	}
	
	/**
	 * Insert a building into the tree. Only call this method on the root 
	 * node of a tree.
	 * 
	 * @return True if the building was inserted successfully.
	 */
	public boolean add(Building b) {
		if (b.getName() == buildingName) {
			buildings.add(b);
			return true;
		}
		else {
			for (BuildingTree bt : childs) {
				if (bt.add(b)) {
					return true;
				}
			}
		}
		// Make sure buildings are inserted at the correct level.
		if (buildingName == "Moon Base" && 
				(b.getName() == "Solarpanel Array" || 
				b.getName() == "Ice Mine" || 
				b.getName() == "Regolith Processor")) {
			childs.add(new BuildingTree(b));
			return true;
		}
		else if (buildingName == "Ice Mine" && 
				b.getName() == "Water Processor") {
			childs.add(new BuildingTree(b));	
			return true;		
		}
		else if (buildingName == "Water Processor" && 
				b.getName() == "Propellant Factory") {
			childs.add(new BuildingTree(b));
			return true;			
		}
		else if (buildingName == "Propellant Factory" && 
				b.getName() == "Spaceport") {
			childs.add(new BuildingTree(b));
			return true;			
		}
		else if (buildingName == "Regolith Processor" && 
				(b.getName() == "Smelting Facility" || 
				b.getName() == "Nuclear Plant")) {
			childs.add(new BuildingTree(b));
			return true;			
		}
		else if (buildingName == "Smelting Facility" && 
				b.getName() == "Electronics Factory") {
			childs.add(new BuildingTree(b));
			return true;			
		}
		else if (buildingName == "Electronics Factory" && 
				(b.getName() == "Robot Factory" || 
				b.getName() == "Maglev Train Transport")) {
			childs.add(new BuildingTree(b));	
			return true;		
		}
		else if (buildingName == "Robot Factory" && 
				b.getName() == "Asteroid Defense") {
			childs.add(new BuildingTree(b));	
			return true;		
		}
		else {
			// Either the building was not initially inserted in the tree 
			// root, or the cases above are incorrect.
			assert(false);
			return false;
		}
	}
	
	public List<Building> getBuildings() {
		return buildings;
	}
	
	public List<BuildingTree> getChilds() {
		return childs;
	}
	
	/**
	 * Interface function for computeNetPower(int).
	 */
	public void computeNetPower() {
		computeNetPower(0);
	}
	
	/**
	 * Computes the amount of power available to each building and shuts down 
	 * those that don't have enough power.
	 * 
	 * @param parentPower Total net power of the parent node.
	 * @return Total net power of current node and all child nodes.
	 */
	private int computeNetPower(int parentPower) {
		for (Building b : buildings) {
			parentPower += b.getNetPower();
			b.setHasPower(parentPower >= 0);
		}
		for (BuildingTree c : childs) {
			parentPower += c.computeNetPower(parentPower);
		}
		return parentPower;
	}
	
	/**
	 * Interface function for checkrequiredBuildings(boolean)
	 */
	public void checkRequiredBuildings() {
		// Moon Base has no required buildings.
		checkRequiredBuildings(false);
	}
	
	/**
	 * Checks if each building has its required buildings. This is true if 
	 * no higher node in the tree is empty.
	 * 
	 * @param isParentEmpty True if the parent node is empty. Means required 
	 * 						buildings are not available.
	 */
	private void checkRequiredBuildings(boolean isParentEmpty) {
		if (!isParentEmpty) {
			for (Building b : buildings) {
				b.setHasRequiredBuildings(true);
			}			
			for (BuildingTree c : childs) {
				c.checkRequiredBuildings(false);
			}		
		}
		else {
			for (Building b : buildings) {
				b.setHasRequiredBuildings(false);
			}			
			for (BuildingTree c : childs) {
				c.checkRequiredBuildings(true);
			}				
		}
	}
}
