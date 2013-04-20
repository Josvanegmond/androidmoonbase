/*
 * Parses XML containing information about Buildings.
 */
//Note: Reusing ResourceXMLParser would be a better idea.
package spaceappschallenge.moonville.xml_parsers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParserException;

import spaceappschallenge.moonville.businessmodels.Building;

public class BuildingXMLParser
{
	private InputStream inputStream = null;

	/*
	 * @param: inputStream: InputStream object with the XML as the file
	 */
	public BuildingXMLParser(InputStream inputStream)
	{
		this.inputStream = inputStream;
	}



	// Create "Building" objects by parsing input stream
	// This is the longest function I have written in my entire life : Robik
	public ArrayList<Building> parse() throws XmlPullParserException, IOException
	{
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse( this.inputStream );
		
		NodeList buildingList = doc.getElementsByTagName( "building" );
		
		
		return this.buildings;

	}// end of function
}// class
