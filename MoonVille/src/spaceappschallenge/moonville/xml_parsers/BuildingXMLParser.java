/*
 * Parses XML containing information about Buildings and stores them inside ArrayList of Building
 */
package spaceappschallenge.moonville.xml_parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import spaceappschallenge.moonville.businessmodels.Building;
import spaceappschallenge.moonville.businessmodels.Resource;
import spaceappschallenge.moonville.managers.ApplicationService;
import android.content.Context;
import android.util.Log;

public class BuildingXMLParser {
	protected InputStream inputStream = null;
	protected XmlPullParser xpp;
	protected ArrayList<BuildingDefinition> buildings;
	protected boolean isBuildingFinished = false;

	/*
	 * @param: inputStream: InputStream object with the XML as the file
	 */
	public BuildingXMLParser(InputStream inputStream)
			throws XmlPullParserException {
		this.inputStream = inputStream;
		XmlPullParserFactory xmlFactory = XmlPullParserFactory.newInstance();
		xmlFactory.setNamespaceAware(true);
		xpp = xmlFactory.newPullParser();
		this.buildings = new ArrayList<BuildingDefinition>();
	}

	String buildingName = "";
	String buildingInfo = "";
	int buildingAmount = 0;
	int buildingInputPower = 0, buildingOutputPower = 0;
	int buildingMonetaryCost = 0, buildingRegolithCost = 0;
	int buildingRequiredTurns = 0;
	int buildingXPos = 0;
	int buildingYPos = 0;
	ArrayList<Resource> requiredResources;
	ArrayList<Resource> outputResources;
	ArrayList<BuildingDefinition> requiredBuildings;

	public void readBuildingAttributes() {
		// Read the attributes for each building
		buildingName = xpp.getAttributeValue(null, "name");
		buildingInfo = xpp.getAttributeValue(null, "info");
		buildingAmount = Integer
				.parseInt(xpp.getAttributeValue(null, "amount"));
		buildingInputPower = Integer.parseInt(xpp.getAttributeValue(null,
				"inputPower"));
		buildingOutputPower = Integer.parseInt(xpp.getAttributeValue(null,
				"outputPower"));
		buildingMonetaryCost = Integer.parseInt(xpp.getAttributeValue(null,
				"monetaryCost"));
		buildingRegolithCost = Integer.parseInt(xpp.getAttributeValue(null,
				"regolithCost"));
		buildingRequiredTurns = Integer.parseInt(xpp.getAttributeValue(null,
				"requiredTurns"));
		buildingXPos = Integer.parseInt(xpp.getAttributeValue(null, "x"));
		buildingYPos = Integer.parseInt(xpp.getAttributeValue(null, "y"));
		Log.i("XML", "buildingName: " + buildingName);
	}

	public void addRequiredResource(XmlPullParser xpp,
			ArrayList<Resource> requiredResources) {

		String reqdResName = xpp.getAttributeValue(null, "name");
		int reqdResAmount = Integer.parseInt(xpp.getAttributeValue(null,
				"amount"));
		requiredResources.add(new Resource(reqdResName, reqdResAmount));
		Log.i("XML", "required resource " + reqdResName);
	}

	public void addOutputResource(XmlPullParser xpp,
			ArrayList<Resource> outputResources) {
		String outResName = xpp.getAttributeValue(null, "name");

		int outResAmount = 0;
		try {
			outResAmount = Integer.parseInt(xpp.getAttributeValue(null,
					"amount"));
		} catch (Exception e) {
			Log.e("XMLError", "outResAmount");
		}

		outputResources.add(new Resource(outResName, outResAmount));
		Log.i("XML", "out resource " + outResName);
	}

	public void addRequiredBuilding(XmlPullParser xpp,
			ArrayList<BuildingDefinition> requiredBuildings) {
		String reqdBuildName = xpp.getAttributeValue(null, "name");
	
		requiredBuildings.add(new BuildingDefinition(reqdBuildName));
		Log.i("XML", "required building " + reqdBuildName);
	}

