package spaceappschallenge.moonville.businessmodels;

public class Resource {
	protected String type;
	protected int amount;
	protected float quality;
	
	public Resource(String type, int amount, float quality) {
		super();
		this.type = type;
		this.amount = amount;
		this.quality = quality;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getQuality() {
		return quality;
	}
	public void setQuality(float quality) {
		this.quality = quality;
	}
	
	
}
