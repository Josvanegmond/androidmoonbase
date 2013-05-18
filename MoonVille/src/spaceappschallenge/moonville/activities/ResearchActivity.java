package spaceappschallenge.moonville.activities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.R.layout;
import spaceappschallenge.moonville.R.menu;
import spaceappschallenge.moonville.domain.Research;
import spaceappschallenge.moonville.factories.ApplicationService;
import spaceappschallenge.moonville.factories.Researches;
import spaceappschallenge.moonville.factories.Resources;
import spaceappschallenge.moonville.listadapters.InitialLaunchListAdapter;
import spaceappschallenge.moonville.listadapters.ResearchListAdapter;
import spaceappschallenge.moonville.miscellaneous.SerializablePair;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class ResearchActivity extends GameActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_research);
		Log.i("research","start activity");
		ApplicationService.setResearchActivity(this);
		Log.i("research", "fetching all  research");
		ArrayList<Research> allResearch = Researches.getInstance()
				.getAllResearch();
		Log.i("research", "got all research");
		ArrayList<SerializablePair<Research, Integer>> researchList = new ArrayList<SerializablePair<Research, Integer>>();

		for (Research research : allResearch) {
			researchList.add(new SerializablePair<Research, Integer>(research,
					0));
		}
		Log.i("research", "adding adapter");
		ResearchListAdapter adapter = new ResearchListAdapter(researchList);
		((ListView) this.findViewById(R.id.researchListView))
				.setAdapter(adapter);
		Log.i("research", "adding adapter");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_research, menu);
		return true;
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
