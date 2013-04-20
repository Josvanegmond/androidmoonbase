package spaceappschallenge.moonville.businessmodels;

import java.util.List;

public class Resource {
	protected String name;
	protected int amount;
	protected double quality;
	protected int unitCost;

	public Resource(String name, int amount, double quality) {
		super();
		this.name = name;
		this.amount = amount;
		this.quality = quality;
	}

	public Resource(String name, int amount, double quality, int unitCost) {
		super();
		this.name = name;
		this.amount = amount;
		this.quality = quality;
		this.unitCost = unitCost;
	}
	
	/**
	 * Merges two lists of resources, by merging identical resources and adding 
	 * up their amount. Assumes no identical resources within a list.
	 */
	public static List<Resource> merge(List<Resource> a, List<Resource> b) {
		for (Resource ra : a) {
			for (Resource rb : b) {
				if (ra.getName() == rb.getName()) {
					ra.setAmount(ra.getAmount() + rb.getAmount());
					b.remove(rb);
				}
			}
		}
		a.addAll(b);
		return a;		
	}

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

	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}

	public int getUnitCost() {
		return this.unitCost;
	}

}
