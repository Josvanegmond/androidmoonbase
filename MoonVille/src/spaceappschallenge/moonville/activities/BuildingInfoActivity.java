package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.GameActivity;
import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.factories.Buildings;
import spaceappschallenge.moonville.managers.MoonBaseManager;
import spaceappschallenge.moonville.xml_parsers.BuildingDefinition;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BuildingInfoActivity extends GameActivity {

	private BuildingDefinition building;
	private TextView buildingScale;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_info);
		
		//the building passed through via baseoverviewactivity
		this.building = Buildings.getInstance().getBuilding(getIntent().getExtras().getString("Building"));
		
		
		ImageView buildingImage = (ImageView) findViewById( R.id.buildingimage );

		android.content.res.Resources res = this.getResources();

		int resID = res
				.getIdentifier("ref_"
						+ building.getName().replace(" ", "_")
								.toLowerCase(), "drawable",
						getPackageName());
		Drawable buildingDrawable = res.getDrawable(resID);
		buildingImage.setImageDrawable(buildingDrawable);
		
		
		buildingScale = (TextView) findViewById( R.id.buildingscaletext );
		buildingScale.setText( "Building scale: " + building.getAmount() );
		
		//TextView buildingName = (TextView) findViewById( R.id.buildingname );
		//buildingName.setText( building.getName() );
	}
	
	public void build( View view )
	{
		MoonBaseManager.getCurrentMoonBase().addBuilding(building.getName());
		buildingScale.setText( "Building scale: " + 
					MoonBaseManager.getCurrentMoonBase().getBuildingAmount(building.getName()));
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
