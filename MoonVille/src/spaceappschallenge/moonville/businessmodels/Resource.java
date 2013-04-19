package spaceappschallenge.moonville.businessmodels;

public class Resource {
	protected String name;
	protected int amount;
	protected double quality;
	
	public Resource(String name, int amount, double quality) {
		super();
		this.name = name;
		this.amount = amount;
		this.quality = quality;
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
	
	
}
