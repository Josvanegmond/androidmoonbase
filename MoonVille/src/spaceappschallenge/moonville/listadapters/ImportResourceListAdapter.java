package spaceappschallenge.moonville.listadapters;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.Resource;
import spaceappschallenge.moonville.factories.ApplicationService;
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

public class ImportResourceListAdapter extends BaseAdapter {
	private List<Resource> allResources;

	public ImportResourceListAdapter(List<Resource> resources) {
		// get the resources via the factory
		this.allResources = resources;
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
			convertView = inflater.inflate(R.layout.listitem_import_resource,
					parent, false);
		}

		TextView resourceName = (TextView) convertView
				.findViewById(R.id.importResourceNameTextView);
		resourceName.setText(resource.getName());
		addListenerToSeekBar(convertView);
		addListenerToBuyButton(convertView, parent);
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
								.findViewById(R.id.importResourceNameTextView))
								.getText().toString();

						Resource currentResource = Resources
								.getInstance().getResource(resourceName);
						if (currentResource == null) {
							Log.i("null", resourceName + "not found");
							return;
						}
						int unitCost = currentResource.getImportPrice();
						int maxQuantity = MoonBaseManager.getCurrentMoonBase()
								.getMoney() / unitCost;// 100=maxAmount
						Log.i("maxQuantity", "maxQuantity " + maxQuantity);
						float position = (float) progress / 100;
						Log.i("position", "position " + position);
						int quantity = (int) (position * maxQuantity);
						Log.i("quantity", "quantity " + quantity);

						((TextView) convertView
								.findViewById(R.id.resourceQuantityTextView))
								.setText("" + quantity);

						int totalCost = unitCost * quantity;
						((TextView) convertView
								.findViewById(R.id.resourceCostTextView))
								.setText("" + totalCost);

						Log.i("yes", "quantity set " + quantity);

					}
				});
	}

	protected void addListenerToBuyButton(final View convertView,
			final ViewGroup parent) {
		Button importButton = (Button) convertView
				.findViewById(R.id.importResourceButton);
		importButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String resourceName = ((TextView) convertView
						.findViewById(R.id.importResourceNameTextView))
						.getText().toString();
				Resource currentResource = Resources.getInstance()
						.getResource(resourceName);

				int unitCost = currentResource.getImportPrice();
				int quantity = Integer.parseInt(((TextView) convertView
						.findViewById(R.id.resourceQuantityTextView)).getText()
						.toString());
				int totalCost = unitCost * quantity;
				Toast toast;
				if (MoonBaseManager.getCurrentMoonBase().spend(totalCost)) {
					ArrayList<SerializablePair<Resource,Integer>> newList = new ArrayList<SerializablePair<Resource,Integer>>();
					newList.add(new SerializablePair<Resource,Integer>(Resources.getInstance().getResource(resourceName), quantity));
					
					MoonBaseManager.getCurrentMoonBase().increaseResources(newList);
					toast = Toast.makeText(v.getContext(), "Spent: "
							+ totalCost, 2000);

				} else {
					toast = Toast.makeText(v.getContext(),
							"Can't spend so much!", 2000);
				}
				toast.show();

				Log.i("cost", " total cost is:" + totalCost);
				String budget = ""
						+ MoonBaseManager.getCurrentMoonBase().getMoney();
				try {

					((TextView) (ApplicationService
							.getImportResourcesActivity())
							.findViewById(R.id.budgettext)).setText(budget);

				} catch (Exception e) {
					Log.e("ImportResourceListAdapter",
							"Could not update budget in text view");

				}
				try {
					((TextView) (ApplicationService.getBaseOverviewActivity())
							.findViewById(R.id.baseOverviewFundsTextView))
							.setText("Funds: "+budget);
				} catch (Exception e) {
					Log.e("ImportResourceListAdapter",
							"Could not update budget in text view of base overview screen");
				}
				MoonBaseManager.saveMoonBase(v.getContext());
			}
		});
	}
}
