package spaceappschallenge.moonville;

import android.app.Activity;

/**
 * Notifies MoonVille each time an activity is opened or closed. This class
 * should be used for all activites.
 * 
 * @author Felix
 *
 */
public class GameActivity extends Activity {
	
	/**
	 * Calls MoonVile.resumeActivity.
	 */
	@Override
	protected void onResume() {
		super.onResume();
		MoonVille mv = (MoonVille) getApplication();
		mv.resumeActivity();
	}

	@Override
	protected void onPause() {
		super.onPause();
		MoonVille mv = (MoonVille) getApplication();
		mv.pauseActivity();
	}
}
