package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.GameActivity;
import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.listadapters.BuildingListAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class BuildingsActivity extends GameActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buildings);
		
		BuildingListAdapter buildingListAdapter = new BuildingListAdapter();
		
		ListView buildingList = (ListView) this.findViewById( R.id.buildingslist );
		buildingList.setAdapter( buildingListAdapter );
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_buildings, menu);
		return true;
	}
	
	
	
	
	
	
	//methods called by onClick property of button in xml
	public void showBaseOverviewScreen( View view )
	{
		view.getContext().startActivity( new Intent( this, BaseOverviewActivity.class ) );
		this.finish();
	}
	
	public void showBuildingScreen( View view )
	{
		//we are already here
		//view.getContext().startActivity( new Intent( this, BuildingsActivity.class) );
		//this.finish();
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
