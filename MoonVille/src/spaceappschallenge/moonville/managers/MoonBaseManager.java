/*
 * A singleton class which manages moon bases. It also identifies the current moon base.
 */
package spaceappschallenge.moonville.managers;
import java.util.List;

import spaceappschallenge.moonville.businessmodels.*;
public class MoonBaseManager {
	private static MoonBaseManager instance = null;
	protected MoonBaseManager(){
		//Read available choice of moon bases from flat file??
	}
	public static MoonBaseManager getInstance(){
		if(instance==null){
			instance=new MoonBaseManager();
		}
		return instance;
	}
	protected List<MoonBase> moonBases;
	protected MoonBase currentMoonBase;
	public List<MoonBase> getMoonBases() {
		return moonBases;
	}
	public void setMoonBases(List<MoonBase> moonBases) {
		this.moonBases = moonBases;
	}
	public MoonBase getCurrentMoonBase() {
		return currentMoonBase;
	}
	public void setCurrentMoonBase(MoonBase currentMoonBase) {
		this.currentMoonBase = currentMoonBase;
	}
}
