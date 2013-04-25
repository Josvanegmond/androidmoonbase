package spaceappschallenge.moonville.businessmodels;

import java.util.ArrayList;
import java.util.List;

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
