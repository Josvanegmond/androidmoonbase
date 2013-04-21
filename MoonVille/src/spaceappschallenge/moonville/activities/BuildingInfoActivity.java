package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.GameActivity;
import spaceappschallenge.moonville.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.ImageView;

public class BuildingInfoActivity extends GameActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_info);
		
		ImageView buildingImage = (ImageView) findViewById( R.id.buildingimage );
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
	    if ((keyCode == KeyEvent.KEYCODE_BACK))
	    {
			startActivity(
					new Intent(BuildingInfoActivity.this, BaseOverviewActivity.class));
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
