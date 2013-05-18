package spaceappschallenge.moonville.listadapters;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.BuildingDefinition;
import spaceappschallenge.moonville.domain.MoonBase;
import spaceappschallenge.moonville.domain.Resource;
import spaceappschallenge.moonville.factories.Buildings;
import spaceappschallenge.moonville.factories.MoonBaseManager;
import spaceappschallenge.moonville.miscellaneous.MoonVille;
import spaceappschallenge.moonville.miscellaneous.SerializablePair;
import spaceappschallenge.moonville.ui.FontTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MegaprojectListAdapter extends BaseAdapter {
	private List<BuildingDefinition> megaprojects;
	private android.content.res.Resources appResources;
	private MoonBase moonBase;

	// Constructor
	public MegaprojectListAdapter(List<BuildingDefinition> megaprojects) {
		this.megaprojects = megaprojects;
		this.moonBase = MoonBaseManager.getCurrentMoonBase();
		appResources = MoonVille.getContext().getResources();
		if (appResources == null) {
			Log.e("null", "app resources is null");
		}
	}

	@Override
	public View getView(int index, View convertView, ViewGroup parent) {
		BuildingDefinition megaproject = this.megaprojects.get(index);

		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.listitem_megaproject,
					parent, false);
		}

		// Set name
		TextView megaprojectTextView = (TextView) convertView
				.findViewById(R.id.megaprojectTextView);
		megaprojectTextView.setText(megaproject.getName());

		// Add description
		TextView descriptionTextView = (TextView) convertView
				.findViewById(R.id.megaprojectDescriptionTextView);
		descriptionTextView.setText(megaproject.getInfo());

		// Add listener to construct button
		addListenerToConstructMegaprojectButton(convertView, this.megaprojects
				.get(index).getName());
		
		// Adjust status of construction
		showConstructionStatus(convertView, megaproject);

		// Show list of stats
		initInfoList(index, convertView);
		// Add listener to collapse/expand button
		addListenerToMoreLessButton(convertView);
		return convertView;
	}

	/**
	 * Updates the status to: construct, constructed, under construction and
	 * active
	 * 
	 * @param v
	 * @param megaproject
	 */
	private void showConstructionStatus(View v, BuildingDefinition megaproject) {
		// If the building has been constructed
		Button constructButton = (Button) v
				.findViewById(R.id.constructMegaprojectButton);
		if (moonBase.isBuildingConstructed(megaproject.getName())) {
			constructButton.setText("Constructed");
			constructButton.setClickable(false);
			// If the building is active
			if (moonBase.isBuildingActive(megaproject.getName())) {
				constructButton.setText("Active");
			}
		} else if (moonBase.isBuildingUnderConstruction(megaproject.getName())) {
			constructButton.setText("Under Construction");
			constructButton.setClickable(false);
		} else {
			constructButton.setText("Construct");
			constructButton.setClickable(true);
		}

	}

	/**
	 * Starts construction of megaproject
	 * 
	 * @param convertView
	 * @param buildingName
	 */
	private void addListenerToConstructMegaprojectButton(
			final View convertView, final String buildingName) {
		final Button constructButton = (Button) convertView
				.findViewById(R.id.constructMegaprojectButton);

		constructButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
				moonBase.construct(Buildings.getInstance().getBuilding(
						buildingName));
				constructButton.setText("Construction Started!");
				constructButton.setClickable(false);

			}
		});

	}

	/**
	 * Initializes the list of stats about the megaproject
	 * 
	 * @param index
	 * @param convertView
	 */
	public void initInfoList(int index, View convertView) {
		LinearLayout megaprojectInfoList = (LinearLayout) convertView
				.findViewById(R.id.megaprojectInfoList);
		megaprojectInfoList.removeAllViews();
		BuildingInfoListAdapter buildingInfoListAdapter = new BuildingInfoListAdapter(
				megaprojects.get(index).getName());
		List<String> infoList = buildingInfoListAdapter.getInfoList();
		LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		for (String info : infoList) {
			FontTextView infoTextView = new FontTextView(
					convertView.getContext());

			infoTextView.setLayoutParams(layoutParams);
			infoTextView.setText(info);
			megaprojectInfoList.addView(infoTextView);
		}

	}

	public void addListenerToMoreLessButton(final View v) {
		final LinearLayout megaprojectInfoList = (LinearLayout) v
				.findViewById(R.id.megaprojectInfoList);
		((Button) v.findViewById(R.id.megaprojectMoreLessButton))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						if (megaprojectInfoList.getVisibility() == View.GONE
								|| megaprojectInfoList.getVisibility() == View.INVISIBLE)
							expandInfoList(v, megaprojectInfoList);
						else
							collapseInfoList(v, megaprojectInfoList);
						v.requestLayout();
						megaprojectInfoList.invalidate();
					}
				});

	}

	public void collapseInfoList(View v, LinearLayout megaprojectInfoList) {
		Log.i("collapse", "collapsing");
		Button moreLessButton = (Button) (v
				.findViewById(R.id.megaprojectMoreLessButton));
		moreLessButton.setText("More");
		megaprojectInfoList.setVisibility(View.GONE);
		v.requestLayout();
		v.invalidate();
	}

	public void expandInfoList(View v, LinearLayout megaprojectInfoList) {
		Log.i("expand", "expanding");
		Button moreLessButton = (Button) (v
				.findViewById(R.id.megaprojectMoreLessButton));
		moreLessButton.setText("Less");
		megaprojectInfoList.setVisibility(View.VISIBLE);
		v.requestLayout();
		v.invalidate();

	}

	// Getters
	@Override
	public int getCount() {
		return megaprojects.size();
	}

	@Override
	public Object getItem(int index) {
		return megaprojects.get(index);
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

}
