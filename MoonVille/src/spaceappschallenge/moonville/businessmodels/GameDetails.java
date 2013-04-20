package spaceappschallenge.moonville.businessmodels;

import spaceappschallenge.moonville.managers.Reference;

public class GameDetails {
	String username = "";
	int difficultyLevel = Reference.DIF_EASY;
	private static GameDetails instance = null;

	protected GameDetails() {

	}

	public static GameDetails getInstance() {
		if (GameDetails.instance == null) {
			GameDetails.instance = new GameDetails();
		}
		return GameDetails.instance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

}
