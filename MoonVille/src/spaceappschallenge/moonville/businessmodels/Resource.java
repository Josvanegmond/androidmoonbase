package spaceappschallenge.moonville.businessmodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*
 * A resource can be imported/exported and produced by buildings. Most 
 * importantly, they are used to construct buildings.
 */
public class Resource implements Serializable {
	protected String name;
	protected int amount;
	protected double quality;
	protected int unitImportPrice;
	protected int unitExportPrice;
	protected int weight;

	public Resource(String name, int amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

	
	public Resource(String name, double quality, int unitImportPrice,
			int unitExportPrice, int weight) {
		super();
		this.name = name;
		this.quality = quality;
		this.unitImportPrice = unitImportPrice;
		this.unitExportPrice = unitExportPrice;
		this.weight = weight;
	}

	public Resource(String name, int amount, double quality, int unitImportPrice,
			int unitExportPrice, int weight) {
		super();
		this.name = name;
		this.amount = amount;
		this.quality = quality;
		this.unitImportPrice = unitImportPrice;
		this.unitExportPrice = unitExportPrice;
		this.weight = weight;
	}
	
	public Resource(Resource r) {
		super();
		name = r.name;
		amount = r.amount;
		quality = r.quality;
		unitImportPrice = r.unitImportPrice;
		unitExportPrice = r.unitExportPrice;
		weight = r.weight;
	}

	/**
	 * Merges two lists of resources, by merging identical resources and adding
	 * up their amount. Assumes no identical resources within a list.
	 */
	public static List<Resource> merge(List<Resource> a, List<Resource> b) {
		final Map<String, Resource> map =  new TreeMap<String, Resource>();
		for (Resource r : a) 
			map.put(r.getName(), new Resource(r));
		for (Resource r : b) {
			if (map.containsKey(r.getName())) {
				Resource existing = map.get(r.getName());
				existing.setAmount(existing.getAmount() + r.getAmount());
			}
			else
				map.put(r.getName(), new Resource(r));					
		}
		return new ArrayList<Resource>(map.values());
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getQuality() {
		return quality;
	}

	public void setQuality(double quality) {
		this.quality = quality;
	}

	public int getImportPrice() {
		return unitImportPrice;
	}

	public void setUnitImportPrice(int unitImportPrice) {
		this.unitImportPrice = unitImportPrice;
	}

	public int getUnitExportPrice() {
		return unitExportPrice;
	}

	public void setUnitExportPrice(int unitValue) {
		this.unitExportPrice = unitValue;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
