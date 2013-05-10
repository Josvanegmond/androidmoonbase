package spaceappschallenge.moonville.factories;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.TransportCompany;

public class TransportCompanies
{
	private static TransportCompanies instance;
	private List<TransportCompany> companyList;
	
	private TransportCompanies()
	{
		this.companyList = new ArrayList<TransportCompany>();
		this.companyList.add( new TransportCompany( R.drawable.orbitaltransmissions, "Orbital Transmissions", "Experts in gravitation slingshots", 100, 25000 ) );
		this.companyList.add( new TransportCompany( R.drawable.exotravelexpress, "Exotravel Express", "Jumpstarting your space endeavours", 160, 35000 ) );
		this.companyList.add( new TransportCompany( R.drawable.voidpriority, "Void Priority", "Your solution for astrologistics", 50, 14000 ) );
	}
	
	public static TransportCompanies getInstance()
	{
		if( TransportCompanies.instance == null )
		{
			TransportCompanies.instance = new TransportCompanies();
		}
		
		return TransportCompanies.instance;
	}
	
	public List<TransportCompany> getCompanies()
	{
		return this.companyList;
	}
}
