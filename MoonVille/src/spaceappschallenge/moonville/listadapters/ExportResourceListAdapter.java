package spaceappschallenge.moonville.listadapters;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.businessmodels.MoonBase;
import spaceappschallenge.moonville.businessmodels.Resource;
import spaceappschallenge.moonville.factories.Resources;
import spaceappschallenge.moonville.managers.MoonBaseManager;
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
	private ArrayList<Resource> allResources;

	public ExportResourceListAdapter() {
		// get the resources via the factory
		this.allResources = Resources.getInstance().getAllResources();
	}

	@Override
	public int getCount() {
		return allResources.size();
	}

	@Override
	public Object getItem(int index) {
		return allResources.get(index);
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	@Override
	public View getView(int index, View convertView, ViewGroup parent) {
		Resource resource = this.allResources.get(index);

		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.listitem_export_resource,
					parent, false);
		}

		TextView resourceName = (TextView) convertView
				.findViewById(R.id.exportResourceNameTextView);
		resourceName.setText(resource.getName());
		addListenerToSeekBar(convertView);
		addListenerToSellButton(convertView, parent);
		return convertView;
	}

	protected void addListenerToSeekBar(final View convertView) {
		SeekBar quantitySeekBar = (SeekBar) convertView
				.findViewById(R.id.resourceQuantitySeekBar);
		quantitySeekBar
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
					}

					@Override
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {

						String resourceName = ((TextView) convertView
								.findViewById(R.id.exportResourceNameTextView))
								.getText().toString();

						Resource currentResource = Resources.getInstance()
								.getResource(resourceName);
						if (currentResource == null) {
							Log.i("null export resource", resourceName
									+ "not found");
							return;
						}
						int unitProfit = currentResource.getUnitExportPrice();
						int maxExportQuantity = 0;
						List<Resource> list = MoonBaseManager
								.getCurrentMoonBase().getStoredResources();
						for (Resource res : list) {
							if (res.getName().equalsIgnoreCase(
									currentResource.getName())) {
								maxExportQuantity = res.getAmount();
								break;
							}
						}
						Log.i("maxQuantity", "export maxQuantity "
								+ maxExportQuantity);
						float position = (float) progress / 100;
						Log.i("position", "export position " + position);
						int quantity = (int) (position * maxExportQuantity);
						Log.i("quantity", "export quantity " + quantity);

						((TextView) convertView
								.findViewById(R.id.exportResourceQuantityTextView))
								.setText("" + quantity);

						int totalProfit = unitProfit * quantity;
						((TextView) convertView
								.findViewById(R.id.exportResourceCostTextView))
								.setText("" + totalProfit);

						Log.i("yes", "quantity set " + quantity);

					}
				});
	}

	protected void addListenerToSellButton(final View convertView,
			final ViewGroup parent) {
		Button importButton = (Button) convertView
				.findViewById(R.id.exportButton);
		importButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String resourceName = ((TextView) convertView
						.findViewById(R.id.exportResourceNameTextView))
						.getText().toString();
				Resource currentResource = Resources.getInstance().getResource(
						resourceName);

				int unitProfit = currentResource.getUnitExportPrice();
				int quantity = Integer.parseInt(((TextView) convertView
						.findViewById(R.id.exportResourceQuantityTextView))
						.getText().toString());
				int totalProfit = unitProfit * quantity;
				Toast toast;
				toast = Toast.makeText(v.getContext(),
						"Profit: " + totalProfit, Toast.LENGTH_SHORT);
				toast.show();
				MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
				Resource[] list = moonBase.getStoredResources().toArray(
						new Resource[moonBase.getStoredResources().size()]);
				for (int i = 0; i < list.length; i++) {
					if (list[i].getName().equalsIgnoreCase(
							currentResource.getName())) {
						currentResource.setAmount(list[i].getAmount()
								- quantity);
						moonBase.getStoredResources().set(i, currentResource);
						break;
					}
				}
				moonBase.sell(totalProfit);
				
				Log.i("profit", " total profit is:" + totalProfit);

				// update budget shown on screen
				try {
					((TextView) ((View) (parent.getParent().getParent()))
							.findViewById(R.id.exportBudgetTextView))
							.setText(""
									+ MoonBaseManager.getCurrentMoonBase()
											.getMoney());
				} catch (Exception e) {
					Log.e("ExportResourceListAdapter",
							"Could not update budget in text view");

				}

				MoonBaseManager.saveMoonBase(v.getContext());
			}
		});
	}

}
