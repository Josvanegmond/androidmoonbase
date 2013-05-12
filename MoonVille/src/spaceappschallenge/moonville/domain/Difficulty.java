package spaceappschallenge.moonville.domain;

import java.io.Serializable;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import spaceappschallenge.moonville.factories.ApplicationService;
import spaceappschallenge.moonville.factories.MoonBaseManager;
import spaceappschallenge.moonville.miscellaneous.MoonVille;
import spaceappschallenge.moonville.R;

/**
 * Provides values based on difficulty level.
 */
public class Difficulty implements Serializable {

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
	private Resources resources;

	// some basic difficulties... not final! ~ jodli
	public Difficulty(int difficultyLevel) {
		resources = MoonVille.getContext().getResources();
		switch (difficultyLevel) {

		case DIF_MED:
			this.researchPoints = resources
					.getInteger(R.integer.difficult_research);
			this.prospectingLevel = resources
					.getInteger(R.integer.difficult_prospecting_level);
			this.money = resources.getInteger(R.integer.difficult_money);
			break;
		case DIF_HARD:
			this.researchPoints = resources
					.getInteger(R.integer.medium_research);
			this.prospectingLevel = resources
					.getInteger(R.integer.medium_prospecting_level);
			this.money = resources.getInteger(R.integer.medium_money);
			break;

		default:

			this.researchPoints = resources.getInteger(R.integer.easy_research);
			this.prospectingLevel = resources
					.getInteger(R.integer.easy_prospecting_level);
			this.money = resources.getInteger(R.integer.easy_money);
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
