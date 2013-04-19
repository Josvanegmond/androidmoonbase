package spaceappschallenge.moonville.businessmodels;

public class GameDetails {
	String username="";
	String difficultyLevel="";
	private static GameDetails instance=null;
	protected GameDetails(){
		
	}
	
	public static GameDetails getInstance(){
		if(GameDetails.instance==null){
			GameDetails.instance=new GameDetails();
		}
		return GameDetails.instance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	
}
