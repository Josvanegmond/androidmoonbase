/*
 * Parses XML containing information about Resources
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

import spaceappschallenge.moonville.businessmodels.Resource;
import spaceappschallenge.moonville.managers.ApplicationService;
import android.content.Context;
import android.util.Log;

public class ResourceXMLParser {
	protected Context context = null;
	protected InputStream inputStream = null;
	protected XmlPullParser xpp;
	protected ArrayList<Resource> resources;

	public ResourceXMLParser(InputStream inputStream)
			throws XmlPullParserException {
		this.inputStream = inputStream;
		this.context = ApplicationService.getInstance().getApplicationContext();
		XmlPullParserFactory xmlFactory = XmlPullParserFactory.newInstance();
		xmlFactory.setNamespaceAware(true);
		xpp = xmlFactory.newPullParser();
		this.resources = new ArrayList<Resource>();
		Log.i("ResourceXMLParser", "Done initializing parser");
	}

	// Create "Resource" objects by parsing input stream
	public ArrayList<Resource> parse() throws XmlPullParserException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				this.inputStream));
		xpp.setInput(br);
		String startTagName = "";
		int eventType = xpp.getEventType();
		Resource resource = null;
		String name = "";
		int amount = 0;
		double quality = 0.0;
		int unitCost = 0;

		// Parse the xml file to create "resource" objects
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_TAG) {
				startTagName = xpp.getName();
				if (startTagName.equals("resource")) {
					Log.i("ResourceXML", "start tag is resource");
					name = xpp.getAttributeValue(null, "name");
					amount = Integer.parseInt(xpp.getAttributeValue(null,
							"amount"));
					quality = Double.parseDouble(xpp.getAttributeValue(null,
							"quality"));
					unitCost = Integer.parseInt(xpp.getAttributeValue(null,
							"unitCost"));
					Log.i("unitCost of resource ",""+unitCost);
					resource = new Resource(name, amount, quality, unitCost);
					resources.add(resource);
					Log.i("ResourceXML", "name: " + name);
				}
				System.out.println("Start tag " + xpp.getName());
			}
			eventType = xpp.next();
		}
		return this.resources;
	}

}
