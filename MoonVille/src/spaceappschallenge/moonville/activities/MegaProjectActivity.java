package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.R;
import android.os.Bundle;
import android.view.Menu;

public class MegaProjectActivity extends GameActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mega_project);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_mega_project, menu);
		return true;
	}

}
