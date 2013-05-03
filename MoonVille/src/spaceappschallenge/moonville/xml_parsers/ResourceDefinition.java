package spaceappschallenge.moonville.xml_parsers;

public class ResourceDefinition
{
	private final String name;
	private final double quality;
	private final int importPrice;
	private final int exportPrice;
	private final int weight;
	
	public ResourceDefinition( String name, double quality, int importPrice, int exportPrice, int weight )
	{
		this.name = name;
		this.quality = quality;
		this.importPrice = importPrice;
		this.exportPrice = exportPrice;
		this.weight = weight;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getImportPrice()
	{
		return this.importPrice;
	}
	
	public int getExportPrice()
	{
		return this.exportPrice;
	}
}
