package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.managers.MoonBaseManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

public class BaseOverviewActivity extends Activity {

    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_overview);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_base_overview, menu);
		return true;
	}

	

	
	//methods called by onClick property of button in xml
	public void nextTurn( View view )
	{
		//calculate resources from all buildings, starting at the bottom of the building tree
		//per building:
		//are required buildings still available?
		//is required power available?
		//are there enough required resources?
		//calculate output in combination with research and prospecting bonus
		//add output resources via resources factory
		//drain power
		//calculate reputation
		
		//last step, save to file
		MoonBaseManager.saveMoonBase();
	}
	
	
	public void showBaseOverviewScreen( View view )
	{
		//we are already here
		//view.getContext().startActivity( new Intent( this, BaseOverviewActivity.class ) );
		//this.finish();
	}
	
	public void showBuildingScreen( View view )
	{
		view.getContext().startActivity( new Intent( this, BuildingsActivity.class) );
		this.finish();
	}
	
	public void showResourcesScreen( View view )
	{
		view.getContext().startActivity( new Intent( this, ResourcesActivity.class ) );
		this.finish();
	}

	
	public void showExportScreen( View view )
	{
		view.getContext().startActivity( new Intent( this, ResourcesActivity.class ) );
		this.finish();
	}
}
