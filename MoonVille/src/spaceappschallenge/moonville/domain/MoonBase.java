package spaceappschallenge.moonville.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import spaceappschallenge.moonville.factories.Buildings;
import spaceappschallenge.moonville.miscellaneous.SerializablePair;

import android.util.Log;

/**
 * Handles information about the game world, including power, money, resources
 * and buildings
 */
public class MoonBase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6698209397974201732L;
	// List of SerializablePairs of resources and their amounts
	protected List<SerializablePair<Resource, Integer>> storedResources = new ArrayList<SerializablePair<Resource, Integer>>();
	protected List<Building> constructedBuildings = new ArrayList<Building>();
	protected List<Building> buildingsUnderConstruction = new ArrayList<Building>();

	protected int money;
	protected int power;
	private int currentMonth = 0;

	protected GameDetails gameDetails;

	public MoonBase(int money) {
		this.storedResources = new ArrayList<SerializablePair<Resource, Integer>>();
		this.money = money;
		// It is assumed that at the start of the game, a moon base is present
		BuildingDefinition moonBaseDefinition = Buildings.getInstance()
				.getBuilding("Moon Base");
		Building moonBase = new Building(moonBaseDefinition,
				moonBaseDefinition.getRequiredTurns());
		moonBase.setActive(true);
		moonBase.setConstructed(true);
		this.constructedBuildings.add(moonBase);
		this.gameDetails = GameDetails.getInstance();
	}

	/**
	 * Checks if moonbase can spend specified amount of money
	 * @param expenditure
	 * @return
	 */
	public boolean canSpend(int expenditure) {
		if (expenditure <= money) {
			return true;
		} else
			return false;
	}

	/**
	 * Spend the specified money
	 * @param expenditure
	 * @return
	 */
	public boolean spend(int expenditure) {
		if (canSpend(expenditure)) {
			this.money -= expenditure;
			return true;
		} else
			return false;
	}

	public void sell(int income) {
		this.money += income;
	}

	/**
	 * Checks if building of certain type can be built
	 * 
	 * @param buildingDefinition
	 * @return
	 */
	public boolean canConstruct(BuildingDefinition buildingDefinition) {
		return true;// for now any type of building can be constructed
	}

	public void construct(BuildingDefinition buildingDefinition) {
		Building building = new Building(buildingDefinition, 0);
		this.buildingsUnderConstruction.add(building);
	}

	public void nextTurn() {
		incrementMonth();
		updateBuildingsUnderConstruction();
		updateConstructedBuildings();// Output is with this function
	}

	/**
	 * Update buildings which are under construction
	 */
	public void updateBuildingsUnderConstruction() {
		for (Building b : this.buildingsUnderConstruction) {
			b.updateAge();
		}
		for (int i = this.buildingsUnderConstruction.size() - 1; i >= 0; i--) {
			Building b = this.buildingsUnderConstruction.get(i);
			if (b.isConstructed()) {
				this.constructedBuildings.add(b);
				this.buildingsUnderConstruction.remove(i);
			}
		}

	}

	/**
	 * If at least one building of given name is constructed, then it returns
	 * true
	 * 
	 * @param buildingName
	 * @return
	 */
	public boolean isBuildingConstructed(String buildingName) {
		for (Building b : constructedBuildings) {
			if (buildingName.equalsIgnoreCase(b.getBuildingDefinition()
					.getName())) {
				Log.i("constructed building: ", buildingName);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if any building is under construction
	 * @param buildingName
	 * @return
	 */
	public boolean isBuildingUnderConstruction(String buildingName) {
		for (Building b : buildingsUnderConstruction) {
			if (buildingName.equalsIgnoreCase(b.getBuildingDefinition()
					.getName())) {
				Log.i("building under construction: ", buildingName);
				return true;
			}
		}
		return false;
	}

	/**
	 * Update the buildings which are already constructed
	 */
	public void updateConstructedBuildings() {
		for (Building b : this.constructedBuildings) {
			b.updateNextTurn();
		}
	}

	/**
	 * Checks if resource can be provided
	 * 
	 * @param resources
	 * @return
	 */
	public boolean canProvideResources(
			List<SerializablePair<Resource, Integer>> resources) {
		if (resources == null)
			return true;
		if (resources.size() == 0)
			return true;
		boolean resourceFound = false;
		for (SerializablePair<Resource, Integer> requiredResource : resources) {
			resourceFound = false;
			for (SerializablePair<Resource, Integer> storedResource : storedResources) {
				if (requiredResource.first.getName().equals(
						storedResource.first.getName())) {
					resourceFound = true;
					if (requiredResource.second > storedResource.second) {
						Log.i("canProvideResources",
								" can't fulfil resources due to lack of amount");
						return false;
					}
				}
			}
			if (!resourceFound) {
				Log.i("canProvideResources ", " resource not found");
				return false;
			}

		}
		return true;
	}

	/**
	 * Returns the amount of resources of given name
	 * 
	 * @param resourceName
	 * @return
	 */
	public int getAmountOfResources(String resourceName) {
		for (SerializablePair<Resource, Integer> resource : storedResources) {
			if (resource.first.getName().equals(resourceName)) {
				return resource.second;
			}
		}
		return 0;
	}

	/**
	 * Adds inputResources to stored resources
	 * 
	 * @param inputResources
	 */
	public void increaseResources(
			List<SerializablePair<Resource, Integer>> inputResources) {
		boolean resourceFound = false;
		for (SerializablePair<Resource, Integer> inputResource : inputResources) {
			for (int i = 0; i < storedResources.size(); i++) {
				if (inputResource.first.getName().equalsIgnoreCase(
						storedResources.get(i).first.getName())) {
					resourceFound = true;
					Log.i("increase resources", "resource found");
					SerializablePair<Resource, Integer> updatedResource = new SerializablePair<Resource, Integer>(
							inputResource.first, inputResource.second
									+ storedResources.get(i).second);
					storedResources.set(i, updatedResource);

				}
			}
			// If resource does not pre-exist then, add new entry to the list
			if (!resourceFound) {
				storedResources.add(inputResource);
				Log.i("increase resource", inputResource.first.getName()
						+ " was entered");
			}
		}
	}

	/**
	 * Decreases the stored resources with the specified resources Caution!!!!:
	 * Check with canProvideResources() before calling this function
	 * 
	 * @param resources
	 */
	public void decreaseResources(
			List<SerializablePair<Resource, Integer>> resources) {
		for (SerializablePair<Resource, Integer> requiredResource : resources) {
			for (int i = 0; i < storedResources.size(); i++) {

				if (requiredResource.first.getName().equals(
						storedResources.get(i).first.getName())) {
					SerializablePair<Resource, Integer> updatedResource = new SerializablePair<Resource, Integer>(
							requiredResource.first,
							storedResources.get(i).second
									- requiredResource.second);
					storedResources.set(i, updatedResource);
				}
			}
		}
	}

	/**
	 * Checks if the requiredBuildings are present
	 * 
	 * @param requiredBuildings
	 * @return
	 */
	public boolean hasBuildings(List<String> requiredBuildings) {
		if (requiredBuildings == null || requiredBuildings.size() == 0) {
			return true;
		}
		boolean buildingFound = false;
		for (String requiredBuildingName : requiredBuildings) {
			for (Building constructedBuilding : constructedBuildings) {
				if (constructedBuilding.getBuildingDefinition().getName()
						.equals(requiredBuildingName)) {
					buildingFound = true;
					break;
				}
			}
			if (!buildingFound) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if the MoonBase can provide the required power
	 * 
	 * @param requiredPower
	 * @return
	 */
	public boolean hasPower(int requiredPower) {
		if (requiredPower <= 0)
			return true;
		if (requiredPower < this.power)
			return true;
		else
			return false;
	}

	/**
	 * Allows adding power to MoonBase
	 * 
	 * @param power
	 */
	public void addPower(int power) {
		this.power += power;
	}

	/**
	 * Decreases the available power Caution!!: Use hasPower() for confirmation
	 * before calling this function
	 * 
	 * @param power
	 */
	public void decreasePower(int power) {
		this.power -= power;
	}

	/**
	 * Returns number of constructed buildings having specified name
	 * 
	 * @param buildingName
	 * @return
	 */
	public int getNumberOfConstructedBuildings(String buildingName) {
		int cnt = 0;
		for (Building b : this.constructedBuildings) {
			if (b.getBuildingDefinition().getName().equals(buildingName)) {
				++cnt;
			}
		}
		return cnt;
	}

	/**
	 * Returns number of buildings with specified name which are under
	 * construction
	 * 
	 * @param buildingName
	 * @return
	 */
	public int getNumberOfBuildingsUnderConstruction(String buildingName) {
		int cnt = 0;
		for (Building b : this.buildingsUnderConstruction) {
			if (b.getBuildingDefinition().getName().equals(buildingName)) {
				++cnt;
			}
		}
		return cnt;
	}

	/**
	 * Checks if a building with given name is present or not
	 * 
	 * @param name
	 * @return
	 */
	public boolean isBuildingPresent(String name) {
		for (Building b : constructedBuildings) {
			if (b.getBuildingDefinition().getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the number of constructed buildings having specified name
	 * 
	 * @param buildingName
	 * @return
	 */
	public int getNoOfActiveBuildings(String buildingName) {
		int num = 0;
		for (Building b : constructedBuildings) {
			if (b.getBuildingDefinition().getName().equals(buildingName)
					&& b.isActive()) {

				++num;
			}
		}
		Log.i("active: ", num + " " + buildingName + " are active");
		return num;
	}

	/**
	 * Checks if there is at least one building with the specified name that is
	 * active
	 * 
	 * @param buildingName
	 * @return
	 */
	public boolean isBuildingActive(String buildingName) {
		for (Building b : constructedBuildings) {
			if (b.getBuildingDefinition().getName().equals(buildingName)
					&& b.isActive()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns outputResources from its active buildings
	 * 
	 * @param buildingName
	 * @return
	 */
	public List<SerializablePair<Resource, Integer>> getOutputResources(
			String buildingName) {
		int noOfConstructedBuildings = getNoOfActiveBuildings(buildingName);
		List<SerializablePair<Resource, Integer>> outputResourcesPerBuilding = Buildings
				.getInstance().getBuilding(buildingName).getOutputResources();
		List<SerializablePair<Resource, Integer>> outputResources = new ArrayList();

		for (SerializablePair<Resource, Integer> outputResourcePerBuilding : outputResourcesPerBuilding) {
			SerializablePair<Resource, Integer> outputResource = new SerializablePair(
					outputResourcePerBuilding.first,
					outputResourcePerBuilding.second * noOfConstructedBuildings);
			Log.i("getOutputResources()", buildingName + ": "
					+ outputResource.first.getName() + " amount: "
					+ outputResource.second);
			outputResources.add(outputResource);
		}

		return outputResources;
	}

	// Getters and Setters
	public List<SerializablePair<Resource, Integer>> getStoredResources() {
		return storedResources;
	}

	public void setStoredResources(
			List<SerializablePair<Resource, Integer>> storedResources) {
		this.storedResources = storedResources;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public List<Building> getConstructedBuildings() {
		return constructedBuildings;
	}

	public void setConstructedBuildings(List<Building> constructedBuildings) {
		this.constructedBuildings = constructedBuildings;
	}

	public int getMonth() {
		return currentMonth;
	}

	public void setMonth(int inMonth) {
		this.currentMonth = inMonth;
	}

	public void incrementMonth() {
		++this.currentMonth;
	}

	public List<Building> getBuildingsUnderConstruction() {
		return buildingsUnderConstruction;
	}

	public void setBuildingsUnderConstruction(
			List<Building> buildingsUnderConstruction) {
		this.buildingsUnderConstruction = buildingsUnderConstruction;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}
}
