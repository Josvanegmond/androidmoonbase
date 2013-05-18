package spaceappschallenge.moonville.listadapters;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.MoonBase;
import spaceappschallenge.moonville.domain.Resource;
import spaceappschallenge.moonville.factories.MoonBaseManager;
import spaceappschallenge.moonville.factories.Resources;
import spaceappschallenge.moonville.miscellaneous.SerializablePair;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class ExportResourceListAdapter extends BaseAdapter {
	private List<SerializablePair<Resource, Integer>> resourceList;

	public ExportResourceListAdapter(
			List<SerializablePair<Resource, Integer>> resourceList) {
		this.resourceList = resourceList;
	}

	@Override
	public int getCount() {
		return resourceList.size();
	}

	@Override
	public Object getItem(int index) {
		return resourceList.get(index);
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	@Override
	public View getView(int index, View convertView, ViewGroup parent) {
		Resource resource = this.resourceList.get(index).first;
		int amount = this.resourceList.get(index).second;
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.listitem_export_resource,
					parent, false);
		}

		TextView resourceDescription = (TextView) convertView
				.findViewById(R.id.export_resource_description);
		resourceDescription.setText(amount + " units of " + resource.getName()
				+ " at $" + resource.getExportPrice() * amount);

		/*
		 * // Add name TextView resourceName = (TextView) convertView
		 * .findViewById(R.id.exportresourcename);
		 * 
		 * // Add amount TextView resourceAmount = (TextView) convertView
		 * .findViewById(R.id.exportresourcequantity);
		 * 
		 * // Add price TextView resourcePrice = (TextView) convertView
		 * .findViewById(R.id.exportresourcecost);
		 * resourceName.setText(resource.getName());
		 * resourceAmount.setText(""+amount); resourcePrice.setText("" + amount
		 * * resource.getExportPrice());
		 */

		return convertView;
	}
	
	


}
