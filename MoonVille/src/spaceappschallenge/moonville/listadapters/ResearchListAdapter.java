package spaceappschallenge.moonville.listadapters;

import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.Research;
import spaceappschallenge.moonville.miscellaneous.SerializablePair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ResearchListAdapter extends BaseAdapter {
	private List<SerializablePair<Research, Integer>> researchList;

	public ResearchListAdapter(
			List<SerializablePair<Research, Integer>> researchList) {
		// get the resources via the factory
		this.researchList = researchList;
	}

	@Override
	public int getCount() {
		return researchList.size();
	}

	@Override
	public Object getItem(int index) {
		return researchList.get(index);
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	@Override
	public View getView(int index, View convertView, ViewGroup parent) {
		SerializablePair<Research, Integer> research = this.researchList
				.get(index);

		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.listitem_research, parent,
					false);
		}

		TextView name = (TextView) convertView
				.findViewById(R.id.research_nameTextView);
		name.setText(research.first.getName());
		TextView info = (TextView) convertView
				.findViewById(R.id.research_infoTextView);
		info.setText(research.first.getInfo());
		TextView researchLevel = (TextView) convertView
				.findViewById(R.id.research_levelTextView);
		researchLevel.setText("" + research.second);
		return convertView;
	}

}
