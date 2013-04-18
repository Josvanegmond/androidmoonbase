package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class ResourcesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resources);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_resources, menu);
		return true;
	}
	


	
	//methods called by onClick property of button in xml
	public void showBaseOverviewScreen( View view )
	{
		view.getContext().startActivity( new Intent( this, BaseOverviewActivity.class ) );
	}
	
	public void showBuildingScreen( View view )
	{
		view.getContext().startActivity( new Intent( this, BuildingsActivity.class) );
	}
	
	public void showResourcesScreen( View view )
	{
		//we are already here
		//view.getContext().startActivity( new Intent( this, ResourcesActivity.class ) );
	}

	
	public void showExportScreen( View view )
	{
		view.getContext().startActivity( new Intent( this, ResourcesActivity.class ) );
	}

}
