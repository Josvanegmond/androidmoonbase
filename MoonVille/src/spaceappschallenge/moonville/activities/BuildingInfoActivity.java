package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.GameActivity;
import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.adapters.BuildingInfoListAdapter;
import spaceappschallenge.moonville.businessmodels.MoonBase;
import spaceappschallenge.moonville.managers.MoonBaseManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BuildingInfoActivity extends GameActivity {

	private String buildingName;
	private TextView buildingScale;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_info);
		
		//the building passed through via baseoverviewactivity
		this.buildingName = getIntent().getExtras().getString("Building");
		
		
		ImageView buildingImage = (ImageView) findViewById( R.id.buildingimage );

		android.content.res.Resources res = this.getResources();

		int resID = res
				.getIdentifier("ref_"
						+ buildingName.replace(" ", "_")
								.toLowerCase(), "drawable",
						getPackageName());
		Drawable buildingDrawable = res.getDrawable(resID);
		buildingImage.setImageDrawable(buildingDrawable);

		MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
		
		buildingScale = (TextView) findViewById( R.id.buildingscaletext );
		buildingScale.setText("Building scale: " + 
					moonBase.getBuildingAmount(buildingName));
		
		BaseAdapter buildingInfoListAdapter = new BuildingInfoListAdapter( moonBase.getBuilding( buildingName ) );
		
		ListView buildingInfoList = (ListView) findViewById( R.id.buildinginfolist );
		buildingInfoList.setAdapter( buildingInfoListAdapter );
	}
	
	public void build( View view ) {

		MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
		
		if (moonBase.canBuild(buildingName)) {
			moonBase.addBuilding(buildingName);
			buildingScale.setText("Building scale: " + 
					moonBase.getBuildingAmount(buildingName));
		}
		else {
			// TODO: Show the reason (missing resources, required building etc.).
			Toast.makeText(this, "Can't build at this time", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
	    if ((keyCode == KeyEvent.KEYCODE_BACK))
	    {
			startActivity(
					new Intent(this, BaseOverviewActivity.class));
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
