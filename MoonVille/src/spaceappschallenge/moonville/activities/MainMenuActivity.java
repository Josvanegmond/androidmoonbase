package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.factories.ApplicationService;
import spaceappschallenge.moonville.factories.MoonBaseManager;
import spaceappschallenge.moonville.miscellaneous.MoonVille;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainMenuActivity extends GameActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainmenu);
		// The following line allows us to share the application context
		// throughout the application
		// Other classes can access the context through ApplicationService
		ApplicationService app = ApplicationService.getInstance();
		app.setApplicationContext(this.getApplicationContext());
		CheckBox cb = (CheckBox) findViewById(R.id.cb_background_music);
		SharedPreferences settings = getSharedPreferences(
				MoonVille.PREFERENCE_FILE, 0);
		cb.setChecked(settings.getBoolean(
				MoonVille.PREFERENCE_BACKGROUND_MUSIC, true));
	}

	// methods called by onClick property of button in xml
	public void showBaseOverviewScreen(View view) {
		MoonBaseManager.loadSavedMoonbase(view.getContext());
		if (MoonBaseManager.getCurrentMoonBase() != null) {
			view.getContext().startActivity(
					new Intent(this, BaseOverviewActivity.class));
		} else
			Toast.makeText(this, "No saved game found", Toast.LENGTH_SHORT)
					.show();
	}

	public void showNewGameScreen(View view) {
		view.getContext()
				.startActivity(new Intent(this, NewGameActivity.class));
	}

	public void showCreditsScreen(View view) {
		view.getContext()
				.startActivity(new Intent(this, CreditsActivity.class));
	}

	public void toggleBackgroundMusic(View view) {
		SharedPreferences.Editor editor = getSharedPreferences(
				MoonVille.PREFERENCE_FILE, 0).edit();
		CheckBox cb = (CheckBox) view;
		editor.putBoolean(MoonVille.PREFERENCE_BACKGROUND_MUSIC, cb.isChecked());
		editor.commit();
		MoonVille mv = (MoonVille) getApplication();
		mv.updateSoundState();
	}

}
