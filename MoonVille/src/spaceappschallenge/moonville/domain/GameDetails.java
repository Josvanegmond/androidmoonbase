package spaceappschallenge.moonville.domain;

import java.io.Serializable;

/**
 * Stores game specific settings (player name and difficulty).
 */
public class GameDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7546492796233811239L;
	String username = "";
	int difficultyLevel = Difficulty.DIF_EASY;
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
