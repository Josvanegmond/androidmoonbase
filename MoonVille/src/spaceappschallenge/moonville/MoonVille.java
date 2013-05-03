package spaceappschallenge.moonville;

import android.app.Application;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;

/**
 * Plays background music while any activity is opened. All activities 
 * should imlpement GameActivity to properly play sounds.
 * 
 * @author Felix
 *
 */
public class MoonVille extends Application {
	
	public static String PREFERENCE_FILE = "preferences";
	public static String PREFERENCE_BACKGROUND_MUSIC = 
			"moonvile_background_music";

	
	
	private MediaPlayer player = null;
	private int currentActivityCount = 0;
	

	public void resumeActivity() {
		currentActivityCount++;
		updateSoundState();
	}
	
	public void pauseActivity() {
		currentActivityCount--;
		updateSoundState();
	}
	
	/**
	 * Calls backgroundSoundRunnable after a short delay (in case a new 
	 * activity is loading).
	 */
	public void updateSoundState() {	
		Handler myHandler = new Handler();
		myHandler.postDelayed(backgroundSoundRunnable, 100);
	}
	
	/**
	 * Enables or disables background sound based on activities visibility 
	 * and preferences.
	 */
	private Runnable backgroundSoundRunnable = new Runnable()
	{
	    @Override
	    public void run() {
			SharedPreferences settings = 
					getSharedPreferences(PREFERENCE_FILE, 0);
			if (currentActivityCount > 0 && 
					settings.getBoolean(PREFERENCE_BACKGROUND_MUSIC, true)) {
				if (player == null) {
					player = MediaPlayer.create(MoonVille.this, 
				    		R.raw.moonloop1reformated_small);
				}
				if (!player.isPlaying()) {
			        player.setLooping(true);
			        player.setVolume(100, 100); 
			        player.start(); 		
				}    		
			}
			else if (player != null) {
					player.release();
					player = null; 		
			}
	    }
	 };
}
