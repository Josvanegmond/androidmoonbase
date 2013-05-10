package spaceappschallenge.moonville.listadapters;

import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.TransportCompany;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class TransportCompanySpinnerAdapter implements SpinnerAdapter
{
	private List<TransportCompany> transportCompanyList;
	
	private static class CompanyHolder
	{
		public ImageView logoImage;
		public TextView nameText;
		public TextView sloganText;
		public TextView weightText;
		public TextView costText;
	}
	
	public TransportCompanySpinnerAdapter( List<TransportCompany> transportCompanyList )
	{
		this.transportCompanyList = transportCompanyList;
	}
	
	
	@Override
	public int getCount() {
		return this.transportCompanyList.size();
	}

	@Override
	public Object getItem(int position) {
		return this.transportCompanyList.get( position );
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getItemViewType(int position) {
		return IGNORE_ITEM_VIEW_TYPE;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		TransportCompany transportCompany = this.transportCompanyList.get( position );
		
		if( convertView == null )
		{
			convertView = new ImageView( parent.getContext() );
			convertView.setLayoutParams( new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT ) );
			
			CompanyHolder companyHolder = new CompanyHolder();
			companyHolder.logoImage = (ImageView)convertView;
			
			convertView.setTag( R.string.TRANSPORTCOMPANY_LISTITEM_HOLDER, companyHolder );
		}

		CompanyHolder companyHolder = (CompanyHolder) convertView.getTag( R.string.TRANSPORTCOMPANY_LISTITEM_HOLDER );
		companyHolder.logoImage.setImageResource( transportCompany.getRes_logo() );
		
		return convertView;
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.transportCompanyList.isEmpty();
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		TransportCompany transportCompany = this.transportCompanyList.get( position );
		
		if( convertView == null )
		{
			convertView = LayoutInflater.from( parent.getContext() ).inflate( R.layout.listitem_transportcompany, parent, false );
			
			CompanyHolder companyHolder = new CompanyHolder();
			companyHolder.logoImage = (ImageView)convertView.findViewById( R.id.companylogo );
			companyHolder.nameText = (TextView)convertView.findViewById( R.id.companytitle );
			companyHolder.sloganText = (TextView)convertView.findViewById( R.id.companyslogan );
			companyHolder.weightText = (TextView)convertView.findViewById( R.id.companylaunchweight );
			companyHolder.costText = (TextView)convertView.findViewById( R.id.companylaunchcost );
			
			convertView.setTag( R.string.TRANSPORTCOMPANY_LISTITEM_HOLDER, companyHolder );
		}

		CompanyHolder companyHolder = (CompanyHolder) convertView.getTag( R.string.TRANSPORTCOMPANY_LISTITEM_HOLDER );
		companyHolder.logoImage.setImageResource( transportCompany.getRes_logo() );
		companyHolder.nameText.setText( transportCompany.getName() );
		companyHolder.sloganText.setText( transportCompany.getSlogan() );
		companyHolder.weightText.setText( "Weight capacity: " + transportCompany.getWeightCapacity() + "kg" );
		companyHolder.costText.setText( "Launch costs: $" + transportCompany.getLaunchCost() + " million" );
		
		return convertView;
	}

}
