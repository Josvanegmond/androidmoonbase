/*
 * Company can advance by researching or by building infrastructure for: transportation, extraction of resources
 	and construction of buildings.
 */
package spaceappschallenge.moonville.managers;

public class Advancement{
	//Advancement areas
	public static int TRANSPORT=0;
	public static int RESOURCE=1;
	public static int BUILDING=2;
	
	//Methods of advancement: conducting research and building infrastructure
	public static int RESEARCH = 0;
	public static int INFRASTRUCTURE=1;
	
	protected float advancement[][];//efficiency[TRANSPORT][RESEARCH]
	private static Advancement instance=null;
	
	protected Advancement(){
		advancement = new float[3][2];
	}
	
	public static Advancement getInstance(){
		if(instance==null)
			instance=new Advancement();
		return instance;
	}
	
	public void setAdvancement(int area, int method, float advancementLevel){
		advancement[area][method] = advancementLevel;
	}
	public float[][] getAdvancement(){
		return this.advancement;
	}
	
	/*
	 * Provide the following parameters to retrieve the level of advancement
	 * @params:
	 * @area:   TRANSPORT=0, RESOURCE=1, BUILDING=2 
	 * @method: RESEARCH=0, INFRASTRUCTURE=1	              	
	 */
	public float getAdvancement(int area, int method){
		return this.advancement[area][method];
	}

	//Use it as follows:
	public static void main(String[] args){
		Advancement adv = new Advancement();
		adv.setAdvancement(Advancement.TRANSPORT, Advancement.RESOURCE, (float)0.2);
		System.out.println(adv.getAdvancement(Advancement.TRANSPORT, Advancement.RESOURCE));
		
	}
	}
