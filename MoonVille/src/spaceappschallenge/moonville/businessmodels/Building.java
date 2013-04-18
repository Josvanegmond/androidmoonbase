package spaceappschallenge.moonville.businessmodels;

import java.util.List;

public class Building {
	protected String name;
	protected String info;
	protected int amount;
	protected List<Resource> inputResources;
	protected List<Building> inputBuildings;
	protected List<Resource> requiredResources;
	protected List<Building> requiredBuildings;
	protected List<Resource> outputResources;
	protected int inputPower;
	protected int outputPower;
	
	public Building(String name, String info, int amount,
			List<Resource> requiredResources, List<Building> requiredBuildings,
			List<Resource> outputResources, List<Building> outputBuildings,
			int inputPower, int outputPower) {
		super();
		this.name = name;
		this.info = info;
		this.amount = amount;
		this.requiredResources = requiredResources;
		this.requiredBuildings = requiredBuildings;
		this.outputResources = outputResources;
		this.inputPower = inputPower;
		this.outputPower = outputPower;
	}
	
	//Increases amount, if input resources/buildings fulfill required resources/buildings
	public void build()
	{
		for (int i=requiredResources.size()-1;i>=0;i--){
			
		}
	}
	
	
	
	
	
}
