package spaceappschallenge.moonville.adapters;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.businessmodels.Building;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class BuildingInfoListAdapter extends BaseAdapter
{
	private Building building;
	private List<String> infoList;
	
	public BuildingInfoListAdapter( Building building )
	{
		this.building = building;
		this.infoList = new ArrayList<String>();

		this.infoList.add( "Power levels " + ((building.getHasPower() == true) ? "nominal" : "depleted") );
		this.infoList.add( "Preceding buildings " + ((building.getHasRequiredBuildings() == true) ? "operative" : "shut down") );
		
		if( building.getResourceInput().size() > 0 )
			this.infoList.add( "Resource supply " + ((building.getHasRequiredResources() == true) ? "upholding" : "depleted") );
		
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
			TextView text = new TextView( parent.getContext() );
			text.setLayoutParams( new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT ));
			text.setText( this.infoList.get( position ) );
			convertView = text;
		}
		
		return convertView;
	}

}
