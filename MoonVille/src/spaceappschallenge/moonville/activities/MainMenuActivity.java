package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.managers.MoonBaseManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainmenu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_base_overview, menu);
		return true;
	}
	

	//methods called by onClick property of button in xml
	public void showBaseOverviewScreen( View view )
	{
		MoonBaseManager.loadSavedMoonbase();
		view.getContext().startActivity( new Intent( this, BaseOverviewActivity.class ) );
	}
	
	public void showNewCompanyScreen( View view )
	{
		view.getContext().startActivity( new Intent( this, NewCompanyActivity.class ) );
	}

//	public void showCreditsScreen( View view )
//	{
//		view.getContext().startActivity( new Intent( this, CreditsActivity.class ) );
//	}
	

}
