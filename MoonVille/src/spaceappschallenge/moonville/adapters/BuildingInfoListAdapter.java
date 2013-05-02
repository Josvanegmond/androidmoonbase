package spaceappschallenge.moonville.adapters;

import spaceappschallenge.moonville.businessmodels.Building;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class BuildingInfoListAdapter extends BaseAdapter
{
	private Building building;
	
	public BuildingInfoListAdapter( Building building )
	{
		this.building = building;
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
