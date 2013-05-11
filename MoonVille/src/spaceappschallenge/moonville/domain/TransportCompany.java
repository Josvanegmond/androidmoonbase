package spaceappschallenge.moonville.domain;

import java.io.Serializable;

public class TransportCompany implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3928258998268313288L;
	private int res_logo;
	private String name;
	private String slogan;
	private int launchCost;
	private int weightCapacity;
	
	public TransportCompany( int res_logo, String name, String slogan, int launchCost, int weightCapacity )
	{
		this.res_logo = res_logo;
		this.name = name;
		this.slogan = slogan;
		this.launchCost = launchCost;
		this.weightCapacity = weightCapacity;
	}

	public int getRes_logo() {
		return res_logo;
	}

	public String getName() {
		return name;
	}

	public String getSlogan() {
		return slogan;
	}

	public int getLaunchCost() {
		return launchCost;
	}

	public int getWeightCapacity() {
		return weightCapacity;
	}
}
