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

import spaceappschallenge.moonville.domain.ImportCompany;
import spaceappschallenge.moonville.domain.Resource;
import spaceappschallenge.moonville.factories.Resources;
import android.util.Log;
import spaceappschallenge.moonville.SerializablePair;

public class CompanyXMLParser {
	protected InputStream inputStream = null;
	protected XmlPullParser xpp;
	protected ArrayList<ImportCompany> companies;
	protected boolean isCompanyFinished = false;

	/*
	 * @param: inputStream: InputStream object with the XML as the file
	 */
	public CompanyXMLParser(InputStream inputStream)
			throws XmlPullParserException {
		this.inputStream = inputStream;
		XmlPullParserFactory xmlFactory = XmlPullParserFactory.newInstance();
		xmlFactory.setNamespaceAware(true);
		xpp = xmlFactory.newPullParser();
		this.companies = new ArrayList<ImportCompany>();
	}

	String companyName = "";
	String companyInfo = "";
	double paymentFactor = 0;
	int requiredReputation = 0;
	ArrayList<SerializablePair<Resource, Integer>> importResources;

	public void readCompanyAttributes() {
		// Read the attributes for each building
		companyName = xpp.getAttributeValue(null, "name");
		companyInfo = xpp.getAttributeValue(null, "info");
		paymentFactor = Double.parseDouble(xpp.getAttributeValue(null,
				"paymentfactor"));
		requiredReputation = Integer.parseInt(xpp.getAttributeValue(null,
				"requiredreputation"));
	}

	public void addImportResource(XmlPullParser xpp,
			ArrayList<SerializablePair<Resource, Integer>> importResources) {

		String reqdResName = xpp.getAttributeValue(null, "name");
		int reqdResAmount = Integer.parseInt(xpp.getAttributeValue(null,
				"amount"));
		importResources.add(new SerializablePair(Resources.getInstance().getResource(
				reqdResName), reqdResAmount));
	}

	// Create "Building" objects by parsing input stream
	public ArrayList<ImportCompany> parse() throws XmlPullParserException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				this.inputStream));
		xpp.setInput(br);
		int eventType = xpp.getEventType();

		// Parse the xml file to create "building" objects
		while (eventType != XmlPullParser.END_DOCUMENT) {
			boolean atBuilding = false;
			if (eventType == XmlPullParser.START_TAG
					&& xpp.getName().equalsIgnoreCase("company")) {
				atBuilding = true;
				readCompanyAttributes();
				importResources = new ArrayList<SerializablePair<Resource, Integer>>();

				// For Nested elements
				while (atBuilding) {// <building>

					// Break the loop when the end tag: </building> is reached
					if (eventType == XmlPullParser.END_TAG
							&& xpp.getName().equalsIgnoreCase("company")) {
						break;
					}

					boolean atImportResources = false;
					if (eventType == XmlPullParser.START_TAG
							&& xpp.getName()
									.equalsIgnoreCase("importresources")) {
						atImportResources = true;
					}
					while (atImportResources) {
						// Break the loop when the end tag: </requiredResources>
						// is reached
						if (eventType == XmlPullParser.END_TAG
								&& xpp.getName().equalsIgnoreCase(
										"importresources")) {
							break;
						}

						boolean atImportResource = false;// The tag:
						// <requiredResource>
						// might be absent
						if (eventType == XmlPullParser.START_TAG
								&& xpp.getName().equalsIgnoreCase("resource")) {
							atImportResource = true;
						}// requiredResource

						while (atImportResource) {
							if (eventType == XmlPullParser.END_TAG
									&& xpp.getName().equalsIgnoreCase(
											"resource")) {
								break;
							}

							if (xpp.getAttributeCount() > 0) {
								addImportResource(xpp, importResources);
							}
							eventType = xpp.next();
						}// atRequiredResource

						eventType = xpp.next();
					}// atRequiredResources

					eventType = xpp.next();
				}// while atBuilding

				this.companies.add(new ImportCompany(companyName, companyInfo,
						paymentFactor, requiredReputation, importResources));

			}// if building

			eventType = xpp.next();

		}// end
		return this.companies;

	}// end of function
}// class