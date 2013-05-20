package spaceappschallenge.moonville.activities;

import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.BuildingDefinition;
import spaceappschallenge.moonville.factories.Buildings;
import spaceappschallenge.moonville.factories.MoonBaseManager;
import spaceappschallenge.moonville.listadapters.MegaprojectListAdapter;
import android.os.Bundle;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

public class MegaprojectListActivity extends GameActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mega_project_list);

		List<BuildingDefinition> megaprojects = Buildings.getInstance()
				.getAllMegaprojects();
		MegaprojectListAdapter megaprojectListAdapter = new MegaprojectListAdapter(
				megaprojects);

		ListView megaprojectsListView = (ListView) this
				.findViewById(R.id.megaprojectsListView);
		megaprojectsListView.setAdapter(megaprojectListAdapter);
		// ApplicationService.setImportResourcesActivity(this);
		updateUI();
	}
	
	@Override
	protected void onStart() {
	   super.onStart();
	   // In order to not be too narrow, set the window size based on the screen resolution:
	   final int screen_width = getResources().getDisplayMetrics().widthPixels;
	   final int new_window_width = screen_width * 90 / 100; 
	   android.view.WindowManager.LayoutParams layout = getWindow().getAttributes();
	   layout.width = Math.max(layout.width, new_window_width); 
	   getWindow().setAttributes(layout);
	}

	public void updateUI() {
		TextView budgetTextView = (TextView) (this
				.findViewById(R.id.megaprojectBudgetTextView));
		budgetTextView.setText("$"
				+ MoonBaseManager.getCurrentMoonBase().getMoney());
	}

}
