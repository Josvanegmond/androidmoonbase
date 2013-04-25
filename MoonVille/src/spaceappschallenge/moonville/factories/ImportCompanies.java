package spaceappschallenge.moonville.factories;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.businessmodels.ImportCompany;
import spaceappschallenge.moonville.managers.ApplicationService;
import spaceappschallenge.moonville.xml_parsers.CompanyXMLParser;
import android.content.Context;
import android.util.Log;

public class ImportCompanies
{
	private static ImportCompanies instance;
	private List<ImportCompany> companies;
	
	public ImportCompanies()
	{
		this.companies = new ArrayList<ImportCompany>();

		initAllCompanies();
	}
	

	/*
	 * Calls the parser to initialize the ArrayList of buildings
	 */
	protected void initAllCompanies()
	{
		Context context = ApplicationService.getInstance().getApplicationContext();
		InputStream inputStream = context.getResources().openRawResource(R.raw.companies);

		try
		{
			CompanyXMLParser xmlParser = new CompanyXMLParser(inputStream);
			try {
				this.companies = xmlParser.parse();
				//printAllBuildings();
			} catch (IOException e) {
				Log.e("Buildings",
						"There was problem while parsing the xml file");
			}
		} catch (XmlPullParserException e) {
			Log.e("Buildings", "XMLParser could not be instantiated");
		}
	}


	public static ImportCompanies getInstance()
	{
		if( instance == null )
		{
			instance = new ImportCompanies();
		}
		return instance;
	}


	public ArrayList<ImportCompany> getCompaniesByMinimumReputation(int i)
	{
		ArrayList<ImportCompany> foundCompanies = new ArrayList<ImportCompany>();
		
		for( ImportCompany company : this.companies )
		{
			if( company.getRequiredReputation() <= i )
			{
				foundCompanies.add( company );
			}
		}
		
		return foundCompanies;
	}
}
