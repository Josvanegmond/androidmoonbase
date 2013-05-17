package spaceappschallenge.moonville.listadapters;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.Building;
import spaceappschallenge.moonville.domain.BuildingDefinition;
import spaceappschallenge.moonville.domain.MoonBase;
import spaceappschallenge.moonville.domain.Resource;
import spaceappschallenge.moonville.factories.ApplicationService;
import spaceappschallenge.moonville.factories.Buildings;
import spaceappschallenge.moonville.factories.MoonBaseManager;
import spaceappschallenge.moonville.miscellaneous.MoonVille;
import spaceappschallenge.moonville.miscellaneous.SerializablePair;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BuildingInfoListAdapter extends BaseAdapter {
	private List<String> infoList;
	private Resources appResources;
	private BuildingDefinition buildingDefinition;
	private String buildingName;
	private MoonBase moonBase;

	public BuildingInfoListAdapter(String buildingName) {
		this.infoList = new ArrayList<String>();
		this.buildingName = buildingName;
		appResources = MoonVille.getContext().getResources();
		moonBase = MoonBaseManager.getCurrentMoonBase();
		buildingDefinition = Buildings.getInstance().getBuilding(buildingName);
		if (appResources == null) {
			Log.e("null", "app resources is null");
		}
		fillBuildingInfo();

	}

	public void fillBuildingInfo() {

		this.infoList.add("Description: \n" + buildingDefinition.getInfo()
				+ "\n");

		if (moonBase.isBuildingConstructed(buildingName)) {
			fillConstructedBuildingInfo();
		} else
			fillUnconstructedBuildingInfo();
	}

	/**
	 * Fill in information about buildings which have not been constructed yet
	 */
	private void fillUnconstructedBuildingInfo() {
		this.infoList.add(appResources.getString(R.string.construction_time)
				+ "\n" + buildingDefinition.getRequiredTurns() + " months"
				+ "\n");

		if (buildingDefinition.getInputPower() > 0)
			this.infoList.add(appResources.getString(R.string.input_power)
					+ "\n" + (buildingDefinition.getInputPower()) + " KW"
					+ "\n");

		if (buildingDefinition.getOutputPower() > 0)
			this.infoList.add(appResources.getString(R.string.output_power)
					+ "\n" + (buildingDefinition.getOutputPower()) + " KW"
					+ "\n");

		this.infoList.add("");

		if (buildingDefinition.getRequiredBuildings().size() > 0) {
			this.infoList.add(appResources
					.getString(R.string.required_buildings));
			for (String buildingName : buildingDefinition
					.getRequiredBuildings()) {
				this.infoList.add(buildingName);
			}
		}

		this.infoList.add("");

		if (buildingDefinition.getRequiredResources().size() > 0) {
			this.infoList.add(appResources
					.getString(R.string.required_resources));
			for (SerializablePair<Resource, Integer> resource : buildingDefinition
					.getRequiredResources()) {
				this.infoList.add(resource.first.getName() + ": "
						+ resource.second);
			}
		}

		this.infoList.add("");

		if (buildingDefinition.getOutputResources().size() > 0) {
			this.infoList
					.add(appResources.getString(R.string.output_resources));
			for (SerializablePair<Resource, Integer> resource : buildingDefinition
					.getOutputResources()) {
				this.infoList.add(resource.first.getName() + ": "
						+ resource.second);
			}
		}
	}

	private void fillConstructedBuildingInfo() {
		this.infoList.add(appResources.getString(R.string.construction_time)
				+ "\n" + buildingDefinition.getRequiredTurns() + " months"
				+ "\n");
		int noOfBuildings = MoonBaseManager.getCurrentMoonBase()
				.getNoOfActiveBuildings(buildingDefinition.getName());
		this.infoList.add("Active:\n" + noOfBuildings + "\n");
		this.infoList.add("");

		if (buildingDefinition.getInputPower() > 0)
			this.infoList.add(appResources.getString(R.string.input_power)
					+ "\n"
					+ (buildingDefinition.getInputPower() * noOfBuildings)
					+ " KW" + "\n");

		if (buildingDefinition.getOutputPower() > 0)
			this.infoList.add(appResources.getString(R.string.output_power)
					+ "\n" + buildingDefinition.getOutputPower()
					* noOfBuildings + " KW" + "\n");

		if (buildingDefinition.getRequiredBuildings().size() > 0) {

			this.infoList.add(""
					+ appResources.getString(R.string.required_buildings));
			for (String buildingName : buildingDefinition
					.getRequiredBuildings()) {
				this.infoList.add(buildingName);
			}
		}

		this.infoList.add("");

		if (buildingDefinition.getRequiredResources().size() > 0) {
			this.infoList.add(""
					+ appResources.getString(R.string.required_resources));
			for (SerializablePair<Resource, Integer> resource : buildingDefinition
					.getRequiredResources()) {
				this.infoList.add(resource.first.getName() + ": "
						+ (resource.second * noOfBuildings));
			}
		}
		this.infoList.add("");

		if (buildingDefinition.getOutputResources().size() > 0) {
			this.infoList.add(""
					+ appResources.getString(R.string.output_resources));
			for (SerializablePair<Resource, Integer> resource : buildingDefinition
					.getOutputResources()) {
				this.infoList.add(resource.first.getName() + ": "
						+ (resource.second * noOfBuildings));
			}
		}
	}

	@Override
	public int getCount() {
		return this.infoList.size();
	}

	@Override
	public Object getItem(int position) {
		return this.infoList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			View listItem = LayoutInflater.from(parent.getContext()).inflate(
					R.layout.listitem_textview, parent, false);
			convertView = listItem;
		}

		TextView text = (TextView) convertView
				.findViewById(R.id.buildinginfotext);
		text.setText(this.infoList.get(position));

		return convertView;
	}

	public List<String> getInfoList() {
		return this.infoList;
	}

}
