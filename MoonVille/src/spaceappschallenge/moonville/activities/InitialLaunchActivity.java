package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.R.layout;
import spaceappschallenge.moonville.R.menu;
import spaceappschallenge.moonville.factories.ApplicationService;
import spaceappschallenge.moonville.factories.Resources;
import spaceappschallenge.moonville.listadapters.InitialLaunchListAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class InitialLaunchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_initial_launch);
		ApplicationService.setInitialLaunchActivity(this);
		InitialLaunchListAdapter adapter = new InitialLaunchListAdapter(
				Resources.getInstance().getAllResources());
		((ListView) this.findViewById(R.id.il_resourcesListView))
				.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_initial_launch, menu);
		return true;
	}

	public void showBaseOverviewScreen(View view) {
		view.getContext().startActivity(
				new Intent(this, BaseOverviewActivity.class));
		this.finish();
	}
	
	public void showResourceList(View view){
		view.getContext().startActivity(new Intent(this,ResourcesActivity.class));
		this.finish();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
