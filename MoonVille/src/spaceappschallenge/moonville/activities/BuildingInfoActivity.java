package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.GameActivity;
import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.MoonBase;
import spaceappschallenge.moonville.factories.Buildings;
import spaceappschallenge.moonville.factories.MoonBaseManager;
import spaceappschallenge.moonville.listadapters.BuildingInfoListAdapter;
import spaceappschallenge.moonville.xml_parsers.BuildingDefinition;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BuildingInfoActivity extends GameActivity {

	private String buildingName;
	private TextView buildingScale;
	private BuildingInfoListAdapter buildingInfoListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_info);

		// the building passed through via baseoverviewactivity
		this.buildingName = getIntent().getExtras().getString("Building");

		ImageView buildingImage = (ImageView) findViewById(R.id.buildingimage);

		android.content.res.Resources res = this.getResources();

		int resID = res.getIdentifier("ref_"
				+ buildingName.replace(" ", "_").toLowerCase(), "drawable",
				getPackageName());
		Drawable buildingDrawable = res.getDrawable(resID);
		buildingImage.setImageDrawable(buildingDrawable);

		MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();

		buildingScale = (TextView) findViewById(R.id.noOfBuildingsText);
		buildingScale.setText("Buildings: "
				+ moonBase.getNumberOfConstructedBuildings(buildingName));

		// Show Description of the building
		TextView buildingInfo = (TextView) findViewById(R.id.buildinginfo);
		buildingInfo.setText(Buildings.getInstance()
				.getBuilding(this.buildingName).getInfo());

		// Show stats of the building in a list view
		buildingInfoListAdapter = new BuildingInfoListAdapter(buildingName);
		ListView buildingInfoList = (ListView) findViewById(R.id.buildinginfolist);
		buildingInfoList.setAdapter(buildingInfoListAdapter);
	}

	public void constructBuilding(View view) {

		MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
		moonBase.construct(Buildings.getInstance().getBuilding(buildingName));
		startActivity(new Intent(this, BaseOverviewActivity.class));
		finish();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			startActivity(new Intent(this, BaseOverviewActivity.class));
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_building_info, menu);
		return true;
	}

}
