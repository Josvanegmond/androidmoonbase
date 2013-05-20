/*
 * Parses XML containing information about Research and stores them inside ArrayList of Research
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

import android.util.Log;

import spaceappschallenge.moonville.domain.Research;

public class ResearchXMLParser {
	protected InputStream inputStream = null;
	protected XmlPullParser xpp;
	protected ArrayList<Research> researchList = new ArrayList<Research>();
	String name, info;
	int inputPower, monetaryCost, requiredTurns;

	/*
	 * @param: inputStream: InputStream object with the XML as the file
	 */
	public ResearchXMLParser(InputStream inputStream)
			throws XmlPullParserException {
		this.inputStream = inputStream;
		XmlPullParserFactory xmlFactory = XmlPullParserFactory.newInstance();
		xmlFactory.setNamespaceAware(true);
		xpp = xmlFactory.newPullParser();
		this.researchList = new ArrayList<Research>();
		Log.i("research", "start of parser");
	}

	public void readResearchAttributes() {
		// Read the attributes for each building
		name = xpp.getAttributeValue(null, "name");
		info = xpp.getAttributeValue(null, "info");
		inputPower = Integer
				.parseInt(xpp.getAttributeValue(null, "inputPower"));
		monetaryCost = Integer.parseInt(xpp.getAttributeValue(null,
				"monetaryCost"));
		requiredTurns = Integer.parseInt(xpp.getAttributeValue(null,
				"requiredTurns"));
		Log.i("research", name);

	}

	/**
	 * Creates building objects by parsing xml file
	 * 
	 * @return
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	public ArrayList<Research> parse() throws XmlPullParserException,
			IOException {
		Log.i("research", "init br");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				this.inputStream));
		xpp.setInput(br);
		int eventType = xpp.getEventType();
		Log.i("research", "start of while");
		// Parse the xml file to create "building" objects
		while (eventType != XmlPullParser.END_DOCUMENT) {

			boolean atResearch = false;
			if (eventType == XmlPullParser.START_TAG
					&& xpp.getName().equalsIgnoreCase("research")) {
				Log.i("research", "at research");
				atResearch = true;
				readResearchAttributes();

				// For Nested elements
				while (atResearch) {

					// Break the loop when the end tag: </research> is reached
					if (eventType == XmlPullParser.END_TAG
							&& xpp.getName().equalsIgnoreCase("research")) {
						break;
					}
					if (xpp.getAttributeCount() > 0) {
						Research research = new Research(name, info,
								inputPower, monetaryCost, requiredTurns);
						Log.i("research", name);
						this.researchList.add(research);
					}
					eventType = xpp.next();

				}// while atResearch


			}// if research

			eventType = xpp.next();
		}// while not end of document
		return this.researchList;
	}

	public ArrayList<Research> getResearchList() {
		return this.researchList;
	}
}// class