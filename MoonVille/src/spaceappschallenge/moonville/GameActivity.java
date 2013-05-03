package spaceappschallenge.moonville;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;

/**
 * Notifies MoonVille each time an activity is opened or closed. This class
 * should be used for all activites.
 * 
 * @author Felix
 *
 */
public class GameActivity extends Activity
{
	
	public static Typeface NASALISATION_FONT;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //set up our custom fonts
        NASALISATION_FONT = Typeface.createFromAsset(getAssets(), "nasalization.ttf");   
    }
	
    
    
    
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
