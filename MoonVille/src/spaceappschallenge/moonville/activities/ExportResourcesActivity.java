package spaceappschallenge.moonville.activities;

import java.util.List;

import spaceappschallenge.moonville.GameActivity;
import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.ImportCompany;
import spaceappschallenge.moonville.domain.MoonBase;
import spaceappschallenge.moonville.domain.Resource;
import spaceappschallenge.moonville.factories.ImportCompanies;
import spaceappschallenge.moonville.factories.MoonBaseManager;
import spaceappschallenge.moonville.listadapters.ExportResourceListAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
	
	/**
	 * export grabs the selected company, checks the resource demand, and compares it to the resources stored in moonbase.
	 * If there are enough resources, the resources are substracted from moonbase and money is added.
	 * 
	 * TODO: reputation involvement
	 */
	public void export( View view )
	{
		MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
		ImportCompany company = companies.get( this.companyIndex );
		
		List<Resource> moonBaseResources = moonBase.getStoredResources();
		List<Resource> importResources = company.getImportResources();
		
		boolean canExport = true;
		
		//check if enough resources have been gathered to export the resources
		//canExport will be set accordingly
		for( Resource importResource : importResources )
		{
			Resource moonBaseResource = null;
			
			for( Resource searchResource : moonBaseResources )
			{
				if( searchResource.getName().equals( importResource.getName() ) )
				{
					moonBaseResource = searchResource;
					break;
				}
			}
			
			if( moonBaseResource != null )
			{
				if( moonBaseResource.getAmount() < importResource.getAmount() )
				{
					canExport = false;
					Toast.makeText( this, "Can't export, resources in stock, but demand not satisfied", 500 ).show();
					
				}
			}
			else
			{
				canExport = false;
				Toast.makeText( this, "Can't export, demanded resources not in stock", 500 ).show();
			}
		}
		
		//if we can export, substract resources and add money
		if( canExport == true )
		{
			moonBase.setMoney( moonBase.getMoney() + company.getPayment() );
			Toast.makeText( this, "Exported, payment is " + company.getPayment(), 500 ).show();
		}
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