	// Create "Building" objects by parsing input stream
	public ArrayList<BuildingDefinition> parse() throws XmlPullParserException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				this.inputStream));
		xpp.setInput(br);
		int eventType = xpp.getEventType();

		// Parse the xml file to create "building" objects
		while (eventType != XmlPullParser.END_DOCUMENT) {

			boolean atBuilding = false;
			if (eventType == XmlPullParser.START_TAG
					&& xpp.getName().equalsIgnoreCase("building")) {
				atBuilding = true;
				readBuildingAttributes();
				outputResources = new ArrayList<Resource>();
				requiredResources = new ArrayList<Resource>();
				requiredBuildings = new ArrayList<BuildingDefinition>();

				// For Nested elements
				while (atBuilding) {// <building>

					// Break the loop when the end tag: </building> is reached
					if (eventType == XmlPullParser.END_TAG
							&& xpp.getName().equalsIgnoreCase("building")) {
						break;
					}

					boolean atRequiredResources = false;
					if (eventType == XmlPullParser.START_TAG
							&& xpp.getName().equalsIgnoreCase(
									"requiredResources")) {
						atRequiredResources = true;
					}
					while (atRequiredResources) {
						// Break the loop when the end tag: </requiredResources>
						// is reached
						if (eventType == XmlPullParser.END_TAG
								&& xpp.getName().equalsIgnoreCase(
										"requiredResources")) {
							break;
						}

						boolean atRequiredResource = false;// The tag:
						// <requiredResource>
						// might be absent
						if (eventType == XmlPullParser.START_TAG
								&& xpp.getName().equalsIgnoreCase("resource")) {
							atRequiredResource = true;
						}// requiredResource

						while (atRequiredResource) {
							if (eventType == XmlPullParser.END_TAG
									&& xpp.getName().equalsIgnoreCase(
											"resource")) {
								break;
							}

							if (xpp.getAttributeCount() > 0) {
								addRequiredResource(xpp, requiredResources);
							}
							eventType = xpp.next();
						}// atRequiredResource

						eventType = xpp.next();
					}// atRequiredResources

					boolean atOutputResources = false;
					if (eventType == XmlPullParser.START_TAG
							&& xpp.getName()
									.equalsIgnoreCase("outputResources")) {
						atOutputResources = true;
					}
					while (atOutputResources) {
						if (eventType == XmlPullParser.END_TAG
								&& xpp.getName().equalsIgnoreCase(
										"outputResources")) {
							break;
						}

						boolean atOutputResource = false;
						if (eventType == XmlPullParser.START_TAG
								&& xpp.getName().equalsIgnoreCase("resource")) {
							atOutputResource = true;
						}// requiredBuilding

						while (atOutputResource) {
							if (eventType == XmlPullParser.END_TAG
									&& xpp.getName().equalsIgnoreCase(
											"resource")) {
								break;
							}
							if (xpp.getAttributeCount() > 0) {
								addOutputResource(xpp, outputResources);
							}
							eventType = xpp.next();
						}// atOutputResource
						eventType = xpp.next();
					}// atOutputResources

					boolean atRequiredBuildings = false;
					if (eventType == XmlPullParser.START_TAG
							&& xpp.getName().equalsIgnoreCase(
									"requiredBuildings")) {
						atRequiredBuildings = true;
						// Log.i("XML","required buildings tag found");
					}
					while (atRequiredBuildings) {

						if (eventType == XmlPullParser.END_TAG
								&& xpp.getName().equalsIgnoreCase(
										"requiredBuildings")) {
							atRequiredBuildings = false;
							break;
						}

						boolean atRequiredBuilding = false;
						if (eventType == XmlPullParser.START_TAG
								&& xpp.getName().equalsIgnoreCase("building")) {
							atRequiredBuilding = true;
						}// requiredBuilding

						while (atRequiredBuilding) {
							if (eventType == XmlPullParser.END_TAG
									&& xpp.getName().equalsIgnoreCase(
											"building")) {
								atRequiredBuilding = false;
								break;
							}
							if (xpp.getAttributeCount() > 0) {
								addRequiredBuilding(xpp, requiredBuildings);

							}

							eventType = xpp.next();
						}// atRequiredBuilding

						eventType = xpp.next();
					}

					eventType = xpp.next();
				}// while atBuilding
				this.buildings.add(new BuildingDefinition(buildingName, buildingInfo,
						buildingAmount, buildingInputPower,
						buildingOutputPower, buildingMonetaryCost,
						buildingRegolithCost, buildingRequiredTurns,
						requiredResources, outputResources, requiredBuildings,
						buildingXPos, buildingYPos));
			}// if building

			eventType = xpp.next();

		}// end
		return this.buildings;

	}// end of function
}// class