package spaceappschallenge.moonville.listadapters;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.Building;
import spaceappschallenge.moonville.domain.MoonBase;
import spaceappschallenge.moonville.domain.Resource;
import spaceappschallenge.moonville.factories.ApplicationService;
import spaceappschallenge.moonville.factories.Buildings;
import spaceappschallenge.moonville.factories.MoonBaseManager;
import spaceappschallenge.moonville.miscellaneous.MoonVille;
import spaceappschallenge.moonville.miscellaneous.SerializablePair;
import spaceappschallenge.moonville.xml_parsers.BuildingDefinition;
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

	public BuildingInfoListAdapter(String buildingName) {
		this.infoList = new ArrayList<String>();
		appResources = MoonVille.getContext().getResources();
		if (appResources == null) {
			Log.e("null", "app resources is null");
		}
		fillBuildingInfo(buildingName);

	}

	public void fillBuildingInfo(String buildingName) {
		MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
		BuildingDefinition buildingDefinition = Buildings.getInstance()
				.getBuilding(buildingName);
		if (moonBase.isBuildingConstructed(buildingName)) {
			fillConstructedBuildingInfo(buildingDefinition);
		} else
			fillUnconstructedBuildingInfo(buildingDefinition);
	}

	private void fillUnconstructedBuildingInfo(
			BuildingDefinition buildingDefinition) {
		this.infoList.add(appResources.getString(R.string.construction_time)
				+" "+ buildingDefinition.getRequiredTurns() + " months");
		this.infoList.add("");
		if (buildingDefinition.getInputPower() > 0)
			this.infoList.add(appResources.getString(R.string.input_power)
					+" "+ (buildingDefinition.getInputPower()) + " KW");

		if (buildingDefinition.getOutputPower() > 0)
			this.infoList.add(appResources.getString(R.string.output_power)
					+" "+ (buildingDefinition.getOutputPower()) + " KW");

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

	private void fillConstructedBuildingInfo(
			BuildingDefinition buildingDefinition) {
		this.infoList.add(appResources.getString(R.string.construction_time)
				+" "+ buildingDefinition.getRequiredTurns() + " months");
		int noOfBuildings = MoonBaseManager.getCurrentMoonBase()
				.getNoOfActiveBuildings(buildingDefinition.getName());
		this.infoList.add("Active: "+noOfBuildings);
		this.infoList.add("");
		
		if (buildingDefinition.getInputPower() > 0)
			this.infoList.add(appResources.getString(R.string.input_power)
					+" "+ (buildingDefinition.getInputPower() * noOfBuildings)
					+ " KW");

		if (buildingDefinition.getOutputPower() > 0)
			this.infoList.add(appResources.getString(R.string.output_power)
					+" "	+ buildingDefinition.getOutputPower() * noOfBuildings
					+ " KW");

		this.infoList.add("");

		if (buildingDefinition.getRequiredBuildings().size() > 0) {

			this.infoList.add(""
					+ appResources.getString(R.string.required_buildings));
			for (String buildingName : buildingDefinition
					.getRequiredBuildings()) {
				this.infoList.add(buildingName);
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

}
