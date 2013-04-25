package spaceappschallenge.moonville.listadapters;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.businessmodels.Resource;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ResourceListAdapter extends BaseAdapter
{
	private List<Resource> resources;
	
	public ResourceListAdapter( List<Resource> resourceList )
	{
		//get the resources via the factory
		this.resources = resourceList;
	}
	
	
	@Override
	public int getCount()
	{
		return resources.size();
	}

	@Override
	public Object getItem( int index )
	{
		return resources.get( index );
	}

	@Override
	public long getItemId( int index )
	{
		return index;
	}

	@Override
	public View getView( int index, View convertView, ViewGroup parent )
	{
		Resource resource = this.resources.get( index );
		
		if( convertView == null )
		{
			LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
			convertView = inflater.inflate( R.layout.listitem_resource, parent, false );
		}
		
		TextView resourceName = (TextView) convertView.findViewById( R.id.resourceNameTextView );
		resourceName.setText( resource.getName() );
		TextView resourceAmount = (TextView) convertView.findViewById( R.id.resourceAmountTextView );
		resourceAmount.setText( "Available\nAmount: "+resource.getAmount() );
		return convertView;
	}

}
