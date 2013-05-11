package spaceappschallenge.moonville.domain;

import java.io.Serializable;

public class Resource implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9104023380104564668L;
	private String name;
	private double quality;
	private int importPrice;
	private int exportPrice;
	private int weight;
	
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

	public void setName(String name) {
		this.name = name;
	}

	public void setQuality(double quality) {
		this.quality = quality;
	}

	public void setImportPrice(int importPrice) {
		this.importPrice = importPrice;
	}

	public void setExportPrice(int exportPrice) {
		this.exportPrice = exportPrice;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
