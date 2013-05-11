package spaceappschallenge.moonville.domain;

import java.io.Serializable;

public class Resource implements Serializable
{
	private final String name;
	private final double quality;
	private final int importPrice;
	private final int exportPrice;
	private final int weight;
	
	public Resource( String name, double quality, int importPrice, int exportPrice, int weight )
	{
		this.name = name;
		this.quality = quality;
		this.importPrice = importPrice;
		this.exportPrice = exportPrice;
		this.weight = weight;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getImportPrice()
	{
		return this.importPrice;
	}
	
	public int getExportPrice()
	{
		return this.exportPrice;
	}

	public double getQuality() {
		return quality;
	}

	public int getWeight() {
		return weight;
	}
	
	
}
