package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.GameActivity;
import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.businessmodels.BuildingTree;
import spaceappschallenge.moonville.businessmodels.MoonBase;
import spaceappschallenge.moonville.managers.MoonBaseManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class BaseOverviewActivity extends GameActivity {

    
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
		MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
		BuildingTree tree = moonBase.getBuiltBuildings();
		tree.checkPower();
		tree.checkRequiredBuildings();
		//calculate resources from all buildings, starting at the bottom of the building tree
		//per building:
		//are there enough required resources?
		//calculate output in combination with research and prospecting bonus
		//add output resources via resources factory
		//calculate reputation
		
		//last step, save to file
		MoonBaseManager.saveMoonBase(view.getContext());
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
