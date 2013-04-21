package spaceappschallenge.moonville;

import android.app.Application;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;

/**
 * Plays background music while any activity is opened.
 * 
 * @author Felix
 *
 */
public class MoonVille extends Application {
	
	public static String PREFERENCE_FILE = "preferences";
	public static String PREFERENCE_BACKGROUND_MUSIC = 
			"moonvile_background_music";

	MediaPlayer player = null;
	
	private int currentActivityCount = 0;
	
	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	public void resumeActivity() {
		currentActivityCount++;
		visibilityChanged();
	}
	
	public void pauseActivity() {
		currentActivityCount--;
		visibilityChanged();
	}
	
	public void visibilityChanged() {	
		Handler myHandler = new Handler();
		// Wait a moment in case we are switching activities within this app.
		// (Otherwise, sound might be stopped and started at each activity 
		// change).
		myHandler.postDelayed(backgroundSoundRunnable, 100);
	}
	
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
			else {
				if (player != null) {
					player.release();
					player = null;
				}    		
			}
	    }
	 };
}
