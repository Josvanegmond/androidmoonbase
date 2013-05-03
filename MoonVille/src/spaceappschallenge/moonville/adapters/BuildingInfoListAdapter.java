package spaceappschallenge.moonville.adapters;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.businessmodels.Building;
import spaceappschallenge.moonville.businessmodels.MoonBase;
import spaceappschallenge.moonville.businessmodels.Resource;
import spaceappschallenge.moonville.factories.Buildings;
import spaceappschallenge.moonville.managers.MoonBaseManager;
import spaceappschallenge.moonville.xml_parsers.BuildingDefinition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BuildingInfoListAdapter extends BaseAdapter
{
	private List<String> infoList;
	
	public BuildingInfoListAdapter( String buildingName )
	{
		this.infoList = new ArrayList<String>();
		
		MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
		Building building = moonBase.getBuilding( buildingName );
		
		//if there is no building, the building has not been made yet and we only acquire data from the matching buildingdefinition
		if( building == null )
		{
			BuildingDefinition buildingDefinition = Buildings.getInstance().getBuilding( buildingName );
			fillBuildingInfo( buildingDefinition );
		}

		else
		{
			fillBuildingInfo( building );
		}
	}
	
	private void fillBuildingInfo( BuildingDefinition buildingDefinition )
	{
		this.infoList.add( buildingDefinition.getRequiredTurns() + " months building time" );
		this.infoList.add( "" );
		
		if( buildingDefinition.getInputPower() > 0 )
			this.infoList.add( "Input power: " + buildingDefinition.getInputPower() + " kWh" );
		
		if( buildingDefinition.getOutputPower() > 0 )
			this.infoList.add( "Output power: " + buildingDefinition.getOutputPower() + "kWh" );
		
		this.infoList.add( "" );
		
		if( buildingDefinition.getRequiredBuildings().size() > 0 )
		{
			this.infoList.add( "Required buildings:" );
			for( String buildingName : buildingDefinition.getRequiredBuildings() )
			{
				this.infoList.add( buildingName );
			}
		}
			
		if( buildingDefinition.getRequiredResources().size() > 0 )
		{
			this.infoList.add( "Processes resources (per month per building):" );
			for( Resource resource : buildingDefinition.getRequiredResources() )
			{
				this.infoList.add( resource.getName() + ": " + (resource.getAmount() * buildingDefinition.getAmount()) );
			}
		}

		this.infoList.add( "" );

		if( buildingDefinition.getOutputResources().size() > 0 )
		{
			this.infoList.add( "Output resources (per month per building):" );
			for( Resource resource : buildingDefinition.getOutputResources() )
			{
				this.infoList.add( resource.getName() + ": " + resource.getAmount() );
			}
		}
	}
	
	private void fillBuildingInfo( Building building )
	{
		this.infoList.add( building.getRequiredTurns() + " months building time" );
		this.infoList.add( "" );
		this.infoList.add( "Power levels " + ((building.getHasPower() == true) ? "nominal" : "depleted") );
		
		if( building.getInputPower() > 0 )
			this.infoList.add( "Input power: " + building.getInputPower() + " kWh" );
		
		if( building.getOutputPower() > 0 )
			this.infoList.add( "Output power: " + building.getOutputPower() + "kWh" );
		
		this.infoList.add( "" );
		
		if( building.getRequiredBuildings().size() > 0 )
			this.infoList.add( "Preceding buildings " + ((building.getHasRequiredBuildings() == true) ? "operative" : "shut down") );
		
		if( building.getResourceInput().size() > 0 )
		{
			this.infoList.add( "Resource supply " + ((building.getHasRequiredResources() == true) ? "upholding" : "depleted") );
			this.infoList.add( "Processed resources (per month):" );
			for( Resource resource : building.getResourceInput() )
			{
				this.infoList.add( resource.getName() + ": " + (resource.getAmount() * building.getAmount()) );
			}
		}

		this.infoList.add( "" );

		if( building.getResourceOutput().size() > 0 )
		{
			this.infoList.add( "Output resources (per month):" );
			for( Resource resource : building.getResourceOutput() )
			{
				this.infoList.add( resource.getName() + ": " + (resource.getAmount() * building.getAmount()) );
			}
		}
	}
	
	
	
	@Override
	public int getCount() {
		return this.infoList.size();
	}

	@Override
	public Object getItem(int position)
	{
		return this.infoList.get( position );
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if( convertView == null )
		{
			View listItem = LayoutInflater.from( parent.getContext() ).inflate( R.layout.listitem_buildinginfo, parent, false );
			convertView = listItem;
		}

		TextView text = (TextView) convertView.findViewById( R.id.buildinginfotext );
		text.setText( this.infoList.get( position ) );
		
		return convertView;
	}

}
