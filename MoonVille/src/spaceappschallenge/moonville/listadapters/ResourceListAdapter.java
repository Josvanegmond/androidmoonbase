package spaceappschallenge.moonville.listadapters;

import java.util.ArrayList;
import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.businessmodels.Resource;
import spaceappschallenge.moonville.factories.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ResourceListAdapter extends BaseAdapter
{
	private ArrayList<Resource> allResources;
	
	public ResourceListAdapter()
	{
		//get the resources via the factory
		this.allResources = Resources.getInstance().getAllResources();
	}
	
	
	@Override
	public int getCount()
	{
		return allResources.size();
	}

	@Override
	public Object getItem( int index )
	{
		return allResources.get( index );
	}

	@Override
	public long getItemId( int index )
	{
		return index;
	}

	@Override
	public View getView( int index, View convertView, ViewGroup parent )
	{
		Resource resource = this.allResources.get( index );
		
		if( convertView == null )
		{
			LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
			convertView = inflater.inflate( R.layout.listitem_resource, parent, false );
		}
		
		TextView resourceName = (TextView) convertView.findViewById( R.id.resourceNameTextView );
		resourceName.setText( resource.getName() );
		
		return convertView;
	}

}
