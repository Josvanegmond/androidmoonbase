package spaceappschallenge.moonville.listadapters;

import java.util.ArrayList;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.Building;
import spaceappschallenge.moonville.factories.Buildings;
import spaceappschallenge.moonville.xml_parsers.BuildingDefinition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BuildingListAdapter extends BaseAdapter
{
	private ArrayList<BuildingDefinition> allBuildings;
	
	public BuildingListAdapter()
	{
		//get the buildings via the factory
		this.allBuildings = Buildings.getInstance().getAllBuildings();
	}
	
	
	@Override
	public int getCount()
	{
		return allBuildings.size();
	}

	@Override
	public Object getItem( int index )
	{
		return allBuildings.get( index );
	}

	@Override
	public long getItemId( int index )
	{
		return index;
	}

	@Override
	public View getView( int index, View convertView, ViewGroup parent )
	{
		BuildingDefinition building = this.allBuildings.get(index);
		
		if( convertView == null )
		{
			LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
			convertView = inflater.inflate( R.layout.listitem_building, parent, false );
		}
		
		TextView buildingName = (TextView) convertView.findViewById( R.id.buildingname );
		buildingName.setText( building.getName() );
		
		return convertView;
	}

}
