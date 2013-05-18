package spaceappschallenge.moonville.listadapters;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.MoonBase;
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

public class InitialLaunchListAdapter extends BaseAdapter {
	private List<Resource> allResources;
	private Resource resource;
	public InitialLaunchListAdapter(List<Resource> resources) {
		// get the resources via the factory
		this.allResources = resources;
	}

	@Override
	public View getView(int index, View convertView, ViewGroup parent) {
		resource = this.allResources.get(index);

		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.listitem_launch_resource,
					parent, false);
		}

		// Set the name of the resource
		TextView resourceName = (TextView) convertView
				.findViewById(R.id.il_launchResourceNameTextView);
		resourceName.setText(resource.getName());

		// Add listener to the seek bar
		addListenerToSeekBar(convertView);

		// Add listenter to the buy button
		addListenerToBuyButton(convertView, parent);
		return convertView;
	}

	/**
	 * Adds listener to seek bar which updates the stats: quantity, cost and
	 * launch mass in their text views
	 * 
	 * @param convertView
	 */
	protected void addListenerToSeekBar(final View convertView) {
		SeekBar quantitySeekBar = (SeekBar) convertView
				.findViewById(R.id.il_resourceQuantitySeekBar);
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
						
						if (resource == null) {
							Log.e("null", resource.getName()+ "not found");
							return;
						}

						// get the stats about the resource
						int unitCost = resource.getImportPrice();
						int unitLaunchMass = resource.getWeight();

						// Find out the maximum quantity which can be launched
						int maxQuantity = MoonBaseManager.getCurrentMoonBase()
								.getMoney() / unitCost;// 100=maxAmount
						int maxQuantityBasedOnLaunchMass = MoonBaseManager
								.getCurrentMoonBase().getLaunchMass()
								/ unitLaunchMass;
						if (maxQuantity > maxQuantityBasedOnLaunchMass) {
							maxQuantity = maxQuantityBasedOnLaunchMass;
						}

						// Determine the stats based on slider position
						Log.i("maxQuantity", "maxQuantity " + maxQuantity);
						float position = (float) progress / 100;
						Log.i("position", "position " + position);
						int quantity = (int) (position * maxQuantity);
						Log.i("quantity", "quantity " + quantity);
						int launchMass = quantity * unitLaunchMass;
						int totalCost = quantity * unitCost;

						// Set the stats in the view
						((TextView) convertView
								.findViewById(R.id.il_resourceQuantityTextView))
								.setText("" + quantity);

						((TextView) convertView
								.findViewById(R.id.il_resourceCostTextView))
								.setText("" + totalCost);

						((TextView) convertView
								.findViewById(R.id.il_resourceLaunchMassTextView))
								.setText("" + launchMass);
					}
				});
	}

	/**
	 * Adds listener to the buy button. Fetches stats from the view (assumes
	 * they are up to date). Asks the moonbase if it can spend/launch the
	 * resources. If it can then, it instructs moonbase to launch it.
	 * 
	 * @param convertView
	 * @param parent
	 */
	protected void addListenerToBuyButton(final View convertView,
			final ViewGroup parent) {
		Button launchResourceButton = (Button) convertView
				.findViewById(R.id.il_launchResourceButton);
		launchResourceButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// Fetch the necessary stats
				int unitCost = resource.getImportPrice();
				int quantity = Integer.parseInt(((TextView) convertView
						.findViewById(R.id.il_resourceQuantityTextView))
						.getText().toString());
				int totalCost = unitCost * quantity;
				int launchMass = Integer.parseInt(((TextView) convertView
						.findViewById(R.id.il_resourceLaunchMassTextView))
						.getText().toString());
				Toast toast;
				MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();

				/*
				 * Check if the resources can be launched (conditions:
				 * sufficient money and launch mass capacity) If the conditions
				 * are satisfied, then add the resources to the launch list
				 */
				if (moonBase.canSpend(totalCost)) {

					if (moonBase.canLaunch(launchMass)) {

						moonBase.spend(totalCost);
						moonBase.launch(launchMass);

						// Add the resource to the list stored by moon base
						ArrayList<SerializablePair<Resource, Integer>> launchResourceList = new ArrayList<SerializablePair<Resource, Integer>>();
						launchResourceList
								.add(new SerializablePair<Resource, Integer>(resource, quantity));

						MoonBaseManager.getCurrentMoonBase().increaseResources(
								launchResourceList);
						toast = Toast.makeText(v.getContext(),
								"Added: " + launchMass + " KG of "
										+ resource.getName() + " for $"
										+ totalCost, 2000);
					} else {
						toast = Toast.makeText(v.getContext(),
								"Not enough launch mass!", 2000);
					}
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
							.getInitialLaunchActivity())
							.findViewById(R.id.il_budgetTextView)).setText(budget);

				} catch (Exception e) {
					Log.e("InitialLaunchListAdapter",
							"Could not update budget in text view");

				}
				try {
					((TextView) (ApplicationService.getInitialLaunchActivity())
							.findViewById(R.id.il_launchMassTextView))
							.setText(""+MoonBaseManager.getCurrentMoonBase().getLaunchMass());
				} catch (Exception e) {
					Log.e("InitialLaunchListAdapter",
							"Could not update budget in text view of initial launch screen");
				}
				MoonBaseManager.saveMoonBase(v.getContext());
			}
		});
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
}
