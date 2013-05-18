package spaceappschallenge.moonville.domain;

/**
 * Research
 *
 */
public class Research {
	protected String name;
	protected String info;
	protected int inputPower;
	protected int monetaryCost;
	protected int requiredTurns;
	
	//Constructor
	public Research(String name, String info, int inputPower, int monetaryCost,
			int requiredTurns) {
		super();
		this.name = name;
		this.info = info;
		this.inputPower = inputPower;
		this.monetaryCost = monetaryCost;
		this.requiredTurns = requiredTurns;
	}
	//Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getInputPower() {
		return inputPower;
	}
	public void setInputPower(int inputPower) {
		this.inputPower = inputPower;
	}
	public int getMonetaryCost() {
		return monetaryCost;
	}
	public void setMonetaryCost(int monetaryCost) {
		this.monetaryCost = monetaryCost;
	}
	public int getRequiredTurns() {
		return requiredTurns;
	}
	public void setRequiredTurns(int requiredTurns) {
		this.requiredTurns = requiredTurns;
	}
	
	
}
