package spaceappschallenge.moonville.domain;

import java.io.Serializable;

/**
 * Provides values based on difficulty level.
 */
public class Difficulty implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5813235211061576115L;
	public static final int DIF_EASY = 0;
	public static final int DIF_MED = 1;
	public static final int DIF_HARD = 2;

	private int researchPoints;
	private int prospectingLevel;
	private int money;

	// some basic difficulties... not final! ~ jodli
	public Difficulty(int difficultyLevel) {
		switch (difficultyLevel) {
		case DIF_EASY:
			this.researchPoints = 100;
			this.prospectingLevel = 10;
			this.money = 100000000;
			break;
		case DIF_MED:
			this.researchPoints = 50;
			this.prospectingLevel = 5;
			this.money = 10000000;
			break;
		case DIF_HARD:
			this.researchPoints = 25;
			this.prospectingLevel = 3;
			this.money = 1000000;
			break;

		default:
			// no difficulty level selected - assuming easy - this shouldnt
			// happen... ~ jodli
			this.researchPoints = 100;
			this.prospectingLevel = 10;
			this.money = 10000000;
			break;
		}
	}

	public int getResearchPoints() {
		return researchPoints;
	}

	public int getProspectingLevel() {
		return prospectingLevel;
	}

	public int getMoney() {
		return money;
	}
}
