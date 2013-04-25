package spaceappschallenge.moonville.activities;

import java.util.List;

import spaceappschallenge.moonville.GameActivity;
import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.businessmodels.ImportCompany;
import spaceappschallenge.moonville.factories.ImportCompanies;
import spaceappschallenge.moonville.listadapters.ExportResourceListAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class ExportResourcesActivity extends GameActivity
{
	private List<ImportCompany> companies;
	private int companyIndex;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_export_resources);
		
		this.companyIndex = 0;
		this.companies = ImportCompanies.getInstance().getCompaniesByMinimumReputation( 100 );
		
		updateUI();
	}

	public void updateUI()
	{
		if( this.companies.size() > 0 )
		{
			ImportCompany company = this.companies.get( this.companyIndex );
			TextView companyName = (TextView) this.findViewById( R.id.companyname );
			TextView companyInfo = (TextView) this.findViewById( R.id.companyinfo );
			ListView exportResourceList = (ListView) this.findViewById( R.id.importresourcelist );
			
			companyName.setText( company.getName() );
			companyInfo.setText( company.getInfo() );
			exportResourceList.setAdapter( new ExportResourceListAdapter( company.getImportResources() ) );
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.activity_export_resources, menu);
		return true;
	}

	
	

	// methods called by onClick property of button in xml
	public void export( View view )
	{
		
	}
	
	
	public void nextImportCompany( View view )
	{
		this.companyIndex++;
		if( this.companyIndex >= this.companies.size() )
		{
			this.companyIndex = 0;
		}
		
		this.updateUI();
	}
	
	
	public void previousImportCompany( View view )
	{
		this.companyIndex--;
		if( this.companyIndex < 0 )
		{
			this.companyIndex = this.companies.size() - 1;
			if( this.companyIndex < 0 )
			{
				this.companyIndex = 0;
			}
		}

		this.updateUI();
	}
	
	
	

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
	    if ((keyCode == KeyEvent.KEYCODE_BACK))
	    {
			startActivity(
					new Intent(ExportResourcesActivity.this, BaseOverviewActivity.class));
	        finish();
	    }
	    return super.onKeyDown(keyCode, event);
	}
	


}
