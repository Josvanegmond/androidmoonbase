/*
 * Starts the game. Initializes managers based on user choices.
 */
package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.businessmodels.GameDetails;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NewGameActivity extends Activity {
	protected GameDetails gameDetails;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_game);

		// initModel();//Model is dependent on the difficulty level right?
	}

	

	public void startNewGame(View view) {
		gameDetails =GameDetails.getInstance();
		retrieveUserInputs();
		initModel();
		showBaseOverviewScreen(view);
	}

	//Retrieve user name and difficulty level
	protected void retrieveUserInputs() {
		EditText userNameEditText = (EditText) findViewById(R.id.userNameEditText);
		String userName = userNameEditText.getText().toString();
		gameDetails.setUsername(userName);
		
		RadioGroup difficultyRadioGroup = (RadioGroup) findViewById(R.id.difficultyRadioGroup);
		int radioButtonId = difficultyRadioGroup.getCheckedRadioButtonId();
		RadioButton selectedButton = (RadioButton) difficultyRadioGroup
				.findViewById(radioButtonId);
		String difficultyLevel = selectedButton.getText().toString();
		gameDetails.setDifficultyLevel(difficultyLevel);
		
		Toast toast = Toast.makeText(this, gameDetails.getDifficultyLevel(), 2000);
		toast.show();
	}
	
	protected void initModel() {
		// Dummy models

		// MoonBase moonBase = new MoonBase()
		// MoonBase should become a singleton I think, best way to make it
		// easily accessible -Jos
	}

	// I changed the init method to this one, which is triggered by the onClick
	// property in the xml of the button
	// since we are using separate activities, this is a very easy way to
	// implement navigation IMO.
	public void showBaseOverviewScreen(View view) {
		view.getContext().startActivity(
				new Intent(this, BaseOverviewActivity.class));
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_new_game, menu);
		return true;
	}

}
