package spaceappschallenge.moonville.businessmodels;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.factories.Resources;
import spaceappschallenge.moonville.xml_parsers.ResourceDefinition;

public class ImportCompany
{
	protected String name;
	protected String info;
	protected List<Resource> importResources;
	protected double paymentFactor;
	protected int requiredReputation;
	
	public ImportCompany(
			String companyName, String companyInfo,
			double paymentFactor2, int requiredReputation,
			ArrayList<Resource> importResources
		)
	{
		this.name = companyName;
		this.info = companyInfo;
		this.paymentFactor = paymentFactor2;
		this.requiredReputation = requiredReputation;
		this.importResources = importResources;
	}
	
	public int getPayment()
	{
		Resources resources = Resources.getInstance();
		
		int totalMoneySum = 0;
		for( Resource resource : this.importResources )
		{
			ResourceDefinition resourceDefinition = resources.getResource( resource.getName() );
			totalMoneySum += resource.getAmount() * resourceDefinition.getExportPrice();
		}
		
		return (int)( this.paymentFactor * totalMoneySum );
	}

	public int getRequiredReputation()
	{
		return this.requiredReputation;
	}

	public String getName()
	{
		return this.name;
	}
	
	public String getInfo()
	{
		return this.info;
	}

	public List<Resource> getImportResources()
	{
		return this.importResources;
	}
}
